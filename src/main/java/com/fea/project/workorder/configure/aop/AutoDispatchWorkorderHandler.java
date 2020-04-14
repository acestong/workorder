package com.fea.project.workorder.configure.aop;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.workorder.enums.DeleteStatusEnum;
import com.fea.project.workorder.enums.IsAutoDispatchEnum;
import com.fea.project.workorder.enums.SwitchPersonEnum;
import com.fea.project.workorder.enums.WorkorderStatusEnum;
import com.fea.project.workorder.model.PoolDispatchUserModel;
import com.fea.project.workorder.model.PoolModel;
import com.fea.project.workorder.model.PoolRuleModel;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;
import com.fea.project.workorder.model.vo.PoolExistModelVo;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.service.IPoolDispatchUserService;
import com.fea.project.workorder.service.IPoolRuleService;
import com.fea.project.workorder.service.IPoolService;
import com.fea.project.workorder.util.WorkorderNumUtil;

/**
 * 工单日志操作切点类
 * 
 * @author st
 * @since 2020/3/13
 *
 */
@Aspect
@Component
public class AutoDispatchWorkorderHandler {

	@Resource
	private SysUserService sysUserService;
	@Resource
	private IPoolService poolService;
	@Resource
	private IPoolRuleService poolRuleService;
	@Resource
	private IPoolDispatchUserService poolDispatchUserService;
	
	private static final Logger log = LoggerFactory.getLogger(AutoDispatchWorkorderHandler.class);

	@Pointcut("@annotation(com.fea.project.workorder.configure.annotation.AutoDispatchWorkorder)")
	public void operationLog() {
	}

	/**
	 * 若传入参数personId为空，则不做拦截 若存在满足条件的工单池，则进入工单，工单池进行自动分配负责人
	 * 
	 * @param jp
	 */
	@Before("operationLog()")
	public void doBefore(JoinPoint jp) {
		Object[] args = jp.getArgs();
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		WorkorderModelVo modelVo = (WorkorderModelVo) args[0];
		/*
		 * 设置工单默认值
		 */
		modelVo.setCreateId(currentUsr.getUserId());
		modelVo.setCreateBy(currentUsr.getRealName());
		modelVo.setCreateTime(new Date());
		modelVo.setWorkorderStatus(WorkorderStatusEnum.UNRESPONSE.getStatus().longValue());
		modelVo.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		modelVo.setOrgId(currentUsr.getOrgId());
		modelVo.setWorkorderProgrossRate(0d);
		if (modelVo.getPersonId() != null) {
			return;
		}
		// 如果满足工单池中的规则：则按照工单池要求进行轮流分配工单池负责人
		PoolExistModelVo containRule = isContainRule(modelVo);
		if (containRule.getIsContainRule()) {
			modelVo.setSwitchPerson(SwitchPersonEnum.LEADER.getStatus().longValue());
			PoolDispatchUserModel dispitchUser = getDispitchUser(containRule.getPool().getWorkorderPoolId());
			modelVo.setPersonId(dispitchUser.getUserId());
			modelVo.setPersonName(dispitchUser.getUserName());
			modelVo.setDispatchId(containRule.getPool().getPoolManagerId());
			modelVo.setDispatchBy(containRule.getPool().getPoolManagerName());
			modelVo.setDispatchPoolId(containRule.getPool().getWorkorderPoolId());
			modelVo.setDispatchTime(new Date());
			log.info("\n=========================================================\n"
					+ "被工单池<" + containRule.getPool().getPoolName() + ">拦截\n"
					+ "工单池管理员：" + containRule.getPool().getPoolManagerName()
					+ "\n=========================================================");
		}
	}

	/**
	 * 是否满足工单池中的规则
	 * 
	 * @return
	 * @return
	 */
	private PoolExistModelVo isContainRule(WorkorderModelVo modelVo) {
		PoolExistModelVo poolExistModelVo = new PoolExistModelVo();
		// 通过当前用户的orgId获取到工单池列表
		List<PoolModel> list = poolService.selectListByOrgId();
		if (list.size() == 0) {
			// 不存在工单池就放行
			return new PoolExistModelVo(null, false);
		} else {
			StringBuffer stringBuffer = new StringBuffer();
			for (PoolModel poolModel : list) {
				// 工单池设置不需要自动分配时，跳出本次循环
				if (poolModel.getIsAutoDispatch() == IsAutoDispatchEnum.NOT_AUTO_DISPATCH.getStatus().longValue()) {
					continue;
				}
				// 通过工单池id获取所有的入池规则
				List<PoolRuleModel> ruleList = poolRuleService.selectListByPoolId(poolModel.getWorkorderPoolId());
				ruleList.stream().forEach(ruleModel -> {
					stringBuffer.append(ruleModel.getConnector() == null ? "1==1 && " : ruleModel.getConnector());
					Object obj = " ";
					try {
						obj = getFieldValue(modelVo, ruleModel.getFieldName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new SystemParamCheckException("工单池拦截异常，字段不存在");
					}
					stringBuffer.append(obj + " ");
					stringBuffer.append(ruleModel.getFilterRule() + " ");
					stringBuffer.append(ruleModel.getFilterValue() + " ");
				});

				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine se = manager.getEngineByName("js");
				Object eval = false;
				try {
					eval = se.eval(stringBuffer.toString());
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ((Boolean) eval) {
					poolExistModelVo.setIsContainRule((Boolean) eval);
					poolExistModelVo.setPool(poolModel);
					break;
				}
			}
			return poolExistModelVo;
		}
	}

	/**
	 * 通过属性名，获取参数中的属性值
	 * 
	 * @param modelVo
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	private Object getFieldValue(WorkorderModelVo modelVo, String fieldName) throws Exception {
		Field f = modelVo.getClass().getSuperclass().getDeclaredField(fieldName);
		f.setAccessible(true);
		return f.get(modelVo);
	}

	/**
	 * 轮流获取分配人,并修改此分配人领到工单的个数
	 */
	public PoolDispatchUserModel getDispitchUser(Long poolId) {
		PoolDispatchUserModel model = poolDispatchUserService.selectModelByPoolId(poolId);
		poolDispatchUserService.updateByPrimaryKey(model);
		return model;
	}
	
}

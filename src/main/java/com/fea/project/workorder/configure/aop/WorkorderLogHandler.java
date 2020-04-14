package com.fea.project.workorder.configure.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.apache.ibatis.binding.MapperMethod.MethodSignature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.configure.annotation.WorkorderLogAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.workorder.enums.OptionResultEnum;
import com.fea.project.workorder.enums.ResultTypeEnum;
import com.fea.project.workorder.enums.WorkorderStatusEnum;
import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderRecordModel;
import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.WorkorderResponseModel;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.service.IWorkorderRecordService;

/**
 * 工单日志操作切点类
 * @author st
 * @since 2020/3/13
 *
 */
@Aspect
@Component
public class WorkorderLogHandler {

	private static final Object WorkorderModelVo = null;

	@Resource
	private IWorkorderRecordService workorderRecordService;
	@Resource
	private SysUserService sysUserService;
	
	private static final Logger log = LoggerFactory.getLogger(WorkorderLogHandler.class);
	
	@Pointcut("@annotation(com.fea.project.workorder.configure.annotation.WorkorderLogAnno)")
	public void operationLog() {}
	
	
//	/**
//     * 处理完请求，返回内容
//     * @param ret
//     */
//    @AfterReturning(returning = "ret", pointcut = "operationLog()")
//    public void doAfterReturning(Object ret) {
//        System.out.println("doAfterReturning方法的返回值 : " + ret);
//    }
//
//    /**
//     * 后置异常通知
//     */
//    @AfterThrowing("operationLog()")
//    public void throwss(JoinPoint jp){
//        System.out.println("throwss方法异常时执行.....");
//    }
//

    @SuppressWarnings("unlikely-arg-type")
	/**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @After("operationLog()")
    public void after(JoinPoint jp) throws Exception{
    	String className = jp.getSignature().getDeclaringTypeName();
    	Method[] methods=Class.forName(className).getMethods();//反射获取所有方法
    	for(Method m:methods) { //遍历所有方法
    		//判断传入的当前方法是否有MyAnnotation注解
    		Signature signature = jp.getSignature();
    		if(m.isAnnotationPresent(WorkorderLogAnno.class) && m.getName().equals(signature.getName())) {
    			SysUserModel currentUsr = sysUserService.getCurrentUsr();
    			WorkorderLogAnno annotation = m.getAnnotation(WorkorderLogAnno.class);
    			WorkorderRecordModel workorderRecordModel = new WorkorderRecordModel(annotation, currentUsr.getUserId(), currentUsr.getRealName());
    			for (Object o : jp.getArgs()) {
    				if(o instanceof WorkorderModel) {
    					WorkorderModel model=(WorkorderModel)o;
    					workorderRecordModel.setWorkorderId(model.getWorkorderId());
    					if(annotation.resultType() == OptionResultEnum.WORKORDER_TYPE.getStatus()) {
    						//resultType为“创建工单”时
    						workorderRecordModel.setResult(model.getBusinessName());
    					}
    					if(annotation.resultType() == OptionResultEnum.DISPATCH_WORKORDER.getStatus()) {
    						//resultType为“分配工单”时
    						workorderRecordModel.setResult(model.getDispatchBy());
    					}
    					if(annotation.resultType() == OptionResultEnum.WORKORDER_CLOSE.getStatus()) {
    						//resultType为“关闭工单”时
    						workorderRecordModel.setResult(currentUsr.getRealName());
    					}
    				}else if(o instanceof WorkorderResponseModel){
    					WorkorderResponseModel model=(WorkorderResponseModel)o;
    					workorderRecordModel.setWorkorderId(model.getWorkorderId());
    					if(annotation.resultType()==OptionResultEnum.RESPONSE_RESULT.getStatus()) {
    						//resultType为“工单响应”时
    						workorderRecordModel.setResult(WorkorderStatusEnum.getValue(model.getIsConfirm().intValue()));
    					}
    				}else if(o instanceof WorkorderReportModel){
    					WorkorderReportModel model=(WorkorderReportModel)o;
    					workorderRecordModel.setWorkorderId(model.getWorkorderId());
    					if(annotation.resultType()==OptionResultEnum.WORKORDER_REPORT.getStatus()) {
    						//resultType为“工单汇报”时
    						workorderRecordModel.setResult(model.getWorkorderProgrossRate()*100+"%");
    					}
    				}else if(o instanceof Long){
    					workorderRecordModel.setWorkorderId((Long)o);
    					if(annotation.resultType()==OptionResultEnum.WORKORDER_ACTIVATE.getStatus()) {
    						//resultType为“工单激活”时
    						workorderRecordModel.setResult(null);
    					}
    				}else if(o instanceof AcceptanceModel) {
    					AcceptanceModel model = (AcceptanceModel)o;
    					workorderRecordModel.setWorkorderId(model.getWorkorderId());
    					if(annotation.resultType()==OptionResultEnum.WORKORDER_ACCEPTANCE.getStatus()) {
    						//resultType为“工单激活”时
    						workorderRecordModel.setResult(model.getPersonName());
    					}
    				}else{
    					throw new SystemParamCheckException("类型转换异常");
    				}
				}
    			if(workorderRecordModel.getWorkorderId() != null) {
    				workorderRecordService.insert(workorderRecordModel);
    			}
    		}
    	}
    	log.info("after方法最后执行.....");
    }
    
    
}

package com.fea.project.workorder.configure.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.configure.annotation.OptionAnno;
import com.fea.project.workorder.enums.TypeEnum;
import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.CommentModel;
import com.fea.project.workorder.model.OptionModel;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderReportModel;
import com.fea.project.workorder.model.vo.ProcedureModelVo;
import com.fea.project.workorder.model.vo.ProcedureReportModelVo;
import com.fea.project.workorder.model.vo.WorkorderModelVo;
import com.fea.project.workorder.service.IOptionService;
import com.fea.project.workorder.service.IProcedureService;
import com.fea.project.workorder.service.IWorkorderService;

/**
 * 工单日志操作切点类
 * 
 * @author st
 * @since 2020/3/13
 *
 */
@Aspect
@Component
public class OptionHandler {

	@Resource
	private IOptionService optionService;
	@Resource
	private IWorkorderService workorderService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private IProcedureService procedureService;

	private static final Logger log = LoggerFactory.getLogger(OptionHandler.class);

	@Pointcut("@annotation(com.fea.project.workorder.configure.annotation.OptionAnno)")
	public void operationLog() {
	}

	@SuppressWarnings("unlikely-arg-type")
	/**
	 * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@After("operationLog()")
	public void after(JoinPoint jp) throws Exception {
		Signature signature = jp.getSignature();
		String declaringTypeName = signature.getDeclaringTypeName();
		Method[] methods = Class.forName(declaringTypeName).getMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(OptionAnno.class) && m.getName().equals(signature.getName())) {
				OptionAnno annotation = m.getAnnotation(OptionAnno.class);
				Integer type = annotation.type();
				Object[] args = jp.getArgs();

				// 工单汇报时，业务id存入工单汇报id
				if (type == TypeEnum.WO_REPORT.getStatus()) {
					WorkorderReportModel workorderReportModel = (WorkorderReportModel) args[0];
					OptionModel optionModel = new OptionModel(workorderReportModel.getActualStartTime(),
							workorderReportModel.getActualEndTime());
					optionModel.setBusinessType(type.longValue());
					optionModel.setBusinessId(workorderReportModel.getReportId());
					optionModel.setBusinessName(workorderReportModel.getReportTitle());
					optionModel.setWorkorderId(workorderReportModel.getWorkorderId());
					optionModel.setOptionName("工单汇报");
					optionService.insert(optionModel);
				}
				// 工序汇报时，业务id存入工序汇报id
				if (type == TypeEnum.PC_REPORT.getStatus()) {
					ProcedureReportModelVo procedureReportModelVo = (ProcedureReportModelVo) args[0];
					ProcedureModelVo procedureModelVo = procedureService
							.selectByPrimaryKey(procedureReportModelVo.getProcedureId());
					OptionModel optionModel = new OptionModel(procedureReportModelVo.getActualStartTime(),
							procedureReportModelVo.getActualEndTime());
					optionModel.setBusinessType(type.longValue());
					optionModel.setBusinessId(procedureReportModelVo.getId());
					optionModel.setBusinessName(procedureReportModelVo.getTitle());
					optionModel.setWorkorderId(procedureModelVo.getWorkorderId());
					optionModel.setOptionName("工序汇报");
					optionService.insert(optionModel);
				}
				// 工单验收时，业务id存入工单验收id
				if (type == TypeEnum.WO_ACCEPTANCE.getStatus()) {
					AcceptanceModel acceptanceModel = (AcceptanceModel) args[0];
					OptionModel optionModel = new OptionModel();
					optionModel.setBusinessType(type.longValue());
					optionModel.setBusinessId(acceptanceModel.getAcceptanceId());
					optionModel.setBusinessName(acceptanceModel.getOpinion());
					optionModel.setOptionName("工单验收");
					optionModel.setOptionTime(new Date());
					optionModel.setWorkorderId(acceptanceModel.getWorkorderId());
					optionService.insert(optionModel);
				}
				// 工单评价时，业务id存入工单评价id
				if (type == TypeEnum.WO_COMMENT.getStatus()) {
					CommentModel commentModel = (CommentModel) args[0];
					OptionModel optionModel = new OptionModel();
					optionModel.setBusinessType(type.longValue());
					optionModel.setBusinessId(commentModel.getCommentId());
					optionModel.setBusinessName(commentModel.getRemark());
					optionModel.setOptionName("工单评价");
					optionModel.setOptionTime(new Date());
					optionModel.setWorkorderId(commentModel.getWorkorderId());
					optionService.insert(optionModel);
				}
				// 工单关闭时，业务id存入工单id
				if (type == TypeEnum.WO_CLOSE.getStatus()) {
					WorkorderModel workorderModel = (WorkorderModel) args[0];
					OptionModel optionModel = new OptionModel();
					optionModel.setBusinessType(type.longValue());
					optionModel.setBusinessId(workorderModel.getWorkorderId());
					optionModel.setBusinessName(workorderModel.getWorkorderName());
					optionModel.setOptionName("关闭工单");
					optionModel.setOptionTime(new Date());
					optionModel.setWorkorderId(workorderModel.getWorkorderId());
					optionModel.setPlanEndTime(
							workorderService.selectOne(workorderModel.getWorkorderId()).getDeadlineTime());
					optionService.insert(optionModel);
				}
			}
		}

		log.info("after方法最后执行.....");
	}

}

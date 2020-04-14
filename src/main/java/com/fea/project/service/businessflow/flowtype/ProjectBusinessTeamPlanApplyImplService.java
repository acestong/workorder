package com.fea.project.service.businessflow.flowtype;

import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.SpringContextHelper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.plan.PlanVersionEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.plan.PlanModel;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.plan.IPlanService;
import com.fea.project.service.plan.impl.PlanServiceImpl;
import com.fea.project.service.task.ITaskService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 17:14
 **/
//TODO
@Service
public class ProjectBusinessTeamPlanApplyImplService extends AbstractFlowApply<PlanModel> {

	@Autowired
    private ProjectFlowService projectFlowService;
    @Autowired
	private SysUserService sysUserService;
    @Autowired
    private IPlanService planService;
    @Autowired
    private ITaskService taskService;
    
	@Override
	protected Long getProjectId(PlanModel model) {
		// TODO Auto-generated method stub
		return model.getProjectId();
	}

	@Override
	protected boolean checkFlowParamIsAvailable(PlanModel model) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected Integer getFlowTypeId() {
		// TODO Auto-generated method stub
		return ProjectConfigEnum.VERIFY_SET_PROJECT_TEAM_PLAN_VERIFY.getValue();
	}

	@Override
	protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
		// TODO Auto-generated method stub
		ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
	}

	@Override
	protected Long getModelPrimaryId(PlanModel model) {
		// TODO Auto-generated method stub
		return model.getPlanId();
	}

	@Override
	protected Long getApplyer(PlanModel model) {
		// TODO Auto-generated method stub
		return model.getCreateId();
	}

	@Override
	protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, PlanModel model) {
		// TODO Auto-generated method stub
		projectApplyPojo.setName(model.getPlanName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_PROJECT_TEAM_PLAN_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getPlanId());
        projectApplyPojo.setBusinessCode(model.getPlanNum());
        projectApplyPojo.setApplyerId(model.getCreateId());
        //查询部门
        List<SysUserVo> sysUserVos = sysUserService.selectUserInfoAndDeptInfoByIds(new ArrayList<Long>() {{
            add(model.getCreateId());
        }});
        if (!sysUserVos.isEmpty()){
            projectApplyPojo.setApplyDepart(sysUserVos.get(0).getDeptId());
        }
        projectApplyPojo.setProjectId(model.getProjectId());
	}

	@Override
	public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
		// TODO Auto-generated method stub
		PlanModel planModel = new PlanModel();
    	planModel.setPlanId(businessId);
    	//设置版本为1.0版本，状态设置为已审批状态
    	planModel.setPlanVersion(PlanVersionEnum.V1_0.getStatus().longValue());
    	planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue().longValue());
    	//通过审批1.0版本的计划将自动通过后计划转为任务
    	boolean isUpdate = SpringContextHelper.getBean(PlanServiceImpl.class).update(planModel) >= 0;
    	planModel = planService.selectOneByPlanId(businessId);
    	if(isUpdate && planModel.getCheckStatus() ==  ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue().longValue()) {
    		taskService.planToTask(planModel);
    	}
        return isUpdate;
	}

	@Override
	public boolean revertBusinessInfo(Long businessId) {
		// TODO Auto-generated method stub
		PlanModel planModel = new PlanModel();
    	planModel.setPlanId(businessId);
    	planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REPULSE.getValue().longValue());
    	boolean isUpdate= SpringContextHelper.getBean(PlanServiceImpl.class).update(planModel) >= 0;
    	//已审批的1.0版本的计划将自动转为任务
    	if(isUpdate) {
    		taskService.planToTask(planModel);
    	}
        return isUpdate;
	}

	@Override
	public boolean refuseBusinessInfo(Long businessId) {
		// TODO Auto-generated method stub
		PlanModel planModel = new PlanModel();
    	planModel.setPlanId(businessId);
    	planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue().longValue());
        return SpringContextHelper.getBean(PlanServiceImpl.class).update(planModel) >= 0;
	}
	
	
}

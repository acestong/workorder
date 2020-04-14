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
public class ProjectBusinessPlanApplyImplService extends AbstractFlowApply<PlanModel>{

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
        return model.getProjectId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(PlanModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectConfigEnum.VERIFY_SET_PROJECT_PLAN_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    @Override
    protected Long getModelPrimaryId(PlanModel model) {
        return model.getPlanId();
    }

    @Override
    protected Long getApplyer(PlanModel model) {
        return model.getCreateId();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, PlanModel model) {
        projectApplyPojo.setName(model.getPlanName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_PROJECT_PLAN_VERIFY.getValue());
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

    /**
     * 审批通过完成时的业务id
     */
    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
    	PlanModel planModel = new PlanModel();
    	planModel.setPlanId(businessId);
    	// 更新计划状态为已审批，计划版本为v1.0版本
    	planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue().longValue());
    	planModel.setPlanVersion(PlanVersionEnum.V1_0.getStatus().longValue());
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
    	PlanModel planModel = new PlanModel();
    	planModel.setPlanId(businessId);
    	// 更新计划状态为已驳回，计划版本不做修改
    	planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REPULSE.getValue().longValue());
        return SpringContextHelper.getBean(PlanServiceImpl.class).update(planModel) >= 0;
    }

    @Override
    public boolean refuseBusinessInfo(Long businessId) {
    	PlanModel planModel = new PlanModel();
    	planModel.setPlanId(businessId);
    	planModel.setCheckStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue().longValue());
        return SpringContextHelper.getBean(PlanServiceImpl.class).update(planModel) >= 0;
    }
}

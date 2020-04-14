package com.fea.project.service.businessflow.flowtype;

import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.milestone.ProjectMilestoneVerifyModel;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.milestone.ProjectMilestoneService;
import com.fea.project.service.milestone.ProjectMilestoneVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ProjectBusinessMilestoneApplyImplService extends AbstractFlowApply<ProjectMilestoneVerifyModel> {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectFlowService projectFlowService;
    @Autowired
    private ProjectMilestoneService projectMilestoneService;
    @Autowired
    private ProjectMilestoneVerifyService milestoneVerifyService;
    @Override
    protected Long getProjectId(ProjectMilestoneVerifyModel model) {
        return model.getProjectId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(ProjectMilestoneVerifyModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectFlowTypeEnum.VERIFY_SET_PROJECT_MILESTONE_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    @Override
    protected Long getModelPrimaryId(ProjectMilestoneVerifyModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(ProjectMilestoneVerifyModel model) {
        return model.getApplyUserId();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, ProjectMilestoneVerifyModel model) {
        projectApplyPojo.setName(model.getName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_PROJECT_MILESTONE_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setBusinessCode(model.getCode());
        projectApplyPojo.setApplyerId(model.getApplyUserId());
        //查询部门
        List<SysUserVo> sysUserVos = sysUserService.selectUserInfoAndDeptInfoByIds(new ArrayList<Long>() {{
            add(model.getApplyUserId());
        }});
        if (!sysUserVos.isEmpty()){
            projectApplyPojo.setApplyDepart(sysUserVos.get(0).getDeptId());
        }
        projectApplyPojo.setProjectId(this.getProjectId(model));
    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
        ProjectMilestoneVerifyModel milestoneModel = new ProjectMilestoneVerifyModel();
        milestoneModel.setId(businessId);
        milestoneModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        if (milestoneVerifyService.updateByIdSelective(milestoneModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目里程碑审核通过状态更新失败");
    }

    @Override
    public boolean revertBusinessInfo(Long businessId) {
        ProjectMilestoneVerifyModel milestoneModel = new ProjectMilestoneVerifyModel();
        milestoneModel.setId(businessId);
        milestoneModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        if (milestoneVerifyService.updateByIdSelective(milestoneModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目里程碑申请撤回状态更新失败");
    }

    @Override
    public boolean refuseBusinessInfo(Long businessId) {
        ProjectMilestoneVerifyModel milestoneModel = new ProjectMilestoneVerifyModel();
        milestoneModel.setId(businessId);
        milestoneModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        if (milestoneVerifyService.updateByIdSelective(milestoneModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目里程碑审核拒绝状态更新失败");
    }
}

package com.fea.project.service.businessflow.flowtype;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.deliverable.ProjectDeliverableModel;
import com.fea.project.model.feebudget.ProjectFeeDubgetParentModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.service.deliverable.ProjectDeliverableService;
import com.fea.project.service.feebudget.ProjectFeeDubgetParentService;
import com.fea.project.service.feebudget.ProjectFeeDubgetService;
import com.fea.project.service.flow.ProjectFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 项目预算提交审核
 */
@Service
public class ProjectBusinessFeeDubgetApplyImplService extends AbstractFlowApply<ProjectFeeDubgetParentModel> {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectFeeDubgetParentService projectFeeDubgetParentService;
    @Autowired
    private ProjectFlowService projectFlowService;
    @Autowired
    private ProjectFeeDubgetService projectFeeDubgetService;

    @Override
    protected Long getProjectId(ProjectFeeDubgetParentModel model) {
        return model.getProjectId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(ProjectFeeDubgetParentModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectConfigEnum.VERIFY_SET_PROJECT_BUDGET_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        //无条件流程,当前启用流程即为默认流程
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    @Override
    protected Long getModelPrimaryId(ProjectFeeDubgetParentModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(ProjectFeeDubgetParentModel model) {
        //先默认为交付人
        return sysUserService.getCurrentUsr().getUserId();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, ProjectFeeDubgetParentModel model) {
        projectApplyPojo.setName(model.getName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_PROJECT_BUDGET_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setApplyerId(sysUserService.getCurrentUsr().getUserId());
        //查询部门
        List<SysUserVo> sysUserVos = sysUserService.selectUserInfoAndDeptInfoByIds(new ArrayList<Long>() {{
            add(sysUserService.getCurrentUsr().getUserId());
        }});
        if (!sysUserVos.isEmpty()) {
            projectApplyPojo.setApplyDepart(sysUserVos.get(0).getDeptId());
        }
        projectApplyPojo.setProjectId(this.getProjectId(model));
    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
        //更新审核状态
        ProjectFeeDubgetParentModel projectFeeDubgetParentModel = new ProjectFeeDubgetParentModel();
        projectFeeDubgetParentModel.setId(businessId);
        projectFeeDubgetParentModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        if (projectFeeDubgetParentService.updateByIdSelective(projectFeeDubgetParentModel)) {
            projectFeeDubgetService.check(businessId);
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目预算审核通过状态更新失败");
    }

    @Override
    public boolean revertBusinessInfo(Long businessId) {
        //撤销申请
        ProjectFeeDubgetParentModel projectFeeDubgetParentModel = new ProjectFeeDubgetParentModel();
        projectFeeDubgetParentModel.setId(businessId);
        projectFeeDubgetParentModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        if (projectFeeDubgetParentService.updateByIdSelective(projectFeeDubgetParentModel)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目预算申请撤销状态更新失败");
    }

    @Override
    public boolean refuseBusinessInfo(Long businessId) {
        //拒绝
        ProjectFeeDubgetParentModel projectFeeDubgetParentModel = new ProjectFeeDubgetParentModel();
        projectFeeDubgetParentModel.setId(businessId);
        projectFeeDubgetParentModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        if (projectFeeDubgetParentService.updateByIdSelective(projectFeeDubgetParentModel)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目预算审核拒绝状态更新失败");
    }
}

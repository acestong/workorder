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
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.service.deliverable.ProjectDeliverableService;
import com.fea.project.service.flow.ProjectFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Administrator
 * 项目交付物相关
 */
@Service
public class ProjectBusinessProjectDeliverableApplyImplService extends AbstractFlowApply<ProjectDeliverableModel> {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectDeliverableService projectDeliverableService;
    @Autowired
    private ProjectFlowService projectFlowService;
    @Override
    protected Long getProjectId(ProjectDeliverableModel model) {
        ProjectDeliverableModel projectDeliverableModel = projectDeliverableService.selectById(model);
        return projectDeliverableModel.getBusinessId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(ProjectDeliverableModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectConfigEnum.VERIFY_SET_PROJECT_DELIVERABLE_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        //无条件流程,当前启用流程即为默认流程
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    @Override
    protected Long getModelPrimaryId(ProjectDeliverableModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(ProjectDeliverableModel model) {
        //先默认为交付人
        return model.getDeliver();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, ProjectDeliverableModel model) {
        projectApplyPojo.setName(model.getDeliverableName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_PROJECT_DELIVERABLE_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setBusinessCode(model.getDeliverableNum());
        projectApplyPojo.setApplyerId(model.getDeliver());
        //查询部门
        List<SysUserVo> sysUserVos = sysUserService.selectUserInfoAndDeptInfoByIds(new ArrayList<Long>() {{
            add(model.getDeliver());
        }});
        if (!sysUserVos.isEmpty()){
            projectApplyPojo.setApplyDepart(sysUserVos.get(0).getDeptId());
        }
        projectApplyPojo.setProjectId(this.getProjectId(model));
    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //更新审核状态
        ProjectDeliverableModel projectDeliverableModel = new ProjectDeliverableModel();
        projectDeliverableModel.setId(businessId);
        projectDeliverableModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        projectDeliverableModel.setVerifyer(currentUsr.getUserId());
        projectDeliverableModel.setVerifyerTime(new Date());
        if (projectDeliverableService.updateByIdSelective(projectDeliverableModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目交付物审核通过状态更新失败");
    }

    @Override
    public boolean revertBusinessInfo(Long businessId) {
        //撤销申请
        ProjectDeliverableModel projectDeliverableModel = new ProjectDeliverableModel();
        projectDeliverableModel.setId(businessId);
        projectDeliverableModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        if (projectDeliverableService.updateByIdSelective(projectDeliverableModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目交付物申请撤销状态更新失败");
    }

    @Override
    public boolean refuseBusinessInfo(Long businessId) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //拒绝
        ProjectDeliverableModel projectDeliverableModel = new ProjectDeliverableModel();
        projectDeliverableModel.setId(businessId);
        projectDeliverableModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        projectDeliverableModel.setVerifyer(currentUsr.getUserId());
        projectDeliverableModel.setVerifyerTime(new Date());
        if (projectDeliverableService.updateByIdSelective(projectDeliverableModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目交付物审核拒绝状态更新失败");
    }
}

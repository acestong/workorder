package com.fea.project.service.businessflow.flowtype;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.milestone.ProjectMilestoneDeliverableMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.milestone.DeliveryStatusEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.milestone.ProjectMilestoneDeliverableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * 里程碑交付物流程相关
 */
@Service
public class ProjectBusinessMilestoneDeliverableApplyImplService extends AbstractFlowApply<ProjectMilestoneDeliverableModel> {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectMilestoneDeliverableService projectMilestoneDeliverableService;
    @Autowired
    private ProjectFlowService projectFlowService;
    @Resource
    private ProjectMilestoneDeliverableMapper projectMilestoneDeliverableMapper;
    @Override
    protected Long getProjectId(ProjectMilestoneDeliverableModel model) {
        ProjectDeliverableVo deliverableVo = projectMilestoneDeliverableMapper.selectMilestoneDeliverableInfoById(model.getId());
        return deliverableVo.getProjectId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(ProjectMilestoneDeliverableModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectConfigEnum.VERIFY_SET_MILESTONE_DELIVERABLE_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    @Override
    protected Long getModelPrimaryId(ProjectMilestoneDeliverableModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(ProjectMilestoneDeliverableModel model) {
        //当前申请人
        return model.getDeliver();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, ProjectMilestoneDeliverableModel model) {
        projectApplyPojo.setName(model.getDeliverableName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_MILESTONE_DELIVERABLE_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setBusinessCode(model.getDeliverableNumber());
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
        SysUserModel user = sysUserService.getCurrentUsr();
        //审核通过状态
        ProjectMilestoneDeliverableModel model = new ProjectMilestoneDeliverableModel();
        model.setId(businessId);
        model.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        model.setVerifyer(user.getUserId());
        model.setVerifyerTime(new Date());
        model.setDeliverStatus(DeliveryStatusEnum.SUCCESS_DELIVERY.getCode());
        boolean b = projectMilestoneDeliverableService.updateByIdSelective(model);
        if (!b){
            throw new SystemParamCheckException("里程碑交付物审核通过状态更新失败");
        }
        return true;
    }

    @Override
    public boolean revertBusinessInfo(Long businessId) {
        //审核撤销
        ProjectMilestoneDeliverableModel model = new ProjectMilestoneDeliverableModel();
        model.setId(businessId);
        model.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        boolean b = projectMilestoneDeliverableService.updateByIdSelective(model);
        if (!b){
            throw new SystemParamCheckException("里程碑交付物审核申请撤销状态更新失败");
        }
        return true;
    }

    @Override
    public boolean refuseBusinessInfo(Long businessId) {
        SysUserModel user = sysUserService.getCurrentUsr();
        //审核拒绝
        ProjectMilestoneDeliverableModel model = new ProjectMilestoneDeliverableModel();
        model.setId(businessId);
        model.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        model.setVerifyer(user.getUserId());
        model.setVerifyerTime(new Date());
        boolean b = projectMilestoneDeliverableService.updateByIdSelective(model);
        if (!b){
            throw new SystemParamCheckException("里程碑交付物审核拒绝状态更新失败");
        }
        return true;
    }
}

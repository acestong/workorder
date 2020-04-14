package com.fea.project.service.businessflow.flowtype;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.task.ITaskDeliverProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/2 17:14
 **/
//TODO
@Service
public class ProjectBusinessTaskDeliverableApplyImplService extends AbstractFlowApply<TaskDeliverProductModel> {

    @Autowired
    private ProjectFlowService projectFlowService;
    @Autowired
    private ITaskDeliverProductService taskDeliverProductService;
    @Autowired
    private SysUserService sysUserService;
    @Override
    protected Long getProjectId(TaskDeliverProductModel model) {
        ProjectDeliverableVo deliverableVo = taskDeliverProductService.selectTaskDeliverableInfoById(model.getDeliverProductId());
        return deliverableVo.getProjectId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(TaskDeliverProductModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectFlowTypeEnum.VERIFY_SET_TASK_DELIVERABLE_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    @Override
    protected Long getModelPrimaryId(TaskDeliverProductModel model) {
        return model.getDeliverProductId();
    }

    @Override
    protected Long getApplyer(TaskDeliverProductModel model) {
        return model.getTaskDelivererId();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, TaskDeliverProductModel model) {
        projectApplyPojo.setName(model.getDeliverProductName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.VERIFY_SET_TASK_DELIVERABLE_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getDeliverProductId());
        projectApplyPojo.setBusinessCode(model.getDeliverProductNum());
        projectApplyPojo.setApplyerId(model.getTaskDelivererId());
        //查询部门
        List<SysUserVo> sysUserVos = sysUserService.selectUserInfoAndDeptInfoByIds(new ArrayList<Long>() {{
            add(model.getTaskDelivererId());
        }});
        if (!sysUserVos.isEmpty()){
            projectApplyPojo.setApplyDepart(sysUserVos.get(0).getDeptId());
        }
        projectApplyPojo.setProjectId(this.getProjectId(model));
    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
        SysUserModel usr = sysUserService.getCurrentUsr();
        TaskDeliverProductModel model = new TaskDeliverProductModel();
        model.setDeliverProductId(businessId);
        model.setTaskDeliverStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue().longValue());
        model.setDeliverCheckerId(usr.getUserId());
        model.setDeliveryCheckTime(new Date());
        try {
            taskDeliverProductService.update(model);
        } catch (Exception e) {
            throw new SystemParamCheckException("项目任务交付物审核通过状态更新失败");
        }
        return true;
    }

    @Override
    //TODO
    public boolean revertBusinessInfo(Long businessId) {
        TaskDeliverProductModel model = new TaskDeliverProductModel();
        model.setDeliverProductId(businessId);
        model.setTaskDeliverStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue().longValue());
        try {
            taskDeliverProductService.update(model);
        } catch (Exception e) {
            throw new SystemParamCheckException("项目任务交付物申请撤销状态更新失败");
        }
        return true;
    }

    @Override
    //TODO
    public boolean refuseBusinessInfo(Long businessId) {
        SysUserModel usr = sysUserService.getCurrentUsr();
        TaskDeliverProductModel model = new TaskDeliverProductModel();
        model.setDeliverProductId(businessId);
        model.setTaskDeliverStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue().longValue());
        model.setDeliverCheckerId(usr.getUserId());
        model.setDeliveryCheckTime(new Date());
        try {
            taskDeliverProductService.update(model);
        } catch (Exception e) {
            throw new SystemParamCheckException("项目任务交付物审核拒绝状态更新失败");
        }
        return true;
    }
}

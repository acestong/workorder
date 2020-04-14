package com.fea.project.service.businessflow.flowtype;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.project.ProjectEstablishStartStatusEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.flow.pojo.FlowApplyStatusModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.establishproject.project.ProjectEstablishProjectService;
import com.fea.project.service.establishproject.project.ProjectEstablishStepService;
import com.fea.project.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/2 10:19
 **/
@Service
public class ProjectBusinessEstablishApplyImplService extends AbstractFlowApply<ProjectEstablishStepModel> {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectEstablishStepService projectEstablishStepService;

    @Autowired
    private ProjectEstablishProjectService projectEstablishProjectService;



    @Override
    protected Long getProjectId(ProjectEstablishStepModel model) {
        return model.getProjectId();
    }

    @Override
    protected boolean checkFlowParamIsAvailable(ProjectEstablishStepModel model) {
        return true;
    }

    @Override
    protected Integer getFlowTypeId() {
        return ProjectFlowTypeEnum.PROJECT_ESTABLISH_VERIFY.getValue();
    }

    @Override
    protected Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        return projectEstablishStepService.getCurrentFlowNeedChooseFlowList(businessId, flowId);
    }

    @Override
    protected Long getModelPrimaryId(ProjectEstablishStepModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(ProjectEstablishStepModel model) {
        return model.getLeader();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, ProjectEstablishStepModel model) {
        ProjectModel projectModel = this.projectService.selectById(model.getProjectId());
        projectApplyPojo.setName(model.getName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.PROJECT_ESTABLISH_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setBusinessCode(projectModel.getCode());
        projectApplyPojo.setApplyerId(model.getLeader());
        projectApplyPojo.setApplyDepart(projectModel.getApplyDepart());
        projectApplyPojo.setProjectId(model.getProjectId());
    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long businessId) {
        ProjectEstablishStepModel projectEstablishStepModel = new ProjectEstablishStepModel(businessId, ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        if(projectEstablishStepService.updateByIdSelective(projectEstablishStepModel)){
            List<ProjectEstablishStepModel> leftNeedSubmit = this.projectEstablishStepService.selectLeftNeedUpdate(businessId);
            if(leftNeedSubmit.isEmpty()){
                //更新项目整体状态
                projectEstablishStepModel = this.projectEstablishStepService.selectById(businessId);
                ProjectModel projectModel = new ProjectModel(projectEstablishStepModel.getProjectId());
                projectModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
                //更新项目启用状态
                this.updateApplyStatus(businessId);
                ProjectEstablishProjectModel projectEstablishProjectModel = this.projectEstablishProjectService.selectByProjectId(projectEstablishStepModel.getProjectId());
                projectEstablishProjectModel.setStartStatus(ProjectEstablishStartStatusEnum.TYPE_UNSTART.getValue());
                this.projectService.updateSelectiveByIdOnEstablish(projectModel);
                projectEstablishProjectModel.setEstablishTime(new Date());
                this.projectEstablishProjectService.updateByIdSelective(projectEstablishProjectModel);
            }else{
                ProjectEstablishProjectModel projectEstablishProjectModel = this.projectEstablishProjectService.selectByProjectId(leftNeedSubmit.get(0).getProjectId());
                projectEstablishProjectModel.setEstablishStep(leftNeedSubmit.get(0).getId());
                this.projectEstablishProjectService.updateByIdSelective(projectEstablishProjectModel);
            }
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目立项阶段审核状态更新失败");
    }

    @Override
    public boolean revertBusinessInfo(Long businessId) {
        ProjectEstablishStepModel projectEstablishStepModel = new ProjectEstablishStepModel(businessId, ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        if(projectEstablishStepService.updateByIdSelective(projectEstablishStepModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目立项阶段审核状态更新失败");
    }

    @Override
    public boolean refuseBusinessInfo(Long businessId) {
        ProjectEstablishStepModel projectEstablishStepModel = new ProjectEstablishStepModel(businessId, ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        if(projectEstablishStepService.updateByIdSelective(projectEstablishStepModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目立项阶段审核状态更新失败");
    }

    @Override
    protected FlowApplyStatusModel getFlowApplyStatus(ProjectEstablishStepModel model){
        ProjectEstablishStepModel projectEstablishStepModel = this.projectEstablishStepService.selectById(model.getId());
        if(Objects.isNull(projectEstablishStepModel)){
            throw new SystemParamCheckException("项目立项阶段设置异常");
        }
        Integer status = projectEstablishStepModel.getFlowState();
        Long flowId = projectEstablishStepModel.getFlowId();
        return new FlowApplyStatusModel(status, flowId);
    }
}

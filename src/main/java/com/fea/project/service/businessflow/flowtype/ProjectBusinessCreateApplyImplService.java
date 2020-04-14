package com.fea.project.service.businessflow.flowtype;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.project.ProjectVersionSelectTypeEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/25 9:38
 * 项目创建申请服务
 **/
@Service
public class ProjectBusinessCreateApplyImplService extends AbstractFlowApply<ProjectModel> {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectVersionService projectVersionService;

    @Override
    protected Long getProjectId(ProjectModel model) {
        return model.getId();
    }

    @Override
    public boolean checkFlowParamIsAvailable(ProjectModel model) {
        return true;
    }



    @Override
    public Integer getFlowTypeId() {
        return ProjectConfigEnum.PROJECT_CREATE_VERIFY.getValue();
    }

    @Override
    public Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId) {
        return projectService.getCurrentFlowNeedChooseFlowList(businessId, flowId);
    }


    @Override
    protected Long getModelPrimaryId(ProjectModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(ProjectModel model) {
        return model.getApplyer();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, ProjectModel model) {
        projectApplyPojo.setName(model.getName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.PROJECT_CREATE_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setBusinessCode(model.getCode());
        projectApplyPojo.setApplyerId(model.getApplyer());
        projectApplyPojo.setApplyDepart(model.getApplyDepart());
        projectApplyPojo.setProjectId(model.getId());
    }

    /**
     * 创建项目版本
     * 更新项目状态
     */
    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long id) {
        Long version = this.projectVersionService.createNewProjectVersionModel(
                id, ProjectVersionSelectTypeEnum.TYPE_REAL.getValue(), id);
        ProjectModel projectModel = new ProjectModel(id, version, ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        if(projectService.updateSelectiveById(projectModel)
            && this.updateApplyStatus(id)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目审核通过状态更新失败");
    }

    @Override
    public boolean revertBusinessInfo(Long id) {
        ProjectModel projectModel = new ProjectModel(id, ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        if(projectService.updateSelectiveById(projectModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目撤销状态更新失败");
    }

    @Override
    public boolean refuseBusinessInfo(Long id) {
        ProjectModel projectModel = new ProjectModel(id, ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        if(projectService.updateSelectiveById(projectModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目撤销状态更新失败");
    }
}

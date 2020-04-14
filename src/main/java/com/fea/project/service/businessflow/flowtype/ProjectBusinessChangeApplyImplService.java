package com.fea.project.service.businessflow.flowtype;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.draft.vo.DraftStepVo;
import com.fea.project.model.project.history.HistoryProjectModel;
import com.fea.project.service.project.ProjectDeliverClaimService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectStepService;
import com.fea.project.service.project.ProjectVersionService;
import com.fea.project.service.project.draft.DraftDeliverClaimService;
import com.fea.project.service.project.draft.DraftProjectService;
import com.fea.project.service.project.draft.DraftStepService;
import com.fea.project.service.project.history.HistoryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/25 9:38
 * 项目创建申请服务
 **/
@Service
public class ProjectBusinessChangeApplyImplService extends AbstractFlowApply<DraftProjectModel> {


    @Autowired
    private DraftProjectService draftProjectService;

    @Autowired
    private DraftStepService draftStepService;

    @Autowired
    private DraftDeliverClaimService draftDeliverClaimService;

    @Autowired
    private ProjectVersionService projectVersionService;

    @Autowired
    private HistoryProjectService historyProjectService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectDeliverClaimService projectDeliverClaimService;

    @Autowired
    private ProjectStepService projectStepService;



    @Override
    protected Long getProjectId(DraftProjectModel model) {
        return model.getOriginalId();
    }

    @Override
    public boolean checkFlowParamIsAvailable(DraftProjectModel model) {
        return true;
    }


    @Override
    public Integer getFlowTypeId() {
        return ProjectConfigEnum.PROJECT_CHANGE_VERIFY.getValue();
    }

    @Override
    public Long getCurrentFlowNeedChooseFlowList(Long draftId, Long flowId) {
        return draftProjectService.getCurrentFlowNeedChooseFlowList(draftId, flowId);
    }


    @Override
    protected Long getModelPrimaryId(DraftProjectModel model) {
        return model.getId();
    }

    @Override
    protected Long getApplyer(DraftProjectModel model) {
        return model.getApplyer();
    }

    @Override
    protected void setProjectApplyConnectBusinessInfo(ProjectApplyPojo projectApplyPojo, DraftProjectModel model) {
        projectApplyPojo.setName(model.getName());
        projectApplyPojo.setApplyType(ProjectFlowTypeEnum.PROJECT_CHANGE_VERIFY.getValue());
        projectApplyPojo.setBusinessId(model.getId());
        projectApplyPojo.setBusinessCode(model.getCode());
        projectApplyPojo.setApplyerId(model.getApplyer());
        projectApplyPojo.setApplyDepart(model.getApplyDepart());
        projectApplyPojo.setProjectId(model.getOriginalId());
    }

    @Override
    public boolean updateBusinessInfoWhenFlowFinish(Long draftId){
        //获取项目版本，插入新版本，移除旧版本
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(draftId);
        List<DraftStepVo> draftStepVos = draftStepService.selectByDraftId(draftId);
        List<DraftDeliverClaimModel> draftDeliverClaimModels = draftDeliverClaimService.selectByDraftId(draftId);
        HistoryProjectModel historyProjectModel = null;
        //草稿替换正式版数据
        try {
            historyProjectModel = historyProjectService.createHistoryProject(new ProjectModel(draftProjectModel.getOriginalId()));
        } catch (Exception e) {
            throw new SystemParamCheckException(e);
        }
        Long versionId = projectVersionService.deleteDraftVersionAndInsertNewRealVersion(draftId, draftProjectModel.getOriginalId(), historyProjectModel.getId());
        ProjectModel projectModel = new ProjectModel(draftProjectModel, versionId);
        if(this.projectService.updateSelectiveById(projectModel)
            && this.projectDeliverClaimService.insertOrUpdateList(draftDeliverClaimModels, projectModel.getId())
            && this.projectStepService.insertOrUpdateList(draftStepVos, projectModel.getId())
            && this.updateApplyStatus(draftId)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean revertBusinessInfo(Long draftId) {
        DraftProjectModel draftProjectModel = new DraftProjectModel(draftId, ProjectApplyVerifyStatusEnum.TYPE_HAS_REVERT.getValue());
        if(draftProjectService.updateSelectiveById(draftProjectModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目撤销状态更新失败");
    }

    @Override
    public boolean refuseBusinessInfo(Long draftId) {
        DraftProjectModel draftProjectModel = new DraftProjectModel(draftId, ProjectApplyVerifyStatusEnum.TYPE_HAS_REFUSE.getValue());
        if(draftProjectService.updateSelectiveById(draftProjectModel)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目撤销状态更新失败");
    }


}

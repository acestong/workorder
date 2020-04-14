package com.fea.project.service.project.history;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.history.HistoryProjectMapper;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.ProjectStepVerifyModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.history.HistoryDeliverClaimModel;
import com.fea.project.model.project.history.HistoryProjectModel;
import com.fea.project.model.project.history.HistoryStepModel;
import com.fea.project.model.project.history.HistoryStepVerifyModel;
import com.fea.project.model.project.history.vo.HistoryProjectVo;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.project.ProjectDeliverClaimService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectStepService;
import com.fea.project.service.project.ProjectStepVerifyService;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/12/19.
 * 项目信息表 Service
 */
@Service
public class HistoryProjectService {

    @Autowired
    private HistoryProjectMapper historyProjectMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectDeliverClaimService projectDeliverClaimService;

    @Autowired
    private ProjectStepService projectStepService;

    @Autowired
    private ProjectStepVerifyService projectStepVerifyService;

    @Autowired
    private HistoryDeliverClaimService historyDeliverClaimService;

    @Autowired
    private HistoryStepService historyStepService;

    @Autowired
    private HistoryStepVerifyService historyStepVerifyService;


    @Transactional(rollbackFor = Exception.class)
    public HistoryProjectModel createHistoryProject(ProjectModel model) throws Exception {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        ProjectVo projectVo = this.projectService.selectOne(model, false);
        return createOrUpdateDraftProjectModel(projectVo, null);
    }

    /**
     * 创建或是更新项目草稿信息
     * @param projectVo 项目信息
     * @param historyId 草稿id，如果存在表示更新草稿信息，如果不存在，表示新增草稿
     * @return
     */
    private HistoryProjectModel createOrUpdateDraftProjectModel(ProjectVo projectVo, Long historyId) {
        projectVo.setVerifyStatus(null);
        List<ProjectDeliverClaimVo> projectDeliverClaimVos = this.projectDeliverClaimService.listByProjectId(new ProjectDeliverClaimModel(projectVo.getId()));
        List<ProjectStepVo> projectStepModels = this.projectStepService.listByProjectId(new ProjectStepModel(projectVo.getId()));
        List<ProjectStepVerifyModel> projectStepVerifyModels = this.projectStepVerifyService.selectByStepIds(
                projectStepModels.stream().map(ProjectStepVo::getId).distinct().collect(Collectors.toList()));
        /**
         * 项目基本信息复制
         * 项目阶段进行复制
         * 项目阶段审核信息进行复制
         * 项目交付物信息复制
         * （项目联系人直接添加，不进行保存）
         */
        HistoryProjectModel historyProjectModel = new HistoryProjectModel(projectVo, UserUtil.getUserId());
        List<HistoryDeliverClaimModel> historyDeliverClaimModels = projectDeliverClaimVos.stream().map(HistoryDeliverClaimModel::new).collect(Collectors.toList());
        List<HistoryStepModel> historyStepModels = projectStepModels.stream().map(HistoryStepModel::new).collect(Collectors.toList());
        List<HistoryStepVerifyModel> historyStepVerifyModels = projectStepVerifyModels.stream().map(HistoryStepVerifyModel::new).collect(Collectors.toList());
        if(this.insertOrUpdateSelectiveByDraftId(historyProjectModel, historyId)
                && this.historyDeliverClaimService.insertListSelective(historyDeliverClaimModels, historyProjectModel.getId())
                && this.historyStepService.insertListSelective(historyStepModels, historyProjectModel.getId())
                && this.historyStepVerifyService.insertListSelective(historyStepVerifyModels, historyProjectModel.getId())){
            return new HistoryProjectModel(historyProjectModel.getId());
        }
        throw new SystemParamCheckException("草稿信息生成失败");
    }

    private boolean insertOrUpdateSelectiveByDraftId(HistoryProjectModel historyProjectModel, Long historyId) {
        historyProjectModel.setId(historyId == null?historyProjectModel.getId():historyId);
        if(historyId == null && this.historyProjectMapper.insert(historyProjectModel) >= 0){
            return Boolean.TRUE;
        }else if(historyId != null && this.historyProjectMapper.updateById(historyProjectModel) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("草稿项目信息生成失败");
    }

    public HistoryProjectVo selectOne(DraftProjectModel model) throws ExecutionException, InterruptedException {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("传入的草稿id异常，无法进行查询");
        }
        HistoryProjectVo historyProjectVo = this.historyProjectMapper.selectById(model.getId());
        ProjectVo projectVo = historyProjectVo.createProjectModel();
        projectVo = projectService.fileProjectInfo(Stream.of(projectVo).collect(Collectors.toList())).get(0);
        historyProjectVo.setExtentionInfo(projectVo);
        return historyProjectVo;
    }
}
package com.fea.project.model.businessflow.pojo;

import com.fea.project.model.businessflow.ProjectBusinessFlowCopyerModel;
import com.fea.project.model.businessflow.ProjectBusinessFlowListConditionModel;
import com.fea.project.model.businessflow.ProjectBusinessFlowListModel;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowListPojo extends ProjectBusinessFlowListModel {

    private List<ProjectBusinessFlowCopyerModel> projectBusinessFlowCopyerModels;
    private List<ProjectBusinessFlowVerifyerModel> projectBusinessFlowVerifyerModels;
    private List<ProjectBusinessFlowListConditionModel> projectBusinessFlowListConditionModels;

    public ProjectBusinessFlowListPojo(ProjectFlowListVo projectFlowListVo, Long businessFlowId) {
        super(projectFlowListVo, businessFlowId);
        this.projectBusinessFlowCopyerModels = projectFlowListVo.getProjectFlowCopyerModels().stream().map(ProjectBusinessFlowCopyerModel::new).collect(Collectors.toList());
        this.projectBusinessFlowVerifyerModels = projectFlowListVo.getProjectFlowVerifyerModels().stream().map(ProjectBusinessFlowVerifyerModel::new).collect(Collectors.toList());
        this.projectBusinessFlowListConditionModels = projectFlowListVo.getProjectFlowListConditionModels().stream().map(ProjectBusinessFlowListConditionModel::new).collect(Collectors.toList());
    }
}
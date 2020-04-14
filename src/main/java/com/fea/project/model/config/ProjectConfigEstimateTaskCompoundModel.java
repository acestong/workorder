package com.fea.project.model.config;

import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 17:43
 **/
@Data
public class ProjectConfigEstimateTaskCompoundModel {

    private ProjectConfigEstimateTaskModel projectConfigEstimateTaskModel;

    private List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels;

    public ProjectConfigEstimateTaskCompoundModel() {
    }

    public ProjectConfigEstimateTaskCompoundModel(ProjectConfigEstimateTaskModel projectConfigEstimateTaskModel, List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels) {
        this.projectConfigEstimateTaskModel = projectConfigEstimateTaskModel;
        this.projectConfigEstimatePercentModels = projectConfigEstimatePercentModels;
    }
}

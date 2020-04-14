package com.fea.project.model.config;

import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 17:43
 **/
@Data
public class ProjectConfigEstimateCloseCompoundModel {

    private List<ProjectConfigEstimateCloseModel> projectConfigEstimateCloseModels;

    public ProjectConfigEstimateCloseCompoundModel() {
    }

    public ProjectConfigEstimateCloseCompoundModel(List<ProjectConfigEstimateCloseModel> projectConfigEstimateCloseModels) {
        this.projectConfigEstimateCloseModels = projectConfigEstimateCloseModels;
    }
}

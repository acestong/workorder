package com.fea.project.model.config;

import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 17:43
 **/
@Data
public class ProjectConfigEstimateDeliverableCompoundModel {

    private ProjectConfigEstimateDevlierableModel projectConfigEstimateDevlierableModel;

    private List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels;

    public ProjectConfigEstimateDeliverableCompoundModel() {
    }

    public ProjectConfigEstimateDeliverableCompoundModel(ProjectConfigEstimateDevlierableModel projectConfigEstimateDevlierableModel, List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels) {
        this.projectConfigEstimateDevlierableModel = projectConfigEstimateDevlierableModel;
        this.projectConfigEstimatePercentModels = projectConfigEstimatePercentModels;
    }
}

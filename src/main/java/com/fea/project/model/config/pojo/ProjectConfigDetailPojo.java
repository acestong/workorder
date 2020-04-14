package com.fea.project.model.config.pojo;

import com.fea.project.model.config.*;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 18:20
 **/
@Data
public class ProjectConfigDetailPojo {

    private List<ProjectConfigModel> projectConfigModelList;

    /**
     * 交付物评价
     */
    private ProjectConfigEstimateDeliverableCompoundModel projectConfigEstimateDeliverableCompoundModel;
    /**
     * 任务评价
     */
    private ProjectConfigEstimateTaskCompoundModel projectConfigEstimateTaskCompoundModel;
    /**
     * 结项评价
     */
    private ProjectConfigEstimateCloseCompoundModel projectConfigEstimateCloseCompoundModel;

    public ProjectConfigDetailPojo() {
    }

    private List<ProjectConfigMilestoneModel> projectConfigMilestoneModels;

    public ProjectConfigDetailPojo(List<ProjectConfigModel> list) {
        this.projectConfigModelList = list;
    }

    public ProjectConfigDetailPojo(List<ProjectConfigModel> list, ProjectConfigEstimateDeliverableCompoundModel projectConfigEstimateDeliverableCompoundModel
            , ProjectConfigEstimateTaskCompoundModel projectConfigEstimateTaskCompoundModel, ProjectConfigEstimateCloseCompoundModel projectConfigEstimateCloseCompoundModel
            , List<ProjectConfigMilestoneModel> projectConfigMilestoneModels) {
        this(list);
        this.projectConfigEstimateCloseCompoundModel = projectConfigEstimateCloseCompoundModel;
        this.projectConfigEstimateDeliverableCompoundModel = projectConfigEstimateDeliverableCompoundModel;
        this.projectConfigEstimateTaskCompoundModel = projectConfigEstimateTaskCompoundModel;
        this.projectConfigMilestoneModels = projectConfigMilestoneModels;
    }
}

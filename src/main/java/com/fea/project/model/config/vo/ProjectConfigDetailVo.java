package com.fea.project.model.config.vo;

import com.fea.project.model.config.ProjectConfigEstimateCloseCompoundModel;
import com.fea.project.model.config.ProjectConfigEstimateDeliverableCompoundModel;
import com.fea.project.model.config.ProjectConfigEstimateTaskCompoundModel;
import com.fea.project.model.config.ProjectConfigMilestoneModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 18:20
 **/
@Data
public class ProjectConfigDetailVo {

    private List<ProjectConfigVo> projectConfigModelList;

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

    private List<ProjectConfigMilestoneModel> projectConfigMilestoneModels;

    private Integer isInit;


    public ProjectConfigDetailVo(List<ProjectConfigVo> list) {
        this.projectConfigModelList = list;
    }

    public ProjectConfigDetailVo(List<ProjectConfigVo> list, ProjectConfigEstimateDeliverableCompoundModel projectConfigEstimateDeliverableCompoundModel
            , ProjectConfigEstimateTaskCompoundModel projectConfigEstimateTaskCompoundModel, ProjectConfigEstimateCloseCompoundModel projectConfigEstimateCloseCompoundModel
            , List<ProjectConfigMilestoneModel> projectConfigMilestoneModels) {
        this(list);
        this.projectConfigEstimateCloseCompoundModel = projectConfigEstimateCloseCompoundModel;
        this.projectConfigEstimateDeliverableCompoundModel = projectConfigEstimateDeliverableCompoundModel;
        this.projectConfigEstimateTaskCompoundModel = projectConfigEstimateTaskCompoundModel;
        this.projectConfigMilestoneModels = projectConfigMilestoneModels;
    }
}

package com.fea.project.model.baseconfig.vo;

import com.fea.project.model.baseconfig.ProjectBaseSetPlanModel;
import com.fea.project.model.baseconfig.ProjectBaseSetTaskModel;
import com.fea.project.model.baseconfig.ProjectCodeModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 11:53
 **/
@Data
public class ProjectBaseSetVo {

    private ProjectCodeModel projectCodeModel;
    private List<ProjectBaseSetTaskModel> projectBaseSetTaskModels;
    private List<ProjectBaseSetPlanModel> projectBaseSetPlanModels;

    public ProjectBaseSetVo() {
    }

    public ProjectBaseSetVo(ProjectCodeModel projectCodeModel, List<ProjectBaseSetPlanModel> projectBaseSetPlanModels
            , List<ProjectBaseSetTaskModel> projectBaseSetTaskModels) {
        this.projectCodeModel = projectCodeModel;
        this.projectBaseSetTaskModels = projectBaseSetTaskModels;
        this.projectBaseSetPlanModels = projectBaseSetPlanModels;
    }
}

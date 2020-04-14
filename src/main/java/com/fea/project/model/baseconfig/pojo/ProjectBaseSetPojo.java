package com.fea.project.model.baseconfig.pojo;

import com.fea.project.model.baseconfig.ProjectBaseSetPlanModel;
import com.fea.project.model.baseconfig.ProjectBaseSetTaskModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 11:53
 **/
@Data
public class ProjectBaseSetPojo {

    private ProjectCodePojo projectCodeModel;
    private List<ProjectBaseSetTaskModel> projectBaseSetTaskModels;
    private List<ProjectBaseSetPlanModel> projectBaseSetPlanModels;

}

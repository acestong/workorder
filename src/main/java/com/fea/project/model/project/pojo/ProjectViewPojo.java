package com.fea.project.model.project.pojo;

import com.fea.project.model.project.ProjectViewModel;
import com.fea.project.model.project.ProjectViewSelfConfigModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/31 9:24
 **/
@Data
public class ProjectViewPojo extends ProjectViewModel {

    private List<ProjectViewSelfConfigModel> projectViewSelfConfigModels;


}

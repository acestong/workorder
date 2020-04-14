package com.fea.project.model.baseconfig.pojo;

import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.model.baseconfig.ProjectCodeShortNameModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 */
@Data
public class ProjectCodePojo extends ProjectCodeModel {

    private List<ProjectCodeShortNameModel> projectCodeShortNameModels;


}
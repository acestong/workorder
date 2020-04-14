package com.fea.project.model.establishproject.vo;

import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/12/30.
 */
@Data
public class ProjectEstablishStepVo extends ProjectEstablishStepModel {

    private String leadName;

    private String flowName;

    private List<ProjectAppendixModel> appendixModels;

    private String verifyStatusName;

    private Integer sumitBtnShow;

    public ProjectEstablishStepVo() {
    }
}
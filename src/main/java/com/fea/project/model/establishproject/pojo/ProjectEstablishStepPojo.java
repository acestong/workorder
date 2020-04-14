package com.fea.project.model.establishproject.pojo;

import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/12/30.
 */
@Data
public class ProjectEstablishStepPojo extends ProjectEstablishStepModel {

    private List<Long> appendixs;


}
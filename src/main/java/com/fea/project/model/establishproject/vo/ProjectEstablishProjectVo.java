package com.fea.project.model.establishproject.vo;

import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/12/23.
 */
@Data
public class ProjectEstablishProjectVo extends ProjectEstablishProjectModel {


    /**
     * 立项申请人名称
     */
    private String applyerName;

    /**
     * 立项成员名称
     */
    private String establishPartnersNames;

    private String establishLeaderName;

    private String establishStepName;

    private String startStatusName;


    public ProjectEstablishProjectVo() {
    }
}
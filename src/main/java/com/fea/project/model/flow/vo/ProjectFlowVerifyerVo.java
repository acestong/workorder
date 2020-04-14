package com.fea.project.model.flow.vo;

import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.model.flow.ProjectFlowVerifyerModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowVerifyerVo extends ProjectFlowVerifyerModel {

    protected String detailStrName;


    public ProjectFlowVerifyerVo() {
    }


    public ProjectFlowVerifyerVo(ProjectBusinessFlowVerifyerModel projectBusinessFlowVerifyerModel) {
        super(projectBusinessFlowVerifyerModel);
    }
}
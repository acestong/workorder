package com.fea.project.model.apply.pojo;

import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
@Data
public class ProjectApplyFlowInfoPojo extends ProjectApplyFlowInfoModel {

    private List<ProjectApplyFlowVerifyModel> projectApplyFlowVerifyModels;

    private Long projectBusinessFlowVerifyId;

    public ProjectApplyFlowInfoPojo() {
    }

}
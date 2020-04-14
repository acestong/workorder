package com.fea.project.model.flow.vo;

import com.fea.project.model.flow.ProjectFlowListModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowListVo extends ProjectFlowListModel {

    private List<ProjectFlowListConditionVo> projectFlowListConditionModels;

    private List<ProjectFlowCopyerVo> projectFlowCopyerModels;

    private List<ProjectFlowVerifyerVo> projectFlowVerifyerModels;

}
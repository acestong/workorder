package com.fea.project.model.flow.pojo;

import com.fea.project.model.flow.ProjectFlowListModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowListPojo extends ProjectFlowListModel {

    private Integer flowConfigType;

    private List<ProjectFlowListConditionPojo> projectFlowListConditionModels;

    private List<ProjectFlowCopyerPojo> projectFlowCopyerModels;

    private List<ProjectFlowVerifyerPojo> projectFlowVerifyerModels;

    private List<Long> ids;

    public ProjectFlowListPojo(List<Long> ids) {
        this.ids = ids;
    }

    public ProjectFlowListPojo() {
    }
}
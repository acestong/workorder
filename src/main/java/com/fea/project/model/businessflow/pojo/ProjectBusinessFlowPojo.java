package com.fea.project.model.businessflow.pojo;

import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowPojo extends ProjectBusinessFlowModel {

    public ProjectBusinessFlowPojo() {
    }

    public ProjectBusinessFlowPojo(Long id, Long listId) {
        super(id, listId);
    }

    public ProjectBusinessFlowPojo(ProjectBusinessFlowCopyParamPojo projectBusinessFlowCopyParamPojo) {
        this.id = projectBusinessFlowCopyParamPojo.getId();
        this.listId = projectBusinessFlowCopyParamPojo.getListId();
    }


}
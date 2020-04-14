package com.fea.project.model.team.pojo;

import com.fea.project.model.team.ProjectTeamModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
public class ProjectTeamPojo extends ProjectTeamModel {

    private Boolean noRemoveGroup;

    public ProjectTeamPojo() {
    }

    public ProjectTeamPojo(Long projectId, Boolean noRemoveGroup) {
        this.projectId = projectId;
        this.noRemoveGroup = noRemoveGroup;
    }
}
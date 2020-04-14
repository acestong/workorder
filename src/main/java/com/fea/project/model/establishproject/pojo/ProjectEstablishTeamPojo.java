package com.fea.project.model.establishproject.pojo;

import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
public class ProjectEstablishTeamPojo extends ProjectEstablishTeamModel {

    private Boolean noRemoveGroup;

    public ProjectEstablishTeamPojo() {
    }

    public ProjectEstablishTeamPojo(Long projectId, Boolean noRemoveGroup) {
        this.projectId = projectId;
        this.noRemoveGroup = noRemoveGroup;
    }
}
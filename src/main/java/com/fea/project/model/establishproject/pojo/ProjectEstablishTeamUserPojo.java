package com.fea.project.model.establishproject.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import lombok.Data;

import java.util.List;

@Data
public class ProjectEstablishTeamUserPojo extends ProjectEstablishTeamUserModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> userIds;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> ids;

    private Long roleId;

    public ProjectEstablishTeamUserPojo() {
    }

    public ProjectEstablishTeamUserPojo(Long teamId) {
        this.teamId = teamId;
    }
}


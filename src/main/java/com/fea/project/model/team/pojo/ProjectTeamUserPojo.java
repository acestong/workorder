package com.fea.project.model.team.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.team.ProjectTeamUserModel;
import lombok.Data;

import java.util.List;

@Data
public class ProjectTeamUserPojo extends ProjectTeamUserModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> userIds;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> ids;

    private Long roleId;

    public ProjectTeamUserPojo() {
    }

    public ProjectTeamUserPojo(Long teamId) {
        this.teamId = teamId;
    }
}


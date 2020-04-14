package com.fea.project.model.milestone.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class UserListTeamVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long regId;
    private String realName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long teamId;
    private String teamName;
}

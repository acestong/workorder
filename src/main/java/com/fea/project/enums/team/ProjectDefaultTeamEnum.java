package com.fea.project.enums.team;

import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import com.fea.project.model.team.ProjectTeamModel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/12 10:26
 * 项目默认团队
 **/
public enum ProjectDefaultTeamEnum {

    TYPE_UNGROUP_QUEUE(Long.MAX_VALUE - 1, "未分配成员", "没有分组的成员"
            , EnableStatusEnum.DISABLE.getStatus(), "ungroup_queue"),
    TYPE_REMOVE_QUEUE(Long.MAX_VALUE, "移出项目组的成员", "移出项目族的成员"
            , EnableStatusEnum.DISABLE.getStatus(), "remove_queue");

    private Long value;
    private String text;
    private String responsibility;
    private Integer canDelete;
    private String shortName;

    ProjectDefaultTeamEnum(Long value, String text, String responsibility, Integer canDelete, String shortName) {
        this.value = value;
        this.text = text;
        this.responsibility = responsibility;
        this.canDelete = canDelete;
        this.shortName = shortName;
    }

    public static Long getDefaultIndex() {
        return System.currentTimeMillis();
    }

    public static final List<ProjectTeamModel> initSysTeam() {
        return Stream.of(ProjectDefaultTeamEnum.values()).map(tmp -> new ProjectTeamModel(tmp)).collect(Collectors.toList());
    }

    public static List<ProjectEstablishTeamModel> initEstablishSysTeam() {
        return Stream.of(ProjectDefaultTeamEnum.values()).map(tmp -> new ProjectEstablishTeamModel(tmp)).collect(Collectors.toList());
    }

    public Long getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public Integer getCanDelete() {
        return canDelete;
    }

    public String getShortName() {
        return shortName;
    }
}

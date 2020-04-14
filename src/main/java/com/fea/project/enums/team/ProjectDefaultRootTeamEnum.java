package com.fea.project.enums.team;

import com.fea.project.enums.base.EnableStatusEnum;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/14 16:33
 * 项目默认根项目枚举
 **/
public enum ProjectDefaultRootTeamEnum {


    TYPE_ROOT_TEAM(0L, "项目组", ""
            , EnableStatusEnum.DISABLE.getStatus(), "root_queue");

    private Long value;
    private String text;
    private String responsibility;
    private Integer canDelete;
    private String shortName;

    ProjectDefaultRootTeamEnum(Long value, String text, String responsibility, Integer canDelete, String shortName) {
        this.value = value;
        this.text = text;
        this.responsibility = responsibility;
        this.canDelete = canDelete;
        this.shortName = shortName;
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

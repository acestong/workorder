package com.fea.project.enums.task;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 10:01
 **/
public enum ProjectTeamTagEnum {

    TYPE_TEAM(0, "团队"),
    TYPE_USER(1, "人员");

    private Integer value;
    private String text;

    ProjectTeamTagEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }
 
    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

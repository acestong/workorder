package com.fea.project.enums.project;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/30 11:27
 **/
public enum ProjectQueryPersonOrTeamEnum {

    TYPE_PERSON(1, "个人"),
    TYPE_TEAM(2, "团队");

    private Integer value;
    private String text;

    ProjectQueryPersonOrTeamEnum(Integer value, String text) {
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

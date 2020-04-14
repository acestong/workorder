package com.fea.project.enums.team;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/12 15:10
 **/
public enum ProjectDefaultRoleEnum {

    TYPE_PROJECT_ADMIN(0, "项目经理", "project_admin");

    private Integer value;
    private String text;
    private String shortName;

    ProjectDefaultRoleEnum(Integer value, String text, String shortName) {
        this.value = value;
        this.text = text;
        this.shortName = shortName;
    }


    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getShortName() {
        return shortName;
    }
}

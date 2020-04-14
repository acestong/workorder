package com.fea.project.enums.project;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/27 16:32
 * 项目父子类型枚举
 **/
public enum ProjectParentOrChildTypeEnum {

    TYPE_PARENT(1, "父类项目"),
    TYPE_CHILD(2, "子类项目");

    private Integer value;
    private String text;

    ProjectParentOrChildTypeEnum(Integer value, String text) {
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

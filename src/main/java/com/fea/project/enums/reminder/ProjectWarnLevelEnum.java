package com.fea.project.enums.reminder;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 10:52
 * 预警状态枚举
 **/
public enum ProjectWarnLevelEnum {

    TYPE_WARN(1, "预警"),
    TYPE_EXCEED_TIME(2, "超期"),
    TYPE_SERIOUS_EXCEED_TIME(3, "严重超期");

    private Integer value;
    private String text;

    ProjectWarnLevelEnum(Integer value, String text) {
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

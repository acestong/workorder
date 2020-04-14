package com.fea.project.enums.project;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/8 14:35
 **/
public enum ProjectEstablishStartStatusEnum {

    TYPE_UNSTART(0, "未启动"),
    TYPE_START(1, "已启动");

    private Integer value;
    private String text;

    ProjectEstablishStartStatusEnum(Integer value, String text) {
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

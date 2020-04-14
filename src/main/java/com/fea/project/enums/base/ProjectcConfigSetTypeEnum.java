package com.fea.project.enums.base;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/25 10:48
 * 此类用于识别到底是在编号设置页面设置的通用配置，还是在针对每一个项目内部流程设置的
 **/
public enum ProjectcConfigSetTypeEnum {

    TYPE_GENERAL(1, "通用设置"),
    TYPE_SELF(2, "项目内部设置");

    private Integer value;
    private String text;

    ProjectcConfigSetTypeEnum(Integer value, String text) {
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

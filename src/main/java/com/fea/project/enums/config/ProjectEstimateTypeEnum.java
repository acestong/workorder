package com.fea.project.enums.config;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 13:57
 * 项目评价类型枚举
 **/
public enum ProjectEstimateTypeEnum {

    TYPE_DELIVERABLE(1, "项目交付物"),
    TYPE_TASK(2, "项目任务");

    private Integer value;
    private String text;

    ProjectEstimateTypeEnum(Integer value, String text) {
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

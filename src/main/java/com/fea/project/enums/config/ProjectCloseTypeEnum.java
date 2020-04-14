package com.fea.project.enums.config;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/9 9:23
 * 项目结项类型枚举
 **/
public enum ProjectCloseTypeEnum {

    TYPE_FULL(1, "按整体"),
    TYPE_STEP(2, "按阶段");

    private Integer value;
    private String text;

    ProjectCloseTypeEnum(Integer value, String text) {
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

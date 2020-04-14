package com.fea.project.enums.config;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/18 17:35
 **/
public enum ProjectTaskProgressEnum {

    TYPE_APPEND_CHILD_TASK(1, "以项目子任务进度平均计算， 得到项目任务的进度"),
    TYPE_INPUT_BY_HAND(2, "项目任务负责人对项目进度进行手动汇报");

    private Integer value;
    private String text;

    ProjectTaskProgressEnum(Integer value, String text) {
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

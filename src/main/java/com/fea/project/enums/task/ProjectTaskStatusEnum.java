package com.fea.project.enums.task;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 10:59
 * 项目任务执行状态
 **/
public enum ProjectTaskStatusEnum {

    TYPE_UNSTART(1, "未开始"),
    TYPE_RUNNING(2, "进行中"),
    TYPE_FINISH(3, "已完成");

    private Integer value;
    private String text;

    ProjectTaskStatusEnum(Integer value, String text) {
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

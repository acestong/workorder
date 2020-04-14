package com.fea.project.enums.apply;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/9 12:05
 **/
public enum ProjectApplyFlowStatusColorTypeEnum {

    TYPE_REVERT(-3, "已撤销"),
    TYPE_HAVING_BEATBACK(-2, "已驳回"),
    TYPE_HAVING_REFUSE(-1, "已拒绝"),
    TYPE_WAITING_ACTION(0, "待执行"),
    TYPE_ACTING(1, "处理中"),
    TYPE_HAVING_ACTION(2, "已处理");

    private Integer value;
    private String text;

    ProjectApplyFlowStatusColorTypeEnum(Integer value, String text) {
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

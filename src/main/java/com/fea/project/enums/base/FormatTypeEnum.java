package com.fea.project.enums.base;

/**
 * @author wuqi
 * @since 2019/10/10 14:08
 **/
public enum FormatTypeEnum {

    TYPE_LIST(1, "列表"),
    TYPE_DATE(2, "时间");

    private Integer value;
    private String text;

    FormatTypeEnum(Integer value, String text) {
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

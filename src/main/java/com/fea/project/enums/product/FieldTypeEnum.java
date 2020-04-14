package com.fea.project.enums.product;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/3/27 13:56
 **/
public enum FieldTypeEnum {
    TEXT(1L,"文本"),
    AMOUNT(2L,"金额"),
    NUMBER(3L,"数量");
    private Long code;
    private String text;

    FieldTypeEnum(Long code, String text) {
        this.code = code;
        this.text = text;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

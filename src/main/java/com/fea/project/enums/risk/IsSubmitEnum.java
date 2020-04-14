package com.fea.project.enums.risk;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/3 14:33
 **/
public enum IsSubmitEnum {
    NOT_SUBMIT(0,"未提交"),
    SUBMIT(1,"已提交");
    private Integer code;
    private String text;

    IsSubmitEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

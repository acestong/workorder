package com.fea.project.enums.feebudget;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/1/15 10:29
 **/
public enum UseTypeEnum {
    GE("个"),
    TAI("台");

    private String text;

    UseTypeEnum( String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.fea.project.enums.feebudget;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/20 9:53
 **/
public enum  FeeTypeEnum {
    HUMAN("人工费用"),
    REIMB("报销费用"),
    DAILY("日常费用"),
    TRAVEL("差旅费"),
    MATERIAL("物料费用"),
    OTHER("其他费用");

    private String text;

    FeeTypeEnum( String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

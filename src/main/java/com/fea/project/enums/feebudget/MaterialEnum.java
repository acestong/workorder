package com.fea.project.enums.feebudget;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/18 16:18
 **/
public enum MaterialEnum {
    ASSET_PURCHASE("资产采购"),
    OTHER("其他");

    private String text;

    MaterialEnum( String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

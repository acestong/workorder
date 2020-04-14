package com.fea.project.enums.feebudget;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/18 15:41
 **/
public enum ReimbTypeEnum {
    BUSINESS(1,"出差"),
    EVERYDAY(2,"日常"),
    PURCHASE(3,"采购");

    private Integer code;
    private String text;

    ReimbTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String ReimbTypeEnum(Integer code){
        for (int i = 0; i< ReimbTypeEnum.values().length; i++){
            ReimbTypeEnum ice= ReimbTypeEnum.values()[i];
            if (ice.getCode().equals(code)){
                return ice.getText();
            }
        }
        return null;
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

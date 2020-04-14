package com.fea.project.enums.feebudget;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/1/13 15:21
 **/
public enum IsDraftEnum {
    NOT_DRAFT(0,"非草稿"),
    DRATE(1,"草稿"),
    CHANGED(2,"已变更");

    private Integer code;
    private String text;

    IsDraftEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String IsDraftEnum(Integer code){
        for (int i = 0; i< IsDraftEnum.values().length; i++){
            IsDraftEnum ice= IsDraftEnum.values()[i];
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

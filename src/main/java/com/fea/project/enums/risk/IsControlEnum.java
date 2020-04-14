package com.fea.project.enums.risk;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/3 14:28
 **/
public enum IsControlEnum {
    CAN_CONTROL(0,"是"),
    CAN_NOT_CONTROL(1,"否");
    private Integer code;
    private String text;

    IsControlEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Integer queryCode(String text){
        for (int i = 0; i< IsControlEnum.values().length; i++){
            IsControlEnum ase= IsControlEnum.values()[i];
            if (ase.getText().equals(text)){
                return ase.getCode();
            }
        }
        return null;
    }
    public static String queryDescription(Integer code){
        for (int i=0;i<IsControlEnum.values().length;i++){
            IsControlEnum ite=IsControlEnum.values()[i];
            if (ite.getCode().equals(code)){
                return ite.getText();
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

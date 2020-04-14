package com.fea.project.enums.feebudget;


/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/1/13 15:42
 **/
public enum IsCheckEnum {
    NO_SUBMIT(1,"未提交"),
    NO_AUDIT(2,"未审核"),
    SUCCESS_AUDIT(3,"已审核"),
    REJECT_AUDIT(4,"已拒绝");

    private Integer code;
    private String text;

    IsCheckEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String queryText(Integer code){
        for (int i = 0; i< IsCheckEnum.values().length; i++){
            IsCheckEnum ase= IsCheckEnum.values()[i];
            if (ase.getCode().equals(code)){
                return ase.getText();
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

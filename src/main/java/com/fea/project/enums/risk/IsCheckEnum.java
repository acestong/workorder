package com.fea.project.enums.risk;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/3 14:40
 **/
public enum IsCheckEnum {
    NOT_SUBMIT(1,"未提交"),
    NOT_AUDIT(2,"未审核"),
    SUCCESS_AUDIT(3,"审核通过"),
    REJECT_AUDIT(4,"已拒绝");

    private Integer code;
    private String text;

    IsCheckEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String queryText(Integer code){
        for (int i = 0; i< IsCheckEnum.values().length; i++){
            IsCheckEnum ice= IsCheckEnum.values()[i];
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

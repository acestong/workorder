package com.fea.project.enums.milestone;

/**
 * @author Administrator
 */

public enum IsFinishEnum {

    NOT_BEGIN(0,"未开始"),

    EXECUTING(1,"执行中"),

    FINISH(2,"已确认");

    private Integer code;
    private String text;

    IsFinishEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String queryText(Integer code){
        for (int i = 0; i< IsFinishEnum.values().length; i++){
            IsFinishEnum ase= IsFinishEnum.values()[i];
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

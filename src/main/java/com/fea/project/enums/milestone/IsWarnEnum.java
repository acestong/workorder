package com.fea.project.enums.milestone;

/**
 * @author Administrator
 */

public enum IsWarnEnum {

    OVER_TIME(1,"超期"),
    AHEAD_TIME(2,"提前"),
    NORMAL(3,"正常"),
    EXECUTING(4,"进行中");

    private Integer code;
    private String text;

    IsWarnEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String queryText(Integer code){
        for (int i = 0; i< IsWarnEnum.values().length; i++){
            IsWarnEnum ase= IsWarnEnum.values()[i];
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

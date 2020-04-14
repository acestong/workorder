package com.fea.project.enums.milestone;

/**
 * @author Administrator
 */

public enum ChangeStatusEnum {

    NO_CHANGE("0","未变更"),
    CHANGING("1","变更草稿"),
    CHANGE_HISTORY("2","变更记录");

    private String code;
    private String text;

    ChangeStatusEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

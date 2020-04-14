package com.fea.project.enums.interflow;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public enum EmailTypeEnum {
    //send emails   receive email
    SEND_EMAILS(1,"发邮件"),
    RECEIVE_EMAILS(2,"收邮件");

    private Integer code;
    private String text;

    EmailTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Map<Integer,String> getMap(){
        return Stream.of(EmailTypeEnum.values()).collect(Collectors.toMap(EmailTypeEnum::getCode,
                EmailTypeEnum::getText));
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

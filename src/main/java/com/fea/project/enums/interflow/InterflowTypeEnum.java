package com.fea.project.enums.interflow;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */

public enum InterflowTypeEnum {

    MEETING(1,"会议记录"),
    PHONE(2,"电话记录"),
    EMAILS(3,"邮件记录"),
    VISITING(4,"拜访记录");

    private Integer code;
    private String text;

    InterflowTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Map<Integer,String> getMap(){
        return Stream.of(InterflowTypeEnum.values()).collect(Collectors.toMap(InterflowTypeEnum::getCode,
                InterflowTypeEnum::getText));
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

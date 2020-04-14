package com.fea.project.enums.interflow;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public enum PhoneTypeEnum {

    CALL_PHONE(1,"去电"),
    ANSWER_PHONE(2,"来电");

    private Integer code;
    private String text;

    PhoneTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Map<Integer,String> getMap(){
        return Stream.of(PhoneTypeEnum.values()).collect(Collectors.toMap(PhoneTypeEnum::getCode,
                PhoneTypeEnum::getText));
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

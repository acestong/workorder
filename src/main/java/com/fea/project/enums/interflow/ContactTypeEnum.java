package com.fea.project.enums.interflow;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public enum ContactTypeEnum {

    INTERNAL_CONTACT(1,"内部联系人"),
    EXTERNAL_CONTACT(2,"外部联系人");

    private Integer code;
    private String text;

    ContactTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Map<Integer,String> getMap(){
        return Stream.of(ContactTypeEnum.values()).collect(Collectors.toMap(ContactTypeEnum::getCode,
                ContactTypeEnum::getText));
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

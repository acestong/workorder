package com.fea.project.enums.interflow;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public enum VisitingTypeEnum {

    TO_VISIT(1,"去访"),
    COME_VISIT(2,"来访");

    private Integer code;
    private String text;

    VisitingTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static Map<Integer,String> getMap(){
        return Stream.of(VisitingTypeEnum.values()).collect(Collectors.toMap(VisitingTypeEnum::getCode,
                VisitingTypeEnum::getText));
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

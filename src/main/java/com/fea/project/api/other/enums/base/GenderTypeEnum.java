package com.fea.project.api.other.enums.base;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fea.project.enums.plan.PlanAppendixTypeEnum;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 15:51
 **/
public enum GenderTypeEnum {

    TYPE_MALE(0, "男"),
    TYPE_FEMALE(1, "女"),
    TYPE_UNDEFINED(2, "未知");

    private Integer value;
    private String text;

    GenderTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(GenderTypeEnum.values()).collect(Collectors.toMap(GenderTypeEnum::getValue, GenderTypeEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
    
    public static String getValue(Integer value) {  
    	GenderTypeEnum[] enums = values();  
        for (GenderTypeEnum e : enums) {  
            if (e.getValue().equals(value)) {  
                return e.getText();  
            }  
        }  
        return null;  
    }  
}

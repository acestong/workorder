package com.fea.project.enums.flow.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @since 2019/10/10 10:38
 * 同级有多个上级时，执行类别
 **/
public enum ProjectSignTypeEnum {

    TYPE_COUNTER_SIGN(1, "会签"),
    TYPE_SINGLE_SIGN(2, "或签");

    ProjectSignTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    private Integer value;
    private String text;

    public static List<Map<String, Object>> getMap() {
        return Stream.of(ProjectSignTypeEnum.values()).map(x -> new HashMap<String, Object>(2) {{
            put("value", x.value);
            put("text", x.text);
        }}).collect(Collectors.toList());
    }

    public static Map<Integer, String> getVerifyTypeNames() {
        return Stream.of(ProjectSignTypeEnum.values()).collect(Collectors.toMap(ProjectSignTypeEnum::getValue, ProjectSignTypeEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

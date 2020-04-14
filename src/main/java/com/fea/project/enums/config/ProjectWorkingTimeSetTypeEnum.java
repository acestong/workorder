package com.fea.project.enums.config;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/4 10:03
 **/
public enum ProjectWorkingTimeSetTypeEnum {

    TYPE_DAY(1, "日"),
    TYPE_WEEK(2, "周");

    private Integer value;
    private String text;

    ProjectWorkingTimeSetTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, ProjectWorkingTimeSetTypeEnum> getMap() {
        return Stream.of(ProjectWorkingTimeSetTypeEnum.values()).collect(Collectors
                .toMap(ProjectWorkingTimeSetTypeEnum::getValue, x -> x));
    }

    public static Map<Integer, String> getTextMap() {
        return Stream.of(ProjectWorkingTimeSetTypeEnum.values()).collect(Collectors
                .toMap(ProjectWorkingTimeSetTypeEnum::getValue, ProjectWorkingTimeSetTypeEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

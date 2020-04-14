package com.fea.project.enums.project;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/14 11:47
 **/
public enum ProjectVersionSelectTypeEnum {

    TYPE_HISTORY(-1, "历史版本"),
    TYPE_DRAFT(0, "草稿"),
    TYPE_REAL(1, "正式版本");

    private Integer value;
    private String text;

    ProjectVersionSelectTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectVersionSelectTypeEnum.values())
                .collect(Collectors.toMap(ProjectVersionSelectTypeEnum::getValue, ProjectVersionSelectTypeEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

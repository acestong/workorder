package com.fea.project.enums.baseconfig;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 11:43
 **/
public enum ProjectBaseConfigPlanCodeTypeEnum {

    TYPE_PROJECT_PLAN(1, "项目计划"),
    TYPE_PROJECT_CHILDREN_PLAN(2, "项目子计划");

    private Integer value;
    private String text;

    public static List<Integer> getPlanCodes() {
        return Stream.of(ProjectBaseConfigPlanCodeTypeEnum.values())
                .map(ProjectBaseConfigPlanCodeTypeEnum::getValue).collect(Collectors.toList());
    }

    ProjectBaseConfigPlanCodeTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

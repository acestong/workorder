package com.fea.project.enums.baseconfig;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/5 11:43
 **/
public enum ProjectBaseConfigTaskCodeTypeEnum {

    TYPE_PROJECT_TASK(1, "项目任务"),
    TYPE_PROJECT_CHILDREN_TASK(2, "项目子任务"),
    TYPE_PROJECT_WORK_TASK(3, "项目工作任务");

    private Integer value;
    private String text;

    public static List<Integer> getPlanCodes() {
        return Stream.of(ProjectBaseConfigTaskCodeTypeEnum.values())
                .map(ProjectBaseConfigTaskCodeTypeEnum::getValue).collect(Collectors.toList());
    }

    ProjectBaseConfigTaskCodeTypeEnum(Integer value, String text) {
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

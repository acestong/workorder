package com.fea.project.enums.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/26 10:19
 **/
public enum ProjectQueryTypeEnum {
    TYPE_ALL_PROJECT(0, "全部项目"),
    TYPE_CREATE_PROJECT(1, "创建项目"),
    TYPE_LEAD_PROJECT(2, "负责项目"),
    TYPE_ATTENTION_PROJECT(3, "关注项目"),
    TYPE_PART_PROJECT(4, "参加项目"),
    TYPE_MANAGE_USER_PROJECT(5, "下属负责的项目");

    private Integer value;
    private String text;

    ProjectQueryTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static List<Integer> selectStandardQueryType(){
        List<Integer> list = new ArrayList<>();
        list.add(TYPE_CREATE_PROJECT.value);
        list.add(TYPE_LEAD_PROJECT.value);
        list.add(TYPE_ATTENTION_PROJECT.value);
        list.add(TYPE_PART_PROJECT.value);
        return list;
    }

    public static List<Integer> getFullList() {
        return Arrays.stream(ProjectQueryTypeEnum.values()).map(x -> x.getValue()).collect(Collectors.toList());
    }

    public static List<Integer> getUserQueryList(){
        List<Integer> list = new ArrayList<>();
        list.add(ProjectQueryTypeEnum.TYPE_CREATE_PROJECT.getValue());
        list.add(ProjectQueryTypeEnum.TYPE_LEAD_PROJECT.getValue());
        list.add(ProjectQueryTypeEnum.TYPE_ATTENTION_PROJECT.getValue());
        list.add(ProjectQueryTypeEnum.TYPE_PART_PROJECT.getValue());
        return list;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

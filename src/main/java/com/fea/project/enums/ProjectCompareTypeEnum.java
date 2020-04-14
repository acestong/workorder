package com.fea.project.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 10:42
 * 项目任务预警设置
 **/
public enum ProjectCompareTypeEnum {

    TYPE_GREATER_THAN(1, ">", "大于"),
    TYPE_GREATER_THAN_OR_EQUAL_TO(2, "≥", "大于等于"),
    TYPE_LESS_THAN(3, "<", "小于"),
    TYPE_LESS_THAN_OR_EQUAL_TO(4, "≤", "小于等于"),
    TYPE_EQUAL_TO(5, "=", "等于");

    private Integer value;
    private String text;
    private String destribe;

    ProjectCompareTypeEnum(Integer value, String text, String destribe) {
        this.value = value;
        this.text = text;
        this.destribe = destribe;
    }


    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        ProjectCompareTypeEnum[] projectCompareTypeEnums = ProjectCompareTypeEnum.values();
        for (ProjectCompareTypeEnum tmpEnum : projectCompareTypeEnums) {
            map.put(tmpEnum.getValue(), tmpEnum.getText());
        }
        return map;
    }

    public static List<Map<String, Object>> getProjectFlowSetActionCode() {
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(new HashMap<String, Object>() {{
            put("value", TYPE_GREATER_THAN_OR_EQUAL_TO.getValue());
            put("text", TYPE_GREATER_THAN_OR_EQUAL_TO.getText());
        }});
        return list;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getDestribe() {
        return destribe;
    }
}

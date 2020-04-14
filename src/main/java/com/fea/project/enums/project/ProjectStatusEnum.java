package com.fea.project.enums.project;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/24 11:24
 **/
public enum ProjectStatusEnum {

    TYPE_NOT_FINISH(1, "未结项"),
    TYPE_FINISH(2, "已结项");

    private Integer value;
    private String text;

    ProjectStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        ProjectStatusEnum[] enums = ProjectStatusEnum.values();
        for (ProjectStatusEnum tmp : enums) {
            map.put(tmp.getValue(), tmp.getText());
        }
        return map;
    }

    public static Integer getInitStatus() {
        return TYPE_NOT_FINISH.getValue();
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

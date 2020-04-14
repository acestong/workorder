package com.fea.project.enums.project;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/30 15:07
 **/
public enum ProjectDeliverStatusEnum {

    TYPE_UNDELIVER(1, "未交付"),
    TYPE_HAS_SUBMIT(2, "审核中"),
    TYPE_HAS_DELIVER(3, "已交付");

    private Integer value;
    private String text;

    ProjectDeliverStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        ProjectDeliverStatusEnum[] enums = ProjectDeliverStatusEnum.values();
        for (ProjectDeliverStatusEnum tmp : enums) {
            map.put(tmp.getValue(), tmp.getText());
        }
        return map;
    }

    public static Integer getInitStatus() {
        return TYPE_UNDELIVER.value;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

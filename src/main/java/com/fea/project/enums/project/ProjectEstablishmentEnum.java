package com.fea.project.enums.project;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/24 11:21
 * 立项状态
 **/
public enum ProjectEstablishmentEnum {

    TYPE_ESTABLISHMENT_NOT(0, "否"),
    TYPE_ESTABLISHMENT(1, "是");

    private Integer value;
    private String text;

    ProjectEstablishmentEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        ProjectEstablishmentEnum[] enums = ProjectEstablishmentEnum.values();
        for (ProjectEstablishmentEnum tmp : enums) {
            map.put(tmp.getValue(), tmp.getText());
        }
        return map;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

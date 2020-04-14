package com.fea.project.enums.flow.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @since 2019/10/10 10:31
 * 上级类别
 **/
public enum ProjectSuperiorTypeEnum {

    TYPE_FIRST_SUPERIOR(1, "直接上级"),
    TYPE_SECOND_SUPERIOR(2, "第二级上级"),
    TYPE_THIRD_SUPERIOR(3, "第三级上级"),
    TYPE_FORTH_SUPERIOR(4, "第四级上级"),
    TYPE_FIFTH_SUPERIOR(5, "第五级上级"),
    TYPE_SIXTH_SUPERIOR(6, "第六级上级"),
    TYPE_SEVENTH_SUPERIOR(7, "第七级上级"),
    TYPE_EIGHTH_SUPERIOR(8, "第八级上级"),
    TYPE_NINTH_SUPERIOR(9, "第九级上级"),
    TYPE_TENTH_SUPERIOR(10, "第十级上级");

    private Integer value;
    private String text;

    public static List<Map<String, Object>> getMap() {
        return Stream.of(ProjectSuperiorTypeEnum.values()).map(x -> new HashMap<String, Object>(2) {{
            put("value", x.getValue());
            put("text", x.getText());
        }}).collect(Collectors.toList());
    }

    ProjectSuperiorTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Long, String> getPersonTypeNameMap() {
        return Stream.of(ProjectSuperiorTypeEnum.values()).collect(
                Collectors.toMap(x -> Long.parseLong(String.valueOf(x.value)), ProjectSuperiorTypeEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

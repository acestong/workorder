package com.fea.project.enums.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @since 2020/3/18 11:24
 * 项目角色权限操作类型码
 **/
public enum ProjectRoleAuthorityActionTypeEnum {

    TYPE_QUERY(1, "查询"),
    TYPE_INSERT(2, "新增"),
    TYPE_UPDATE(3, "更新"),
    TYPE_DELETE(4, "删除");

    private Integer value;
    private String text;

    public static List<Map<String, Object>> getProjectRoleAuthorityActionTypes(){
        return Stream.of(ProjectRoleAuthorityActionTypeEnum.values()).map(x -> {
            Map<String, Object> map = new HashMap<>();
            map.put("value", x.getValue());
            map.put("text", x.getText());
            return map;
        }).collect(Collectors.toList());
    }

    ProjectRoleAuthorityActionTypeEnum(Integer value, String text) {
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

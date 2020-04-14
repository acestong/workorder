package com.fea.project.enums.base;

import com.fea.project.configure.exception.SystemParamCheckException;
import io.netty.util.internal.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 10:47
 **/
public enum ProjectListActionEnum {

    TYPE_EQUAL(1, "等于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " = " + str;
        }

        @Override
        public boolean isSatisfied(List<Long> conditionIds, List<Long> businessInfo) {
            businessInfo.retainAll(conditionIds);
            return Objects.equals(conditionIds.size(), businessInfo.size());
        }
    },
    TYPE_NOT_EQUAL(2, "不等于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " != " + str;
        }

        @Override
        public boolean isSatisfied(List<Long> conditionIds, List<Long> businessInfo) {
            businessInfo.retainAll(conditionIds);
            return !Objects.equals(conditionIds.size(), businessInfo.size());
        }
    },
    TYPE_CONTAIN(3, "包含") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " in (" +
                    String.join(",", str.split(",")) + ")";
        }

        @Override
        public boolean isSatisfied(List<Long> conditionIds, List<Long> businessInfo) {
            conditionIds.retainAll(businessInfo);
            return !conditionIds.isEmpty();
        }
    },
    TYPE_NOT_CONTAIN(4, "不包含") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " not in (" +
                    String.join(",", str.split(",")) + ")";
        }

        @Override
        public boolean isSatisfied(List<Long> conditionIds, List<Long> businessInfo) {
            conditionIds.retainAll(businessInfo);
            return conditionIds.isEmpty();
        }
    };

    private Integer value;
    private String text;

    ProjectListActionEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static List<Map<String, Object>> getMap() {
        return Stream.of(ProjectListActionEnum.values()).map(x -> {
            Map<String, Object> map = new HashMap<>(2);
            map.put("text", x.getText());
            map.put("value", x.getValue());
            return map;
        }).collect(Collectors.toList());
    }

    public static Map<Integer, ProjectListActionEnum> getEnumMap() {
        return Stream.of(ProjectListActionEnum.values()).collect(Collectors.toMap(ProjectListActionEnum::getValue, x -> x));
    }

    public static String getTargetViewExplain(Integer type, String fieldName, String str) {
        checkParam(type, fieldName, str);
        ProjectListActionEnum targetEnum = ProjectListActionEnum.getEnumMap().get(type);
        return targetEnum.getExplainStr(fieldName, str);
    }

    public static void checkParam(Integer type, String fieldName, String str) {
        if (type == null || StringUtil.isNullOrEmpty(fieldName) || StringUtil.isNullOrEmpty(str)) {
            throw new SystemParamCheckException("传入的参数异常，无法进行视图解析");
        }
    }

    public static Map<Integer, String> getCodeKeyStrValueMap() {
        return Stream.of(ProjectListActionEnum.values()).collect(Collectors.toMap(ProjectListActionEnum::getValue, ProjectListActionEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract String getExplainStr(String fieldName, String str);

    public abstract boolean isSatisfied(List<Long> conditionIds, List<Long> businessInfo);
}

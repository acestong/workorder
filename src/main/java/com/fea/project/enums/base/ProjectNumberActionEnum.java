package com.fea.project.enums.base;

import com.fea.project.configure.exception.SystemParamCheckException;
import io.netty.util.internal.StringUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 10:47
 **/
public enum ProjectNumberActionEnum {

    TYPE_GREATER_THAN(1, "大于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " > " + str;
        }

        @Override
        public boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost) {
            if (setCost.size() != 1) {
                return Boolean.FALSE;
            }
            return realCost.compareTo(setCost.get(0)) > 0;
        }
    },
    TYPE_GREATER_EQUAL_THAN(2, "大于等于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " >= " + str;
        }

        @Override
        public boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost) {
            if (setCost.size() != 1) {
                return Boolean.FALSE;
            }
            return realCost.compareTo(setCost.get(0)) >= 0;
        }
    },
    TYPE_LESS_THAN(3, "小于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " < " + str;
        }

        @Override
        public boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost) {
            if (setCost.size() != 1) {
                return Boolean.FALSE;
            }
            return realCost.compareTo(setCost.get(0)) < 0;
        }
    },
    TYPE_LESS_EQUAL_THAN(4, "小于等于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " <= " + str;
        }

        @Override
        public boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost) {
            if (setCost.size() != 1) {
                return Boolean.FALSE;
            }
            return realCost.compareTo(setCost.get(0)) <= 0;
        }
    },
    TYPE_EQUAL(5, "等于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            return " and " + fieldName + " = " + str;
        }

        @Override
        public boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost) {
            if (setCost.size() != 1) {
                return Boolean.FALSE;
            }
            return realCost.compareTo(setCost.get(0)) == 0;
        }
    },
    TYPE_BETWEEN(6, "介于") {
        @Override
        public String getExplainStr(String fieldName, String str) {
            String[] status = str.split(",");
            if (status.length != 2) {
                throw new SystemParamCheckException("当前介于情况下，传递的数据异常");
            }
            return " and " + fieldName + " between " + status[0] + " and " + status[1];
        }

        @Override
        public boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost) {
            if (setCost.size() != 2) {
                return Boolean.FALSE;
            }
            return realCost.subtract(setCost.get(0))
                    .multiply(realCost.subtract(setCost.get(1))).compareTo(BigDecimal.ZERO) <= 0;
        }
    };

    private Integer value;
    private String text;

    ProjectNumberActionEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static List<Map<String, Object>> getMap() {
        return Stream.of(ProjectNumberActionEnum.values()).map(x -> {
            Map<String, Object> map = new HashMap<>(2);
            map.put("text", x.getText());
            map.put("value", x.getValue());
            return map;
        }).collect(Collectors.toList());
    }

    public static Map<Integer, ProjectNumberActionEnum> getEnumMap() {
        return Stream.of(ProjectNumberActionEnum.values()).collect(Collectors.toMap(ProjectNumberActionEnum::getValue, x -> x));
    }

    public static String getTargetViewExplain(Integer type, String fieldName, String str) {
        checkParam(type, fieldName, str);
        ProjectNumberActionEnum targetEnum = ProjectNumberActionEnum.getEnumMap().get(type);
        return targetEnum.getExplainStr(fieldName, str);
    }

    public static void checkParam(Integer type, String fieldName, String str) {
        if (type == null || StringUtil.isNullOrEmpty(fieldName) || StringUtil.isNullOrEmpty(str)) {
            throw new SystemParamCheckException("传入的参数异常，无法进行视图解析");
        }
    }

    public static Map<Integer, String> getCodeKeyStrValueMap() {
        return Stream.of(ProjectNumberActionEnum.values()).collect(Collectors.toMap(ProjectNumberActionEnum::getValue, ProjectNumberActionEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract String getExplainStr(String fieldName, String str);

    public abstract boolean isSatisfied(List<BigDecimal> setCost, BigDecimal realCost);
}

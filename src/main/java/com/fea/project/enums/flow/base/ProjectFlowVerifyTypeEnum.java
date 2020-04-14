package com.fea.project.enums.flow.base;

import com.fea.project.configure.exception.SystemParamCheckException;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/11 16:33
 **/
public enum ProjectFlowVerifyTypeEnum {

    TYPE_DEFAULT(1, "默认") {
        @Override
        public Long getIndex() {
            return 0L;
        }
    },
    TYPE_CONDITION(2, "条件判断") {
        @Override
        public Long getIndex() {
            return System.currentTimeMillis();
        }
    };

    public static Map<Integer, ProjectFlowVerifyTypeEnum> getEnumMap() {
        return Stream.of(ProjectFlowVerifyTypeEnum.values()).collect(Collectors.toMap(ProjectFlowVerifyTypeEnum::getValue, x -> x));
    }

    private Integer value;
    private String text;

    ProjectFlowVerifyTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Long getIndex(Integer flowConfigType) {
        ProjectFlowVerifyTypeEnum targetEnum = getEnumMap().get(flowConfigType);
        if (targetEnum == null) {
            throw new SystemParamCheckException("传入的流程类型未定义");
        }
        return targetEnum.getIndex();
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract Long getIndex();
}

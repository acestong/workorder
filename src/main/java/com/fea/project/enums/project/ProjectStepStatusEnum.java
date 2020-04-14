package com.fea.project.enums.project;

import com.fea.project.configure.exception.SystemParamCheckException;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/6 15:33
 **/
public enum ProjectStepStatusEnum {

    TYPE_UNVERIFY(1, "未审核") {
        @Override
        public Integer getNextStatus() {
            return TYPE_RUNNING.value;
        }
    },
    TYPE_RUNNING(2, "进行中") {
        @Override
        public Integer getNextStatus() {
            return TYPE_FINISH.value;
        }
    },
    TYPE_FINISH(3, "已确认") {
        @Override
        public Integer getNextStatus() {
            throw new SystemParamCheckException("当前已是完成状态无法进行更新");
        }
    };

    private Integer value;
    private String text;

    ProjectStepStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, ProjectStepStatusEnum> getEnumMap() {
        return Stream.of(ProjectStepStatusEnum.values()).collect(Collectors.toMap(ProjectStepStatusEnum::getValue, x -> x));
    }

    public static Integer getNextStatusByCurrentStep(Integer status) {
        ProjectStepStatusEnum currentEnum = getEnumMap().get(status);
        if (currentEnum == null) {
            throw new SystemParamCheckException("当前阶段状态未定义，请重新确认");
        }
        return currentEnum.getNextStatus();
    }

    public static Map<Integer, String> getMap() {
        return Stream.of(ProjectStepStatusEnum.values())
                .collect(Collectors.toMap(ProjectStepStatusEnum::getValue, ProjectStepStatusEnum::getText));
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract Integer getNextStatus();
}

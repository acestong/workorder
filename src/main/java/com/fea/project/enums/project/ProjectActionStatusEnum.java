package com.fea.project.enums.project;

import com.fea.project.configure.exception.SystemParamCheckException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/24 11:33
 **/
public enum ProjectActionStatusEnum {


    TYPE_UNSTART(1, "未开始") {
        @Override
        public Integer getNextStatus() {
            return TYPE_RUNNING.value;
        }
    },
    TYPE_RUNNING(2, "运行中") {
        @Override
        public Integer getNextStatus() {
            return TYPE_FINISH.value;
        }
    },
    TYPE_FINISH(3, "已完成") {
        @Override
        public Integer getNextStatus() {
            throw new SystemParamCheckException("当前流程已经完成，无法进行下一步");
        }
    };

    private Integer value;
    private String text;

    ProjectActionStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        ProjectActionStatusEnum[] enums = ProjectActionStatusEnum.values();
        for (ProjectActionStatusEnum tmp : enums) {
            map.put(tmp.getValue(), tmp.getText());
        }
        return map;
    }

    public static List<Map<String, Object>> getProjectActionStatus() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = null;
        ProjectActionStatusEnum[] enums = ProjectActionStatusEnum.values();
        for (ProjectActionStatusEnum anEnum : enums) {
            map = new HashMap<>();
            map.put("id", anEnum.getValue() + "");
            map.put("name", anEnum.getText());
            list.add(map);
        }
        return list;
    }

    public static Integer getInitStatus() {
        return TYPE_UNSTART.value;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public abstract Integer getNextStatus();
}

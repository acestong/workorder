package com.fea.project.enums.deliverable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum DeliverableTypeEnum {

    MILESTONE_DELIVERABLE(1,"里程碑交付物"),
    PROJECT_DELIVERABLE(2,"项目交付物"),
    TASK_DELIVERABLE(3,"任务交付物");

    private Integer code;
    private String text;

    DeliverableTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static Map<Long,String> getConditionMap(){
        Map<Long,String> collect = new HashMap<>();
        for (int i = 0; i< DeliverableTypeEnum.values().length; i++){
            collect.put(DeliverableTypeEnum.values()[i].code.longValue(),DeliverableTypeEnum.values()[i].text);
        }
        return collect;
    }

    public static List<DeliverableTypeEnum> getList(){
        List<DeliverableTypeEnum> collect = Arrays.stream(DeliverableTypeEnum.values()).collect(Collectors.toList());
        return collect;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

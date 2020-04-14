package com.fea.project.enums;

/**
 * @author aa
 * @version 1.0
 * @since 2019/10/8 10:42
 **/
public enum AppendixTypeEnum {
    PLAN(1L,"计划"),
    TASK(2L,"任务"),
    PROJECT(3L,"项目");


    private Long code;
    private String type;

    AppendixTypeEnum(Long code, String type) {
        this.code = code;
        this.type = type;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

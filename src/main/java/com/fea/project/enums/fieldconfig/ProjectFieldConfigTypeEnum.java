package com.fea.project.enums.fieldconfig;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/19 15:14
 **/
public enum ProjectFieldConfigTypeEnum {

    TYPE_PROJECT_ESTABLISH(1, "项目立项"),
    TYPE_PROJECT_CREATE(2, "项目创建");


    private Integer value;
    private String msg;

    ProjectFieldConfigTypeEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public Integer getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }
}

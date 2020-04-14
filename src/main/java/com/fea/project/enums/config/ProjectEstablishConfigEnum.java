package com.fea.project.enums.config;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/2 10:30
 **/
public enum ProjectEstablishConfigEnum {

    ESTABLISH_PROJECT_TYPE(19, "verify_set", "立项是否审批");

    private Integer value;
    private String type;
    private String describe;

    public Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getDescribe() {
        return describe;
    }

    ProjectEstablishConfigEnum(Integer value, String type, String describe) {
        this.value = value;
        this.type = type;
        this.describe = describe;
    }


}

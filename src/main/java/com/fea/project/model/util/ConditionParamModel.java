package com.fea.project.model.util;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/23 10:26
 **/
public class ConditionParamModel {

    private String fieldName;
    private Long fieldValue;

    public ConditionParamModel() {
    }

    public ConditionParamModel(String fieldName, Long fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Long fieldValue) {
        this.fieldValue = fieldValue;
    }
}

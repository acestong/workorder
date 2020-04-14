package com.fea.project.model.util;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 17:32
 **/
public class FieldValueTypeModel<T> {

    private Class<T> fieldClass;
    private T fieldValue;

    public FieldValueTypeModel() {
    }

    public FieldValueTypeModel(Class<T> fieldClass, T fieldValue) {
        this.fieldClass = fieldClass;
        this.fieldValue = fieldValue;
    }

    public Class<T> getFieldClass() {
        return fieldClass;
    }

    public void setFieldClass(Class<T> fieldClass) {
        this.fieldClass = fieldClass;
    }

    public T getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(T fieldValue) {
        this.fieldValue = fieldValue;
    }
}

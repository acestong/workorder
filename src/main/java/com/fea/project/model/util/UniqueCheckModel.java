package com.fea.project.model.util;

import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 15:34
 * 唯一性检验model
 **/
@Data
public class UniqueCheckModel<T> {

    private String primaryName;
    private Long pkValue;
    private String checkFieldName;
    private T checkFieldValue;
    private String tableName;

    private List<ConditionParamModel> conditionParamModelList;

    public UniqueCheckModel() {
    }

    public UniqueCheckModel(String fieldName, T fieldValue) {
        this.checkFieldName = fieldName;
        this.checkFieldValue = fieldValue;
    }

}

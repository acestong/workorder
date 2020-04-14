package com.fea.project.enums.base;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/25 14:15
 **/
public enum DictionaryTypeEnum {

    PROJECT_TYPE("项目类型", "project_type"),
    PROJECT_PRIORITY("优先级", "project_priority"),
    PROJECT_LEVEL("项目级别", "project_level"),
    PROJECT_RISK_LEVEL("风险等级", "project_risk_level"),
    PROJECT_ESTIMATE_VALUE("评价分值类型", "project_estimate_percent"),
    APPENDIX_DATA_TYPE("附件资料类型","appendix_data_type"),
    PROJECT_RISK_TYPE("项目风险类型", "project_risk_type"),
    PROJECT_FEE_TYPE("费用类型", "project_fee_type"),
    PROJECT_RESOURCE_DETAIL("项目来源详情","project_source_detail");

    private String test;
    private String value;

    DictionaryTypeEnum(String test, String value) {
        this.test = test;
        this.value = value;
    }

    public String getTest() {
        return test;
    }

    public String getValue() {
        return value;
    }
}

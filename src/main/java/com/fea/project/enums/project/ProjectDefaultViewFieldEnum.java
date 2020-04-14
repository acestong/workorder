package com.fea.project.enums.project;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/21 12:13
 * 项目视图字段枚举
 **/
public enum ProjectDefaultViewFieldEnum {

    TYPE_PROJECT_PRODUCT(1, "产品维度", "project_product"),
    TYPE_PROJECT_AREA(2, "区域维度", "project_area"),
    TYPE_PROJECT_INDUSTRY(3, "行业维度", "project_industry"),
    TYPE_PROJECT_SCOPE(4, "规模维度", "project_scope"),
    TYPE_PROJECT_RISK(5, "风险维度", "project_risk"),
    TYPE_PROJECT_DEPT(6, "所属部门", "project_dept"),
    TYPE_PROJECT_CUSTOMER(7, "客户维度", "project_customer");

    private Integer value;
    private String text;
    private String shortName;

    ProjectDefaultViewFieldEnum(Integer value, String text, String shortName) {
        this.value = value;
        this.text = text;
        this.shortName = shortName;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String getShortName() {
        return shortName;
    }

}

package com.fea.project.model.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportRequirementModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportRequirementModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    } 
 
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPlanReportRequirementIdIsNull() {
            addCriterion("plan_report_requirement_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdIsNotNull() {
            addCriterion("plan_report_requirement_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdEqualTo(Long value) {
            addCriterion("plan_report_requirement_id =", value, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdNotEqualTo(Long value) {
            addCriterion("plan_report_requirement_id <>", value, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdGreaterThan(Long value) {
            addCriterion("plan_report_requirement_id >", value, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_report_requirement_id >=", value, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdLessThan(Long value) {
            addCriterion("plan_report_requirement_id <", value, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_report_requirement_id <=", value, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdIn(List<Long> values) {
            addCriterion("plan_report_requirement_id in", values, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdNotIn(List<Long> values) {
            addCriterion("plan_report_requirement_id not in", values, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdBetween(Long value1, Long value2) {
            addCriterion("plan_report_requirement_id between", value1, value2, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_report_requirement_id not between", value1, value2, "planReportRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeIsNull() {
            addCriterion("plan_report_requirement_theme is null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeIsNotNull() {
            addCriterion("plan_report_requirement_theme is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeEqualTo(String value) {
            addCriterion("plan_report_requirement_theme =", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeNotEqualTo(String value) {
            addCriterion("plan_report_requirement_theme <>", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeGreaterThan(String value) {
            addCriterion("plan_report_requirement_theme >", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_report_requirement_theme >=", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeLessThan(String value) {
            addCriterion("plan_report_requirement_theme <", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeLessThanOrEqualTo(String value) {
            addCriterion("plan_report_requirement_theme <=", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeLike(String value) {
            addCriterion("plan_report_requirement_theme like", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeNotLike(String value) {
            addCriterion("plan_report_requirement_theme not like", value, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeIn(List<String> values) {
            addCriterion("plan_report_requirement_theme in", values, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeNotIn(List<String> values) {
            addCriterion("plan_report_requirement_theme not in", values, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeBetween(String value1, String value2) {
            addCriterion("plan_report_requirement_theme between", value1, value2, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeNotBetween(String value1, String value2) {
            addCriterion("plan_report_requirement_theme not between", value1, value2, "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeIsNull() {
            addCriterion("plan_report_requirement_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeIsNotNull() {
            addCriterion("plan_report_requirement_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeEqualTo(Date value) {
            addCriterion("plan_report_requirement_time =", value, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeNotEqualTo(Date value) {
            addCriterion("plan_report_requirement_time <>", value, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeGreaterThan(Date value) {
            addCriterion("plan_report_requirement_time >", value, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_report_requirement_time >=", value, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeLessThan(Date value) {
            addCriterion("plan_report_requirement_time <", value, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_report_requirement_time <=", value, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeIn(List<Date> values) {
            addCriterion("plan_report_requirement_time in", values, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeNotIn(List<Date> values) {
            addCriterion("plan_report_requirement_time not in", values, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeBetween(Date value1, Date value2) {
            addCriterion("plan_report_requirement_time between", value1, value2, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_report_requirement_time not between", value1, value2, "planReportRequirementTime");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodIsNull() {
            addCriterion("plan_report_requirement_method is null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodIsNotNull() {
            addCriterion("plan_report_requirement_method is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodEqualTo(Long value) {
            addCriterion("plan_report_requirement_method =", value, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodNotEqualTo(Long value) {
            addCriterion("plan_report_requirement_method <>", value, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodGreaterThan(Long value) {
            addCriterion("plan_report_requirement_method >", value, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_report_requirement_method >=", value, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodLessThan(Long value) {
            addCriterion("plan_report_requirement_method <", value, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodLessThanOrEqualTo(Long value) {
            addCriterion("plan_report_requirement_method <=", value, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodIn(List<Long> values) {
            addCriterion("plan_report_requirement_method in", values, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodNotIn(List<Long> values) {
            addCriterion("plan_report_requirement_method not in", values, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodBetween(Long value1, Long value2) {
            addCriterion("plan_report_requirement_method between", value1, value2, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementMethodNotBetween(Long value1, Long value2) {
            addCriterion("plan_report_requirement_method not between", value1, value2, "planReportRequirementMethod");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIsNull() {
            addCriterion("plan_report_requirement is null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIsNotNull() {
            addCriterion("plan_report_requirement is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementEqualTo(String value) {
            addCriterion("plan_report_requirement =", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementNotEqualTo(String value) {
            addCriterion("plan_report_requirement <>", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementGreaterThan(String value) {
            addCriterion("plan_report_requirement >", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("plan_report_requirement >=", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementLessThan(String value) {
            addCriterion("plan_report_requirement <", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementLessThanOrEqualTo(String value) {
            addCriterion("plan_report_requirement <=", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementLike(String value) {
            addCriterion("plan_report_requirement like", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementNotLike(String value) {
            addCriterion("plan_report_requirement not like", value, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementIn(List<String> values) {
            addCriterion("plan_report_requirement in", values, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementNotIn(List<String> values) {
            addCriterion("plan_report_requirement not in", values, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementBetween(String value1, String value2) {
            addCriterion("plan_report_requirement between", value1, value2, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementNotBetween(String value1, String value2) {
            addCriterion("plan_report_requirement not between", value1, value2, "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdIsNull() {
            addCriterion("plan_report_appendix_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdIsNotNull() {
            addCriterion("plan_report_appendix_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdEqualTo(Long value) {
            addCriterion("plan_report_appendix_id =", value, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdNotEqualTo(Long value) {
            addCriterion("plan_report_appendix_id <>", value, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdGreaterThan(Long value) {
            addCriterion("plan_report_appendix_id >", value, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_report_appendix_id >=", value, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdLessThan(Long value) {
            addCriterion("plan_report_appendix_id <", value, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_report_appendix_id <=", value, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdIn(List<Long> values) {
            addCriterion("plan_report_appendix_id in", values, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdNotIn(List<Long> values) {
            addCriterion("plan_report_appendix_id not in", values, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdBetween(Long value1, Long value2) {
            addCriterion("plan_report_appendix_id between", value1, value2, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanReportAppendixIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_report_appendix_id not between", value1, value2, "planReportAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Long value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Long value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Long value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Long value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Long value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Long> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Long> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Long value1, Long value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Long value1, Long value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNull() {
            addCriterion("del_status is null");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNotNull() {
            addCriterion("del_status is not null");
            return (Criteria) this;
        }

        public Criteria andDelStatusEqualTo(Long value) {
            addCriterion("del_status =", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotEqualTo(Long value) {
            addCriterion("del_status <>", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThan(Long value) {
            addCriterion("del_status >", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("del_status >=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThan(Long value) {
            addCriterion("del_status <", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThanOrEqualTo(Long value) {
            addCriterion("del_status <=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusIn(List<Long> values) {
            addCriterion("del_status in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotIn(List<Long> values) {
            addCriterion("del_status not in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusBetween(Long value1, Long value2) {
            addCriterion("del_status between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotBetween(Long value1, Long value2) {
            addCriterion("del_status not between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementThemeLikeInsensitive(String value) {
            addCriterion("upper(plan_report_requirement_theme) like", value.toUpperCase(), "planReportRequirementTheme");
            return (Criteria) this;
        }

        public Criteria andPlanReportRequirementLikeInsensitive(String value) {
            addCriterion("upper(plan_report_requirement) like", value.toUpperCase(), "planReportRequirement");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLikeInsensitive(String value) {
            addCriterion("upper(update_by) like", value.toUpperCase(), "updateBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
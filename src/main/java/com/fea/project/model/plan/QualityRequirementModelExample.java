package com.fea.project.model.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QualityRequirementModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QualityRequirementModelExample() {
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

        public Criteria andPlanQualityRequirementIdIsNull() {
            addCriterion("plan_quality_requirement_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdIsNotNull() {
            addCriterion("plan_quality_requirement_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdEqualTo(Long value) {
            addCriterion("plan_quality_requirement_id =", value, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdNotEqualTo(Long value) {
            addCriterion("plan_quality_requirement_id <>", value, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdGreaterThan(Long value) {
            addCriterion("plan_quality_requirement_id >", value, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_quality_requirement_id >=", value, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdLessThan(Long value) {
            addCriterion("plan_quality_requirement_id <", value, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_quality_requirement_id <=", value, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdIn(List<Long> values) {
            addCriterion("plan_quality_requirement_id in", values, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdNotIn(List<Long> values) {
            addCriterion("plan_quality_requirement_id not in", values, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdBetween(Long value1, Long value2) {
            addCriterion("plan_quality_requirement_id between", value1, value2, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_quality_requirement_id not between", value1, value2, "planQualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameIsNull() {
            addCriterion("plan_quality_requirement_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameIsNotNull() {
            addCriterion("plan_quality_requirement_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameEqualTo(String value) {
            addCriterion("plan_quality_requirement_name =", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameNotEqualTo(String value) {
            addCriterion("plan_quality_requirement_name <>", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameGreaterThan(String value) {
            addCriterion("plan_quality_requirement_name >", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_quality_requirement_name >=", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameLessThan(String value) {
            addCriterion("plan_quality_requirement_name <", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameLessThanOrEqualTo(String value) {
            addCriterion("plan_quality_requirement_name <=", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameLike(String value) {
            addCriterion("plan_quality_requirement_name like", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameNotLike(String value) {
            addCriterion("plan_quality_requirement_name not like", value, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameIn(List<String> values) {
            addCriterion("plan_quality_requirement_name in", values, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameNotIn(List<String> values) {
            addCriterion("plan_quality_requirement_name not in", values, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameBetween(String value1, String value2) {
            addCriterion("plan_quality_requirement_name between", value1, value2, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementNameNotBetween(String value1, String value2) {
            addCriterion("plan_quality_requirement_name not between", value1, value2, "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentIsNull() {
            addCriterion("plan_quality_requirement_content is null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentIsNotNull() {
            addCriterion("plan_quality_requirement_content is not null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentEqualTo(String value) {
            addCriterion("plan_quality_requirement_content =", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentNotEqualTo(String value) {
            addCriterion("plan_quality_requirement_content <>", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentGreaterThan(String value) {
            addCriterion("plan_quality_requirement_content >", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentGreaterThanOrEqualTo(String value) {
            addCriterion("plan_quality_requirement_content >=", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentLessThan(String value) {
            addCriterion("plan_quality_requirement_content <", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentLessThanOrEqualTo(String value) {
            addCriterion("plan_quality_requirement_content <=", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentLike(String value) {
            addCriterion("plan_quality_requirement_content like", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentNotLike(String value) {
            addCriterion("plan_quality_requirement_content not like", value, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentIn(List<String> values) {
            addCriterion("plan_quality_requirement_content in", values, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentNotIn(List<String> values) {
            addCriterion("plan_quality_requirement_content not in", values, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentBetween(String value1, String value2) {
            addCriterion("plan_quality_requirement_content between", value1, value2, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentNotBetween(String value1, String value2) {
            addCriterion("plan_quality_requirement_content not between", value1, value2, "planQualityRequirementContent");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdIsNull() {
            addCriterion("plan_quality_appendix_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdIsNotNull() {
            addCriterion("plan_quality_appendix_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdEqualTo(Long value) {
            addCriterion("plan_quality_appendix_id =", value, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdNotEqualTo(Long value) {
            addCriterion("plan_quality_appendix_id <>", value, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdGreaterThan(Long value) {
            addCriterion("plan_quality_appendix_id >", value, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_quality_appendix_id >=", value, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdLessThan(Long value) {
            addCriterion("plan_quality_appendix_id <", value, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_quality_appendix_id <=", value, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdIn(List<Long> values) {
            addCriterion("plan_quality_appendix_id in", values, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdNotIn(List<Long> values) {
            addCriterion("plan_quality_appendix_id not in", values, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdBetween(Long value1, Long value2) {
            addCriterion("plan_quality_appendix_id between", value1, value2, "planQualityAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanQualityAppendixIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_quality_appendix_id not between", value1, value2, "planQualityAppendixId");
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

        public Criteria andPlanQualityRequirementNameLikeInsensitive(String value) {
            addCriterion("upper(plan_quality_requirement_name) like", value.toUpperCase(), "planQualityRequirementName");
            return (Criteria) this;
        }

        public Criteria andPlanQualityRequirementContentLikeInsensitive(String value) {
            addCriterion("upper(plan_quality_requirement_content) like", value.toUpperCase(), "planQualityRequirementContent");
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
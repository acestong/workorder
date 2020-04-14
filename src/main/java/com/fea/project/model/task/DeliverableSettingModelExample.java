package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliverableSettingModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliverableSettingModelExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdIsNull() {
            addCriterion("resource_business_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdIsNotNull() {
            addCriterion("resource_business_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdEqualTo(Long value) {
            addCriterion("resource_business_id =", value, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdNotEqualTo(Long value) {
            addCriterion("resource_business_id <>", value, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdGreaterThan(Long value) {
            addCriterion("resource_business_id >", value, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resource_business_id >=", value, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdLessThan(Long value) {
            addCriterion("resource_business_id <", value, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdLessThanOrEqualTo(Long value) {
            addCriterion("resource_business_id <=", value, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdIn(List<Long> values) {
            addCriterion("resource_business_id in", values, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdNotIn(List<Long> values) {
            addCriterion("resource_business_id not in", values, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdBetween(Long value1, Long value2) {
            addCriterion("resource_business_id between", value1, value2, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessIdNotBetween(Long value1, Long value2) {
            addCriterion("resource_business_id not between", value1, value2, "resourceBusinessId");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeIsNull() {
            addCriterion("resource_business_type is null");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeIsNotNull() {
            addCriterion("resource_business_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeEqualTo(Long value) {
            addCriterion("resource_business_type =", value, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeNotEqualTo(Long value) {
            addCriterion("resource_business_type <>", value, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeGreaterThan(Long value) {
            addCriterion("resource_business_type >", value, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("resource_business_type >=", value, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeLessThan(Long value) {
            addCriterion("resource_business_type <", value, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeLessThanOrEqualTo(Long value) {
            addCriterion("resource_business_type <=", value, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeIn(List<Long> values) {
            addCriterion("resource_business_type in", values, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeNotIn(List<Long> values) {
            addCriterion("resource_business_type not in", values, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeBetween(Long value1, Long value2) {
            addCriterion("resource_business_type between", value1, value2, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andResourceBusinessTypeNotBetween(Long value1, Long value2) {
            addCriterion("resource_business_type not between", value1, value2, "resourceBusinessType");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdIsNull() {
            addCriterion("deliverable_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdIsNotNull() {
            addCriterion("deliverable_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdEqualTo(Long value) {
            addCriterion("deliverable_id =", value, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdNotEqualTo(Long value) {
            addCriterion("deliverable_id <>", value, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdGreaterThan(Long value) {
            addCriterion("deliverable_id >", value, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deliverable_id >=", value, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdLessThan(Long value) {
            addCriterion("deliverable_id <", value, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdLessThanOrEqualTo(Long value) {
            addCriterion("deliverable_id <=", value, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdIn(List<Long> values) {
            addCriterion("deliverable_id in", values, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdNotIn(List<Long> values) {
            addCriterion("deliverable_id not in", values, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdBetween(Long value1, Long value2) {
            addCriterion("deliverable_id between", value1, value2, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andDeliverableIdNotBetween(Long value1, Long value2) {
            addCriterion("deliverable_id not between", value1, value2, "deliverableId");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightIsNull() {
            addCriterion("quality_estimate_weight is null");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightIsNotNull() {
            addCriterion("quality_estimate_weight is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightEqualTo(Double value) {
            addCriterion("quality_estimate_weight =", value, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightNotEqualTo(Double value) {
            addCriterion("quality_estimate_weight <>", value, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightGreaterThan(Double value) {
            addCriterion("quality_estimate_weight >", value, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("quality_estimate_weight >=", value, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightLessThan(Double value) {
            addCriterion("quality_estimate_weight <", value, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightLessThanOrEqualTo(Double value) {
            addCriterion("quality_estimate_weight <=", value, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightIn(List<Double> values) {
            addCriterion("quality_estimate_weight in", values, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightNotIn(List<Double> values) {
            addCriterion("quality_estimate_weight not in", values, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightBetween(Double value1, Double value2) {
            addCriterion("quality_estimate_weight between", value1, value2, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andQualityEstimateWeightNotBetween(Double value1, Double value2) {
            addCriterion("quality_estimate_weight not between", value1, value2, "qualityEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightIsNull() {
            addCriterion("time_estimate_weight is null");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightIsNotNull() {
            addCriterion("time_estimate_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightEqualTo(Double value) {
            addCriterion("time_estimate_weight =", value, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightNotEqualTo(Double value) {
            addCriterion("time_estimate_weight <>", value, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightGreaterThan(Double value) {
            addCriterion("time_estimate_weight >", value, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("time_estimate_weight >=", value, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightLessThan(Double value) {
            addCriterion("time_estimate_weight <", value, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightLessThanOrEqualTo(Double value) {
            addCriterion("time_estimate_weight <=", value, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightIn(List<Double> values) {
            addCriterion("time_estimate_weight in", values, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightNotIn(List<Double> values) {
            addCriterion("time_estimate_weight not in", values, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightBetween(Double value1, Double value2) {
            addCriterion("time_estimate_weight between", value1, value2, "timeEstimateWeight");
            return (Criteria) this;
        }

        public Criteria andTimeEstimateWeightNotBetween(Double value1, Double value2) {
            addCriterion("time_estimate_weight not between", value1, value2, "timeEstimateWeight");
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
package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentWeightModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentWeightModelExample() {
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

        public Criteria andCommentWeightIdIsNull() {
            addCriterion("comment_weight_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdIsNotNull() {
            addCriterion("comment_weight_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdEqualTo(Long value) {
            addCriterion("comment_weight_id =", value, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdNotEqualTo(Long value) {
            addCriterion("comment_weight_id <>", value, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdGreaterThan(Long value) {
            addCriterion("comment_weight_id >", value, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_weight_id >=", value, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdLessThan(Long value) {
            addCriterion("comment_weight_id <", value, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_weight_id <=", value, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdIn(List<Long> values) {
            addCriterion("comment_weight_id in", values, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdNotIn(List<Long> values) {
            addCriterion("comment_weight_id not in", values, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdBetween(Long value1, Long value2) {
            addCriterion("comment_weight_id between", value1, value2, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andCommentWeightIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_weight_id not between", value1, value2, "commentWeightId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andQualityWeightIsNull() {
            addCriterion("quality_weight is null");
            return (Criteria) this;
        }

        public Criteria andQualityWeightIsNotNull() {
            addCriterion("quality_weight is not null");
            return (Criteria) this;
        }

        public Criteria andQualityWeightEqualTo(Double value) {
            addCriterion("quality_weight =", value, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightNotEqualTo(Double value) {
            addCriterion("quality_weight <>", value, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightGreaterThan(Double value) {
            addCriterion("quality_weight >", value, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("quality_weight >=", value, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightLessThan(Double value) {
            addCriterion("quality_weight <", value, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightLessThanOrEqualTo(Double value) {
            addCriterion("quality_weight <=", value, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightIn(List<Double> values) {
            addCriterion("quality_weight in", values, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightNotIn(List<Double> values) {
            addCriterion("quality_weight not in", values, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightBetween(Double value1, Double value2) {
            addCriterion("quality_weight between", value1, value2, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andQualityWeightNotBetween(Double value1, Double value2) {
            addCriterion("quality_weight not between", value1, value2, "qualityWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightIsNull() {
            addCriterion("time_weight is null");
            return (Criteria) this;
        }

        public Criteria andTimeWeightIsNotNull() {
            addCriterion("time_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTimeWeightEqualTo(Double value) {
            addCriterion("time_weight =", value, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightNotEqualTo(Double value) {
            addCriterion("time_weight <>", value, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightGreaterThan(Double value) {
            addCriterion("time_weight >", value, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("time_weight >=", value, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightLessThan(Double value) {
            addCriterion("time_weight <", value, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightLessThanOrEqualTo(Double value) {
            addCriterion("time_weight <=", value, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightIn(List<Double> values) {
            addCriterion("time_weight in", values, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightNotIn(List<Double> values) {
            addCriterion("time_weight not in", values, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightBetween(Double value1, Double value2) {
            addCriterion("time_weight between", value1, value2, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andTimeWeightNotBetween(Double value1, Double value2) {
            addCriterion("time_weight not between", value1, value2, "timeWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightIsNull() {
            addCriterion("satisfy_weight is null");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightIsNotNull() {
            addCriterion("satisfy_weight is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightEqualTo(Double value) {
            addCriterion("satisfy_weight =", value, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightNotEqualTo(Double value) {
            addCriterion("satisfy_weight <>", value, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightGreaterThan(Double value) {
            addCriterion("satisfy_weight >", value, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("satisfy_weight >=", value, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightLessThan(Double value) {
            addCriterion("satisfy_weight <", value, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightLessThanOrEqualTo(Double value) {
            addCriterion("satisfy_weight <=", value, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightIn(List<Double> values) {
            addCriterion("satisfy_weight in", values, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightNotIn(List<Double> values) {
            addCriterion("satisfy_weight not in", values, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightBetween(Double value1, Double value2) {
            addCriterion("satisfy_weight between", value1, value2, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andSatisfyWeightNotBetween(Double value1, Double value2) {
            addCriterion("satisfy_weight not between", value1, value2, "satisfyWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightIsNull() {
            addCriterion("create_id_weight is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightIsNotNull() {
            addCriterion("create_id_weight is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightEqualTo(Double value) {
            addCriterion("create_id_weight =", value, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightNotEqualTo(Double value) {
            addCriterion("create_id_weight <>", value, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightGreaterThan(Double value) {
            addCriterion("create_id_weight >", value, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("create_id_weight >=", value, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightLessThan(Double value) {
            addCriterion("create_id_weight <", value, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightLessThanOrEqualTo(Double value) {
            addCriterion("create_id_weight <=", value, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightIn(List<Double> values) {
            addCriterion("create_id_weight in", values, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightNotIn(List<Double> values) {
            addCriterion("create_id_weight not in", values, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightBetween(Double value1, Double value2) {
            addCriterion("create_id_weight between", value1, value2, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andCreateIdWeightNotBetween(Double value1, Double value2) {
            addCriterion("create_id_weight not between", value1, value2, "createIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightIsNull() {
            addCriterion("superior_id_weight is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightIsNotNull() {
            addCriterion("superior_id_weight is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightEqualTo(Double value) {
            addCriterion("superior_id_weight =", value, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightNotEqualTo(Double value) {
            addCriterion("superior_id_weight <>", value, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightGreaterThan(Double value) {
            addCriterion("superior_id_weight >", value, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("superior_id_weight >=", value, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightLessThan(Double value) {
            addCriterion("superior_id_weight <", value, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightLessThanOrEqualTo(Double value) {
            addCriterion("superior_id_weight <=", value, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightIn(List<Double> values) {
            addCriterion("superior_id_weight in", values, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightNotIn(List<Double> values) {
            addCriterion("superior_id_weight not in", values, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightBetween(Double value1, Double value2) {
            addCriterion("superior_id_weight between", value1, value2, "superiorIdWeight");
            return (Criteria) this;
        }

        public Criteria andSuperiorIdWeightNotBetween(Double value1, Double value2) {
            addCriterion("superior_id_weight not between", value1, value2, "superiorIdWeight");
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
package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentModelExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIsNull() {
            addCriterion("workorder_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIsNotNull() {
            addCriterion("workorder_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdEqualTo(Long value) {
            addCriterion("workorder_id =", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotEqualTo(Long value) {
            addCriterion("workorder_id <>", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdGreaterThan(Long value) {
            addCriterion("workorder_id >", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_id >=", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLessThan(Long value) {
            addCriterion("workorder_id <", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdLessThanOrEqualTo(Long value) {
            addCriterion("workorder_id <=", value, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdIn(List<Long> values) {
            addCriterion("workorder_id in", values, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotIn(List<Long> values) {
            addCriterion("workorder_id not in", values, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdBetween(Long value1, Long value2) {
            addCriterion("workorder_id between", value1, value2, "workorderId");
            return (Criteria) this;
        }

        public Criteria andWorkorderIdNotBetween(Long value1, Long value2) {
            addCriterion("workorder_id not between", value1, value2, "workorderId");
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

        public Criteria andQualityScoreIsNull() {
            addCriterion("quality_score is null");
            return (Criteria) this;
        }

        public Criteria andQualityScoreIsNotNull() {
            addCriterion("quality_score is not null");
            return (Criteria) this;
        }

        public Criteria andQualityScoreEqualTo(Double value) {
            addCriterion("quality_score =", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreNotEqualTo(Double value) {
            addCriterion("quality_score <>", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreGreaterThan(Double value) {
            addCriterion("quality_score >", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("quality_score >=", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreLessThan(Double value) {
            addCriterion("quality_score <", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreLessThanOrEqualTo(Double value) {
            addCriterion("quality_score <=", value, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreIn(List<Double> values) {
            addCriterion("quality_score in", values, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreNotIn(List<Double> values) {
            addCriterion("quality_score not in", values, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreBetween(Double value1, Double value2) {
            addCriterion("quality_score between", value1, value2, "qualityScore");
            return (Criteria) this;
        }

        public Criteria andQualityScoreNotBetween(Double value1, Double value2) {
            addCriterion("quality_score not between", value1, value2, "qualityScore");
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

        public Criteria andTimeScoreIsNull() {
            addCriterion("time_score is null");
            return (Criteria) this;
        }

        public Criteria andTimeScoreIsNotNull() {
            addCriterion("time_score is not null");
            return (Criteria) this;
        }

        public Criteria andTimeScoreEqualTo(Double value) {
            addCriterion("time_score =", value, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreNotEqualTo(Double value) {
            addCriterion("time_score <>", value, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreGreaterThan(Double value) {
            addCriterion("time_score >", value, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("time_score >=", value, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreLessThan(Double value) {
            addCriterion("time_score <", value, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreLessThanOrEqualTo(Double value) {
            addCriterion("time_score <=", value, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreIn(List<Double> values) {
            addCriterion("time_score in", values, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreNotIn(List<Double> values) {
            addCriterion("time_score not in", values, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreBetween(Double value1, Double value2) {
            addCriterion("time_score between", value1, value2, "timeScore");
            return (Criteria) this;
        }

        public Criteria andTimeScoreNotBetween(Double value1, Double value2) {
            addCriterion("time_score not between", value1, value2, "timeScore");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreIsNull() {
            addCriterion("satisfy_score is null");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreIsNotNull() {
            addCriterion("satisfy_score is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreEqualTo(Double value) {
            addCriterion("satisfy_score =", value, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreNotEqualTo(Double value) {
            addCriterion("satisfy_score <>", value, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreGreaterThan(Double value) {
            addCriterion("satisfy_score >", value, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("satisfy_score >=", value, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreLessThan(Double value) {
            addCriterion("satisfy_score <", value, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreLessThanOrEqualTo(Double value) {
            addCriterion("satisfy_score <=", value, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreIn(List<Double> values) {
            addCriterion("satisfy_score in", values, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreNotIn(List<Double> values) {
            addCriterion("satisfy_score not in", values, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreBetween(Double value1, Double value2) {
            addCriterion("satisfy_score between", value1, value2, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andSatisfyScoreNotBetween(Double value1, Double value2) {
            addCriterion("satisfy_score not between", value1, value2, "satisfyScore");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIsNull() {
            addCriterion("create_role is null");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIsNotNull() {
            addCriterion("create_role is not null");
            return (Criteria) this;
        }

        public Criteria andCreateRoleEqualTo(Long value) {
            addCriterion("create_role =", value, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleNotEqualTo(Long value) {
            addCriterion("create_role <>", value, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleGreaterThan(Long value) {
            addCriterion("create_role >", value, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleGreaterThanOrEqualTo(Long value) {
            addCriterion("create_role >=", value, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleLessThan(Long value) {
            addCriterion("create_role <", value, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleLessThanOrEqualTo(Long value) {
            addCriterion("create_role <=", value, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleIn(List<Long> values) {
            addCriterion("create_role in", values, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleNotIn(List<Long> values) {
            addCriterion("create_role not in", values, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleBetween(Long value1, Long value2) {
            addCriterion("create_role between", value1, value2, "createRole");
            return (Criteria) this;
        }

        public Criteria andCreateRoleNotBetween(Long value1, Long value2) {
            addCriterion("create_role not between", value1, value2, "createRole");
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

        public Criteria andDescLikeInsensitive(String value) {
            addCriterion("upper(desc) like", value.toUpperCase(), "desc");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
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
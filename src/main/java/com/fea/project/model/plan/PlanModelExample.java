package com.fea.project.model.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanModelExample() {
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

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanVersionIsNull() {
            addCriterion("plan_version is null");
            return (Criteria) this;
        }

        public Criteria andPlanVersionIsNotNull() {
            addCriterion("plan_version is not null");
            return (Criteria) this;
        }

        public Criteria andPlanVersionEqualTo(Long value) {
            addCriterion("plan_version =", value, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionNotEqualTo(Long value) {
            addCriterion("plan_version <>", value, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionGreaterThan(Long value) {
            addCriterion("plan_version >", value, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_version >=", value, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionLessThan(Long value) {
            addCriterion("plan_version <", value, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionLessThanOrEqualTo(Long value) {
            addCriterion("plan_version <=", value, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionIn(List<Long> values) {
            addCriterion("plan_version in", values, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionNotIn(List<Long> values) {
            addCriterion("plan_version not in", values, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionBetween(Long value1, Long value2) {
            addCriterion("plan_version between", value1, value2, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanVersionNotBetween(Long value1, Long value2) {
            addCriterion("plan_version not between", value1, value2, "planVersion");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescIsNull() {
            addCriterion("plan_apply_desc is null");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescIsNotNull() {
            addCriterion("plan_apply_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescEqualTo(String value) {
            addCriterion("plan_apply_desc =", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescNotEqualTo(String value) {
            addCriterion("plan_apply_desc <>", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescGreaterThan(String value) {
            addCriterion("plan_apply_desc >", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescGreaterThanOrEqualTo(String value) {
            addCriterion("plan_apply_desc >=", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescLessThan(String value) {
            addCriterion("plan_apply_desc <", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescLessThanOrEqualTo(String value) {
            addCriterion("plan_apply_desc <=", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescLike(String value) {
            addCriterion("plan_apply_desc like", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescNotLike(String value) {
            addCriterion("plan_apply_desc not like", value, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescIn(List<String> values) {
            addCriterion("plan_apply_desc in", values, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescNotIn(List<String> values) {
            addCriterion("plan_apply_desc not in", values, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescBetween(String value1, String value2) {
            addCriterion("plan_apply_desc between", value1, value2, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescNotBetween(String value1, String value2) {
            addCriterion("plan_apply_desc not between", value1, value2, "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanNumIsNull() {
            addCriterion("plan_num is null");
            return (Criteria) this;
        }

        public Criteria andPlanNumIsNotNull() {
            addCriterion("plan_num is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNumEqualTo(String value) {
            addCriterion("plan_num =", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotEqualTo(String value) {
            addCriterion("plan_num <>", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumGreaterThan(String value) {
            addCriterion("plan_num >", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumGreaterThanOrEqualTo(String value) {
            addCriterion("plan_num >=", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumLessThan(String value) {
            addCriterion("plan_num <", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumLessThanOrEqualTo(String value) {
            addCriterion("plan_num <=", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumLike(String value) {
            addCriterion("plan_num like", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotLike(String value) {
            addCriterion("plan_num not like", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumIn(List<String> values) {
            addCriterion("plan_num in", values, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotIn(List<String> values) {
            addCriterion("plan_num not in", values, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumBetween(String value1, String value2) {
            addCriterion("plan_num between", value1, value2, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotBetween(String value1, String value2) {
            addCriterion("plan_num not between", value1, value2, "planNum");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdIsNull() {
            addCriterion("parent_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdIsNotNull() {
            addCriterion("parent_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdEqualTo(Long value) {
            addCriterion("parent_plan_id =", value, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdNotEqualTo(Long value) {
            addCriterion("parent_plan_id <>", value, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdGreaterThan(Long value) {
            addCriterion("parent_plan_id >", value, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_plan_id >=", value, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdLessThan(Long value) {
            addCriterion("parent_plan_id <", value, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_plan_id <=", value, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdIn(List<Long> values) {
            addCriterion("parent_plan_id in", values, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdNotIn(List<Long> values) {
            addCriterion("parent_plan_id not in", values, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdBetween(Long value1, Long value2) {
            addCriterion("parent_plan_id between", value1, value2, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andParentPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_plan_id not between", value1, value2, "parentPlanId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNull() {
            addCriterion("project_step is null");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNotNull() {
            addCriterion("project_step is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStepEqualTo(Long value) {
            addCriterion("project_step =", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotEqualTo(Long value) {
            addCriterion("project_step <>", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThan(Long value) {
            addCriterion("project_step >", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThanOrEqualTo(Long value) {
            addCriterion("project_step >=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThan(Long value) {
            addCriterion("project_step <", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThanOrEqualTo(Long value) {
            addCriterion("project_step <=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepIn(List<Long> values) {
            addCriterion("project_step in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotIn(List<Long> values) {
            addCriterion("project_step not in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepBetween(Long value1, Long value2) {
            addCriterion("project_step between", value1, value2, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotBetween(Long value1, Long value2) {
            addCriterion("project_step not between", value1, value2, "projectStep");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Long value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Long value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Long value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Long value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Long value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Long value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Long> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Long> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Long value1, Long value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Long value1, Long value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeIsNull() {
            addCriterion("plan_startTime is null");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeIsNotNull() {
            addCriterion("plan_startTime is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeEqualTo(Date value) {
            addCriterion("plan_startTime =", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeNotEqualTo(Date value) {
            addCriterion("plan_startTime <>", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeGreaterThan(Date value) {
            addCriterion("plan_startTime >", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_startTime >=", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeLessThan(Date value) {
            addCriterion("plan_startTime <", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_startTime <=", value, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeIn(List<Date> values) {
            addCriterion("plan_startTime in", values, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeNotIn(List<Date> values) {
            addCriterion("plan_startTime not in", values, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeBetween(Date value1, Date value2) {
            addCriterion("plan_startTime between", value1, value2, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_startTime not between", value1, value2, "planStarttime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeIsNull() {
            addCriterion("plan_endTime is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeIsNotNull() {
            addCriterion("plan_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeEqualTo(Date value) {
            addCriterion("plan_endTime =", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeNotEqualTo(Date value) {
            addCriterion("plan_endTime <>", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeGreaterThan(Date value) {
            addCriterion("plan_endTime >", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_endTime >=", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeLessThan(Date value) {
            addCriterion("plan_endTime <", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_endTime <=", value, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeIn(List<Date> values) {
            addCriterion("plan_endTime in", values, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeNotIn(List<Date> values) {
            addCriterion("plan_endTime not in", values, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeBetween(Date value1, Date value2) {
            addCriterion("plan_endTime between", value1, value2, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_endTime not between", value1, value2, "planEndtime");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineIsNull() {
            addCriterion("plan_deadline is null");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineIsNotNull() {
            addCriterion("plan_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineEqualTo(Date value) {
            addCriterion("plan_deadline =", value, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineNotEqualTo(Date value) {
            addCriterion("plan_deadline <>", value, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineGreaterThan(Date value) {
            addCriterion("plan_deadline >", value, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_deadline >=", value, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineLessThan(Date value) {
            addCriterion("plan_deadline <", value, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("plan_deadline <=", value, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineIn(List<Date> values) {
            addCriterion("plan_deadline in", values, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineNotIn(List<Date> values) {
            addCriterion("plan_deadline not in", values, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineBetween(Date value1, Date value2) {
            addCriterion("plan_deadline between", value1, value2, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("plan_deadline not between", value1, value2, "planDeadline");
            return (Criteria) this;
        }

        public Criteria andPlanDurationIsNull() {
            addCriterion("plan_duration is null");
            return (Criteria) this;
        }

        public Criteria andPlanDurationIsNotNull() {
            addCriterion("plan_duration is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDurationEqualTo(Long value) {
            addCriterion("plan_duration =", value, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationNotEqualTo(Long value) {
            addCriterion("plan_duration <>", value, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationGreaterThan(Long value) {
            addCriterion("plan_duration >", value, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_duration >=", value, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationLessThan(Long value) {
            addCriterion("plan_duration <", value, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationLessThanOrEqualTo(Long value) {
            addCriterion("plan_duration <=", value, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationIn(List<Long> values) {
            addCriterion("plan_duration in", values, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationNotIn(List<Long> values) {
            addCriterion("plan_duration not in", values, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationBetween(Long value1, Long value2) {
            addCriterion("plan_duration between", value1, value2, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanDurationNotBetween(Long value1, Long value2) {
            addCriterion("plan_duration not between", value1, value2, "planDuration");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdIsNull() {
            addCriterion("plan_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdIsNotNull() {
            addCriterion("plan_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdEqualTo(Long value) {
            addCriterion("plan_leader_id =", value, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdNotEqualTo(Long value) {
            addCriterion("plan_leader_id <>", value, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdGreaterThan(Long value) {
            addCriterion("plan_leader_id >", value, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_leader_id >=", value, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdLessThan(Long value) {
            addCriterion("plan_leader_id <", value, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_leader_id <=", value, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdIn(List<Long> values) {
            addCriterion("plan_leader_id in", values, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdNotIn(List<Long> values) {
            addCriterion("plan_leader_id not in", values, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdBetween(Long value1, Long value2) {
            addCriterion("plan_leader_id between", value1, value2, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanLeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_leader_id not between", value1, value2, "planLeaderId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdIsNull() {
            addCriterion("plan_team_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdIsNotNull() {
            addCriterion("plan_team_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdEqualTo(Long value) {
            addCriterion("plan_team_id =", value, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdNotEqualTo(Long value) {
            addCriterion("plan_team_id <>", value, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdGreaterThan(Long value) {
            addCriterion("plan_team_id >", value, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_team_id >=", value, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdLessThan(Long value) {
            addCriterion("plan_team_id <", value, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_team_id <=", value, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdIn(List<Long> values) {
            addCriterion("plan_team_id in", values, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdNotIn(List<Long> values) {
            addCriterion("plan_team_id not in", values, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdBetween(Long value1, Long value2) {
            addCriterion("plan_team_id between", value1, value2, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_team_id not between", value1, value2, "planTeamId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdIsNull() {
            addCriterion("plan_participant_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdIsNotNull() {
            addCriterion("plan_participant_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdEqualTo(Long value) {
            addCriterion("plan_participant_id =", value, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdNotEqualTo(Long value) {
            addCriterion("plan_participant_id <>", value, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdGreaterThan(Long value) {
            addCriterion("plan_participant_id >", value, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_participant_id >=", value, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdLessThan(Long value) {
            addCriterion("plan_participant_id <", value, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_participant_id <=", value, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdIn(List<Long> values) {
            addCriterion("plan_participant_id in", values, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdNotIn(List<Long> values) {
            addCriterion("plan_participant_id not in", values, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdBetween(Long value1, Long value2) {
            addCriterion("plan_participant_id between", value1, value2, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanParticipantIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_participant_id not between", value1, value2, "planParticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdIsNull() {
            addCriterion("plan_milestone_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdIsNotNull() {
            addCriterion("plan_milestone_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdEqualTo(Long value) {
            addCriterion("plan_milestone_id =", value, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdNotEqualTo(Long value) {
            addCriterion("plan_milestone_id <>", value, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdGreaterThan(Long value) {
            addCriterion("plan_milestone_id >", value, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_milestone_id >=", value, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdLessThan(Long value) {
            addCriterion("plan_milestone_id <", value, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_milestone_id <=", value, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdIn(List<Long> values) {
            addCriterion("plan_milestone_id in", values, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdNotIn(List<Long> values) {
            addCriterion("plan_milestone_id not in", values, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdBetween(Long value1, Long value2) {
            addCriterion("plan_milestone_id between", value1, value2, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanMilestoneIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_milestone_id not between", value1, value2, "planMilestoneId");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourIsNull() {
            addCriterion("plan_remind_hour is null");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourIsNotNull() {
            addCriterion("plan_remind_hour is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourEqualTo(Long value) {
            addCriterion("plan_remind_hour =", value, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourNotEqualTo(Long value) {
            addCriterion("plan_remind_hour <>", value, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourGreaterThan(Long value) {
            addCriterion("plan_remind_hour >", value, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_remind_hour >=", value, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourLessThan(Long value) {
            addCriterion("plan_remind_hour <", value, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourLessThanOrEqualTo(Long value) {
            addCriterion("plan_remind_hour <=", value, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourIn(List<Long> values) {
            addCriterion("plan_remind_hour in", values, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourNotIn(List<Long> values) {
            addCriterion("plan_remind_hour not in", values, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourBetween(Long value1, Long value2) {
            addCriterion("plan_remind_hour between", value1, value2, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanRemindHourNotBetween(Long value1, Long value2) {
            addCriterion("plan_remind_hour not between", value1, value2, "planRemindHour");
            return (Criteria) this;
        }

        public Criteria andPlanContentIsNull() {
            addCriterion("plan_content is null");
            return (Criteria) this;
        }

        public Criteria andPlanContentIsNotNull() {
            addCriterion("plan_content is not null");
            return (Criteria) this;
        }

        public Criteria andPlanContentEqualTo(String value) {
            addCriterion("plan_content =", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotEqualTo(String value) {
            addCriterion("plan_content <>", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentGreaterThan(String value) {
            addCriterion("plan_content >", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentGreaterThanOrEqualTo(String value) {
            addCriterion("plan_content >=", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLessThan(String value) {
            addCriterion("plan_content <", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLessThanOrEqualTo(String value) {
            addCriterion("plan_content <=", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentLike(String value) {
            addCriterion("plan_content like", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotLike(String value) {
            addCriterion("plan_content not like", value, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentIn(List<String> values) {
            addCriterion("plan_content in", values, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotIn(List<String> values) {
            addCriterion("plan_content not in", values, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentBetween(String value1, String value2) {
            addCriterion("plan_content between", value1, value2, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanContentNotBetween(String value1, String value2) {
            addCriterion("plan_content not between", value1, value2, "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdIsNull() {
            addCriterion("plan_appendix_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdIsNotNull() {
            addCriterion("plan_appendix_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdEqualTo(Long value) {
            addCriterion("plan_appendix_id =", value, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdNotEqualTo(Long value) {
            addCriterion("plan_appendix_id <>", value, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdGreaterThan(Long value) {
            addCriterion("plan_appendix_id >", value, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_appendix_id >=", value, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdLessThan(Long value) {
            addCriterion("plan_appendix_id <", value, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_appendix_id <=", value, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdIn(List<Long> values) {
            addCriterion("plan_appendix_id in", values, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdNotIn(List<Long> values) {
            addCriterion("plan_appendix_id not in", values, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdBetween(Long value1, Long value2) {
            addCriterion("plan_appendix_id between", value1, value2, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andPlanAppendixIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_appendix_id not between", value1, value2, "planAppendixId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdIsNull() {
            addCriterion("association_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdIsNotNull() {
            addCriterion("association_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdEqualTo(Long value) {
            addCriterion("association_plan_id =", value, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdNotEqualTo(Long value) {
            addCriterion("association_plan_id <>", value, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdGreaterThan(Long value) {
            addCriterion("association_plan_id >", value, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("association_plan_id >=", value, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdLessThan(Long value) {
            addCriterion("association_plan_id <", value, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("association_plan_id <=", value, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdIn(List<Long> values) {
            addCriterion("association_plan_id in", values, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdNotIn(List<Long> values) {
            addCriterion("association_plan_id not in", values, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdBetween(Long value1, Long value2) {
            addCriterion("association_plan_id between", value1, value2, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andAssociationPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("association_plan_id not between", value1, value2, "associationPlanId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdIsNull() {
            addCriterion("delivery_requirement_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdIsNotNull() {
            addCriterion("delivery_requirement_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdEqualTo(Long value) {
            addCriterion("delivery_requirement_id =", value, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdNotEqualTo(Long value) {
            addCriterion("delivery_requirement_id <>", value, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdGreaterThan(Long value) {
            addCriterion("delivery_requirement_id >", value, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("delivery_requirement_id >=", value, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdLessThan(Long value) {
            addCriterion("delivery_requirement_id <", value, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdLessThanOrEqualTo(Long value) {
            addCriterion("delivery_requirement_id <=", value, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdIn(List<Long> values) {
            addCriterion("delivery_requirement_id in", values, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdNotIn(List<Long> values) {
            addCriterion("delivery_requirement_id not in", values, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdBetween(Long value1, Long value2) {
            addCriterion("delivery_requirement_id between", value1, value2, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andDeliveryRequirementIdNotBetween(Long value1, Long value2) {
            addCriterion("delivery_requirement_id not between", value1, value2, "deliveryRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdIsNull() {
            addCriterion("report_requirement_id is null");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdIsNotNull() {
            addCriterion("report_requirement_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdEqualTo(Long value) {
            addCriterion("report_requirement_id =", value, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdNotEqualTo(Long value) {
            addCriterion("report_requirement_id <>", value, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdGreaterThan(Long value) {
            addCriterion("report_requirement_id >", value, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("report_requirement_id >=", value, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdLessThan(Long value) {
            addCriterion("report_requirement_id <", value, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdLessThanOrEqualTo(Long value) {
            addCriterion("report_requirement_id <=", value, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdIn(List<Long> values) {
            addCriterion("report_requirement_id in", values, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdNotIn(List<Long> values) {
            addCriterion("report_requirement_id not in", values, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdBetween(Long value1, Long value2) {
            addCriterion("report_requirement_id between", value1, value2, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andReportRequirementIdNotBetween(Long value1, Long value2) {
            addCriterion("report_requirement_id not between", value1, value2, "reportRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdIsNull() {
            addCriterion("quality_requirement_id is null");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdIsNotNull() {
            addCriterion("quality_requirement_id is not null");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdEqualTo(Long value) {
            addCriterion("quality_requirement_id =", value, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdNotEqualTo(Long value) {
            addCriterion("quality_requirement_id <>", value, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdGreaterThan(Long value) {
            addCriterion("quality_requirement_id >", value, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("quality_requirement_id >=", value, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdLessThan(Long value) {
            addCriterion("quality_requirement_id <", value, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdLessThanOrEqualTo(Long value) {
            addCriterion("quality_requirement_id <=", value, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdIn(List<Long> values) {
            addCriterion("quality_requirement_id in", values, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdNotIn(List<Long> values) {
            addCriterion("quality_requirement_id not in", values, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdBetween(Long value1, Long value2) {
            addCriterion("quality_requirement_id between", value1, value2, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andQualityRequirementIdNotBetween(Long value1, Long value2) {
            addCriterion("quality_requirement_id not between", value1, value2, "qualityRequirementId");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkIsNull() {
            addCriterion("plan_remark is null");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkIsNotNull() {
            addCriterion("plan_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkEqualTo(String value) {
            addCriterion("plan_remark =", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkNotEqualTo(String value) {
            addCriterion("plan_remark <>", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkGreaterThan(String value) {
            addCriterion("plan_remark >", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("plan_remark >=", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkLessThan(String value) {
            addCriterion("plan_remark <", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkLessThanOrEqualTo(String value) {
            addCriterion("plan_remark <=", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkLike(String value) {
            addCriterion("plan_remark like", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkNotLike(String value) {
            addCriterion("plan_remark not like", value, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkIn(List<String> values) {
            addCriterion("plan_remark in", values, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkNotIn(List<String> values) {
            addCriterion("plan_remark not in", values, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkBetween(String value1, String value2) {
            addCriterion("plan_remark between", value1, value2, "planRemark");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkNotBetween(String value1, String value2) {
            addCriterion("plan_remark not between", value1, value2, "planRemark");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Long value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Long value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Long value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Long value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Long value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Long> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Long> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Long value1, Long value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Long value1, Long value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(Long value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(Long value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(Long value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(Long value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(Long value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<Long> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<Long> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(Long value1, Long value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(Long value1, Long value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
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

        public Criteria andPlanNameLikeInsensitive(String value) {
            addCriterion("upper(plan_name) like", value.toUpperCase(), "planName");
            return (Criteria) this;
        }

        public Criteria andPlanApplyDescLikeInsensitive(String value) {
            addCriterion("upper(plan_apply_desc) like", value.toUpperCase(), "planApplyDesc");
            return (Criteria) this;
        }

        public Criteria andPlanNumLikeInsensitive(String value) {
            addCriterion("upper(plan_num) like", value.toUpperCase(), "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanContentLikeInsensitive(String value) {
            addCriterion("upper(plan_content) like", value.toUpperCase(), "planContent");
            return (Criteria) this;
        }

        public Criteria andPlanRemarkLikeInsensitive(String value) {
            addCriterion("upper(plan_remark) like", value.toUpperCase(), "planRemark");
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
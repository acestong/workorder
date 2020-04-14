package com.fea.project.model.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanAssociationModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanAssociationModelExample() {
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

        public Criteria andPlanAssociationIdIsNull() {
            addCriterion("plan_association_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdIsNotNull() {
            addCriterion("plan_association_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdEqualTo(Long value) {
            addCriterion("plan_association_id =", value, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdNotEqualTo(Long value) {
            addCriterion("plan_association_id <>", value, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdGreaterThan(Long value) {
            addCriterion("plan_association_id >", value, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_association_id >=", value, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdLessThan(Long value) {
            addCriterion("plan_association_id <", value, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_association_id <=", value, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdIn(List<Long> values) {
            addCriterion("plan_association_id in", values, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdNotIn(List<Long> values) {
            addCriterion("plan_association_id not in", values, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdBetween(Long value1, Long value2) {
            addCriterion("plan_association_id between", value1, value2, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_association_id not between", value1, value2, "planAssociationId");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameIsNull() {
            addCriterion("plan_association_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameIsNotNull() {
            addCriterion("plan_association_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameEqualTo(String value) {
            addCriterion("plan_association_name =", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameNotEqualTo(String value) {
            addCriterion("plan_association_name <>", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameGreaterThan(String value) {
            addCriterion("plan_association_name >", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_association_name >=", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameLessThan(String value) {
            addCriterion("plan_association_name <", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameLessThanOrEqualTo(String value) {
            addCriterion("plan_association_name <=", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameLike(String value) {
            addCriterion("plan_association_name like", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameNotLike(String value) {
            addCriterion("plan_association_name not like", value, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameIn(List<String> values) {
            addCriterion("plan_association_name in", values, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameNotIn(List<String> values) {
            addCriterion("plan_association_name not in", values, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameBetween(String value1, String value2) {
            addCriterion("plan_association_name between", value1, value2, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanAssociationNameNotBetween(String value1, String value2) {
            addCriterion("plan_association_name not between", value1, value2, "planAssociationName");
            return (Criteria) this;
        }

        public Criteria andPlanStepIsNull() {
            addCriterion("plan_step is null");
            return (Criteria) this;
        }

        public Criteria andPlanStepIsNotNull() {
            addCriterion("plan_step is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStepEqualTo(Long value) {
            addCriterion("plan_step =", value, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepNotEqualTo(Long value) {
            addCriterion("plan_step <>", value, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepGreaterThan(Long value) {
            addCriterion("plan_step >", value, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_step >=", value, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepLessThan(Long value) {
            addCriterion("plan_step <", value, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepLessThanOrEqualTo(Long value) {
            addCriterion("plan_step <=", value, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepIn(List<Long> values) {
            addCriterion("plan_step in", values, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepNotIn(List<Long> values) {
            addCriterion("plan_step not in", values, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepBetween(Long value1, Long value2) {
            addCriterion("plan_step between", value1, value2, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanStepNotBetween(Long value1, Long value2) {
            addCriterion("plan_step not between", value1, value2, "planStep");
            return (Criteria) this;
        }

        public Criteria andPlanPorityIsNull() {
            addCriterion("plan_pority is null");
            return (Criteria) this;
        }

        public Criteria andPlanPorityIsNotNull() {
            addCriterion("plan_pority is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPorityEqualTo(Long value) {
            addCriterion("plan_pority =", value, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityNotEqualTo(Long value) {
            addCriterion("plan_pority <>", value, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityGreaterThan(Long value) {
            addCriterion("plan_pority >", value, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_pority >=", value, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityLessThan(Long value) {
            addCriterion("plan_pority <", value, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityLessThanOrEqualTo(Long value) {
            addCriterion("plan_pority <=", value, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityIn(List<Long> values) {
            addCriterion("plan_pority in", values, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityNotIn(List<Long> values) {
            addCriterion("plan_pority not in", values, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityBetween(Long value1, Long value2) {
            addCriterion("plan_pority between", value1, value2, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanPorityNotBetween(Long value1, Long value2) {
            addCriterion("plan_pority not between", value1, value2, "planPority");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusIsNull() {
            addCriterion("plan_execution_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusIsNotNull() {
            addCriterion("plan_execution_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusEqualTo(Long value) {
            addCriterion("plan_execution_status =", value, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusNotEqualTo(Long value) {
            addCriterion("plan_execution_status <>", value, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusGreaterThan(Long value) {
            addCriterion("plan_execution_status >", value, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_execution_status >=", value, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusLessThan(Long value) {
            addCriterion("plan_execution_status <", value, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusLessThanOrEqualTo(Long value) {
            addCriterion("plan_execution_status <=", value, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusIn(List<Long> values) {
            addCriterion("plan_execution_status in", values, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusNotIn(List<Long> values) {
            addCriterion("plan_execution_status not in", values, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusBetween(Long value1, Long value2) {
            addCriterion("plan_execution_status between", value1, value2, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanExecutionStatusNotBetween(Long value1, Long value2) {
            addCriterion("plan_execution_status not between", value1, value2, "planExecutionStatus");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipIsNull() {
            addCriterion("plan_relationship is null");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipIsNotNull() {
            addCriterion("plan_relationship is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipEqualTo(Long value) {
            addCriterion("plan_relationship =", value, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipNotEqualTo(Long value) {
            addCriterion("plan_relationship <>", value, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipGreaterThan(Long value) {
            addCriterion("plan_relationship >", value, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_relationship >=", value, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipLessThan(Long value) {
            addCriterion("plan_relationship <", value, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipLessThanOrEqualTo(Long value) {
            addCriterion("plan_relationship <=", value, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipIn(List<Long> values) {
            addCriterion("plan_relationship in", values, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipNotIn(List<Long> values) {
            addCriterion("plan_relationship not in", values, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipBetween(Long value1, Long value2) {
            addCriterion("plan_relationship between", value1, value2, "planRelationship");
            return (Criteria) this;
        }

        public Criteria andPlanRelationshipNotBetween(Long value1, Long value2) {
            addCriterion("plan_relationship not between", value1, value2, "planRelationship");
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

        public Criteria andPlanWorkingHourIsNull() {
            addCriterion("plan_working_hour is null");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourIsNotNull() {
            addCriterion("plan_working_hour is not null");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourEqualTo(Long value) {
            addCriterion("plan_working_hour =", value, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourNotEqualTo(Long value) {
            addCriterion("plan_working_hour <>", value, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourGreaterThan(Long value) {
            addCriterion("plan_working_hour >", value, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_working_hour >=", value, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourLessThan(Long value) {
            addCriterion("plan_working_hour <", value, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourLessThanOrEqualTo(Long value) {
            addCriterion("plan_working_hour <=", value, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourIn(List<Long> values) {
            addCriterion("plan_working_hour in", values, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourNotIn(List<Long> values) {
            addCriterion("plan_working_hour not in", values, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourBetween(Long value1, Long value2) {
            addCriterion("plan_working_hour between", value1, value2, "planWorkingHour");
            return (Criteria) this;
        }

        public Criteria andPlanWorkingHourNotBetween(Long value1, Long value2) {
            addCriterion("plan_working_hour not between", value1, value2, "planWorkingHour");
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

        public Criteria andPlanAssociationNameLikeInsensitive(String value) {
            addCriterion("upper(plan_association_name) like", value.toUpperCase(), "planAssociationName");
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
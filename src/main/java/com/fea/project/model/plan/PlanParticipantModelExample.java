package com.fea.project.model.plan;

import java.util.ArrayList;
import java.util.List;

public class PlanParticipantModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanParticipantModelExample() {
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

        public Criteria andPlanPanticipantIdIsNull() {
            addCriterion("plan_panticipant_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdIsNotNull() {
            addCriterion("plan_panticipant_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdEqualTo(Long value) {
            addCriterion("plan_panticipant_id =", value, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdNotEqualTo(Long value) {
            addCriterion("plan_panticipant_id <>", value, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdGreaterThan(Long value) {
            addCriterion("plan_panticipant_id >", value, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_panticipant_id >=", value, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdLessThan(Long value) {
            addCriterion("plan_panticipant_id <", value, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_panticipant_id <=", value, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdIn(List<Long> values) {
            addCriterion("plan_panticipant_id in", values, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdNotIn(List<Long> values) {
            addCriterion("plan_panticipant_id not in", values, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdBetween(Long value1, Long value2) {
            addCriterion("plan_panticipant_id between", value1, value2, "planPanticipantId");
            return (Criteria) this;
        }

        public Criteria andPlanPanticipantIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_panticipant_id not between", value1, value2, "planPanticipantId");
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

        public Criteria andPlanPaticipantUserIdIsNull() {
            addCriterion("plan_paticipant_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdIsNotNull() {
            addCriterion("plan_paticipant_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdEqualTo(Long value) {
            addCriterion("plan_paticipant_user_id =", value, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdNotEqualTo(Long value) {
            addCriterion("plan_paticipant_user_id <>", value, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdGreaterThan(Long value) {
            addCriterion("plan_paticipant_user_id >", value, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_paticipant_user_id >=", value, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdLessThan(Long value) {
            addCriterion("plan_paticipant_user_id <", value, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_paticipant_user_id <=", value, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdIn(List<Long> values) {
            addCriterion("plan_paticipant_user_id in", values, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdNotIn(List<Long> values) {
            addCriterion("plan_paticipant_user_id not in", values, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdBetween(Long value1, Long value2) {
            addCriterion("plan_paticipant_user_id between", value1, value2, "planPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andPlanPaticipantUserIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_paticipant_user_id not between", value1, value2, "planPaticipantUserId");
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
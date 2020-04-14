package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.List;

public class TaskParticipantModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskParticipantModelExample() {
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

        public Criteria andTaskPanticipantIdIsNull() {
            addCriterion("task_panticipant_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdIsNotNull() {
            addCriterion("task_panticipant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdEqualTo(Long value) {
            addCriterion("task_panticipant_id =", value, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdNotEqualTo(Long value) {
            addCriterion("task_panticipant_id <>", value, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdGreaterThan(Long value) {
            addCriterion("task_panticipant_id >", value, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_panticipant_id >=", value, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdLessThan(Long value) {
            addCriterion("task_panticipant_id <", value, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdLessThanOrEqualTo(Long value) {
            addCriterion("task_panticipant_id <=", value, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdIn(List<Long> values) {
            addCriterion("task_panticipant_id in", values, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdNotIn(List<Long> values) {
            addCriterion("task_panticipant_id not in", values, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdBetween(Long value1, Long value2) {
            addCriterion("task_panticipant_id between", value1, value2, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskPanticipantIdNotBetween(Long value1, Long value2) {
            addCriterion("task_panticipant_id not between", value1, value2, "taskPanticipantId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdIsNull() {
            addCriterion("task_paticipant_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdIsNotNull() {
            addCriterion("task_paticipant_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdEqualTo(Long value) {
            addCriterion("task_paticipant_user_id =", value, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdNotEqualTo(Long value) {
            addCriterion("task_paticipant_user_id <>", value, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdGreaterThan(Long value) {
            addCriterion("task_paticipant_user_id >", value, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_paticipant_user_id >=", value, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdLessThan(Long value) {
            addCriterion("task_paticipant_user_id <", value, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdLessThanOrEqualTo(Long value) {
            addCriterion("task_paticipant_user_id <=", value, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdIn(List<Long> values) {
            addCriterion("task_paticipant_user_id in", values, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdNotIn(List<Long> values) {
            addCriterion("task_paticipant_user_id not in", values, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdBetween(Long value1, Long value2) {
            addCriterion("task_paticipant_user_id between", value1, value2, "taskPaticipantUserId");
            return (Criteria) this;
        }

        public Criteria andTaskPaticipantUserIdNotBetween(Long value1, Long value2) {
            addCriterion("task_paticipant_user_id not between", value1, value2, "taskPaticipantUserId");
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
package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskAttentionModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskAttentionModelExample() {
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

        public Criteria andAttentionIdIsNull() {
            addCriterion("attention_id is null");
            return (Criteria) this;
        }

        public Criteria andAttentionIdIsNotNull() {
            addCriterion("attention_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionIdEqualTo(Long value) {
            addCriterion("attention_id =", value, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdNotEqualTo(Long value) {
            addCriterion("attention_id <>", value, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdGreaterThan(Long value) {
            addCriterion("attention_id >", value, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attention_id >=", value, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdLessThan(Long value) {
            addCriterion("attention_id <", value, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdLessThanOrEqualTo(Long value) {
            addCriterion("attention_id <=", value, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdIn(List<Long> values) {
            addCriterion("attention_id in", values, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdNotIn(List<Long> values) {
            addCriterion("attention_id not in", values, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdBetween(Long value1, Long value2) {
            addCriterion("attention_id between", value1, value2, "attentionId");
            return (Criteria) this;
        }

        public Criteria andAttentionIdNotBetween(Long value1, Long value2) {
            addCriterion("attention_id not between", value1, value2, "attentionId");
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

        public Criteria andAttentionStatusIsNull() {
            addCriterion("attention_status is null");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusIsNotNull() {
            addCriterion("attention_status is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusEqualTo(Long value) {
            addCriterion("attention_status =", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusNotEqualTo(Long value) {
            addCriterion("attention_status <>", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusGreaterThan(Long value) {
            addCriterion("attention_status >", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("attention_status >=", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusLessThan(Long value) {
            addCriterion("attention_status <", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusLessThanOrEqualTo(Long value) {
            addCriterion("attention_status <=", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusIn(List<Long> values) {
            addCriterion("attention_status in", values, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusNotIn(List<Long> values) {
            addCriterion("attention_status not in", values, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusBetween(Long value1, Long value2) {
            addCriterion("attention_status between", value1, value2, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusNotBetween(Long value1, Long value2) {
            addCriterion("attention_status not between", value1, value2, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeIsNull() {
            addCriterion("attention_time is null");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeIsNotNull() {
            addCriterion("attention_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeEqualTo(Date value) {
            addCriterion("attention_time =", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeNotEqualTo(Date value) {
            addCriterion("attention_time <>", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeGreaterThan(Date value) {
            addCriterion("attention_time >", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attention_time >=", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeLessThan(Date value) {
            addCriterion("attention_time <", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeLessThanOrEqualTo(Date value) {
            addCriterion("attention_time <=", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeIn(List<Date> values) {
            addCriterion("attention_time in", values, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeNotIn(List<Date> values) {
            addCriterion("attention_time not in", values, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeBetween(Date value1, Date value2) {
            addCriterion("attention_time between", value1, value2, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeNotBetween(Date value1, Date value2) {
            addCriterion("attention_time not between", value1, value2, "attentionTime");
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
package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DispatchModelExample() {
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

        public Criteria andDispatchIdIsNull() {
            addCriterion("dispatch_id is null");
            return (Criteria) this;
        }

        public Criteria andDispatchIdIsNotNull() {
            addCriterion("dispatch_id is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchIdEqualTo(Long value) {
            addCriterion("dispatch_id =", value, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdNotEqualTo(Long value) {
            addCriterion("dispatch_id <>", value, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdGreaterThan(Long value) {
            addCriterion("dispatch_id >", value, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dispatch_id >=", value, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdLessThan(Long value) {
            addCriterion("dispatch_id <", value, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdLessThanOrEqualTo(Long value) {
            addCriterion("dispatch_id <=", value, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdIn(List<Long> values) {
            addCriterion("dispatch_id in", values, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdNotIn(List<Long> values) {
            addCriterion("dispatch_id not in", values, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdBetween(Long value1, Long value2) {
            addCriterion("dispatch_id between", value1, value2, "dispatchId");
            return (Criteria) this;
        }

        public Criteria andDispatchIdNotBetween(Long value1, Long value2) {
            addCriterion("dispatch_id not between", value1, value2, "dispatchId");
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

        public Criteria andDispatcherIdIsNull() {
            addCriterion("dispatcher_id is null");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdIsNotNull() {
            addCriterion("dispatcher_id is not null");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdEqualTo(Long value) {
            addCriterion("dispatcher_id =", value, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdNotEqualTo(Long value) {
            addCriterion("dispatcher_id <>", value, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdGreaterThan(Long value) {
            addCriterion("dispatcher_id >", value, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dispatcher_id >=", value, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdLessThan(Long value) {
            addCriterion("dispatcher_id <", value, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdLessThanOrEqualTo(Long value) {
            addCriterion("dispatcher_id <=", value, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdIn(List<Long> values) {
            addCriterion("dispatcher_id in", values, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdNotIn(List<Long> values) {
            addCriterion("dispatcher_id not in", values, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdBetween(Long value1, Long value2) {
            addCriterion("dispatcher_id between", value1, value2, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatcherIdNotBetween(Long value1, Long value2) {
            addCriterion("dispatcher_id not between", value1, value2, "dispatcherId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdIsNull() {
            addCriterion("dispatch_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdIsNotNull() {
            addCriterion("dispatch_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdEqualTo(Long value) {
            addCriterion("dispatch_user_id =", value, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdNotEqualTo(Long value) {
            addCriterion("dispatch_user_id <>", value, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdGreaterThan(Long value) {
            addCriterion("dispatch_user_id >", value, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dispatch_user_id >=", value, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdLessThan(Long value) {
            addCriterion("dispatch_user_id <", value, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdLessThanOrEqualTo(Long value) {
            addCriterion("dispatch_user_id <=", value, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdIn(List<Long> values) {
            addCriterion("dispatch_user_id in", values, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdNotIn(List<Long> values) {
            addCriterion("dispatch_user_id not in", values, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdBetween(Long value1, Long value2) {
            addCriterion("dispatch_user_id between", value1, value2, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIdNotBetween(Long value1, Long value2) {
            addCriterion("dispatch_user_id not between", value1, value2, "dispatchUserId");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIsNull() {
            addCriterion("dispatch_time is null");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIsNotNull() {
            addCriterion("dispatch_time is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeEqualTo(Date value) {
            addCriterion("dispatch_time =", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotEqualTo(Date value) {
            addCriterion("dispatch_time <>", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeGreaterThan(Date value) {
            addCriterion("dispatch_time >", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dispatch_time >=", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeLessThan(Date value) {
            addCriterion("dispatch_time <", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeLessThanOrEqualTo(Date value) {
            addCriterion("dispatch_time <=", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIn(List<Date> values) {
            addCriterion("dispatch_time in", values, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotIn(List<Date> values) {
            addCriterion("dispatch_time not in", values, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeBetween(Date value1, Date value2) {
            addCriterion("dispatch_time between", value1, value2, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotBetween(Date value1, Date value2) {
            addCriterion("dispatch_time not between", value1, value2, "dispatchTime");
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
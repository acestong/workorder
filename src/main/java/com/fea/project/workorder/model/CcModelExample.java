package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.List;

public class CcModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcModelExample() {
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

        public Criteria andCcIdIsNull() {
            addCriterion("cc_id is null");
            return (Criteria) this;
        }

        public Criteria andCcIdIsNotNull() {
            addCriterion("cc_id is not null");
            return (Criteria) this;
        }

        public Criteria andCcIdEqualTo(Long value) {
            addCriterion("cc_id =", value, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdNotEqualTo(Long value) {
            addCriterion("cc_id <>", value, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdGreaterThan(Long value) {
            addCriterion("cc_id >", value, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cc_id >=", value, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdLessThan(Long value) {
            addCriterion("cc_id <", value, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdLessThanOrEqualTo(Long value) {
            addCriterion("cc_id <=", value, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdIn(List<Long> values) {
            addCriterion("cc_id in", values, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdNotIn(List<Long> values) {
            addCriterion("cc_id not in", values, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdBetween(Long value1, Long value2) {
            addCriterion("cc_id between", value1, value2, "ccId");
            return (Criteria) this;
        }

        public Criteria andCcIdNotBetween(Long value1, Long value2) {
            addCriterion("cc_id not between", value1, value2, "ccId");
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

        public Criteria andCcPersonIdIsNull() {
            addCriterion("cc_person_id is null");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdIsNotNull() {
            addCriterion("cc_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdEqualTo(Long value) {
            addCriterion("cc_person_id =", value, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdNotEqualTo(Long value) {
            addCriterion("cc_person_id <>", value, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdGreaterThan(Long value) {
            addCriterion("cc_person_id >", value, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cc_person_id >=", value, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdLessThan(Long value) {
            addCriterion("cc_person_id <", value, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("cc_person_id <=", value, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdIn(List<Long> values) {
            addCriterion("cc_person_id in", values, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdNotIn(List<Long> values) {
            addCriterion("cc_person_id not in", values, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdBetween(Long value1, Long value2) {
            addCriterion("cc_person_id between", value1, value2, "ccPersonId");
            return (Criteria) this;
        }

        public Criteria andCcPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("cc_person_id not between", value1, value2, "ccPersonId");
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
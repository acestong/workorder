package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.List;

public class PoolAutoDispatchModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoolAutoDispatchModelExample() {
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

        public Criteria andAutoDispatchIdIsNull() {
            addCriterion("auto_dispatch_id is null");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdIsNotNull() {
            addCriterion("auto_dispatch_id is not null");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdEqualTo(Long value) {
            addCriterion("auto_dispatch_id =", value, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdNotEqualTo(Long value) {
            addCriterion("auto_dispatch_id <>", value, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdGreaterThan(Long value) {
            addCriterion("auto_dispatch_id >", value, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("auto_dispatch_id >=", value, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdLessThan(Long value) {
            addCriterion("auto_dispatch_id <", value, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdLessThanOrEqualTo(Long value) {
            addCriterion("auto_dispatch_id <=", value, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdIn(List<Long> values) {
            addCriterion("auto_dispatch_id in", values, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdNotIn(List<Long> values) {
            addCriterion("auto_dispatch_id not in", values, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdBetween(Long value1, Long value2) {
            addCriterion("auto_dispatch_id between", value1, value2, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchIdNotBetween(Long value1, Long value2) {
            addCriterion("auto_dispatch_id not between", value1, value2, "autoDispatchId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdIsNull() {
            addCriterion("workorder_pool_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdIsNotNull() {
            addCriterion("workorder_pool_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdEqualTo(Long value) {
            addCriterion("workorder_pool_id =", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdNotEqualTo(Long value) {
            addCriterion("workorder_pool_id <>", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdGreaterThan(Long value) {
            addCriterion("workorder_pool_id >", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_pool_id >=", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdLessThan(Long value) {
            addCriterion("workorder_pool_id <", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdLessThanOrEqualTo(Long value) {
            addCriterion("workorder_pool_id <=", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdIn(List<Long> values) {
            addCriterion("workorder_pool_id in", values, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdNotIn(List<Long> values) {
            addCriterion("workorder_pool_id not in", values, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdBetween(Long value1, Long value2) {
            addCriterion("workorder_pool_id between", value1, value2, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdNotBetween(Long value1, Long value2) {
            addCriterion("workorder_pool_id not between", value1, value2, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIsNull() {
            addCriterion("workorder_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIsNotNull() {
            addCriterion("workorder_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdEqualTo(Long value) {
            addCriterion("workorder_type_id =", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotEqualTo(Long value) {
            addCriterion("workorder_type_id <>", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdGreaterThan(Long value) {
            addCriterion("workorder_type_id >", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_type_id >=", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLessThan(Long value) {
            addCriterion("workorder_type_id <", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("workorder_type_id <=", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIn(List<Long> values) {
            addCriterion("workorder_type_id in", values, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotIn(List<Long> values) {
            addCriterion("workorder_type_id not in", values, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdBetween(Long value1, Long value2) {
            addCriterion("workorder_type_id between", value1, value2, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("workorder_type_id not between", value1, value2, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andConnectorIsNull() {
            addCriterion("connector is null");
            return (Criteria) this;
        }

        public Criteria andConnectorIsNotNull() {
            addCriterion("connector is not null");
            return (Criteria) this;
        }

        public Criteria andConnectorEqualTo(String value) {
            addCriterion("connector =", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotEqualTo(String value) {
            addCriterion("connector <>", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorGreaterThan(String value) {
            addCriterion("connector >", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorGreaterThanOrEqualTo(String value) {
            addCriterion("connector >=", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLessThan(String value) {
            addCriterion("connector <", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLessThanOrEqualTo(String value) {
            addCriterion("connector <=", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLike(String value) {
            addCriterion("connector like", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotLike(String value) {
            addCriterion("connector not like", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorIn(List<String> values) {
            addCriterion("connector in", values, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotIn(List<String> values) {
            addCriterion("connector not in", values, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorBetween(String value1, String value2) {
            addCriterion("connector between", value1, value2, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotBetween(String value1, String value2) {
            addCriterion("connector not between", value1, value2, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLikeInsensitive(String value) {
            addCriterion("upper(connector) like", value.toUpperCase(), "connector");
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
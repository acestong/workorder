package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.List;

public class PoolRuleModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoolRuleModelExample() {
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

        public Criteria andPoolRuleIdIsNull() {
            addCriterion("pool_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdIsNotNull() {
            addCriterion("pool_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdEqualTo(Long value) {
            addCriterion("pool_rule_id =", value, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdNotEqualTo(Long value) {
            addCriterion("pool_rule_id <>", value, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdGreaterThan(Long value) {
            addCriterion("pool_rule_id >", value, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pool_rule_id >=", value, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdLessThan(Long value) {
            addCriterion("pool_rule_id <", value, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("pool_rule_id <=", value, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdIn(List<Long> values) {
            addCriterion("pool_rule_id in", values, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdNotIn(List<Long> values) {
            addCriterion("pool_rule_id not in", values, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdBetween(Long value1, Long value2) {
            addCriterion("pool_rule_id between", value1, value2, "poolRuleId");
            return (Criteria) this;
        }

        public Criteria andPoolRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("pool_rule_id not between", value1, value2, "poolRuleId");
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

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(Long value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(Long value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(Long value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(Long value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(Long value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(Long value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<Long> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<Long> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(Long value1, Long value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(Long value1, Long value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFilterRuleIsNull() {
            addCriterion("filter_rule is null");
            return (Criteria) this;
        }

        public Criteria andFilterRuleIsNotNull() {
            addCriterion("filter_rule is not null");
            return (Criteria) this;
        }

        public Criteria andFilterRuleEqualTo(String value) {
            addCriterion("filter_rule =", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotEqualTo(String value) {
            addCriterion("filter_rule <>", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleGreaterThan(String value) {
            addCriterion("filter_rule >", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleGreaterThanOrEqualTo(String value) {
            addCriterion("filter_rule >=", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLessThan(String value) {
            addCriterion("filter_rule <", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLessThanOrEqualTo(String value) {
            addCriterion("filter_rule <=", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLike(String value) {
            addCriterion("filter_rule like", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotLike(String value) {
            addCriterion("filter_rule not like", value, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleIn(List<String> values) {
            addCriterion("filter_rule in", values, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotIn(List<String> values) {
            addCriterion("filter_rule not in", values, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleBetween(String value1, String value2) {
            addCriterion("filter_rule between", value1, value2, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterRuleNotBetween(String value1, String value2) {
            addCriterion("filter_rule not between", value1, value2, "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterValueIsNull() {
            addCriterion("filter_value is null");
            return (Criteria) this;
        }

        public Criteria andFilterValueIsNotNull() {
            addCriterion("filter_value is not null");
            return (Criteria) this;
        }

        public Criteria andFilterValueEqualTo(String value) {
            addCriterion("filter_value =", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueNotEqualTo(String value) {
            addCriterion("filter_value <>", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueGreaterThan(String value) {
            addCriterion("filter_value >", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueGreaterThanOrEqualTo(String value) {
            addCriterion("filter_value >=", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueLessThan(String value) {
            addCriterion("filter_value <", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueLessThanOrEqualTo(String value) {
            addCriterion("filter_value <=", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueLike(String value) {
            addCriterion("filter_value like", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueNotLike(String value) {
            addCriterion("filter_value not like", value, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueIn(List<String> values) {
            addCriterion("filter_value in", values, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueNotIn(List<String> values) {
            addCriterion("filter_value not in", values, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueBetween(String value1, String value2) {
            addCriterion("filter_value between", value1, value2, "filterValue");
            return (Criteria) this;
        }

        public Criteria andFilterValueNotBetween(String value1, String value2) {
            addCriterion("filter_value not between", value1, value2, "filterValue");
            return (Criteria) this;
        }

        public Criteria andConnectorIsNull() {
            addCriterion("Connector is null");
            return (Criteria) this;
        }

        public Criteria andConnectorIsNotNull() {
            addCriterion("Connector is not null");
            return (Criteria) this;
        }

        public Criteria andConnectorEqualTo(String value) {
            addCriterion("Connector =", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotEqualTo(String value) {
            addCriterion("Connector <>", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorGreaterThan(String value) {
            addCriterion("Connector >", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorGreaterThanOrEqualTo(String value) {
            addCriterion("Connector >=", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLessThan(String value) {
            addCriterion("Connector <", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLessThanOrEqualTo(String value) {
            addCriterion("Connector <=", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLike(String value) {
            addCriterion("Connector like", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotLike(String value) {
            addCriterion("Connector not like", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorIn(List<String> values) {
            addCriterion("Connector in", values, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotIn(List<String> values) {
            addCriterion("Connector not in", values, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorBetween(String value1, String value2) {
            addCriterion("Connector between", value1, value2, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotBetween(String value1, String value2) {
            addCriterion("Connector not between", value1, value2, "connector");
            return (Criteria) this;
        }

        public Criteria andFilterRuleLikeInsensitive(String value) {
            addCriterion("upper(filter_rule) like", value.toUpperCase(), "filterRule");
            return (Criteria) this;
        }

        public Criteria andFilterValueLikeInsensitive(String value) {
            addCriterion("upper(filter_value) like", value.toUpperCase(), "filterValue");
            return (Criteria) this;
        }

        public Criteria andConnectorLikeInsensitive(String value) {
            addCriterion("upper(Connector) like", value.toUpperCase(), "connector");
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
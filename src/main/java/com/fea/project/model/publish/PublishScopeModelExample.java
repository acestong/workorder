package com.fea.project.model.publish;

import java.util.ArrayList;
import java.util.List;

public class PublishScopeModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublishScopeModelExample() {
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

        public Criteria andPublishScopeIdIsNull() {
            addCriterion("publish_scope_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdIsNotNull() {
            addCriterion("publish_scope_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdEqualTo(Long value) {
            addCriterion("publish_scope_id =", value, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdNotEqualTo(Long value) {
            addCriterion("publish_scope_id <>", value, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdGreaterThan(Long value) {
            addCriterion("publish_scope_id >", value, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_scope_id >=", value, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdLessThan(Long value) {
            addCriterion("publish_scope_id <", value, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdLessThanOrEqualTo(Long value) {
            addCriterion("publish_scope_id <=", value, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdIn(List<Long> values) {
            addCriterion("publish_scope_id in", values, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdNotIn(List<Long> values) {
            addCriterion("publish_scope_id not in", values, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdBetween(Long value1, Long value2) {
            addCriterion("publish_scope_id between", value1, value2, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishScopeIdNotBetween(Long value1, Long value2) {
            addCriterion("publish_scope_id not between", value1, value2, "publishScopeId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNull() {
            addCriterion("publish_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNotNull() {
            addCriterion("publish_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishIdEqualTo(Long value) {
            addCriterion("publish_id =", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotEqualTo(Long value) {
            addCriterion("publish_id <>", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThan(Long value) {
            addCriterion("publish_id >", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_id >=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThan(Long value) {
            addCriterion("publish_id <", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThanOrEqualTo(Long value) {
            addCriterion("publish_id <=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIn(List<Long> values) {
            addCriterion("publish_id in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotIn(List<Long> values) {
            addCriterion("publish_id not in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdBetween(Long value1, Long value2) {
            addCriterion("publish_id between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotBetween(Long value1, Long value2) {
            addCriterion("publish_id not between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andScopeTypeIsNull() {
            addCriterion("scope_type is null");
            return (Criteria) this;
        }

        public Criteria andScopeTypeIsNotNull() {
            addCriterion("scope_type is not null");
            return (Criteria) this;
        }

        public Criteria andScopeTypeEqualTo(Long value) {
            addCriterion("scope_type =", value, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeNotEqualTo(Long value) {
            addCriterion("scope_type <>", value, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeGreaterThan(Long value) {
            addCriterion("scope_type >", value, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("scope_type >=", value, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeLessThan(Long value) {
            addCriterion("scope_type <", value, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeLessThanOrEqualTo(Long value) {
            addCriterion("scope_type <=", value, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeIn(List<Long> values) {
            addCriterion("scope_type in", values, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeNotIn(List<Long> values) {
            addCriterion("scope_type not in", values, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeBetween(Long value1, Long value2) {
            addCriterion("scope_type between", value1, value2, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeTypeNotBetween(Long value1, Long value2) {
            addCriterion("scope_type not between", value1, value2, "scopeType");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdIsNull() {
            addCriterion("scope_department_id is null");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdIsNotNull() {
            addCriterion("scope_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdEqualTo(Long value) {
            addCriterion("scope_department_id =", value, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdNotEqualTo(Long value) {
            addCriterion("scope_department_id <>", value, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdGreaterThan(Long value) {
            addCriterion("scope_department_id >", value, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("scope_department_id >=", value, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdLessThan(Long value) {
            addCriterion("scope_department_id <", value, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdLessThanOrEqualTo(Long value) {
            addCriterion("scope_department_id <=", value, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdIn(List<Long> values) {
            addCriterion("scope_department_id in", values, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdNotIn(List<Long> values) {
            addCriterion("scope_department_id not in", values, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdBetween(Long value1, Long value2) {
            addCriterion("scope_department_id between", value1, value2, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentIdNotBetween(Long value1, Long value2) {
            addCriterion("scope_department_id not between", value1, value2, "scopeDepartmentId");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameIsNull() {
            addCriterion("scope_department_name is null");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameIsNotNull() {
            addCriterion("scope_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameEqualTo(String value) {
            addCriterion("scope_department_name =", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameNotEqualTo(String value) {
            addCriterion("scope_department_name <>", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameGreaterThan(String value) {
            addCriterion("scope_department_name >", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("scope_department_name >=", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameLessThan(String value) {
            addCriterion("scope_department_name <", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("scope_department_name <=", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameLike(String value) {
            addCriterion("scope_department_name like", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameNotLike(String value) {
            addCriterion("scope_department_name not like", value, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameIn(List<String> values) {
            addCriterion("scope_department_name in", values, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameNotIn(List<String> values) {
            addCriterion("scope_department_name not in", values, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameBetween(String value1, String value2) {
            addCriterion("scope_department_name between", value1, value2, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("scope_department_name not between", value1, value2, "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdIsNull() {
            addCriterion("scope_person_id is null");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdIsNotNull() {
            addCriterion("scope_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdEqualTo(Long value) {
            addCriterion("scope_person_id =", value, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdNotEqualTo(Long value) {
            addCriterion("scope_person_id <>", value, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdGreaterThan(Long value) {
            addCriterion("scope_person_id >", value, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("scope_person_id >=", value, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdLessThan(Long value) {
            addCriterion("scope_person_id <", value, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdLessThanOrEqualTo(Long value) {
            addCriterion("scope_person_id <=", value, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdIn(List<Long> values) {
            addCriterion("scope_person_id in", values, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdNotIn(List<Long> values) {
            addCriterion("scope_person_id not in", values, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdBetween(Long value1, Long value2) {
            addCriterion("scope_person_id between", value1, value2, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonIdNotBetween(Long value1, Long value2) {
            addCriterion("scope_person_id not between", value1, value2, "scopePersonId");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameIsNull() {
            addCriterion("scope_person_name is null");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameIsNotNull() {
            addCriterion("scope_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameEqualTo(String value) {
            addCriterion("scope_person_name =", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameNotEqualTo(String value) {
            addCriterion("scope_person_name <>", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameGreaterThan(String value) {
            addCriterion("scope_person_name >", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("scope_person_name >=", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameLessThan(String value) {
            addCriterion("scope_person_name <", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameLessThanOrEqualTo(String value) {
            addCriterion("scope_person_name <=", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameLike(String value) {
            addCriterion("scope_person_name like", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameNotLike(String value) {
            addCriterion("scope_person_name not like", value, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameIn(List<String> values) {
            addCriterion("scope_person_name in", values, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameNotIn(List<String> values) {
            addCriterion("scope_person_name not in", values, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameBetween(String value1, String value2) {
            addCriterion("scope_person_name between", value1, value2, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameNotBetween(String value1, String value2) {
            addCriterion("scope_person_name not between", value1, value2, "scopePersonName");
            return (Criteria) this;
        }

        public Criteria andScopeDepartmentNameLikeInsensitive(String value) {
            addCriterion("upper(scope_department_name) like", value.toUpperCase(), "scopeDepartmentName");
            return (Criteria) this;
        }

        public Criteria andScopePersonNameLikeInsensitive(String value) {
            addCriterion("upper(scope_person_name) like", value.toUpperCase(), "scopePersonName");
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
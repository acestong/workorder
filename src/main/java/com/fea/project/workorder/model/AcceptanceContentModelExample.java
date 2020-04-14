package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcceptanceContentModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcceptanceContentModelExample() {
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

        public Criteria andAcceptanceContentIdIsNull() {
            addCriterion("acceptance_content_id is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdIsNotNull() {
            addCriterion("acceptance_content_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdEqualTo(Long value) {
            addCriterion("acceptance_content_id =", value, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdNotEqualTo(Long value) {
            addCriterion("acceptance_content_id <>", value, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdGreaterThan(Long value) {
            addCriterion("acceptance_content_id >", value, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("acceptance_content_id >=", value, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdLessThan(Long value) {
            addCriterion("acceptance_content_id <", value, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdLessThanOrEqualTo(Long value) {
            addCriterion("acceptance_content_id <=", value, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdIn(List<Long> values) {
            addCriterion("acceptance_content_id in", values, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdNotIn(List<Long> values) {
            addCriterion("acceptance_content_id not in", values, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdBetween(Long value1, Long value2) {
            addCriterion("acceptance_content_id between", value1, value2, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceContentIdNotBetween(Long value1, Long value2) {
            addCriterion("acceptance_content_id not between", value1, value2, "acceptanceContentId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(Long value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(Long value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(Long value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(Long value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(Long value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(Long value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<Long> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<Long> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(Long value1, Long value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(Long value1, Long value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCountNumIsNull() {
            addCriterion("count_num is null");
            return (Criteria) this;
        }

        public Criteria andCountNumIsNotNull() {
            addCriterion("count_num is not null");
            return (Criteria) this;
        }

        public Criteria andCountNumEqualTo(Long value) {
            addCriterion("count_num =", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotEqualTo(Long value) {
            addCriterion("count_num <>", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumGreaterThan(Long value) {
            addCriterion("count_num >", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumGreaterThanOrEqualTo(Long value) {
            addCriterion("count_num >=", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumLessThan(Long value) {
            addCriterion("count_num <", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumLessThanOrEqualTo(Long value) {
            addCriterion("count_num <=", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumIn(List<Long> values) {
            addCriterion("count_num in", values, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotIn(List<Long> values) {
            addCriterion("count_num not in", values, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumBetween(Long value1, Long value2) {
            addCriterion("count_num between", value1, value2, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotBetween(Long value1, Long value2) {
            addCriterion("count_num not between", value1, value2, "countNum");
            return (Criteria) this;
        }

        public Criteria andConclusionIsNull() {
            addCriterion("conclusion is null");
            return (Criteria) this;
        }

        public Criteria andConclusionIsNotNull() {
            addCriterion("conclusion is not null");
            return (Criteria) this;
        }

        public Criteria andConclusionEqualTo(Long value) {
            addCriterion("conclusion =", value, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionNotEqualTo(Long value) {
            addCriterion("conclusion <>", value, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionGreaterThan(Long value) {
            addCriterion("conclusion >", value, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionGreaterThanOrEqualTo(Long value) {
            addCriterion("conclusion >=", value, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionLessThan(Long value) {
            addCriterion("conclusion <", value, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionLessThanOrEqualTo(Long value) {
            addCriterion("conclusion <=", value, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionIn(List<Long> values) {
            addCriterion("conclusion in", values, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionNotIn(List<Long> values) {
            addCriterion("conclusion not in", values, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionBetween(Long value1, Long value2) {
            addCriterion("conclusion between", value1, value2, "conclusion");
            return (Criteria) this;
        }

        public Criteria andConclusionNotBetween(Long value1, Long value2) {
            addCriterion("conclusion not between", value1, value2, "conclusion");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNull() {
            addCriterion("opinion is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("opinion =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("opinion <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("opinion >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("opinion >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("opinion <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("opinion <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("opinion like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("opinion not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("opinion in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("opinion not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("opinion between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("opinion not between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdIsNull() {
            addCriterion("acceptance_id is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdIsNotNull() {
            addCriterion("acceptance_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdEqualTo(Long value) {
            addCriterion("acceptance_id =", value, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdNotEqualTo(Long value) {
            addCriterion("acceptance_id <>", value, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdGreaterThan(Long value) {
            addCriterion("acceptance_id >", value, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("acceptance_id >=", value, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdLessThan(Long value) {
            addCriterion("acceptance_id <", value, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdLessThanOrEqualTo(Long value) {
            addCriterion("acceptance_id <=", value, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdIn(List<Long> values) {
            addCriterion("acceptance_id in", values, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdNotIn(List<Long> values) {
            addCriterion("acceptance_id not in", values, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdBetween(Long value1, Long value2) {
            addCriterion("acceptance_id between", value1, value2, "acceptanceId");
            return (Criteria) this;
        }

        public Criteria andAcceptanceIdNotBetween(Long value1, Long value2) {
            addCriterion("acceptance_id not between", value1, value2, "acceptanceId");
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andOpinionLikeInsensitive(String value) {
            addCriterion("upper(opinion) like", value.toUpperCase(), "opinion");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
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
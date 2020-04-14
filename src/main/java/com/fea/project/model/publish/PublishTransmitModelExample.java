package com.fea.project.model.publish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublishTransmitModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublishTransmitModelExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPubishIdIsNull() {
            addCriterion("pubish_id is null");
            return (Criteria) this;
        }

        public Criteria andPubishIdIsNotNull() {
            addCriterion("pubish_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubishIdEqualTo(Long value) {
            addCriterion("pubish_id =", value, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdNotEqualTo(Long value) {
            addCriterion("pubish_id <>", value, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdGreaterThan(Long value) {
            addCriterion("pubish_id >", value, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pubish_id >=", value, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdLessThan(Long value) {
            addCriterion("pubish_id <", value, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdLessThanOrEqualTo(Long value) {
            addCriterion("pubish_id <=", value, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdIn(List<Long> values) {
            addCriterion("pubish_id in", values, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdNotIn(List<Long> values) {
            addCriterion("pubish_id not in", values, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdBetween(Long value1, Long value2) {
            addCriterion("pubish_id between", value1, value2, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPubishIdNotBetween(Long value1, Long value2) {
            addCriterion("pubish_id not between", value1, value2, "pubishId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdIsNull() {
            addCriterion("publish_transmit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdIsNotNull() {
            addCriterion("publish_transmit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdEqualTo(Long value) {
            addCriterion("publish_transmit_user_id =", value, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdNotEqualTo(Long value) {
            addCriterion("publish_transmit_user_id <>", value, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdGreaterThan(Long value) {
            addCriterion("publish_transmit_user_id >", value, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_transmit_user_id >=", value, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdLessThan(Long value) {
            addCriterion("publish_transmit_user_id <", value, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdLessThanOrEqualTo(Long value) {
            addCriterion("publish_transmit_user_id <=", value, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdIn(List<Long> values) {
            addCriterion("publish_transmit_user_id in", values, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdNotIn(List<Long> values) {
            addCriterion("publish_transmit_user_id not in", values, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdBetween(Long value1, Long value2) {
            addCriterion("publish_transmit_user_id between", value1, value2, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitUserIdNotBetween(Long value1, Long value2) {
            addCriterion("publish_transmit_user_id not between", value1, value2, "publishTransmitUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeIsNull() {
            addCriterion("publish_transmit_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeIsNotNull() {
            addCriterion("publish_transmit_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeEqualTo(Date value) {
            addCriterion("publish_transmit_time =", value, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeNotEqualTo(Date value) {
            addCriterion("publish_transmit_time <>", value, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeGreaterThan(Date value) {
            addCriterion("publish_transmit_time >", value, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_transmit_time >=", value, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeLessThan(Date value) {
            addCriterion("publish_transmit_time <", value, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_transmit_time <=", value, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeIn(List<Date> values) {
            addCriterion("publish_transmit_time in", values, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeNotIn(List<Date> values) {
            addCriterion("publish_transmit_time not in", values, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeBetween(Date value1, Date value2) {
            addCriterion("publish_transmit_time between", value1, value2, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishTransmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_transmit_time not between", value1, value2, "publishTransmitTime");
            return (Criteria) this;
        }

        public Criteria andPublishContentIsNull() {
            addCriterion("publish_content is null");
            return (Criteria) this;
        }

        public Criteria andPublishContentIsNotNull() {
            addCriterion("publish_content is not null");
            return (Criteria) this;
        }

        public Criteria andPublishContentEqualTo(String value) {
            addCriterion("publish_content =", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentNotEqualTo(String value) {
            addCriterion("publish_content <>", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentGreaterThan(String value) {
            addCriterion("publish_content >", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentGreaterThanOrEqualTo(String value) {
            addCriterion("publish_content >=", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentLessThan(String value) {
            addCriterion("publish_content <", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentLessThanOrEqualTo(String value) {
            addCriterion("publish_content <=", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentLike(String value) {
            addCriterion("publish_content like", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentNotLike(String value) {
            addCriterion("publish_content not like", value, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentIn(List<String> values) {
            addCriterion("publish_content in", values, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentNotIn(List<String> values) {
            addCriterion("publish_content not in", values, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentBetween(String value1, String value2) {
            addCriterion("publish_content between", value1, value2, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentNotBetween(String value1, String value2) {
            addCriterion("publish_content not between", value1, value2, "publishContent");
            return (Criteria) this;
        }

        public Criteria andPublishContentLikeInsensitive(String value) {
            addCriterion("upper(publish_content) like", value.toUpperCase(), "publishContent");
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
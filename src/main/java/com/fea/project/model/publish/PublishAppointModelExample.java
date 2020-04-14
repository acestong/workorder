package com.fea.project.model.publish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublishAppointModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublishAppointModelExample() {
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

        public Criteria andPublishAppointIdIsNull() {
            addCriterion("publish_appoint_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdIsNotNull() {
            addCriterion("publish_appoint_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdEqualTo(Long value) {
            addCriterion("publish_appoint_id =", value, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdNotEqualTo(Long value) {
            addCriterion("publish_appoint_id <>", value, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdGreaterThan(Long value) {
            addCriterion("publish_appoint_id >", value, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_appoint_id >=", value, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdLessThan(Long value) {
            addCriterion("publish_appoint_id <", value, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdLessThanOrEqualTo(Long value) {
            addCriterion("publish_appoint_id <=", value, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdIn(List<Long> values) {
            addCriterion("publish_appoint_id in", values, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdNotIn(List<Long> values) {
            addCriterion("publish_appoint_id not in", values, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdBetween(Long value1, Long value2) {
            addCriterion("publish_appoint_id between", value1, value2, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointIdNotBetween(Long value1, Long value2) {
            addCriterion("publish_appoint_id not between", value1, value2, "publishAppointId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdIsNull() {
            addCriterion("publish_appoint_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdIsNotNull() {
            addCriterion("publish_appoint_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdEqualTo(Long value) {
            addCriterion("publish_appoint_user_id =", value, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdNotEqualTo(Long value) {
            addCriterion("publish_appoint_user_id <>", value, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdGreaterThan(Long value) {
            addCriterion("publish_appoint_user_id >", value, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_appoint_user_id >=", value, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdLessThan(Long value) {
            addCriterion("publish_appoint_user_id <", value, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdLessThanOrEqualTo(Long value) {
            addCriterion("publish_appoint_user_id <=", value, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdIn(List<Long> values) {
            addCriterion("publish_appoint_user_id in", values, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdNotIn(List<Long> values) {
            addCriterion("publish_appoint_user_id not in", values, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdBetween(Long value1, Long value2) {
            addCriterion("publish_appoint_user_id between", value1, value2, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserIdNotBetween(Long value1, Long value2) {
            addCriterion("publish_appoint_user_id not between", value1, value2, "publishAppointUserId");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameIsNull() {
            addCriterion("publish_appoint_user_name is null");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameIsNotNull() {
            addCriterion("publish_appoint_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameEqualTo(String value) {
            addCriterion("publish_appoint_user_name =", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameNotEqualTo(String value) {
            addCriterion("publish_appoint_user_name <>", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameGreaterThan(String value) {
            addCriterion("publish_appoint_user_name >", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("publish_appoint_user_name >=", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameLessThan(String value) {
            addCriterion("publish_appoint_user_name <", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameLessThanOrEqualTo(String value) {
            addCriterion("publish_appoint_user_name <=", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameLike(String value) {
            addCriterion("publish_appoint_user_name like", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameNotLike(String value) {
            addCriterion("publish_appoint_user_name not like", value, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameIn(List<String> values) {
            addCriterion("publish_appoint_user_name in", values, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameNotIn(List<String> values) {
            addCriterion("publish_appoint_user_name not in", values, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameBetween(String value1, String value2) {
            addCriterion("publish_appoint_user_name between", value1, value2, "publishAppointUserName");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameNotBetween(String value1, String value2) {
            addCriterion("publish_appoint_user_name not between", value1, value2, "publishAppointUserName");
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

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Long value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Long value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Long value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Long value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Long value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Long value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Long> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Long> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Long value1, Long value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Long value1, Long value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andPublishAppointUserNameLikeInsensitive(String value) {
            addCriterion("upper(publish_appoint_user_name) like", value.toUpperCase(), "publishAppointUserName");
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
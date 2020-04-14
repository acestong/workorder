package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderResponseModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderResponseModelExample() {
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

        public Criteria andResponseIdIsNull() {
            addCriterion("response_id is null");
            return (Criteria) this;
        }

        public Criteria andResponseIdIsNotNull() {
            addCriterion("response_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponseIdEqualTo(Long value) {
            addCriterion("response_id =", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotEqualTo(Long value) {
            addCriterion("response_id <>", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdGreaterThan(Long value) {
            addCriterion("response_id >", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("response_id >=", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLessThan(Long value) {
            addCriterion("response_id <", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLessThanOrEqualTo(Long value) {
            addCriterion("response_id <=", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdIn(List<Long> values) {
            addCriterion("response_id in", values, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotIn(List<Long> values) {
            addCriterion("response_id not in", values, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdBetween(Long value1, Long value2) {
            addCriterion("response_id between", value1, value2, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotBetween(Long value1, Long value2) {
            addCriterion("response_id not between", value1, value2, "responseId");
            return (Criteria) this;
        }

        public Criteria andIsConfirmIsNull() {
            addCriterion("is_confirm is null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmIsNotNull() {
            addCriterion("is_confirm is not null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmEqualTo(Long value) {
            addCriterion("is_confirm =", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotEqualTo(Long value) {
            addCriterion("is_confirm <>", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmGreaterThan(Long value) {
            addCriterion("is_confirm >", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmGreaterThanOrEqualTo(Long value) {
            addCriterion("is_confirm >=", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmLessThan(Long value) {
            addCriterion("is_confirm <", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmLessThanOrEqualTo(Long value) {
            addCriterion("is_confirm <=", value, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmIn(List<Long> values) {
            addCriterion("is_confirm in", values, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotIn(List<Long> values) {
            addCriterion("is_confirm not in", values, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmBetween(Long value1, Long value2) {
            addCriterion("is_confirm between", value1, value2, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmNotBetween(Long value1, Long value2) {
            addCriterion("is_confirm not between", value1, value2, "isConfirm");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescIsNull() {
            addCriterion("is_confirm_desc is null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescIsNotNull() {
            addCriterion("is_confirm_desc is not null");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescEqualTo(String value) {
            addCriterion("is_confirm_desc =", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescNotEqualTo(String value) {
            addCriterion("is_confirm_desc <>", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescGreaterThan(String value) {
            addCriterion("is_confirm_desc >", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescGreaterThanOrEqualTo(String value) {
            addCriterion("is_confirm_desc >=", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescLessThan(String value) {
            addCriterion("is_confirm_desc <", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescLessThanOrEqualTo(String value) {
            addCriterion("is_confirm_desc <=", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescLike(String value) {
            addCriterion("is_confirm_desc like", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescNotLike(String value) {
            addCriterion("is_confirm_desc not like", value, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescIn(List<String> values) {
            addCriterion("is_confirm_desc in", values, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescNotIn(List<String> values) {
            addCriterion("is_confirm_desc not in", values, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescBetween(String value1, String value2) {
            addCriterion("is_confirm_desc between", value1, value2, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andIsConfirmDescNotBetween(String value1, String value2) {
            addCriterion("is_confirm_desc not between", value1, value2, "isConfirmDesc");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeIsNull() {
            addCriterion("wish_deal_time is null");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeIsNotNull() {
            addCriterion("wish_deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeEqualTo(Date value) {
            addCriterion("wish_deal_time =", value, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeNotEqualTo(Date value) {
            addCriterion("wish_deal_time <>", value, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeGreaterThan(Date value) {
            addCriterion("wish_deal_time >", value, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wish_deal_time >=", value, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeLessThan(Date value) {
            addCriterion("wish_deal_time <", value, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("wish_deal_time <=", value, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeIn(List<Date> values) {
            addCriterion("wish_deal_time in", values, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeNotIn(List<Date> values) {
            addCriterion("wish_deal_time not in", values, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeBetween(Date value1, Date value2) {
            addCriterion("wish_deal_time between", value1, value2, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andWishDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("wish_deal_time not between", value1, value2, "wishDealTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeIsNull() {
            addCriterion("deadline_time is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeIsNotNull() {
            addCriterion("deadline_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeEqualTo(Date value) {
            addCriterion("deadline_time =", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeNotEqualTo(Date value) {
            addCriterion("deadline_time <>", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeGreaterThan(Date value) {
            addCriterion("deadline_time >", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline_time >=", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeLessThan(Date value) {
            addCriterion("deadline_time <", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeLessThanOrEqualTo(Date value) {
            addCriterion("deadline_time <=", value, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeIn(List<Date> values) {
            addCriterion("deadline_time in", values, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeNotIn(List<Date> values) {
            addCriterion("deadline_time not in", values, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeBetween(Date value1, Date value2) {
            addCriterion("deadline_time between", value1, value2, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineTimeNotBetween(Date value1, Date value2) {
            addCriterion("deadline_time not between", value1, value2, "deadlineTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andIsConfirmDescLikeInsensitive(String value) {
            addCriterion("upper(is_confirm_desc) like", value.toUpperCase(), "isConfirmDesc");
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
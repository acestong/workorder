package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderRecordModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderRecordModelExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Long value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Long value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Long value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Long value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Long> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Long> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Long value1, Long value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andOptionTitleIsNull() {
            addCriterion("option_title is null");
            return (Criteria) this;
        }

        public Criteria andOptionTitleIsNotNull() {
            addCriterion("option_title is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTitleEqualTo(String value) {
            addCriterion("option_title =", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotEqualTo(String value) {
            addCriterion("option_title <>", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleGreaterThan(String value) {
            addCriterion("option_title >", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("option_title >=", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleLessThan(String value) {
            addCriterion("option_title <", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleLessThanOrEqualTo(String value) {
            addCriterion("option_title <=", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleLike(String value) {
            addCriterion("option_title like", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotLike(String value) {
            addCriterion("option_title not like", value, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleIn(List<String> values) {
            addCriterion("option_title in", values, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotIn(List<String> values) {
            addCriterion("option_title not in", values, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleBetween(String value1, String value2) {
            addCriterion("option_title between", value1, value2, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOptionTitleNotBetween(String value1, String value2) {
            addCriterion("option_title not between", value1, value2, "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNull() {
            addCriterion("operation_name is null");
            return (Criteria) this;
        }

        public Criteria andOperationNameIsNotNull() {
            addCriterion("operation_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperationNameEqualTo(String value) {
            addCriterion("operation_name =", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotEqualTo(String value) {
            addCriterion("operation_name <>", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThan(String value) {
            addCriterion("operation_name >", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameGreaterThanOrEqualTo(String value) {
            addCriterion("operation_name >=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThan(String value) {
            addCriterion("operation_name <", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLessThanOrEqualTo(String value) {
            addCriterion("operation_name <=", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameLike(String value) {
            addCriterion("operation_name like", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotLike(String value) {
            addCriterion("operation_name not like", value, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameIn(List<String> values) {
            addCriterion("operation_name in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotIn(List<String> values) {
            addCriterion("operation_name not in", values, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameBetween(String value1, String value2) {
            addCriterion("operation_name between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andOperationNameNotBetween(String value1, String value2) {
            addCriterion("operation_name not between", value1, value2, "operationName");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNull() {
            addCriterion("result_type is null");
            return (Criteria) this;
        }

        public Criteria andResultTypeIsNotNull() {
            addCriterion("result_type is not null");
            return (Criteria) this;
        }

        public Criteria andResultTypeEqualTo(Long value) {
            addCriterion("result_type =", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotEqualTo(Long value) {
            addCriterion("result_type <>", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThan(Long value) {
            addCriterion("result_type >", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("result_type >=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThan(Long value) {
            addCriterion("result_type <", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeLessThanOrEqualTo(Long value) {
            addCriterion("result_type <=", value, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeIn(List<Long> values) {
            addCriterion("result_type in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotIn(List<Long> values) {
            addCriterion("result_type not in", values, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeBetween(Long value1, Long value2) {
            addCriterion("result_type between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultTypeNotBetween(Long value1, Long value2) {
            addCriterion("result_type not between", value1, value2, "resultType");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeIsNull() {
            addCriterion("option_user_type is null");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeIsNotNull() {
            addCriterion("option_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeEqualTo(String value) {
            addCriterion("option_user_type =", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeNotEqualTo(String value) {
            addCriterion("option_user_type <>", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeGreaterThan(String value) {
            addCriterion("option_user_type >", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("option_user_type >=", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeLessThan(String value) {
            addCriterion("option_user_type <", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeLessThanOrEqualTo(String value) {
            addCriterion("option_user_type <=", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeLike(String value) {
            addCriterion("option_user_type like", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeNotLike(String value) {
            addCriterion("option_user_type not like", value, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeIn(List<String> values) {
            addCriterion("option_user_type in", values, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeNotIn(List<String> values) {
            addCriterion("option_user_type not in", values, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeBetween(String value1, String value2) {
            addCriterion("option_user_type between", value1, value2, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeNotBetween(String value1, String value2) {
            addCriterion("option_user_type not between", value1, value2, "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdIsNull() {
            addCriterion("option_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdIsNotNull() {
            addCriterion("option_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdEqualTo(Long value) {
            addCriterion("option_user_id =", value, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdNotEqualTo(Long value) {
            addCriterion("option_user_id <>", value, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdGreaterThan(Long value) {
            addCriterion("option_user_id >", value, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("option_user_id >=", value, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdLessThan(Long value) {
            addCriterion("option_user_id <", value, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdLessThanOrEqualTo(Long value) {
            addCriterion("option_user_id <=", value, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdIn(List<Long> values) {
            addCriterion("option_user_id in", values, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdNotIn(List<Long> values) {
            addCriterion("option_user_id not in", values, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdBetween(Long value1, Long value2) {
            addCriterion("option_user_id between", value1, value2, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserIdNotBetween(Long value1, Long value2) {
            addCriterion("option_user_id not between", value1, value2, "optionUserId");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameIsNull() {
            addCriterion("option_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameIsNotNull() {
            addCriterion("option_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameEqualTo(String value) {
            addCriterion("option_user_name =", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameNotEqualTo(String value) {
            addCriterion("option_user_name <>", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameGreaterThan(String value) {
            addCriterion("option_user_name >", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("option_user_name >=", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameLessThan(String value) {
            addCriterion("option_user_name <", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameLessThanOrEqualTo(String value) {
            addCriterion("option_user_name <=", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameLike(String value) {
            addCriterion("option_user_name like", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameNotLike(String value) {
            addCriterion("option_user_name not like", value, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameIn(List<String> values) {
            addCriterion("option_user_name in", values, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameNotIn(List<String> values) {
            addCriterion("option_user_name not in", values, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameBetween(String value1, String value2) {
            addCriterion("option_user_name between", value1, value2, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameNotBetween(String value1, String value2) {
            addCriterion("option_user_name not between", value1, value2, "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeIsNull() {
            addCriterion("option_time_type is null");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeIsNotNull() {
            addCriterion("option_time_type is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeEqualTo(String value) {
            addCriterion("option_time_type =", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeNotEqualTo(String value) {
            addCriterion("option_time_type <>", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeGreaterThan(String value) {
            addCriterion("option_time_type >", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("option_time_type >=", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeLessThan(String value) {
            addCriterion("option_time_type <", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeLessThanOrEqualTo(String value) {
            addCriterion("option_time_type <=", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeLike(String value) {
            addCriterion("option_time_type like", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeNotLike(String value) {
            addCriterion("option_time_type not like", value, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeIn(List<String> values) {
            addCriterion("option_time_type in", values, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeNotIn(List<String> values) {
            addCriterion("option_time_type not in", values, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeBetween(String value1, String value2) {
            addCriterion("option_time_type between", value1, value2, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeNotBetween(String value1, String value2) {
            addCriterion("option_time_type not between", value1, value2, "optionTimeType");
            return (Criteria) this;
        }

        public Criteria andOptionTimeIsNull() {
            addCriterion("option_time is null");
            return (Criteria) this;
        }

        public Criteria andOptionTimeIsNotNull() {
            addCriterion("option_time is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTimeEqualTo(Date value) {
            addCriterion("option_time =", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeNotEqualTo(Date value) {
            addCriterion("option_time <>", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeGreaterThan(Date value) {
            addCriterion("option_time >", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("option_time >=", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeLessThan(Date value) {
            addCriterion("option_time <", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeLessThanOrEqualTo(Date value) {
            addCriterion("option_time <=", value, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeIn(List<Date> values) {
            addCriterion("option_time in", values, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeNotIn(List<Date> values) {
            addCriterion("option_time not in", values, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeBetween(Date value1, Date value2) {
            addCriterion("option_time between", value1, value2, "optionTime");
            return (Criteria) this;
        }

        public Criteria andOptionTimeNotBetween(Date value1, Date value2) {
            addCriterion("option_time not between", value1, value2, "optionTime");
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

        public Criteria andOptionTitleLikeInsensitive(String value) {
            addCriterion("upper(option_title) like", value.toUpperCase(), "optionTitle");
            return (Criteria) this;
        }

        public Criteria andOperationNameLikeInsensitive(String value) {
            addCriterion("upper(operation_name) like", value.toUpperCase(), "operationName");
            return (Criteria) this;
        }

        public Criteria andResultLikeInsensitive(String value) {
            addCriterion("upper(result) like", value.toUpperCase(), "result");
            return (Criteria) this;
        }

        public Criteria andOptionUserTypeLikeInsensitive(String value) {
            addCriterion("upper(option_user_type) like", value.toUpperCase(), "optionUserType");
            return (Criteria) this;
        }

        public Criteria andOptionUserNameLikeInsensitive(String value) {
            addCriterion("upper(option_user_name) like", value.toUpperCase(), "optionUserName");
            return (Criteria) this;
        }

        public Criteria andOptionTimeTypeLikeInsensitive(String value) {
            addCriterion("upper(option_time_type) like", value.toUpperCase(), "optionTimeType");
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
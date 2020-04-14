package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskNumModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskNumModelExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCurUserIdIsNull() {
            addCriterion("cur_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCurUserIdIsNotNull() {
            addCriterion("cur_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurUserIdEqualTo(Long value) {
            addCriterion("cur_user_id =", value, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdNotEqualTo(Long value) {
            addCriterion("cur_user_id <>", value, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdGreaterThan(Long value) {
            addCriterion("cur_user_id >", value, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cur_user_id >=", value, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdLessThan(Long value) {
            addCriterion("cur_user_id <", value, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdLessThanOrEqualTo(Long value) {
            addCriterion("cur_user_id <=", value, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdIn(List<Long> values) {
            addCriterion("cur_user_id in", values, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdNotIn(List<Long> values) {
            addCriterion("cur_user_id not in", values, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdBetween(Long value1, Long value2) {
            addCriterion("cur_user_id between", value1, value2, "curUserId");
            return (Criteria) this;
        }

        public Criteria andCurUserIdNotBetween(Long value1, Long value2) {
            addCriterion("cur_user_id not between", value1, value2, "curUserId");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterIsNull() {
            addCriterion("is_head_letter is null");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterIsNotNull() {
            addCriterion("is_head_letter is not null");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterEqualTo(Long value) {
            addCriterion("is_head_letter =", value, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterNotEqualTo(Long value) {
            addCriterion("is_head_letter <>", value, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterGreaterThan(Long value) {
            addCriterion("is_head_letter >", value, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterGreaterThanOrEqualTo(Long value) {
            addCriterion("is_head_letter >=", value, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterLessThan(Long value) {
            addCriterion("is_head_letter <", value, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterLessThanOrEqualTo(Long value) {
            addCriterion("is_head_letter <=", value, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterIn(List<Long> values) {
            addCriterion("is_head_letter in", values, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterNotIn(List<Long> values) {
            addCriterion("is_head_letter not in", values, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterBetween(Long value1, Long value2) {
            addCriterion("is_head_letter between", value1, value2, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andIsHeadLetterNotBetween(Long value1, Long value2) {
            addCriterion("is_head_letter not between", value1, value2, "isHeadLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterIsNull() {
            addCriterion("head_letter is null");
            return (Criteria) this;
        }

        public Criteria andHeadLetterIsNotNull() {
            addCriterion("head_letter is not null");
            return (Criteria) this;
        }

        public Criteria andHeadLetterEqualTo(String value) {
            addCriterion("head_letter =", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterNotEqualTo(String value) {
            addCriterion("head_letter <>", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterGreaterThan(String value) {
            addCriterion("head_letter >", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterGreaterThanOrEqualTo(String value) {
            addCriterion("head_letter >=", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterLessThan(String value) {
            addCriterion("head_letter <", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterLessThanOrEqualTo(String value) {
            addCriterion("head_letter <=", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterLike(String value) {
            addCriterion("head_letter like", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterNotLike(String value) {
            addCriterion("head_letter not like", value, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterIn(List<String> values) {
            addCriterion("head_letter in", values, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterNotIn(List<String> values) {
            addCriterion("head_letter not in", values, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterBetween(String value1, String value2) {
            addCriterion("head_letter between", value1, value2, "headLetter");
            return (Criteria) this;
        }

        public Criteria andHeadLetterNotBetween(String value1, String value2) {
            addCriterion("head_letter not between", value1, value2, "headLetter");
            return (Criteria) this;
        }

        public Criteria andIsDateIsNull() {
            addCriterion("is_date is null");
            return (Criteria) this;
        }

        public Criteria andIsDateIsNotNull() {
            addCriterion("is_date is not null");
            return (Criteria) this;
        }

        public Criteria andIsDateEqualTo(Long value) {
            addCriterion("is_date =", value, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateNotEqualTo(Long value) {
            addCriterion("is_date <>", value, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateGreaterThan(Long value) {
            addCriterion("is_date >", value, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateGreaterThanOrEqualTo(Long value) {
            addCriterion("is_date >=", value, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateLessThan(Long value) {
            addCriterion("is_date <", value, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateLessThanOrEqualTo(Long value) {
            addCriterion("is_date <=", value, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateIn(List<Long> values) {
            addCriterion("is_date in", values, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateNotIn(List<Long> values) {
            addCriterion("is_date not in", values, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateBetween(Long value1, Long value2) {
            addCriterion("is_date between", value1, value2, "isDate");
            return (Criteria) this;
        }

        public Criteria andIsDateNotBetween(Long value1, Long value2) {
            addCriterion("is_date not between", value1, value2, "isDate");
            return (Criteria) this;
        }

        public Criteria andTodayIsNull() {
            addCriterion("today is null");
            return (Criteria) this;
        }

        public Criteria andTodayIsNotNull() {
            addCriterion("today is not null");
            return (Criteria) this;
        }

        public Criteria andTodayEqualTo(Date value) {
            addCriterionForJDBCDate("today =", value, "today");
            return (Criteria) this;
        }

        public Criteria andTodayNotEqualTo(Date value) {
            addCriterionForJDBCDate("today <>", value, "today");
            return (Criteria) this;
        }

        public Criteria andTodayGreaterThan(Date value) {
            addCriterionForJDBCDate("today >", value, "today");
            return (Criteria) this;
        }

        public Criteria andTodayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("today >=", value, "today");
            return (Criteria) this;
        }

        public Criteria andTodayLessThan(Date value) {
            addCriterionForJDBCDate("today <", value, "today");
            return (Criteria) this;
        }

        public Criteria andTodayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("today <=", value, "today");
            return (Criteria) this;
        }

        public Criteria andTodayIn(List<Date> values) {
            addCriterionForJDBCDate("today in", values, "today");
            return (Criteria) this;
        }

        public Criteria andTodayNotIn(List<Date> values) {
            addCriterionForJDBCDate("today not in", values, "today");
            return (Criteria) this;
        }

        public Criteria andTodayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("today between", value1, value2, "today");
            return (Criteria) this;
        }

        public Criteria andTodayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("today not between", value1, value2, "today");
            return (Criteria) this;
        }

        public Criteria andDigitIsNull() {
            addCriterion("digit is null");
            return (Criteria) this;
        }

        public Criteria andDigitIsNotNull() {
            addCriterion("digit is not null");
            return (Criteria) this;
        }

        public Criteria andDigitEqualTo(Long value) {
            addCriterion("digit =", value, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitNotEqualTo(Long value) {
            addCriterion("digit <>", value, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitGreaterThan(Long value) {
            addCriterion("digit >", value, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitGreaterThanOrEqualTo(Long value) {
            addCriterion("digit >=", value, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitLessThan(Long value) {
            addCriterion("digit <", value, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitLessThanOrEqualTo(Long value) {
            addCriterion("digit <=", value, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitIn(List<Long> values) {
            addCriterion("digit in", values, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitNotIn(List<Long> values) {
            addCriterion("digit not in", values, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitBetween(Long value1, Long value2) {
            addCriterion("digit between", value1, value2, "digit");
            return (Criteria) this;
        }

        public Criteria andDigitNotBetween(Long value1, Long value2) {
            addCriterion("digit not between", value1, value2, "digit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitIsNull() {
            addCriterion("series_digit is null");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitIsNotNull() {
            addCriterion("series_digit is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitEqualTo(Long value) {
            addCriterion("series_digit =", value, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitNotEqualTo(Long value) {
            addCriterion("series_digit <>", value, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitGreaterThan(Long value) {
            addCriterion("series_digit >", value, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitGreaterThanOrEqualTo(Long value) {
            addCriterion("series_digit >=", value, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitLessThan(Long value) {
            addCriterion("series_digit <", value, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitLessThanOrEqualTo(Long value) {
            addCriterion("series_digit <=", value, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitIn(List<Long> values) {
            addCriterion("series_digit in", values, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitNotIn(List<Long> values) {
            addCriterion("series_digit not in", values, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitBetween(Long value1, Long value2) {
            addCriterion("series_digit between", value1, value2, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andSeriesDigitNotBetween(Long value1, Long value2) {
            addCriterion("series_digit not between", value1, value2, "seriesDigit");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskIsNull() {
            addCriterion("is_son_task is null");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskIsNotNull() {
            addCriterion("is_son_task is not null");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskEqualTo(Long value) {
            addCriterion("is_son_task =", value, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskNotEqualTo(Long value) {
            addCriterion("is_son_task <>", value, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskGreaterThan(Long value) {
            addCriterion("is_son_task >", value, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskGreaterThanOrEqualTo(Long value) {
            addCriterion("is_son_task >=", value, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskLessThan(Long value) {
            addCriterion("is_son_task <", value, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskLessThanOrEqualTo(Long value) {
            addCriterion("is_son_task <=", value, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskIn(List<Long> values) {
            addCriterion("is_son_task in", values, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskNotIn(List<Long> values) {
            addCriterion("is_son_task not in", values, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskBetween(Long value1, Long value2) {
            addCriterion("is_son_task between", value1, value2, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andIsSonTaskNotBetween(Long value1, Long value2) {
            addCriterion("is_son_task not between", value1, value2, "isSonTask");
            return (Criteria) this;
        }

        public Criteria andHeadLetterLikeInsensitive(String value) {
            addCriterion("upper(head_letter) like", value.toUpperCase(), "headLetter");
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
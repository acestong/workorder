package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpdcaTaskModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpdcaTaskModelExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andClassTypeIsNull() {
            addCriterion("class_type is null");
            return (Criteria) this;
        }

        public Criteria andClassTypeIsNotNull() {
            addCriterion("class_type is not null");
            return (Criteria) this;
        }

        public Criteria andClassTypeEqualTo(Integer value) {
            addCriterion("class_type =", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotEqualTo(Integer value) {
            addCriterion("class_type <>", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThan(Integer value) {
            addCriterion("class_type >", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_type >=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThan(Integer value) {
            addCriterion("class_type <", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThanOrEqualTo(Integer value) {
            addCriterion("class_type <=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeIn(List<Integer> values) {
            addCriterion("class_type in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotIn(List<Integer> values) {
            addCriterion("class_type not in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeBetween(Integer value1, Integer value2) {
            addCriterion("class_type between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("class_type not between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTimeClassIsNull() {
            addCriterion("time_class is null");
            return (Criteria) this;
        }

        public Criteria andTimeClassIsNotNull() {
            addCriterion("time_class is not null");
            return (Criteria) this;
        }

        public Criteria andTimeClassEqualTo(Integer value) {
            addCriterion("time_class =", value, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassNotEqualTo(Integer value) {
            addCriterion("time_class <>", value, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassGreaterThan(Integer value) {
            addCriterion("time_class >", value, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_class >=", value, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassLessThan(Integer value) {
            addCriterion("time_class <", value, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassLessThanOrEqualTo(Integer value) {
            addCriterion("time_class <=", value, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassIn(List<Integer> values) {
            addCriterion("time_class in", values, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassNotIn(List<Integer> values) {
            addCriterion("time_class not in", values, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassBetween(Integer value1, Integer value2) {
            addCriterion("time_class between", value1, value2, "timeClass");
            return (Criteria) this;
        }

        public Criteria andTimeClassNotBetween(Integer value1, Integer value2) {
            addCriterion("time_class not between", value1, value2, "timeClass");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(Integer value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(Integer value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(Integer value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(Integer value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<Integer> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<Integer> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeIsNull() {
            addCriterion("bus_source_type is null");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeIsNotNull() {
            addCriterion("bus_source_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeEqualTo(Integer value) {
            addCriterion("bus_source_type =", value, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeNotEqualTo(Integer value) {
            addCriterion("bus_source_type <>", value, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeGreaterThan(Integer value) {
            addCriterion("bus_source_type >", value, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bus_source_type >=", value, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeLessThan(Integer value) {
            addCriterion("bus_source_type <", value, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("bus_source_type <=", value, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeIn(List<Integer> values) {
            addCriterion("bus_source_type in", values, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeNotIn(List<Integer> values) {
            addCriterion("bus_source_type not in", values, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("bus_source_type between", value1, value2, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bus_source_type not between", value1, value2, "busSourceType");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdIsNull() {
            addCriterion("bus_source_id is null");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdIsNotNull() {
            addCriterion("bus_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdEqualTo(Long value) {
            addCriterion("bus_source_id =", value, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdNotEqualTo(Long value) {
            addCriterion("bus_source_id <>", value, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdGreaterThan(Long value) {
            addCriterion("bus_source_id >", value, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bus_source_id >=", value, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdLessThan(Long value) {
            addCriterion("bus_source_id <", value, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdLessThanOrEqualTo(Long value) {
            addCriterion("bus_source_id <=", value, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdIn(List<Long> values) {
            addCriterion("bus_source_id in", values, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdNotIn(List<Long> values) {
            addCriterion("bus_source_id not in", values, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdBetween(Long value1, Long value2) {
            addCriterion("bus_source_id between", value1, value2, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceIdNotBetween(Long value1, Long value2) {
            addCriterion("bus_source_id not between", value1, value2, "busSourceId");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameIsNull() {
            addCriterion("bus_source_name is null");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameIsNotNull() {
            addCriterion("bus_source_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameEqualTo(String value) {
            addCriterion("bus_source_name =", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameNotEqualTo(String value) {
            addCriterion("bus_source_name <>", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameGreaterThan(String value) {
            addCriterion("bus_source_name >", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("bus_source_name >=", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameLessThan(String value) {
            addCriterion("bus_source_name <", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameLessThanOrEqualTo(String value) {
            addCriterion("bus_source_name <=", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameLike(String value) {
            addCriterion("bus_source_name like", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameNotLike(String value) {
            addCriterion("bus_source_name not like", value, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameIn(List<String> values) {
            addCriterion("bus_source_name in", values, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameNotIn(List<String> values) {
            addCriterion("bus_source_name not in", values, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameBetween(String value1, String value2) {
            addCriterion("bus_source_name between", value1, value2, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameNotBetween(String value1, String value2) {
            addCriterion("bus_source_name not between", value1, value2, "busSourceName");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIsNull() {
            addCriterion("time_type is null");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIsNotNull() {
            addCriterion("time_type is not null");
            return (Criteria) this;
        }

        public Criteria andTimeTypeEqualTo(Integer value) {
            addCriterion("time_type =", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotEqualTo(Integer value) {
            addCriterion("time_type <>", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeGreaterThan(Integer value) {
            addCriterion("time_type >", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_type >=", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeLessThan(Integer value) {
            addCriterion("time_type <", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("time_type <=", value, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeIn(List<Integer> values) {
            addCriterion("time_type in", values, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotIn(List<Integer> values) {
            addCriterion("time_type not in", values, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeBetween(Integer value1, Integer value2) {
            addCriterion("time_type between", value1, value2, "timeType");
            return (Criteria) this;
        }

        public Criteria andTimeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("time_type not between", value1, value2, "timeType");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(Date value) {
            addCriterion("plan_end_time =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(Date value) {
            addCriterion("plan_end_time <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(Date value) {
            addCriterion("plan_end_time >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_end_time >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(Date value) {
            addCriterion("plan_end_time <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_end_time <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<Date> values) {
            addCriterion("plan_end_time in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<Date> values) {
            addCriterion("plan_end_time not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("plan_end_time between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_end_time not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursIsNull() {
            addCriterion("plan_workhours is null");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursIsNotNull() {
            addCriterion("plan_workhours is not null");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursEqualTo(Double value) {
            addCriterion("plan_workhours =", value, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursNotEqualTo(Double value) {
            addCriterion("plan_workhours <>", value, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursGreaterThan(Double value) {
            addCriterion("plan_workhours >", value, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_workhours >=", value, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursLessThan(Double value) {
            addCriterion("plan_workhours <", value, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursLessThanOrEqualTo(Double value) {
            addCriterion("plan_workhours <=", value, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursIn(List<Double> values) {
            addCriterion("plan_workhours in", values, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursNotIn(List<Double> values) {
            addCriterion("plan_workhours not in", values, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursBetween(Double value1, Double value2) {
            addCriterion("plan_workhours between", value1, value2, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPlanWorkhoursNotBetween(Double value1, Double value2) {
            addCriterion("plan_workhours not between", value1, value2, "planWorkhours");
            return (Criteria) this;
        }

        public Criteria andPriorityIdIsNull() {
            addCriterion("priority_id is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIdIsNotNull() {
            addCriterion("priority_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityIdEqualTo(Long value) {
            addCriterion("priority_id =", value, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdNotEqualTo(Long value) {
            addCriterion("priority_id <>", value, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdGreaterThan(Long value) {
            addCriterion("priority_id >", value, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("priority_id >=", value, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdLessThan(Long value) {
            addCriterion("priority_id <", value, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdLessThanOrEqualTo(Long value) {
            addCriterion("priority_id <=", value, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdIn(List<Long> values) {
            addCriterion("priority_id in", values, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdNotIn(List<Long> values) {
            addCriterion("priority_id not in", values, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdBetween(Long value1, Long value2) {
            addCriterion("priority_id between", value1, value2, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIdNotBetween(Long value1, Long value2) {
            addCriterion("priority_id not between", value1, value2, "priorityId");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHasloanIsNull() {
            addCriterion("hasloan is null");
            return (Criteria) this;
        }

        public Criteria andHasloanIsNotNull() {
            addCriterion("hasloan is not null");
            return (Criteria) this;
        }

        public Criteria andHasloanEqualTo(Integer value) {
            addCriterion("hasloan =", value, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanNotEqualTo(Integer value) {
            addCriterion("hasloan <>", value, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanGreaterThan(Integer value) {
            addCriterion("hasloan >", value, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanGreaterThanOrEqualTo(Integer value) {
            addCriterion("hasloan >=", value, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanLessThan(Integer value) {
            addCriterion("hasloan <", value, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanLessThanOrEqualTo(Integer value) {
            addCriterion("hasloan <=", value, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanIn(List<Integer> values) {
            addCriterion("hasloan in", values, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanNotIn(List<Integer> values) {
            addCriterion("hasloan not in", values, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanBetween(Integer value1, Integer value2) {
            addCriterion("hasloan between", value1, value2, "hasloan");
            return (Criteria) this;
        }

        public Criteria andHasloanNotBetween(Integer value1, Integer value2) {
            addCriterion("hasloan not between", value1, value2, "hasloan");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIsNull() {
            addCriterion("payee_id is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIsNotNull() {
            addCriterion("payee_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeIdEqualTo(Long value) {
            addCriterion("payee_id =", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotEqualTo(Long value) {
            addCriterion("payee_id <>", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdGreaterThan(Long value) {
            addCriterion("payee_id >", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payee_id >=", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLessThan(Long value) {
            addCriterion("payee_id <", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLessThanOrEqualTo(Long value) {
            addCriterion("payee_id <=", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIn(List<Long> values) {
            addCriterion("payee_id in", values, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotIn(List<Long> values) {
            addCriterion("payee_id not in", values, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdBetween(Long value1, Long value2) {
            addCriterion("payee_id between", value1, value2, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotBetween(Long value1, Long value2) {
            addCriterion("payee_id not between", value1, value2, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNull() {
            addCriterion("payee is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNotNull() {
            addCriterion("payee is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeEqualTo(String value) {
            addCriterion("payee =", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotEqualTo(String value) {
            addCriterion("payee <>", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThan(String value) {
            addCriterion("payee >", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("payee >=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThan(String value) {
            addCriterion("payee <", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThanOrEqualTo(String value) {
            addCriterion("payee <=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLike(String value) {
            addCriterion("payee like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotLike(String value) {
            addCriterion("payee not like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeIn(List<String> values) {
            addCriterion("payee in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotIn(List<String> values) {
            addCriterion("payee not in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeBetween(String value1, String value2) {
            addCriterion("payee between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotBetween(String value1, String value2) {
            addCriterion("payee not between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andLoantypeidIsNull() {
            addCriterion("loantypeid is null");
            return (Criteria) this;
        }

        public Criteria andLoantypeidIsNotNull() {
            addCriterion("loantypeid is not null");
            return (Criteria) this;
        }

        public Criteria andLoantypeidEqualTo(Long value) {
            addCriterion("loantypeid =", value, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidNotEqualTo(Long value) {
            addCriterion("loantypeid <>", value, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidGreaterThan(Long value) {
            addCriterion("loantypeid >", value, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("loantypeid >=", value, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidLessThan(Long value) {
            addCriterion("loantypeid <", value, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidLessThanOrEqualTo(Long value) {
            addCriterion("loantypeid <=", value, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidIn(List<Long> values) {
            addCriterion("loantypeid in", values, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidNotIn(List<Long> values) {
            addCriterion("loantypeid not in", values, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidBetween(Long value1, Long value2) {
            addCriterion("loantypeid between", value1, value2, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypeidNotBetween(Long value1, Long value2) {
            addCriterion("loantypeid not between", value1, value2, "loantypeid");
            return (Criteria) this;
        }

        public Criteria andLoantypenameIsNull() {
            addCriterion("loantypename is null");
            return (Criteria) this;
        }

        public Criteria andLoantypenameIsNotNull() {
            addCriterion("loantypename is not null");
            return (Criteria) this;
        }

        public Criteria andLoantypenameEqualTo(String value) {
            addCriterion("loantypename =", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameNotEqualTo(String value) {
            addCriterion("loantypename <>", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameGreaterThan(String value) {
            addCriterion("loantypename >", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameGreaterThanOrEqualTo(String value) {
            addCriterion("loantypename >=", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameLessThan(String value) {
            addCriterion("loantypename <", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameLessThanOrEqualTo(String value) {
            addCriterion("loantypename <=", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameLike(String value) {
            addCriterion("loantypename like", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameNotLike(String value) {
            addCriterion("loantypename not like", value, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameIn(List<String> values) {
            addCriterion("loantypename in", values, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameNotIn(List<String> values) {
            addCriterion("loantypename not in", values, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameBetween(String value1, String value2) {
            addCriterion("loantypename between", value1, value2, "loantypename");
            return (Criteria) this;
        }

        public Criteria andLoantypenameNotBetween(String value1, String value2) {
            addCriterion("loantypename not between", value1, value2, "loantypename");
            return (Criteria) this;
        }

        public Criteria andVisitTypeIsNull() {
            addCriterion("visit_type is null");
            return (Criteria) this;
        }

        public Criteria andVisitTypeIsNotNull() {
            addCriterion("visit_type is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTypeEqualTo(Integer value) {
            addCriterion("visit_type =", value, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeNotEqualTo(Integer value) {
            addCriterion("visit_type <>", value, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeGreaterThan(Integer value) {
            addCriterion("visit_type >", value, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_type >=", value, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeLessThan(Integer value) {
            addCriterion("visit_type <", value, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeLessThanOrEqualTo(Integer value) {
            addCriterion("visit_type <=", value, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeIn(List<Integer> values) {
            addCriterion("visit_type in", values, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeNotIn(List<Integer> values) {
            addCriterion("visit_type not in", values, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeBetween(Integer value1, Integer value2) {
            addCriterion("visit_type between", value1, value2, "visitType");
            return (Criteria) this;
        }

        public Criteria andVisitTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_type not between", value1, value2, "visitType");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Long> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Long> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Integer> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Integer> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryIsNull() {
            addCriterion("task_category is null");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryIsNotNull() {
            addCriterion("task_category is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryEqualTo(Integer value) {
            addCriterion("task_category =", value, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryNotEqualTo(Integer value) {
            addCriterion("task_category <>", value, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryGreaterThan(Integer value) {
            addCriterion("task_category >", value, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_category >=", value, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryLessThan(Integer value) {
            addCriterion("task_category <", value, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("task_category <=", value, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryIn(List<Integer> values) {
            addCriterion("task_category in", values, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryNotIn(List<Integer> values) {
            addCriterion("task_category not in", values, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryBetween(Integer value1, Integer value2) {
            addCriterion("task_category between", value1, value2, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andTaskCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("task_category not between", value1, value2, "taskCategory");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeIsNull() {
            addCriterion("journey_type is null");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeIsNotNull() {
            addCriterion("journey_type is not null");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeEqualTo(Integer value) {
            addCriterion("journey_type =", value, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeNotEqualTo(Integer value) {
            addCriterion("journey_type <>", value, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeGreaterThan(Integer value) {
            addCriterion("journey_type >", value, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("journey_type >=", value, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeLessThan(Integer value) {
            addCriterion("journey_type <", value, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("journey_type <=", value, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeIn(List<Integer> values) {
            addCriterion("journey_type in", values, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeNotIn(List<Integer> values) {
            addCriterion("journey_type not in", values, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeBetween(Integer value1, Integer value2) {
            addCriterion("journey_type between", value1, value2, "journeyType");
            return (Criteria) this;
        }

        public Criteria andJourneyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("journey_type not between", value1, value2, "journeyType");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("lock_status is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Integer value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Integer value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Integer value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Integer value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Integer> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Integer> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Integer value1, Integer value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Long value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Long value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Long value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Long value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Long> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Long> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Long value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Long value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Long value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Long value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Long value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Long> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Long> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Long value1, Long value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Long value1, Long value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdIsNull() {
            addCriterion("applicationfee_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdIsNotNull() {
            addCriterion("applicationfee_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdEqualTo(Long value) {
            addCriterion("applicationfee_id =", value, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdNotEqualTo(Long value) {
            addCriterion("applicationfee_id <>", value, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdGreaterThan(Long value) {
            addCriterion("applicationfee_id >", value, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("applicationfee_id >=", value, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdLessThan(Long value) {
            addCriterion("applicationfee_id <", value, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdLessThanOrEqualTo(Long value) {
            addCriterion("applicationfee_id <=", value, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdIn(List<Long> values) {
            addCriterion("applicationfee_id in", values, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdNotIn(List<Long> values) {
            addCriterion("applicationfee_id not in", values, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdBetween(Long value1, Long value2) {
            addCriterion("applicationfee_id between", value1, value2, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andApplicationfeeIdNotBetween(Long value1, Long value2) {
            addCriterion("applicationfee_id not between", value1, value2, "applicationfeeId");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Double value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Double value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Double value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Double value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Double value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Double> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Double> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Double value1, Double value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Double value1, Double value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyIsNull() {
            addCriterion("final_money is null");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyIsNotNull() {
            addCriterion("final_money is not null");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyEqualTo(Double value) {
            addCriterion("final_money =", value, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyNotEqualTo(Double value) {
            addCriterion("final_money <>", value, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyGreaterThan(Double value) {
            addCriterion("final_money >", value, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("final_money >=", value, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyLessThan(Double value) {
            addCriterion("final_money <", value, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyLessThanOrEqualTo(Double value) {
            addCriterion("final_money <=", value, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyIn(List<Double> values) {
            addCriterion("final_money in", values, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyNotIn(List<Double> values) {
            addCriterion("final_money not in", values, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyBetween(Double value1, Double value2) {
            addCriterion("final_money between", value1, value2, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andFinalMoneyNotBetween(Double value1, Double value2) {
            addCriterion("final_money not between", value1, value2, "finalMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIsNull() {
            addCriterion("currency_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIsNotNull() {
            addCriterion("currency_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdEqualTo(Long value) {
            addCriterion("currency_id =", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotEqualTo(Long value) {
            addCriterion("currency_id <>", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdGreaterThan(Long value) {
            addCriterion("currency_id >", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("currency_id >=", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdLessThan(Long value) {
            addCriterion("currency_id <", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdLessThanOrEqualTo(Long value) {
            addCriterion("currency_id <=", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIn(List<Long> values) {
            addCriterion("currency_id in", values, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotIn(List<Long> values) {
            addCriterion("currency_id not in", values, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdBetween(Long value1, Long value2) {
            addCriterion("currency_id between", value1, value2, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotBetween(Long value1, Long value2) {
            addCriterion("currency_id not between", value1, value2, "currencyId");
            return (Criteria) this;
        }

        public Criteria andDelStateIsNull() {
            addCriterion("del_state is null");
            return (Criteria) this;
        }

        public Criteria andDelStateIsNotNull() {
            addCriterion("del_state is not null");
            return (Criteria) this;
        }

        public Criteria andDelStateEqualTo(Integer value) {
            addCriterion("del_state =", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotEqualTo(Integer value) {
            addCriterion("del_state <>", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateGreaterThan(Integer value) {
            addCriterion("del_state >", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_state >=", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateLessThan(Integer value) {
            addCriterion("del_state <", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateLessThanOrEqualTo(Integer value) {
            addCriterion("del_state <=", value, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateIn(List<Integer> values) {
            addCriterion("del_state in", values, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotIn(List<Integer> values) {
            addCriterion("del_state not in", values, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateBetween(Integer value1, Integer value2) {
            addCriterion("del_state between", value1, value2, "delState");
            return (Criteria) this;
        }

        public Criteria andDelStateNotBetween(Integer value1, Integer value2) {
            addCriterion("del_state not between", value1, value2, "delState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIsNull() {
            addCriterion("execution_state is null");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIsNotNull() {
            addCriterion("execution_state is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionStateEqualTo(Integer value) {
            addCriterion("execution_state =", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotEqualTo(Integer value) {
            addCriterion("execution_state <>", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateGreaterThan(Integer value) {
            addCriterion("execution_state >", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("execution_state >=", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateLessThan(Integer value) {
            addCriterion("execution_state <", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateLessThanOrEqualTo(Integer value) {
            addCriterion("execution_state <=", value, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateIn(List<Integer> values) {
            addCriterion("execution_state in", values, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotIn(List<Integer> values) {
            addCriterion("execution_state not in", values, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateBetween(Integer value1, Integer value2) {
            addCriterion("execution_state between", value1, value2, "executionState");
            return (Criteria) this;
        }

        public Criteria andExecutionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("execution_state not between", value1, value2, "executionState");
            return (Criteria) this;
        }

        public Criteria andWorkHoursIsNull() {
            addCriterion("work_hours is null");
            return (Criteria) this;
        }

        public Criteria andWorkHoursIsNotNull() {
            addCriterion("work_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWorkHoursEqualTo(Double value) {
            addCriterion("work_hours =", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursNotEqualTo(Double value) {
            addCriterion("work_hours <>", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursGreaterThan(Double value) {
            addCriterion("work_hours >", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursGreaterThanOrEqualTo(Double value) {
            addCriterion("work_hours >=", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursLessThan(Double value) {
            addCriterion("work_hours <", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursLessThanOrEqualTo(Double value) {
            addCriterion("work_hours <=", value, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursIn(List<Double> values) {
            addCriterion("work_hours in", values, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursNotIn(List<Double> values) {
            addCriterion("work_hours not in", values, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursBetween(Double value1, Double value2) {
            addCriterion("work_hours between", value1, value2, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkHoursNotBetween(Double value1, Double value2) {
            addCriterion("work_hours not between", value1, value2, "workHours");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedIsNull() {
            addCriterion("work_speed is null");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedIsNotNull() {
            addCriterion("work_speed is not null");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedEqualTo(Double value) {
            addCriterion("work_speed =", value, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedNotEqualTo(Double value) {
            addCriterion("work_speed <>", value, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedGreaterThan(Double value) {
            addCriterion("work_speed >", value, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedGreaterThanOrEqualTo(Double value) {
            addCriterion("work_speed >=", value, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedLessThan(Double value) {
            addCriterion("work_speed <", value, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedLessThanOrEqualTo(Double value) {
            addCriterion("work_speed <=", value, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedIn(List<Double> values) {
            addCriterion("work_speed in", values, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedNotIn(List<Double> values) {
            addCriterion("work_speed not in", values, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedBetween(Double value1, Double value2) {
            addCriterion("work_speed between", value1, value2, "workSpeed");
            return (Criteria) this;
        }

        public Criteria andWorkSpeedNotBetween(Double value1, Double value2) {
            addCriterion("work_speed not between", value1, value2, "workSpeed");
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

        public Criteria andResponseStatusIsNull() {
            addCriterion("response_status is null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNotNull() {
            addCriterion("response_status is not null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusEqualTo(Integer value) {
            addCriterion("response_status =", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotEqualTo(Integer value) {
            addCriterion("response_status <>", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThan(Integer value) {
            addCriterion("response_status >", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("response_status >=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThan(Integer value) {
            addCriterion("response_status <", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("response_status <=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIn(List<Integer> values) {
            addCriterion("response_status in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotIn(List<Integer> values) {
            addCriterion("response_status not in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusBetween(Integer value1, Integer value2) {
            addCriterion("response_status between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("response_status not between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNull() {
            addCriterion("response_time is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNotNull() {
            addCriterion("response_time is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeEqualTo(Date value) {
            addCriterion("response_time =", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotEqualTo(Date value) {
            addCriterion("response_time <>", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThan(Date value) {
            addCriterion("response_time >", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("response_time >=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThan(Date value) {
            addCriterion("response_time <", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("response_time <=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIn(List<Date> values) {
            addCriterion("response_time in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotIn(List<Date> values) {
            addCriterion("response_time not in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeBetween(Date value1, Date value2) {
            addCriterion("response_time between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("response_time not between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdIsNull() {
            addCriterion("task_assign_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdIsNotNull() {
            addCriterion("task_assign_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdEqualTo(Long value) {
            addCriterion("task_assign_id =", value, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdNotEqualTo(Long value) {
            addCriterion("task_assign_id <>", value, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdGreaterThan(Long value) {
            addCriterion("task_assign_id >", value, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_assign_id >=", value, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdLessThan(Long value) {
            addCriterion("task_assign_id <", value, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdLessThanOrEqualTo(Long value) {
            addCriterion("task_assign_id <=", value, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdIn(List<Long> values) {
            addCriterion("task_assign_id in", values, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdNotIn(List<Long> values) {
            addCriterion("task_assign_id not in", values, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdBetween(Long value1, Long value2) {
            addCriterion("task_assign_id between", value1, value2, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andTaskAssignIdNotBetween(Long value1, Long value2) {
            addCriterion("task_assign_id not between", value1, value2, "taskAssignId");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNull() {
            addCriterion("reg_id is null");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNotNull() {
            addCriterion("reg_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegIdEqualTo(Long value) {
            addCriterion("reg_id =", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotEqualTo(Long value) {
            addCriterion("reg_id <>", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThan(Long value) {
            addCriterion("reg_id >", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reg_id >=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThan(Long value) {
            addCriterion("reg_id <", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThanOrEqualTo(Long value) {
            addCriterion("reg_id <=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdIn(List<Long> values) {
            addCriterion("reg_id in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotIn(List<Long> values) {
            addCriterion("reg_id not in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdBetween(Long value1, Long value2) {
            addCriterion("reg_id between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotBetween(Long value1, Long value2) {
            addCriterion("reg_id not between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTravelCodeIsNull() {
            addCriterion("travel_code is null");
            return (Criteria) this;
        }

        public Criteria andTravelCodeIsNotNull() {
            addCriterion("travel_code is not null");
            return (Criteria) this;
        }

        public Criteria andTravelCodeEqualTo(String value) {
            addCriterion("travel_code =", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeNotEqualTo(String value) {
            addCriterion("travel_code <>", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeGreaterThan(String value) {
            addCriterion("travel_code >", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("travel_code >=", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeLessThan(String value) {
            addCriterion("travel_code <", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeLessThanOrEqualTo(String value) {
            addCriterion("travel_code <=", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeLike(String value) {
            addCriterion("travel_code like", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeNotLike(String value) {
            addCriterion("travel_code not like", value, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeIn(List<String> values) {
            addCriterion("travel_code in", values, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeNotIn(List<String> values) {
            addCriterion("travel_code not in", values, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeBetween(String value1, String value2) {
            addCriterion("travel_code between", value1, value2, "travelCode");
            return (Criteria) this;
        }

        public Criteria andTravelCodeNotBetween(String value1, String value2) {
            addCriterion("travel_code not between", value1, value2, "travelCode");
            return (Criteria) this;
        }

        public Criteria andDelayNumIsNull() {
            addCriterion("delay_num is null");
            return (Criteria) this;
        }

        public Criteria andDelayNumIsNotNull() {
            addCriterion("delay_num is not null");
            return (Criteria) this;
        }

        public Criteria andDelayNumEqualTo(Integer value) {
            addCriterion("delay_num =", value, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumNotEqualTo(Integer value) {
            addCriterion("delay_num <>", value, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumGreaterThan(Integer value) {
            addCriterion("delay_num >", value, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("delay_num >=", value, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumLessThan(Integer value) {
            addCriterion("delay_num <", value, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumLessThanOrEqualTo(Integer value) {
            addCriterion("delay_num <=", value, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumIn(List<Integer> values) {
            addCriterion("delay_num in", values, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumNotIn(List<Integer> values) {
            addCriterion("delay_num not in", values, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumBetween(Integer value1, Integer value2) {
            addCriterion("delay_num between", value1, value2, "delayNum");
            return (Criteria) this;
        }

        public Criteria andDelayNumNotBetween(Integer value1, Integer value2) {
            addCriterion("delay_num not between", value1, value2, "delayNum");
            return (Criteria) this;
        }

        public Criteria andSignStateIsNull() {
            addCriterion("sign_state is null");
            return (Criteria) this;
        }

        public Criteria andSignStateIsNotNull() {
            addCriterion("sign_state is not null");
            return (Criteria) this;
        }

        public Criteria andSignStateEqualTo(Integer value) {
            addCriterion("sign_state =", value, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateNotEqualTo(Integer value) {
            addCriterion("sign_state <>", value, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateGreaterThan(Integer value) {
            addCriterion("sign_state >", value, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_state >=", value, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateLessThan(Integer value) {
            addCriterion("sign_state <", value, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateLessThanOrEqualTo(Integer value) {
            addCriterion("sign_state <=", value, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateIn(List<Integer> values) {
            addCriterion("sign_state in", values, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateNotIn(List<Integer> values) {
            addCriterion("sign_state not in", values, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateBetween(Integer value1, Integer value2) {
            addCriterion("sign_state between", value1, value2, "signState");
            return (Criteria) this;
        }

        public Criteria andSignStateNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_state not between", value1, value2, "signState");
            return (Criteria) this;
        }

        public Criteria andIsStartIsNull() {
            addCriterion("is_start is null");
            return (Criteria) this;
        }

        public Criteria andIsStartIsNotNull() {
            addCriterion("is_start is not null");
            return (Criteria) this;
        }

        public Criteria andIsStartEqualTo(Integer value) {
            addCriterion("is_start =", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartNotEqualTo(Integer value) {
            addCriterion("is_start <>", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartGreaterThan(Integer value) {
            addCriterion("is_start >", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_start >=", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartLessThan(Integer value) {
            addCriterion("is_start <", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartLessThanOrEqualTo(Integer value) {
            addCriterion("is_start <=", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartIn(List<Integer> values) {
            addCriterion("is_start in", values, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartNotIn(List<Integer> values) {
            addCriterion("is_start not in", values, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartBetween(Integer value1, Integer value2) {
            addCriterion("is_start between", value1, value2, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartNotBetween(Integer value1, Integer value2) {
            addCriterion("is_start not between", value1, value2, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsSignInIsNull() {
            addCriterion("is_sign_in is null");
            return (Criteria) this;
        }

        public Criteria andIsSignInIsNotNull() {
            addCriterion("is_sign_in is not null");
            return (Criteria) this;
        }

        public Criteria andIsSignInEqualTo(Integer value) {
            addCriterion("is_sign_in =", value, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInNotEqualTo(Integer value) {
            addCriterion("is_sign_in <>", value, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInGreaterThan(Integer value) {
            addCriterion("is_sign_in >", value, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sign_in >=", value, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInLessThan(Integer value) {
            addCriterion("is_sign_in <", value, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInLessThanOrEqualTo(Integer value) {
            addCriterion("is_sign_in <=", value, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInIn(List<Integer> values) {
            addCriterion("is_sign_in in", values, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInNotIn(List<Integer> values) {
            addCriterion("is_sign_in not in", values, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInBetween(Integer value1, Integer value2) {
            addCriterion("is_sign_in between", value1, value2, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignInNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sign_in not between", value1, value2, "isSignIn");
            return (Criteria) this;
        }

        public Criteria andIsSignOutIsNull() {
            addCriterion("is_sign_out is null");
            return (Criteria) this;
        }

        public Criteria andIsSignOutIsNotNull() {
            addCriterion("is_sign_out is not null");
            return (Criteria) this;
        }

        public Criteria andIsSignOutEqualTo(Integer value) {
            addCriterion("is_sign_out =", value, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutNotEqualTo(Integer value) {
            addCriterion("is_sign_out <>", value, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutGreaterThan(Integer value) {
            addCriterion("is_sign_out >", value, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sign_out >=", value, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutLessThan(Integer value) {
            addCriterion("is_sign_out <", value, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutLessThanOrEqualTo(Integer value) {
            addCriterion("is_sign_out <=", value, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutIn(List<Integer> values) {
            addCriterion("is_sign_out in", values, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutNotIn(List<Integer> values) {
            addCriterion("is_sign_out not in", values, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutBetween(Integer value1, Integer value2) {
            addCriterion("is_sign_out between", value1, value2, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andIsSignOutNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sign_out not between", value1, value2, "isSignOut");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateIsNull() {
            addCriterion("difficulty_rate is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateIsNotNull() {
            addCriterion("difficulty_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateEqualTo(Double value) {
            addCriterion("difficulty_rate =", value, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateNotEqualTo(Double value) {
            addCriterion("difficulty_rate <>", value, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateGreaterThan(Double value) {
            addCriterion("difficulty_rate >", value, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateGreaterThanOrEqualTo(Double value) {
            addCriterion("difficulty_rate >=", value, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateLessThan(Double value) {
            addCriterion("difficulty_rate <", value, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateLessThanOrEqualTo(Double value) {
            addCriterion("difficulty_rate <=", value, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateIn(List<Double> values) {
            addCriterion("difficulty_rate in", values, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateNotIn(List<Double> values) {
            addCriterion("difficulty_rate not in", values, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateBetween(Double value1, Double value2) {
            addCriterion("difficulty_rate between", value1, value2, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andDifficultyRateNotBetween(Double value1, Double value2) {
            addCriterion("difficulty_rate not between", value1, value2, "difficultyRate");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursIsNull() {
            addCriterion("out_work_hours is null");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursIsNotNull() {
            addCriterion("out_work_hours is not null");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursEqualTo(Double value) {
            addCriterion("out_work_hours =", value, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursNotEqualTo(Double value) {
            addCriterion("out_work_hours <>", value, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursGreaterThan(Double value) {
            addCriterion("out_work_hours >", value, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursGreaterThanOrEqualTo(Double value) {
            addCriterion("out_work_hours >=", value, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursLessThan(Double value) {
            addCriterion("out_work_hours <", value, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursLessThanOrEqualTo(Double value) {
            addCriterion("out_work_hours <=", value, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursIn(List<Double> values) {
            addCriterion("out_work_hours in", values, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursNotIn(List<Double> values) {
            addCriterion("out_work_hours not in", values, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursBetween(Double value1, Double value2) {
            addCriterion("out_work_hours between", value1, value2, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andOutWorkHoursNotBetween(Double value1, Double value2) {
            addCriterion("out_work_hours not between", value1, value2, "outWorkHours");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdIsNull() {
            addCriterion("remind_time_id is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdIsNotNull() {
            addCriterion("remind_time_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdEqualTo(Long value) {
            addCriterion("remind_time_id =", value, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdNotEqualTo(Long value) {
            addCriterion("remind_time_id <>", value, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdGreaterThan(Long value) {
            addCriterion("remind_time_id >", value, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("remind_time_id >=", value, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdLessThan(Long value) {
            addCriterion("remind_time_id <", value, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdLessThanOrEqualTo(Long value) {
            addCriterion("remind_time_id <=", value, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdIn(List<Long> values) {
            addCriterion("remind_time_id in", values, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdNotIn(List<Long> values) {
            addCriterion("remind_time_id not in", values, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdBetween(Long value1, Long value2) {
            addCriterion("remind_time_id between", value1, value2, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIdNotBetween(Long value1, Long value2) {
            addCriterion("remind_time_id not between", value1, value2, "remindTimeId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdIsNull() {
            addCriterion("relation_routine_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdIsNotNull() {
            addCriterion("relation_routine_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdEqualTo(Long value) {
            addCriterion("relation_routine_id =", value, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdNotEqualTo(Long value) {
            addCriterion("relation_routine_id <>", value, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdGreaterThan(Long value) {
            addCriterion("relation_routine_id >", value, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_routine_id >=", value, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdLessThan(Long value) {
            addCriterion("relation_routine_id <", value, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_routine_id <=", value, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdIn(List<Long> values) {
            addCriterion("relation_routine_id in", values, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdNotIn(List<Long> values) {
            addCriterion("relation_routine_id not in", values, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdBetween(Long value1, Long value2) {
            addCriterion("relation_routine_id between", value1, value2, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_routine_id not between", value1, value2, "relationRoutineId");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeIsNull() {
            addCriterion("relation_routine_type is null");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeIsNotNull() {
            addCriterion("relation_routine_type is not null");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeEqualTo(Byte value) {
            addCriterion("relation_routine_type =", value, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeNotEqualTo(Byte value) {
            addCriterion("relation_routine_type <>", value, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeGreaterThan(Byte value) {
            addCriterion("relation_routine_type >", value, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("relation_routine_type >=", value, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeLessThan(Byte value) {
            addCriterion("relation_routine_type <", value, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeLessThanOrEqualTo(Byte value) {
            addCriterion("relation_routine_type <=", value, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeIn(List<Byte> values) {
            addCriterion("relation_routine_type in", values, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeNotIn(List<Byte> values) {
            addCriterion("relation_routine_type not in", values, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeBetween(Byte value1, Byte value2) {
            addCriterion("relation_routine_type between", value1, value2, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("relation_routine_type not between", value1, value2, "relationRoutineType");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameIsNull() {
            addCriterion("relation_routine_name is null");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameIsNotNull() {
            addCriterion("relation_routine_name is not null");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameEqualTo(String value) {
            addCriterion("relation_routine_name =", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameNotEqualTo(String value) {
            addCriterion("relation_routine_name <>", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameGreaterThan(String value) {
            addCriterion("relation_routine_name >", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameGreaterThanOrEqualTo(String value) {
            addCriterion("relation_routine_name >=", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameLessThan(String value) {
            addCriterion("relation_routine_name <", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameLessThanOrEqualTo(String value) {
            addCriterion("relation_routine_name <=", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameLike(String value) {
            addCriterion("relation_routine_name like", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameNotLike(String value) {
            addCriterion("relation_routine_name not like", value, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameIn(List<String> values) {
            addCriterion("relation_routine_name in", values, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameNotIn(List<String> values) {
            addCriterion("relation_routine_name not in", values, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameBetween(String value1, String value2) {
            addCriterion("relation_routine_name between", value1, value2, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameNotBetween(String value1, String value2) {
            addCriterion("relation_routine_name not between", value1, value2, "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(Byte value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Byte value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Byte value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Byte value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Byte value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Byte> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Byte> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Byte value1, Byte value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Long value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Long value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Long value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Long value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Long value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Long> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Long> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Long value1, Long value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Long value1, Long value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNull() {
            addCriterion("business_name is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNotNull() {
            addCriterion("business_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameEqualTo(String value) {
            addCriterion("business_name =", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotEqualTo(String value) {
            addCriterion("business_name <>", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThan(String value) {
            addCriterion("business_name >", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("business_name >=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThan(String value) {
            addCriterion("business_name <", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("business_name <=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLike(String value) {
            addCriterion("business_name like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotLike(String value) {
            addCriterion("business_name not like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIn(List<String> values) {
            addCriterion("business_name in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotIn(List<String> values) {
            addCriterion("business_name not in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameBetween(String value1, String value2) {
            addCriterion("business_name between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotBetween(String value1, String value2) {
            addCriterion("business_name not between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdIsNull() {
            addCriterion("new_task_id is null");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdIsNotNull() {
            addCriterion("new_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdEqualTo(Long value) {
            addCriterion("new_task_id =", value, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdNotEqualTo(Long value) {
            addCriterion("new_task_id <>", value, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdGreaterThan(Long value) {
            addCriterion("new_task_id >", value, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("new_task_id >=", value, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdLessThan(Long value) {
            addCriterion("new_task_id <", value, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("new_task_id <=", value, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdIn(List<Long> values) {
            addCriterion("new_task_id in", values, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdNotIn(List<Long> values) {
            addCriterion("new_task_id not in", values, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdBetween(Long value1, Long value2) {
            addCriterion("new_task_id between", value1, value2, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andNewTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("new_task_id not between", value1, value2, "newTaskId");
            return (Criteria) this;
        }

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andBusSourceNameLikeInsensitive(String value) {
            addCriterion("upper(bus_source_name) like", value.toUpperCase(), "busSourceName");
            return (Criteria) this;
        }

        public Criteria andPriorityLikeInsensitive(String value) {
            addCriterion("upper(priority) like", value.toUpperCase(), "priority");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andPayeeLikeInsensitive(String value) {
            addCriterion("upper(payee) like", value.toUpperCase(), "payee");
            return (Criteria) this;
        }

        public Criteria andLoantypenameLikeInsensitive(String value) {
            addCriterion("upper(loantypename) like", value.toUpperCase(), "loantypename");
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeInsensitive(String value) {
            addCriterion("upper(create_user) like", value.toUpperCase(), "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLikeInsensitive(String value) {
            addCriterion("upper(update_user) like", value.toUpperCase(), "updateUser");
            return (Criteria) this;
        }

        public Criteria andOwnerLikeInsensitive(String value) {
            addCriterion("upper(owner) like", value.toUpperCase(), "owner");
            return (Criteria) this;
        }

        public Criteria andTravelCodeLikeInsensitive(String value) {
            addCriterion("upper(travel_code) like", value.toUpperCase(), "travelCode");
            return (Criteria) this;
        }

        public Criteria andRelationRoutineNameLikeInsensitive(String value) {
            addCriterion("upper(relation_routine_name) like", value.toUpperCase(), "relationRoutineName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLikeInsensitive(String value) {
            addCriterion("upper(business_name) like", value.toUpperCase(), "businessName");
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
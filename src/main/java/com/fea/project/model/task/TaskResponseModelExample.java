package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskResponseModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskResponseModelExample() {
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

        public Criteria andTaskResponseIdIsNull() {
            addCriterion("task_response_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdIsNotNull() {
            addCriterion("task_response_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdEqualTo(Long value) {
            addCriterion("task_response_id =", value, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdNotEqualTo(Long value) {
            addCriterion("task_response_id <>", value, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdGreaterThan(Long value) {
            addCriterion("task_response_id >", value, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_response_id >=", value, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdLessThan(Long value) {
            addCriterion("task_response_id <", value, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdLessThanOrEqualTo(Long value) {
            addCriterion("task_response_id <=", value, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdIn(List<Long> values) {
            addCriterion("task_response_id in", values, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdNotIn(List<Long> values) {
            addCriterion("task_response_id not in", values, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdBetween(Long value1, Long value2) {
            addCriterion("task_response_id between", value1, value2, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseIdNotBetween(Long value1, Long value2) {
            addCriterion("task_response_id not between", value1, value2, "taskResponseId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodIsNull() {
            addCriterion("task_response_method is null");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodIsNotNull() {
            addCriterion("task_response_method is not null");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodEqualTo(Long value) {
            addCriterion("task_response_method =", value, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodNotEqualTo(Long value) {
            addCriterion("task_response_method <>", value, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodGreaterThan(Long value) {
            addCriterion("task_response_method >", value, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodGreaterThanOrEqualTo(Long value) {
            addCriterion("task_response_method >=", value, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodLessThan(Long value) {
            addCriterion("task_response_method <", value, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodLessThanOrEqualTo(Long value) {
            addCriterion("task_response_method <=", value, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodIn(List<Long> values) {
            addCriterion("task_response_method in", values, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodNotIn(List<Long> values) {
            addCriterion("task_response_method not in", values, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodBetween(Long value1, Long value2) {
            addCriterion("task_response_method between", value1, value2, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskResponseMethodNotBetween(Long value1, Long value2) {
            addCriterion("task_response_method not between", value1, value2, "taskResponseMethod");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIsNull() {
            addCriterion("task_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIsNotNull() {
            addCriterion("task_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeEqualTo(Date value) {
            addCriterion("task_start_time =", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotEqualTo(Date value) {
            addCriterion("task_start_time <>", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThan(Date value) {
            addCriterion("task_start_time >", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_start_time >=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThan(Date value) {
            addCriterion("task_start_time <", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_start_time <=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIn(List<Date> values) {
            addCriterion("task_start_time in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotIn(List<Date> values) {
            addCriterion("task_start_time not in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeBetween(Date value1, Date value2) {
            addCriterion("task_start_time between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_start_time not between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIsNull() {
            addCriterion("task_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIsNotNull() {
            addCriterion("task_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeEqualTo(Date value) {
            addCriterion("task_end_time =", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotEqualTo(Date value) {
            addCriterion("task_end_time <>", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThan(Date value) {
            addCriterion("task_end_time >", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_end_time >=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThan(Date value) {
            addCriterion("task_end_time <", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_end_time <=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIn(List<Date> values) {
            addCriterion("task_end_time in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotIn(List<Date> values) {
            addCriterion("task_end_time not in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeBetween(Date value1, Date value2) {
            addCriterion("task_end_time between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_end_time not between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskDurationIsNull() {
            addCriterion("task_duration is null");
            return (Criteria) this;
        }

        public Criteria andTaskDurationIsNotNull() {
            addCriterion("task_duration is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDurationEqualTo(Long value) {
            addCriterion("task_duration =", value, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationNotEqualTo(Long value) {
            addCriterion("task_duration <>", value, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationGreaterThan(Long value) {
            addCriterion("task_duration >", value, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("task_duration >=", value, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationLessThan(Long value) {
            addCriterion("task_duration <", value, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationLessThanOrEqualTo(Long value) {
            addCriterion("task_duration <=", value, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationIn(List<Long> values) {
            addCriterion("task_duration in", values, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationNotIn(List<Long> values) {
            addCriterion("task_duration not in", values, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationBetween(Long value1, Long value2) {
            addCriterion("task_duration between", value1, value2, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDurationNotBetween(Long value1, Long value2) {
            addCriterion("task_duration not between", value1, value2, "taskDuration");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIsNull() {
            addCriterion("task_deadline is null");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIsNotNull() {
            addCriterion("task_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineEqualTo(Date value) {
            addCriterion("task_deadline =", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotEqualTo(Date value) {
            addCriterion("task_deadline <>", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineGreaterThan(Date value) {
            addCriterion("task_deadline >", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("task_deadline >=", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineLessThan(Date value) {
            addCriterion("task_deadline <", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("task_deadline <=", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIn(List<Date> values) {
            addCriterion("task_deadline in", values, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotIn(List<Date> values) {
            addCriterion("task_deadline not in", values, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineBetween(Date value1, Date value2) {
            addCriterion("task_deadline between", value1, value2, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("task_deadline not between", value1, value2, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescIsNull() {
            addCriterion("task_response_desc is null");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescIsNotNull() {
            addCriterion("task_response_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescEqualTo(String value) {
            addCriterion("task_response_desc =", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescNotEqualTo(String value) {
            addCriterion("task_response_desc <>", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescGreaterThan(String value) {
            addCriterion("task_response_desc >", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescGreaterThanOrEqualTo(String value) {
            addCriterion("task_response_desc >=", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescLessThan(String value) {
            addCriterion("task_response_desc <", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescLessThanOrEqualTo(String value) {
            addCriterion("task_response_desc <=", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescLike(String value) {
            addCriterion("task_response_desc like", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescNotLike(String value) {
            addCriterion("task_response_desc not like", value, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescIn(List<String> values) {
            addCriterion("task_response_desc in", values, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescNotIn(List<String> values) {
            addCriterion("task_response_desc not in", values, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescBetween(String value1, String value2) {
            addCriterion("task_response_desc between", value1, value2, "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescNotBetween(String value1, String value2) {
            addCriterion("task_response_desc not between", value1, value2, "taskResponseDesc");
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

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Long value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Long value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Long value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Long value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Long value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Long> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Long> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Long value1, Long value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Long value1, Long value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
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

        public Criteria andDelStatusIsNull() {
            addCriterion("del_status is null");
            return (Criteria) this;
        }

        public Criteria andDelStatusIsNotNull() {
            addCriterion("del_status is not null");
            return (Criteria) this;
        }

        public Criteria andDelStatusEqualTo(Long value) {
            addCriterion("del_status =", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotEqualTo(Long value) {
            addCriterion("del_status <>", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThan(Long value) {
            addCriterion("del_status >", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("del_status >=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThan(Long value) {
            addCriterion("del_status <", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusLessThanOrEqualTo(Long value) {
            addCriterion("del_status <=", value, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusIn(List<Long> values) {
            addCriterion("del_status in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotIn(List<Long> values) {
            addCriterion("del_status not in", values, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusBetween(Long value1, Long value2) {
            addCriterion("del_status between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andDelStatusNotBetween(Long value1, Long value2) {
            addCriterion("del_status not between", value1, value2, "delStatus");
            return (Criteria) this;
        }

        public Criteria andTaskResponseDescLikeInsensitive(String value) {
            addCriterion("upper(task_response_desc) like", value.toUpperCase(), "taskResponseDesc");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLikeInsensitive(String value) {
            addCriterion("upper(update_by) like", value.toUpperCase(), "updateBy");
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
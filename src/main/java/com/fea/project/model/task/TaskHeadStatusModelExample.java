package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.List;

public class TaskHeadStatusModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskHeadStatusModelExample() {
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

        public Criteria andTaskHeadStatusIdIsNull() {
            addCriterion("task_head_status_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdIsNotNull() {
            addCriterion("task_head_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdEqualTo(Long value) {
            addCriterion("task_head_status_id =", value, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdNotEqualTo(Long value) {
            addCriterion("task_head_status_id <>", value, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdGreaterThan(Long value) {
            addCriterion("task_head_status_id >", value, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_head_status_id >=", value, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdLessThan(Long value) {
            addCriterion("task_head_status_id <", value, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdLessThanOrEqualTo(Long value) {
            addCriterion("task_head_status_id <=", value, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdIn(List<Long> values) {
            addCriterion("task_head_status_id in", values, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdNotIn(List<Long> values) {
            addCriterion("task_head_status_id not in", values, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdBetween(Long value1, Long value2) {
            addCriterion("task_head_status_id between", value1, value2, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskHeadStatusIdNotBetween(Long value1, Long value2) {
            addCriterion("task_head_status_id not between", value1, value2, "taskHeadStatusId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdIsNull() {
            addCriterion("task_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdIsNotNull() {
            addCriterion("task_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdEqualTo(Long value) {
            addCriterion("task_user_id =", value, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdNotEqualTo(Long value) {
            addCriterion("task_user_id <>", value, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdGreaterThan(Long value) {
            addCriterion("task_user_id >", value, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_user_id >=", value, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdLessThan(Long value) {
            addCriterion("task_user_id <", value, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdLessThanOrEqualTo(Long value) {
            addCriterion("task_user_id <=", value, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdIn(List<Long> values) {
            addCriterion("task_user_id in", values, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdNotIn(List<Long> values) {
            addCriterion("task_user_id not in", values, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdBetween(Long value1, Long value2) {
            addCriterion("task_user_id between", value1, value2, "taskUserId");
            return (Criteria) this;
        }

        public Criteria andTaskUserIdNotBetween(Long value1, Long value2) {
            addCriterion("task_user_id not between", value1, value2, "taskUserId");
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(Long value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(Long value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(Long value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(Long value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(Long value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(Long value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<Long> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<Long> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(Long value1, Long value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(Long value1, Long value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNull() {
            addCriterion("task_num is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNotNull() {
            addCriterion("task_num is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumEqualTo(Long value) {
            addCriterion("task_num =", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotEqualTo(Long value) {
            addCriterion("task_num <>", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThan(Long value) {
            addCriterion("task_num >", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThanOrEqualTo(Long value) {
            addCriterion("task_num >=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThan(Long value) {
            addCriterion("task_num <", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThanOrEqualTo(Long value) {
            addCriterion("task_num <=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumIn(List<Long> values) {
            addCriterion("task_num in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotIn(List<Long> values) {
            addCriterion("task_num not in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumBetween(Long value1, Long value2) {
            addCriterion("task_num between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotBetween(Long value1, Long value2) {
            addCriterion("task_num not between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNull() {
            addCriterion("parent_task_id is null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNotNull() {
            addCriterion("parent_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdEqualTo(Long value) {
            addCriterion("parent_task_id =", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotEqualTo(Long value) {
            addCriterion("parent_task_id <>", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThan(Long value) {
            addCriterion("parent_task_id >", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_task_id >=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThan(Long value) {
            addCriterion("parent_task_id <", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_task_id <=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIn(List<Long> values) {
            addCriterion("parent_task_id in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotIn(List<Long> values) {
            addCriterion("parent_task_id not in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdBetween(Long value1, Long value2) {
            addCriterion("parent_task_id between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_task_id not between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNull() {
            addCriterion("project_step is null");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNotNull() {
            addCriterion("project_step is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStepEqualTo(Long value) {
            addCriterion("project_step =", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotEqualTo(Long value) {
            addCriterion("project_step <>", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThan(Long value) {
            addCriterion("project_step >", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThanOrEqualTo(Long value) {
            addCriterion("project_step >=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThan(Long value) {
            addCriterion("project_step <", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThanOrEqualTo(Long value) {
            addCriterion("project_step <=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepIn(List<Long> values) {
            addCriterion("project_step in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotIn(List<Long> values) {
            addCriterion("project_step not in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepBetween(Long value1, Long value2) {
            addCriterion("project_step between", value1, value2, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotBetween(Long value1, Long value2) {
            addCriterion("project_step not between", value1, value2, "projectStep");
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

        public Criteria andPriorityEqualTo(Long value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Long value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Long value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Long value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Long value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Long value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Long> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Long> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Long value1, Long value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Long value1, Long value2) {
            addCriterion("priority not between", value1, value2, "priority");
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

        public Criteria andTaskStartTimeEqualTo(Long value) {
            addCriterion("task_start_time =", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotEqualTo(Long value) {
            addCriterion("task_start_time <>", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThan(Long value) {
            addCriterion("task_start_time >", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("task_start_time >=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThan(Long value) {
            addCriterion("task_start_time <", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("task_start_time <=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIn(List<Long> values) {
            addCriterion("task_start_time in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotIn(List<Long> values) {
            addCriterion("task_start_time not in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeBetween(Long value1, Long value2) {
            addCriterion("task_start_time between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotBetween(Long value1, Long value2) {
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

        public Criteria andTaskEndTimeEqualTo(Long value) {
            addCriterion("task_end_time =", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotEqualTo(Long value) {
            addCriterion("task_end_time <>", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThan(Long value) {
            addCriterion("task_end_time >", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("task_end_time >=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThan(Long value) {
            addCriterion("task_end_time <", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("task_end_time <=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIn(List<Long> values) {
            addCriterion("task_end_time in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotIn(List<Long> values) {
            addCriterion("task_end_time not in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeBetween(Long value1, Long value2) {
            addCriterion("task_end_time between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("task_end_time not between", value1, value2, "taskEndTime");
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

        public Criteria andTaskDeadlineEqualTo(Long value) {
            addCriterion("task_deadline =", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotEqualTo(Long value) {
            addCriterion("task_deadline <>", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineGreaterThan(Long value) {
            addCriterion("task_deadline >", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineGreaterThanOrEqualTo(Long value) {
            addCriterion("task_deadline >=", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineLessThan(Long value) {
            addCriterion("task_deadline <", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineLessThanOrEqualTo(Long value) {
            addCriterion("task_deadline <=", value, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineIn(List<Long> values) {
            addCriterion("task_deadline in", values, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotIn(List<Long> values) {
            addCriterion("task_deadline not in", values, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineBetween(Long value1, Long value2) {
            addCriterion("task_deadline between", value1, value2, "taskDeadline");
            return (Criteria) this;
        }

        public Criteria andTaskDeadlineNotBetween(Long value1, Long value2) {
            addCriterion("task_deadline not between", value1, value2, "taskDeadline");
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

        public Criteria andTaskLeaderIdIsNull() {
            addCriterion("task_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdIsNotNull() {
            addCriterion("task_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdEqualTo(Long value) {
            addCriterion("task_leader_id =", value, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdNotEqualTo(Long value) {
            addCriterion("task_leader_id <>", value, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdGreaterThan(Long value) {
            addCriterion("task_leader_id >", value, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_leader_id >=", value, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdLessThan(Long value) {
            addCriterion("task_leader_id <", value, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("task_leader_id <=", value, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdIn(List<Long> values) {
            addCriterion("task_leader_id in", values, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdNotIn(List<Long> values) {
            addCriterion("task_leader_id not in", values, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdBetween(Long value1, Long value2) {
            addCriterion("task_leader_id between", value1, value2, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("task_leader_id not between", value1, value2, "taskLeaderId");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameIsNull() {
            addCriterion("task_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameIsNotNull() {
            addCriterion("task_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameEqualTo(Long value) {
            addCriterion("task_leader_name =", value, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameNotEqualTo(Long value) {
            addCriterion("task_leader_name <>", value, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameGreaterThan(Long value) {
            addCriterion("task_leader_name >", value, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameGreaterThanOrEqualTo(Long value) {
            addCriterion("task_leader_name >=", value, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameLessThan(Long value) {
            addCriterion("task_leader_name <", value, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameLessThanOrEqualTo(Long value) {
            addCriterion("task_leader_name <=", value, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameIn(List<Long> values) {
            addCriterion("task_leader_name in", values, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameNotIn(List<Long> values) {
            addCriterion("task_leader_name not in", values, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameBetween(Long value1, Long value2) {
            addCriterion("task_leader_name between", value1, value2, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskLeaderNameNotBetween(Long value1, Long value2) {
            addCriterion("task_leader_name not between", value1, value2, "taskLeaderName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdIsNull() {
            addCriterion("task_team_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdIsNotNull() {
            addCriterion("task_team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdEqualTo(Long value) {
            addCriterion("task_team_id =", value, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdNotEqualTo(Long value) {
            addCriterion("task_team_id <>", value, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdGreaterThan(Long value) {
            addCriterion("task_team_id >", value, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_team_id >=", value, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdLessThan(Long value) {
            addCriterion("task_team_id <", value, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("task_team_id <=", value, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdIn(List<Long> values) {
            addCriterion("task_team_id in", values, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdNotIn(List<Long> values) {
            addCriterion("task_team_id not in", values, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdBetween(Long value1, Long value2) {
            addCriterion("task_team_id between", value1, value2, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("task_team_id not between", value1, value2, "taskTeamId");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameIsNull() {
            addCriterion("task_team_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameIsNotNull() {
            addCriterion("task_team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameEqualTo(Long value) {
            addCriterion("task_team_name =", value, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameNotEqualTo(Long value) {
            addCriterion("task_team_name <>", value, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameGreaterThan(Long value) {
            addCriterion("task_team_name >", value, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameGreaterThanOrEqualTo(Long value) {
            addCriterion("task_team_name >=", value, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameLessThan(Long value) {
            addCriterion("task_team_name <", value, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameLessThanOrEqualTo(Long value) {
            addCriterion("task_team_name <=", value, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameIn(List<Long> values) {
            addCriterion("task_team_name in", values, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameNotIn(List<Long> values) {
            addCriterion("task_team_name not in", values, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameBetween(Long value1, Long value2) {
            addCriterion("task_team_name between", value1, value2, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskTeamNameNotBetween(Long value1, Long value2) {
            addCriterion("task_team_name not between", value1, value2, "taskTeamName");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodIsNull() {
            addCriterion("task_dispatch_method is null");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodIsNotNull() {
            addCriterion("task_dispatch_method is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodEqualTo(Long value) {
            addCriterion("task_dispatch_method =", value, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodNotEqualTo(Long value) {
            addCriterion("task_dispatch_method <>", value, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodGreaterThan(Long value) {
            addCriterion("task_dispatch_method >", value, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodGreaterThanOrEqualTo(Long value) {
            addCriterion("task_dispatch_method >=", value, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodLessThan(Long value) {
            addCriterion("task_dispatch_method <", value, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodLessThanOrEqualTo(Long value) {
            addCriterion("task_dispatch_method <=", value, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodIn(List<Long> values) {
            addCriterion("task_dispatch_method in", values, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodNotIn(List<Long> values) {
            addCriterion("task_dispatch_method not in", values, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodBetween(Long value1, Long value2) {
            addCriterion("task_dispatch_method between", value1, value2, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchMethodNotBetween(Long value1, Long value2) {
            addCriterion("task_dispatch_method not between", value1, value2, "taskDispatchMethod");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdIsNull() {
            addCriterion("task_dispatcher_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdIsNotNull() {
            addCriterion("task_dispatcher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdEqualTo(Long value) {
            addCriterion("task_dispatcher_id =", value, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdNotEqualTo(Long value) {
            addCriterion("task_dispatcher_id <>", value, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdGreaterThan(Long value) {
            addCriterion("task_dispatcher_id >", value, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_dispatcher_id >=", value, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdLessThan(Long value) {
            addCriterion("task_dispatcher_id <", value, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdLessThanOrEqualTo(Long value) {
            addCriterion("task_dispatcher_id <=", value, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdIn(List<Long> values) {
            addCriterion("task_dispatcher_id in", values, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdNotIn(List<Long> values) {
            addCriterion("task_dispatcher_id not in", values, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdBetween(Long value1, Long value2) {
            addCriterion("task_dispatcher_id between", value1, value2, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatcherIdNotBetween(Long value1, Long value2) {
            addCriterion("task_dispatcher_id not between", value1, value2, "taskDispatcherId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdIsNull() {
            addCriterion("task_dispatch_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdIsNotNull() {
            addCriterion("task_dispatch_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdEqualTo(Long value) {
            addCriterion("task_dispatch_user_id =", value, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdNotEqualTo(Long value) {
            addCriterion("task_dispatch_user_id <>", value, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdGreaterThan(Long value) {
            addCriterion("task_dispatch_user_id >", value, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_dispatch_user_id >=", value, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdLessThan(Long value) {
            addCriterion("task_dispatch_user_id <", value, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdLessThanOrEqualTo(Long value) {
            addCriterion("task_dispatch_user_id <=", value, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdIn(List<Long> values) {
            addCriterion("task_dispatch_user_id in", values, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdNotIn(List<Long> values) {
            addCriterion("task_dispatch_user_id not in", values, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdBetween(Long value1, Long value2) {
            addCriterion("task_dispatch_user_id between", value1, value2, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskDispatchUserIdNotBetween(Long value1, Long value2) {
            addCriterion("task_dispatch_user_id not between", value1, value2, "taskDispatchUserId");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsIsNull() {
            addCriterion("task_participants is null");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsIsNotNull() {
            addCriterion("task_participants is not null");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsEqualTo(Long value) {
            addCriterion("task_participants =", value, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsNotEqualTo(Long value) {
            addCriterion("task_participants <>", value, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsGreaterThan(Long value) {
            addCriterion("task_participants >", value, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsGreaterThanOrEqualTo(Long value) {
            addCriterion("task_participants >=", value, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsLessThan(Long value) {
            addCriterion("task_participants <", value, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsLessThanOrEqualTo(Long value) {
            addCriterion("task_participants <=", value, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsIn(List<Long> values) {
            addCriterion("task_participants in", values, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsNotIn(List<Long> values) {
            addCriterion("task_participants not in", values, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsBetween(Long value1, Long value2) {
            addCriterion("task_participants between", value1, value2, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskParticipantsNotBetween(Long value1, Long value2) {
            addCriterion("task_participants not between", value1, value2, "taskParticipants");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourIsNull() {
            addCriterion("task_remind_hour is null");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourIsNotNull() {
            addCriterion("task_remind_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourEqualTo(Long value) {
            addCriterion("task_remind_hour =", value, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourNotEqualTo(Long value) {
            addCriterion("task_remind_hour <>", value, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourGreaterThan(Long value) {
            addCriterion("task_remind_hour >", value, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourGreaterThanOrEqualTo(Long value) {
            addCriterion("task_remind_hour >=", value, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourLessThan(Long value) {
            addCriterion("task_remind_hour <", value, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourLessThanOrEqualTo(Long value) {
            addCriterion("task_remind_hour <=", value, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourIn(List<Long> values) {
            addCriterion("task_remind_hour in", values, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourNotIn(List<Long> values) {
            addCriterion("task_remind_hour not in", values, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourBetween(Long value1, Long value2) {
            addCriterion("task_remind_hour between", value1, value2, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskRemindHourNotBetween(Long value1, Long value2) {
            addCriterion("task_remind_hour not between", value1, value2, "taskRemindHour");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(Long value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(Long value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(Long value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(Long value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(Long value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(Long value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<Long> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<Long> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(Long value1, Long value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(Long value1, Long value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIsNull() {
            addCriterion("task_remark is null");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIsNotNull() {
            addCriterion("task_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkEqualTo(Long value) {
            addCriterion("task_remark =", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotEqualTo(Long value) {
            addCriterion("task_remark <>", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkGreaterThan(Long value) {
            addCriterion("task_remark >", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkGreaterThanOrEqualTo(Long value) {
            addCriterion("task_remark >=", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLessThan(Long value) {
            addCriterion("task_remark <", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLessThanOrEqualTo(Long value) {
            addCriterion("task_remark <=", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIn(List<Long> values) {
            addCriterion("task_remark in", values, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotIn(List<Long> values) {
            addCriterion("task_remark not in", values, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkBetween(Long value1, Long value2) {
            addCriterion("task_remark between", value1, value2, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotBetween(Long value1, Long value2) {
            addCriterion("task_remark not between", value1, value2, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusIsNull() {
            addCriterion("work_task_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusIsNotNull() {
            addCriterion("work_task_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusEqualTo(Long value) {
            addCriterion("work_task_status =", value, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusNotEqualTo(Long value) {
            addCriterion("work_task_status <>", value, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusGreaterThan(Long value) {
            addCriterion("work_task_status >", value, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("work_task_status >=", value, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusLessThan(Long value) {
            addCriterion("work_task_status <", value, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusLessThanOrEqualTo(Long value) {
            addCriterion("work_task_status <=", value, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusIn(List<Long> values) {
            addCriterion("work_task_status in", values, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusNotIn(List<Long> values) {
            addCriterion("work_task_status not in", values, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusBetween(Long value1, Long value2) {
            addCriterion("work_task_status between", value1, value2, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskStatusNotBetween(Long value1, Long value2) {
            addCriterion("work_task_status not between", value1, value2, "workTaskStatus");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumIsNull() {
            addCriterion("work_task_num is null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumIsNotNull() {
            addCriterion("work_task_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumEqualTo(Long value) {
            addCriterion("work_task_num =", value, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumNotEqualTo(Long value) {
            addCriterion("work_task_num <>", value, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumGreaterThan(Long value) {
            addCriterion("work_task_num >", value, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumGreaterThanOrEqualTo(Long value) {
            addCriterion("work_task_num >=", value, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumLessThan(Long value) {
            addCriterion("work_task_num <", value, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumLessThanOrEqualTo(Long value) {
            addCriterion("work_task_num <=", value, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumIn(List<Long> values) {
            addCriterion("work_task_num in", values, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumNotIn(List<Long> values) {
            addCriterion("work_task_num not in", values, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumBetween(Long value1, Long value2) {
            addCriterion("work_task_num between", value1, value2, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andWorkTaskNumNotBetween(Long value1, Long value2) {
            addCriterion("work_task_num not between", value1, value2, "workTaskNum");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusIsNull() {
            addCriterion("cancel_task_status is null");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusIsNotNull() {
            addCriterion("cancel_task_status is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusEqualTo(Long value) {
            addCriterion("cancel_task_status =", value, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusNotEqualTo(Long value) {
            addCriterion("cancel_task_status <>", value, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusGreaterThan(Long value) {
            addCriterion("cancel_task_status >", value, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_task_status >=", value, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusLessThan(Long value) {
            addCriterion("cancel_task_status <", value, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusLessThanOrEqualTo(Long value) {
            addCriterion("cancel_task_status <=", value, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusIn(List<Long> values) {
            addCriterion("cancel_task_status in", values, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusNotIn(List<Long> values) {
            addCriterion("cancel_task_status not in", values, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusBetween(Long value1, Long value2) {
            addCriterion("cancel_task_status between", value1, value2, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskStatusNotBetween(Long value1, Long value2) {
            addCriterion("cancel_task_status not between", value1, value2, "cancelTaskStatus");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonIsNull() {
            addCriterion("cancel_task_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonIsNotNull() {
            addCriterion("cancel_task_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonEqualTo(Long value) {
            addCriterion("cancel_task_reason =", value, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonNotEqualTo(Long value) {
            addCriterion("cancel_task_reason <>", value, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonGreaterThan(Long value) {
            addCriterion("cancel_task_reason >", value, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_task_reason >=", value, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonLessThan(Long value) {
            addCriterion("cancel_task_reason <", value, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonLessThanOrEqualTo(Long value) {
            addCriterion("cancel_task_reason <=", value, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonIn(List<Long> values) {
            addCriterion("cancel_task_reason in", values, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonNotIn(List<Long> values) {
            addCriterion("cancel_task_reason not in", values, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonBetween(Long value1, Long value2) {
            addCriterion("cancel_task_reason between", value1, value2, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andCancelTaskReasonNotBetween(Long value1, Long value2) {
            addCriterion("cancel_task_reason not between", value1, value2, "cancelTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusIsNull() {
            addCriterion("stop_task_status is null");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusIsNotNull() {
            addCriterion("stop_task_status is not null");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusEqualTo(Long value) {
            addCriterion("stop_task_status =", value, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusNotEqualTo(Long value) {
            addCriterion("stop_task_status <>", value, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusGreaterThan(Long value) {
            addCriterion("stop_task_status >", value, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("stop_task_status >=", value, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusLessThan(Long value) {
            addCriterion("stop_task_status <", value, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusLessThanOrEqualTo(Long value) {
            addCriterion("stop_task_status <=", value, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusIn(List<Long> values) {
            addCriterion("stop_task_status in", values, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusNotIn(List<Long> values) {
            addCriterion("stop_task_status not in", values, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusBetween(Long value1, Long value2) {
            addCriterion("stop_task_status between", value1, value2, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskStatusNotBetween(Long value1, Long value2) {
            addCriterion("stop_task_status not between", value1, value2, "stopTaskStatus");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonIsNull() {
            addCriterion("stop_task_reason is null");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonIsNotNull() {
            addCriterion("stop_task_reason is not null");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonEqualTo(Long value) {
            addCriterion("stop_task_reason =", value, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonNotEqualTo(Long value) {
            addCriterion("stop_task_reason <>", value, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonGreaterThan(Long value) {
            addCriterion("stop_task_reason >", value, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonGreaterThanOrEqualTo(Long value) {
            addCriterion("stop_task_reason >=", value, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonLessThan(Long value) {
            addCriterion("stop_task_reason <", value, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonLessThanOrEqualTo(Long value) {
            addCriterion("stop_task_reason <=", value, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonIn(List<Long> values) {
            addCriterion("stop_task_reason in", values, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonNotIn(List<Long> values) {
            addCriterion("stop_task_reason not in", values, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonBetween(Long value1, Long value2) {
            addCriterion("stop_task_reason between", value1, value2, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andStopTaskReasonNotBetween(Long value1, Long value2) {
            addCriterion("stop_task_reason not between", value1, value2, "stopTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusIsNull() {
            addCriterion("restart_task_status is null");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusIsNotNull() {
            addCriterion("restart_task_status is not null");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusEqualTo(Long value) {
            addCriterion("restart_task_status =", value, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusNotEqualTo(Long value) {
            addCriterion("restart_task_status <>", value, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusGreaterThan(Long value) {
            addCriterion("restart_task_status >", value, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("restart_task_status >=", value, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusLessThan(Long value) {
            addCriterion("restart_task_status <", value, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusLessThanOrEqualTo(Long value) {
            addCriterion("restart_task_status <=", value, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusIn(List<Long> values) {
            addCriterion("restart_task_status in", values, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusNotIn(List<Long> values) {
            addCriterion("restart_task_status not in", values, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusBetween(Long value1, Long value2) {
            addCriterion("restart_task_status between", value1, value2, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskStatusNotBetween(Long value1, Long value2) {
            addCriterion("restart_task_status not between", value1, value2, "restartTaskStatus");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonIsNull() {
            addCriterion("restart_task_reason is null");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonIsNotNull() {
            addCriterion("restart_task_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonEqualTo(Long value) {
            addCriterion("restart_task_reason =", value, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonNotEqualTo(Long value) {
            addCriterion("restart_task_reason <>", value, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonGreaterThan(Long value) {
            addCriterion("restart_task_reason >", value, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonGreaterThanOrEqualTo(Long value) {
            addCriterion("restart_task_reason >=", value, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonLessThan(Long value) {
            addCriterion("restart_task_reason <", value, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonLessThanOrEqualTo(Long value) {
            addCriterion("restart_task_reason <=", value, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonIn(List<Long> values) {
            addCriterion("restart_task_reason in", values, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonNotIn(List<Long> values) {
            addCriterion("restart_task_reason not in", values, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonBetween(Long value1, Long value2) {
            addCriterion("restart_task_reason between", value1, value2, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andRestartTaskReasonNotBetween(Long value1, Long value2) {
            addCriterion("restart_task_reason not between", value1, value2, "restartTaskReason");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateIsNull() {
            addCriterion("task_progross_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateIsNotNull() {
            addCriterion("task_progross_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateEqualTo(Long value) {
            addCriterion("task_progross_rate =", value, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateNotEqualTo(Long value) {
            addCriterion("task_progross_rate <>", value, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateGreaterThan(Long value) {
            addCriterion("task_progross_rate >", value, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateGreaterThanOrEqualTo(Long value) {
            addCriterion("task_progross_rate >=", value, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateLessThan(Long value) {
            addCriterion("task_progross_rate <", value, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateLessThanOrEqualTo(Long value) {
            addCriterion("task_progross_rate <=", value, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateIn(List<Long> values) {
            addCriterion("task_progross_rate in", values, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateNotIn(List<Long> values) {
            addCriterion("task_progross_rate not in", values, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateBetween(Long value1, Long value2) {
            addCriterion("task_progross_rate between", value1, value2, "taskProgrossRate");
            return (Criteria) this;
        }

        public Criteria andTaskProgrossRateNotBetween(Long value1, Long value2) {
            addCriterion("task_progross_rate not between", value1, value2, "taskProgrossRate");
            return (Criteria) this;
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

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Long value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Long value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Long value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Long value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Long value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Long> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Long> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Long value1, Long value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Long value1, Long value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusIsNull() {
            addCriterion("task_attention_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusIsNotNull() {
            addCriterion("task_attention_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusEqualTo(Long value) {
            addCriterion("task_attention_status =", value, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusNotEqualTo(Long value) {
            addCriterion("task_attention_status <>", value, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusGreaterThan(Long value) {
            addCriterion("task_attention_status >", value, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("task_attention_status >=", value, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusLessThan(Long value) {
            addCriterion("task_attention_status <", value, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusLessThanOrEqualTo(Long value) {
            addCriterion("task_attention_status <=", value, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusIn(List<Long> values) {
            addCriterion("task_attention_status in", values, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusNotIn(List<Long> values) {
            addCriterion("task_attention_status not in", values, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusBetween(Long value1, Long value2) {
            addCriterion("task_attention_status between", value1, value2, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskAttentionStatusNotBetween(Long value1, Long value2) {
            addCriterion("task_attention_status not between", value1, value2, "taskAttentionStatus");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionIsNull() {
            addCriterion("task_question is null");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionIsNotNull() {
            addCriterion("task_question is not null");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionEqualTo(Long value) {
            addCriterion("task_question =", value, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionNotEqualTo(Long value) {
            addCriterion("task_question <>", value, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionGreaterThan(Long value) {
            addCriterion("task_question >", value, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionGreaterThanOrEqualTo(Long value) {
            addCriterion("task_question >=", value, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionLessThan(Long value) {
            addCriterion("task_question <", value, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionLessThanOrEqualTo(Long value) {
            addCriterion("task_question <=", value, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionIn(List<Long> values) {
            addCriterion("task_question in", values, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionNotIn(List<Long> values) {
            addCriterion("task_question not in", values, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionBetween(Long value1, Long value2) {
            addCriterion("task_question between", value1, value2, "taskQuestion");
            return (Criteria) this;
        }

        public Criteria andTaskQuestionNotBetween(Long value1, Long value2) {
            addCriterion("task_question not between", value1, value2, "taskQuestion");
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

        public Criteria andTaskTypeEqualTo(Long value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Long value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Long value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Long value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Long value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Long> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Long> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Long value1, Long value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Long value1, Long value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
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

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
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

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
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

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
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

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
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
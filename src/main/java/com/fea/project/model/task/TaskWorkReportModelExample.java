package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskWorkReportModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskWorkReportModelExample() {
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

        public Criteria andWorkReportIdIsNull() {
            addCriterion("work_report_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdIsNotNull() {
            addCriterion("work_report_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdEqualTo(Long value) {
            addCriterion("work_report_id =", value, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdNotEqualTo(Long value) {
            addCriterion("work_report_id <>", value, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdGreaterThan(Long value) {
            addCriterion("work_report_id >", value, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdGreaterThanOrEqualTo(Long value) {
            addCriterion("work_report_id >=", value, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdLessThan(Long value) {
            addCriterion("work_report_id <", value, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdLessThanOrEqualTo(Long value) {
            addCriterion("work_report_id <=", value, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdIn(List<Long> values) {
            addCriterion("work_report_id in", values, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdNotIn(List<Long> values) {
            addCriterion("work_report_id not in", values, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdBetween(Long value1, Long value2) {
            addCriterion("work_report_id between", value1, value2, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportIdNotBetween(Long value1, Long value2) {
            addCriterion("work_report_id not between", value1, value2, "workReportId");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleIsNull() {
            addCriterion("work_report_title is null");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleIsNotNull() {
            addCriterion("work_report_title is not null");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleEqualTo(String value) {
            addCriterion("work_report_title =", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleNotEqualTo(String value) {
            addCriterion("work_report_title <>", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleGreaterThan(String value) {
            addCriterion("work_report_title >", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleGreaterThanOrEqualTo(String value) {
            addCriterion("work_report_title >=", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleLessThan(String value) {
            addCriterion("work_report_title <", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleLessThanOrEqualTo(String value) {
            addCriterion("work_report_title <=", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleLike(String value) {
            addCriterion("work_report_title like", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleNotLike(String value) {
            addCriterion("work_report_title not like", value, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleIn(List<String> values) {
            addCriterion("work_report_title in", values, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleNotIn(List<String> values) {
            addCriterion("work_report_title not in", values, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleBetween(String value1, String value2) {
            addCriterion("work_report_title between", value1, value2, "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReportTitleNotBetween(String value1, String value2) {
            addCriterion("work_report_title not between", value1, value2, "workReportTitle");
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

        public Criteria andWorkReporterIdIsNull() {
            addCriterion("work_reporter_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdIsNotNull() {
            addCriterion("work_reporter_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdEqualTo(Long value) {
            addCriterion("work_reporter_id =", value, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdNotEqualTo(Long value) {
            addCriterion("work_reporter_id <>", value, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdGreaterThan(Long value) {
            addCriterion("work_reporter_id >", value, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("work_reporter_id >=", value, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdLessThan(Long value) {
            addCriterion("work_reporter_id <", value, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdLessThanOrEqualTo(Long value) {
            addCriterion("work_reporter_id <=", value, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdIn(List<Long> values) {
            addCriterion("work_reporter_id in", values, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdNotIn(List<Long> values) {
            addCriterion("work_reporter_id not in", values, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdBetween(Long value1, Long value2) {
            addCriterion("work_reporter_id between", value1, value2, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterIdNotBetween(Long value1, Long value2) {
            addCriterion("work_reporter_id not between", value1, value2, "workReporterId");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameIsNull() {
            addCriterion("work_reporter_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameIsNotNull() {
            addCriterion("work_reporter_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameEqualTo(String value) {
            addCriterion("work_reporter_name =", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameNotEqualTo(String value) {
            addCriterion("work_reporter_name <>", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameGreaterThan(String value) {
            addCriterion("work_reporter_name >", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_reporter_name >=", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameLessThan(String value) {
            addCriterion("work_reporter_name <", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameLessThanOrEqualTo(String value) {
            addCriterion("work_reporter_name <=", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameLike(String value) {
            addCriterion("work_reporter_name like", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameNotLike(String value) {
            addCriterion("work_reporter_name not like", value, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameIn(List<String> values) {
            addCriterion("work_reporter_name in", values, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameNotIn(List<String> values) {
            addCriterion("work_reporter_name not in", values, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameBetween(String value1, String value2) {
            addCriterion("work_reporter_name between", value1, value2, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameNotBetween(String value1, String value2) {
            addCriterion("work_reporter_name not between", value1, value2, "workReporterName");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeIsNull() {
            addCriterion("actual_task_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeIsNotNull() {
            addCriterion("actual_task_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeEqualTo(Date value) {
            addCriterion("actual_task_start_time =", value, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeNotEqualTo(Date value) {
            addCriterion("actual_task_start_time <>", value, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeGreaterThan(Date value) {
            addCriterion("actual_task_start_time >", value, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_task_start_time >=", value, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeLessThan(Date value) {
            addCriterion("actual_task_start_time <", value, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_task_start_time <=", value, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeIn(List<Date> values) {
            addCriterion("actual_task_start_time in", values, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeNotIn(List<Date> values) {
            addCriterion("actual_task_start_time not in", values, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeBetween(Date value1, Date value2) {
            addCriterion("actual_task_start_time between", value1, value2, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_task_start_time not between", value1, value2, "actualTaskStartTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeIsNull() {
            addCriterion("actual_task_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeIsNotNull() {
            addCriterion("actual_task_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeEqualTo(Date value) {
            addCriterion("actual_task_end_time =", value, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeNotEqualTo(Date value) {
            addCriterion("actual_task_end_time <>", value, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeGreaterThan(Date value) {
            addCriterion("actual_task_end_time >", value, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_task_end_time >=", value, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeLessThan(Date value) {
            addCriterion("actual_task_end_time <", value, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_task_end_time <=", value, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeIn(List<Date> values) {
            addCriterion("actual_task_end_time in", values, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeNotIn(List<Date> values) {
            addCriterion("actual_task_end_time not in", values, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeBetween(Date value1, Date value2) {
            addCriterion("actual_task_end_time between", value1, value2, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_task_end_time not between", value1, value2, "actualTaskEndTime");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationIsNull() {
            addCriterion("actual_task_duration is null");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationIsNotNull() {
            addCriterion("actual_task_duration is not null");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationEqualTo(Long value) {
            addCriterion("actual_task_duration =", value, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationNotEqualTo(Long value) {
            addCriterion("actual_task_duration <>", value, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationGreaterThan(Long value) {
            addCriterion("actual_task_duration >", value, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("actual_task_duration >=", value, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationLessThan(Long value) {
            addCriterion("actual_task_duration <", value, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationLessThanOrEqualTo(Long value) {
            addCriterion("actual_task_duration <=", value, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationIn(List<Long> values) {
            addCriterion("actual_task_duration in", values, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationNotIn(List<Long> values) {
            addCriterion("actual_task_duration not in", values, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationBetween(Long value1, Long value2) {
            addCriterion("actual_task_duration between", value1, value2, "actualTaskDuration");
            return (Criteria) this;
        }

        public Criteria andActualTaskDurationNotBetween(Long value1, Long value2) {
            addCriterion("actual_task_duration not between", value1, value2, "actualTaskDuration");
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

        public Criteria andWorkReportTitleLikeInsensitive(String value) {
            addCriterion("upper(work_report_title) like", value.toUpperCase(), "workReportTitle");
            return (Criteria) this;
        }

        public Criteria andWorkReporterNameLikeInsensitive(String value) {
            addCriterion("upper(work_reporter_name) like", value.toUpperCase(), "workReporterName");
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
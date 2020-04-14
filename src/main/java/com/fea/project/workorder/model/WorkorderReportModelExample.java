package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderReportModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderReportModelExample() {
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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(Long value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(Long value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(Long value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(Long value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(Long value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(Long value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<Long> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<Long> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(Long value1, Long value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(Long value1, Long value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
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

        public Criteria andReportTitleIsNull() {
            addCriterion("report_title is null");
            return (Criteria) this;
        }

        public Criteria andReportTitleIsNotNull() {
            addCriterion("report_title is not null");
            return (Criteria) this;
        }

        public Criteria andReportTitleEqualTo(String value) {
            addCriterion("report_title =", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleNotEqualTo(String value) {
            addCriterion("report_title <>", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleGreaterThan(String value) {
            addCriterion("report_title >", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleGreaterThanOrEqualTo(String value) {
            addCriterion("report_title >=", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleLessThan(String value) {
            addCriterion("report_title <", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleLessThanOrEqualTo(String value) {
            addCriterion("report_title <=", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleLike(String value) {
            addCriterion("report_title like", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleNotLike(String value) {
            addCriterion("report_title not like", value, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleIn(List<String> values) {
            addCriterion("report_title in", values, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleNotIn(List<String> values) {
            addCriterion("report_title not in", values, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleBetween(String value1, String value2) {
            addCriterion("report_title between", value1, value2, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andReportTitleNotBetween(String value1, String value2) {
            addCriterion("report_title not between", value1, value2, "reportTitle");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIsNull() {
            addCriterion("actual_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIsNotNull() {
            addCriterion("actual_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeEqualTo(Date value) {
            addCriterion("actual_start_time =", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotEqualTo(Date value) {
            addCriterion("actual_start_time <>", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeGreaterThan(Date value) {
            addCriterion("actual_start_time >", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_start_time >=", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeLessThan(Date value) {
            addCriterion("actual_start_time <", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_start_time <=", value, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeIn(List<Date> values) {
            addCriterion("actual_start_time in", values, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotIn(List<Date> values) {
            addCriterion("actual_start_time not in", values, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeBetween(Date value1, Date value2) {
            addCriterion("actual_start_time between", value1, value2, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_start_time not between", value1, value2, "actualStartTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNull() {
            addCriterion("actual_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNotNull() {
            addCriterion("actual_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeEqualTo(Date value) {
            addCriterion("actual_end_time =", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotEqualTo(Date value) {
            addCriterion("actual_end_time <>", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThan(Date value) {
            addCriterion("actual_end_time >", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_end_time >=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThan(Date value) {
            addCriterion("actual_end_time <", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("actual_end_time <=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIn(List<Date> values) {
            addCriterion("actual_end_time in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotIn(List<Date> values) {
            addCriterion("actual_end_time not in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeBetween(Date value1, Date value2) {
            addCriterion("actual_end_time between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("actual_end_time not between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourIsNull() {
            addCriterion("actual_work_hour is null");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourIsNotNull() {
            addCriterion("actual_work_hour is not null");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourEqualTo(Long value) {
            addCriterion("actual_work_hour =", value, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourNotEqualTo(Long value) {
            addCriterion("actual_work_hour <>", value, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourGreaterThan(Long value) {
            addCriterion("actual_work_hour >", value, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourGreaterThanOrEqualTo(Long value) {
            addCriterion("actual_work_hour >=", value, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourLessThan(Long value) {
            addCriterion("actual_work_hour <", value, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourLessThanOrEqualTo(Long value) {
            addCriterion("actual_work_hour <=", value, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourIn(List<Long> values) {
            addCriterion("actual_work_hour in", values, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourNotIn(List<Long> values) {
            addCriterion("actual_work_hour not in", values, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourBetween(Long value1, Long value2) {
            addCriterion("actual_work_hour between", value1, value2, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andActualWorkHourNotBetween(Long value1, Long value2) {
            addCriterion("actual_work_hour not between", value1, value2, "actualWorkHour");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateIsNull() {
            addCriterion("workorder_progross_rate is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateIsNotNull() {
            addCriterion("workorder_progross_rate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateEqualTo(Double value) {
            addCriterion("workorder_progross_rate =", value, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateNotEqualTo(Double value) {
            addCriterion("workorder_progross_rate <>", value, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateGreaterThan(Double value) {
            addCriterion("workorder_progross_rate >", value, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateGreaterThanOrEqualTo(Double value) {
            addCriterion("workorder_progross_rate >=", value, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateLessThan(Double value) {
            addCriterion("workorder_progross_rate <", value, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateLessThanOrEqualTo(Double value) {
            addCriterion("workorder_progross_rate <=", value, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateIn(List<Double> values) {
            addCriterion("workorder_progross_rate in", values, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateNotIn(List<Double> values) {
            addCriterion("workorder_progross_rate not in", values, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateBetween(Double value1, Double value2) {
            addCriterion("workorder_progross_rate between", value1, value2, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andWorkorderProgrossRateNotBetween(Double value1, Double value2) {
            addCriterion("workorder_progross_rate not between", value1, value2, "workorderProgrossRate");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andReportTitleLikeInsensitive(String value) {
            addCriterion("upper(report_title) like", value.toUpperCase(), "reportTitle");
            return (Criteria) this;
        }

        public Criteria andContentLikeInsensitive(String value) {
            addCriterion("upper(content) like", value.toUpperCase(), "content");
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
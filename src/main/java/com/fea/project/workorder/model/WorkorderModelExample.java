package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderModelExample() {
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

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameIsNull() {
            addCriterion("workorder_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameIsNotNull() {
            addCriterion("workorder_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameEqualTo(Long value) {
            addCriterion("workorder_name =", value, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameNotEqualTo(Long value) {
            addCriterion("workorder_name <>", value, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameGreaterThan(Long value) {
            addCriterion("workorder_name >", value, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_name >=", value, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameLessThan(Long value) {
            addCriterion("workorder_name <", value, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameLessThanOrEqualTo(Long value) {
            addCriterion("workorder_name <=", value, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameIn(List<Long> values) {
            addCriterion("workorder_name in", values, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameNotIn(List<Long> values) {
            addCriterion("workorder_name not in", values, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameBetween(Long value1, Long value2) {
            addCriterion("workorder_name between", value1, value2, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNameNotBetween(Long value1, Long value2) {
            addCriterion("workorder_name not between", value1, value2, "workorderName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumIsNull() {
            addCriterion("workorder_num is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumIsNotNull() {
            addCriterion("workorder_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumEqualTo(String value) {
            addCriterion("workorder_num =", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumNotEqualTo(String value) {
            addCriterion("workorder_num <>", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumGreaterThan(String value) {
            addCriterion("workorder_num >", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_num >=", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumLessThan(String value) {
            addCriterion("workorder_num <", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumLessThanOrEqualTo(String value) {
            addCriterion("workorder_num <=", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumLike(String value) {
            addCriterion("workorder_num like", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumNotLike(String value) {
            addCriterion("workorder_num not like", value, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumIn(List<String> values) {
            addCriterion("workorder_num in", values, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumNotIn(List<String> values) {
            addCriterion("workorder_num not in", values, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumBetween(String value1, String value2) {
            addCriterion("workorder_num between", value1, value2, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumNotBetween(String value1, String value2) {
            addCriterion("workorder_num not between", value1, value2, "workorderNum");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeIsNull() {
            addCriterion("workorder_resource_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeIsNotNull() {
            addCriterion("workorder_resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeEqualTo(Long value) {
            addCriterion("workorder_resource_type =", value, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeNotEqualTo(Long value) {
            addCriterion("workorder_resource_type <>", value, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeGreaterThan(Long value) {
            addCriterion("workorder_resource_type >", value, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_resource_type >=", value, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeLessThan(Long value) {
            addCriterion("workorder_resource_type <", value, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeLessThanOrEqualTo(Long value) {
            addCriterion("workorder_resource_type <=", value, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeIn(List<Long> values) {
            addCriterion("workorder_resource_type in", values, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeNotIn(List<Long> values) {
            addCriterion("workorder_resource_type not in", values, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeBetween(Long value1, Long value2) {
            addCriterion("workorder_resource_type between", value1, value2, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderResourceTypeNotBetween(Long value1, Long value2) {
            addCriterion("workorder_resource_type not between", value1, value2, "workorderResourceType");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIsNull() {
            addCriterion("workorder_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIsNotNull() {
            addCriterion("workorder_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdEqualTo(Long value) {
            addCriterion("workorder_type_id =", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotEqualTo(Long value) {
            addCriterion("workorder_type_id <>", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdGreaterThan(Long value) {
            addCriterion("workorder_type_id >", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_type_id >=", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLessThan(Long value) {
            addCriterion("workorder_type_id <", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("workorder_type_id <=", value, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdIn(List<Long> values) {
            addCriterion("workorder_type_id in", values, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotIn(List<Long> values) {
            addCriterion("workorder_type_id not in", values, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdBetween(Long value1, Long value2) {
            addCriterion("workorder_type_id between", value1, value2, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("workorder_type_id not between", value1, value2, "workorderTypeId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdIsNull() {
            addCriterion("workorder_catagory_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdIsNotNull() {
            addCriterion("workorder_catagory_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdEqualTo(Long value) {
            addCriterion("workorder_catagory_id =", value, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdNotEqualTo(Long value) {
            addCriterion("workorder_catagory_id <>", value, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdGreaterThan(Long value) {
            addCriterion("workorder_catagory_id >", value, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_catagory_id >=", value, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdLessThan(Long value) {
            addCriterion("workorder_catagory_id <", value, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdLessThanOrEqualTo(Long value) {
            addCriterion("workorder_catagory_id <=", value, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdIn(List<Long> values) {
            addCriterion("workorder_catagory_id in", values, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdNotIn(List<Long> values) {
            addCriterion("workorder_catagory_id not in", values, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdBetween(Long value1, Long value2) {
            addCriterion("workorder_catagory_id between", value1, value2, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andWorkorderCatagoryIdNotBetween(Long value1, Long value2) {
            addCriterion("workorder_catagory_id not between", value1, value2, "workorderCatagoryId");
            return (Criteria) this;
        }

        public Criteria andMouldIdIsNull() {
            addCriterion("mould_id is null");
            return (Criteria) this;
        }

        public Criteria andMouldIdIsNotNull() {
            addCriterion("mould_id is not null");
            return (Criteria) this;
        }

        public Criteria andMouldIdEqualTo(Long value) {
            addCriterion("mould_id =", value, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdNotEqualTo(Long value) {
            addCriterion("mould_id <>", value, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdGreaterThan(Long value) {
            addCriterion("mould_id >", value, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mould_id >=", value, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdLessThan(Long value) {
            addCriterion("mould_id <", value, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdLessThanOrEqualTo(Long value) {
            addCriterion("mould_id <=", value, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdIn(List<Long> values) {
            addCriterion("mould_id in", values, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdNotIn(List<Long> values) {
            addCriterion("mould_id not in", values, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdBetween(Long value1, Long value2) {
            addCriterion("mould_id between", value1, value2, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldIdNotBetween(Long value1, Long value2) {
            addCriterion("mould_id not between", value1, value2, "mouldId");
            return (Criteria) this;
        }

        public Criteria andMouldNameIsNull() {
            addCriterion("mould_name is null");
            return (Criteria) this;
        }

        public Criteria andMouldNameIsNotNull() {
            addCriterion("mould_name is not null");
            return (Criteria) this;
        }

        public Criteria andMouldNameEqualTo(String value) {
            addCriterion("mould_name =", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameNotEqualTo(String value) {
            addCriterion("mould_name <>", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameGreaterThan(String value) {
            addCriterion("mould_name >", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameGreaterThanOrEqualTo(String value) {
            addCriterion("mould_name >=", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameLessThan(String value) {
            addCriterion("mould_name <", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameLessThanOrEqualTo(String value) {
            addCriterion("mould_name <=", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameLike(String value) {
            addCriterion("mould_name like", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameNotLike(String value) {
            addCriterion("mould_name not like", value, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameIn(List<String> values) {
            addCriterion("mould_name in", values, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameNotIn(List<String> values) {
            addCriterion("mould_name not in", values, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameBetween(String value1, String value2) {
            addCriterion("mould_name between", value1, value2, "mouldName");
            return (Criteria) this;
        }

        public Criteria andMouldNameNotBetween(String value1, String value2) {
            addCriterion("mould_name not between", value1, value2, "mouldName");
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

        public Criteria andWorkHourIsNull() {
            addCriterion("work_hour is null");
            return (Criteria) this;
        }

        public Criteria andWorkHourIsNotNull() {
            addCriterion("work_hour is not null");
            return (Criteria) this;
        }

        public Criteria andWorkHourEqualTo(Double value) {
            addCriterion("work_hour =", value, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourNotEqualTo(Double value) {
            addCriterion("work_hour <>", value, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourGreaterThan(Double value) {
            addCriterion("work_hour >", value, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourGreaterThanOrEqualTo(Double value) {
            addCriterion("work_hour >=", value, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourLessThan(Double value) {
            addCriterion("work_hour <", value, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourLessThanOrEqualTo(Double value) {
            addCriterion("work_hour <=", value, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourIn(List<Double> values) {
            addCriterion("work_hour in", values, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourNotIn(List<Double> values) {
            addCriterion("work_hour not in", values, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourBetween(Double value1, Double value2) {
            addCriterion("work_hour between", value1, value2, "workHour");
            return (Criteria) this;
        }

        public Criteria andWorkHourNotBetween(Double value1, Double value2) {
            addCriterion("work_hour not between", value1, value2, "workHour");
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

        public Criteria andSwitchPersonIsNull() {
            addCriterion("switch_person is null");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonIsNotNull() {
            addCriterion("switch_person is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonEqualTo(Long value) {
            addCriterion("switch_person =", value, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonNotEqualTo(Long value) {
            addCriterion("switch_person <>", value, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonGreaterThan(Long value) {
            addCriterion("switch_person >", value, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonGreaterThanOrEqualTo(Long value) {
            addCriterion("switch_person >=", value, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonLessThan(Long value) {
            addCriterion("switch_person <", value, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonLessThanOrEqualTo(Long value) {
            addCriterion("switch_person <=", value, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonIn(List<Long> values) {
            addCriterion("switch_person in", values, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonNotIn(List<Long> values) {
            addCriterion("switch_person not in", values, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonBetween(Long value1, Long value2) {
            addCriterion("switch_person between", value1, value2, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andSwitchPersonNotBetween(Long value1, Long value2) {
            addCriterion("switch_person not between", value1, value2, "switchPerson");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Long value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Long value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Long value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Long value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<Long> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Long> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Long value1, Long value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andContactIdIsNull() {
            addCriterion("contact_id is null");
            return (Criteria) this;
        }

        public Criteria andContactIdIsNotNull() {
            addCriterion("contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactIdEqualTo(Long value) {
            addCriterion("contact_id =", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotEqualTo(Long value) {
            addCriterion("contact_id <>", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThan(Long value) {
            addCriterion("contact_id >", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contact_id >=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThan(Long value) {
            addCriterion("contact_id <", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThanOrEqualTo(Long value) {
            addCriterion("contact_id <=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdIn(List<Long> values) {
            addCriterion("contact_id in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotIn(List<Long> values) {
            addCriterion("contact_id not in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdBetween(Long value1, Long value2) {
            addCriterion("contact_id between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotBetween(Long value1, Long value2) {
            addCriterion("contact_id not between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
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

        public Criteria andBusinessTypeEqualTo(Long value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Long value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Long value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Long value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Long value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Long> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Long> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Long value1, Long value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Long value1, Long value2) {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdIsNull() {
            addCriterion("product_trouble_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdIsNotNull() {
            addCriterion("product_trouble_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdEqualTo(Long value) {
            addCriterion("product_trouble_type_id =", value, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdNotEqualTo(Long value) {
            addCriterion("product_trouble_type_id <>", value, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdGreaterThan(Long value) {
            addCriterion("product_trouble_type_id >", value, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_trouble_type_id >=", value, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdLessThan(Long value) {
            addCriterion("product_trouble_type_id <", value, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("product_trouble_type_id <=", value, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdIn(List<Long> values) {
            addCriterion("product_trouble_type_id in", values, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdNotIn(List<Long> values) {
            addCriterion("product_trouble_type_id not in", values, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdBetween(Long value1, Long value2) {
            addCriterion("product_trouble_type_id between", value1, value2, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("product_trouble_type_id not between", value1, value2, "productTroubleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdIsNull() {
            addCriterion("product_trouble_sort_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdIsNotNull() {
            addCriterion("product_trouble_sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdEqualTo(Long value) {
            addCriterion("product_trouble_sort_id =", value, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdNotEqualTo(Long value) {
            addCriterion("product_trouble_sort_id <>", value, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdGreaterThan(Long value) {
            addCriterion("product_trouble_sort_id >", value, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_trouble_sort_id >=", value, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdLessThan(Long value) {
            addCriterion("product_trouble_sort_id <", value, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdLessThanOrEqualTo(Long value) {
            addCriterion("product_trouble_sort_id <=", value, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdIn(List<Long> values) {
            addCriterion("product_trouble_sort_id in", values, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdNotIn(List<Long> values) {
            addCriterion("product_trouble_sort_id not in", values, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdBetween(Long value1, Long value2) {
            addCriterion("product_trouble_sort_id between", value1, value2, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andProductTroubleSortIdNotBetween(Long value1, Long value2) {
            addCriterion("product_trouble_sort_id not between", value1, value2, "productTroubleSortId");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentIsNull() {
            addCriterion("workorder_content is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentIsNotNull() {
            addCriterion("workorder_content is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentEqualTo(String value) {
            addCriterion("workorder_content =", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentNotEqualTo(String value) {
            addCriterion("workorder_content <>", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentGreaterThan(String value) {
            addCriterion("workorder_content >", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentGreaterThanOrEqualTo(String value) {
            addCriterion("workorder_content >=", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentLessThan(String value) {
            addCriterion("workorder_content <", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentLessThanOrEqualTo(String value) {
            addCriterion("workorder_content <=", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentLike(String value) {
            addCriterion("workorder_content like", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentNotLike(String value) {
            addCriterion("workorder_content not like", value, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentIn(List<String> values) {
            addCriterion("workorder_content in", values, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentNotIn(List<String> values) {
            addCriterion("workorder_content not in", values, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentBetween(String value1, String value2) {
            addCriterion("workorder_content between", value1, value2, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentNotBetween(String value1, String value2) {
            addCriterion("workorder_content not between", value1, value2, "workorderContent");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Long value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Long value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Long value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Long value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Long value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Long> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Long> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Long value1, Long value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Long value1, Long value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonIsNull() {
            addCriterion("revoke_reason is null");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonIsNotNull() {
            addCriterion("revoke_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonEqualTo(String value) {
            addCriterion("revoke_reason =", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonNotEqualTo(String value) {
            addCriterion("revoke_reason <>", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonGreaterThan(String value) {
            addCriterion("revoke_reason >", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonGreaterThanOrEqualTo(String value) {
            addCriterion("revoke_reason >=", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonLessThan(String value) {
            addCriterion("revoke_reason <", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonLessThanOrEqualTo(String value) {
            addCriterion("revoke_reason <=", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonLike(String value) {
            addCriterion("revoke_reason like", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonNotLike(String value) {
            addCriterion("revoke_reason not like", value, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonIn(List<String> values) {
            addCriterion("revoke_reason in", values, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonNotIn(List<String> values) {
            addCriterion("revoke_reason not in", values, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonBetween(String value1, String value2) {
            addCriterion("revoke_reason between", value1, value2, "revokeReason");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonNotBetween(String value1, String value2) {
            addCriterion("revoke_reason not between", value1, value2, "revokeReason");
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

        public Criteria andAttentionStatusIsNull() {
            addCriterion("attention_status is null");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusIsNotNull() {
            addCriterion("attention_status is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusEqualTo(Long value) {
            addCriterion("attention_status =", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusNotEqualTo(Long value) {
            addCriterion("attention_status <>", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusGreaterThan(Long value) {
            addCriterion("attention_status >", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("attention_status >=", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusLessThan(Long value) {
            addCriterion("attention_status <", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusLessThanOrEqualTo(Long value) {
            addCriterion("attention_status <=", value, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusIn(List<Long> values) {
            addCriterion("attention_status in", values, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusNotIn(List<Long> values) {
            addCriterion("attention_status not in", values, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusBetween(Long value1, Long value2) {
            addCriterion("attention_status between", value1, value2, "attentionStatus");
            return (Criteria) this;
        }

        public Criteria andAttentionStatusNotBetween(Long value1, Long value2) {
            addCriterion("attention_status not between", value1, value2, "attentionStatus");
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

        public Criteria andTaskNameLikeInsensitive(String value) {
            addCriterion("upper(task_name) like", value.toUpperCase(), "taskName");
            return (Criteria) this;
        }

        public Criteria andWorkorderNumLikeInsensitive(String value) {
            addCriterion("upper(workorder_num) like", value.toUpperCase(), "workorderNum");
            return (Criteria) this;
        }

        public Criteria andMouldNameLikeInsensitive(String value) {
            addCriterion("upper(mould_name) like", value.toUpperCase(), "mouldName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLikeInsensitive(String value) {
            addCriterion("upper(person_name) like", value.toUpperCase(), "personName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLikeInsensitive(String value) {
            addCriterion("upper(customer_name) like", value.toUpperCase(), "customerName");
            return (Criteria) this;
        }

        public Criteria andContactNameLikeInsensitive(String value) {
            addCriterion("upper(contact_name) like", value.toUpperCase(), "contactName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLikeInsensitive(String value) {
            addCriterion("upper(business_name) like", value.toUpperCase(), "businessName");
            return (Criteria) this;
        }

        public Criteria andProductNameLikeInsensitive(String value) {
            addCriterion("upper(product_name) like", value.toUpperCase(), "productName");
            return (Criteria) this;
        }

        public Criteria andWorkorderContentLikeInsensitive(String value) {
            addCriterion("upper(workorder_content) like", value.toUpperCase(), "workorderContent");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andRevokeReasonLikeInsensitive(String value) {
            addCriterion("upper(revoke_reason) like", value.toUpperCase(), "revokeReason");
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
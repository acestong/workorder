package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDeliverProductModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskDeliverProductModelExample() {
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

        public Criteria andDeliverProductIdIsNull() {
            addCriterion("deliver_product_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdIsNotNull() {
            addCriterion("deliver_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdEqualTo(Long value) {
            addCriterion("deliver_product_id =", value, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdNotEqualTo(Long value) {
            addCriterion("deliver_product_id <>", value, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdGreaterThan(Long value) {
            addCriterion("deliver_product_id >", value, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deliver_product_id >=", value, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdLessThan(Long value) {
            addCriterion("deliver_product_id <", value, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdLessThanOrEqualTo(Long value) {
            addCriterion("deliver_product_id <=", value, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdIn(List<Long> values) {
            addCriterion("deliver_product_id in", values, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdNotIn(List<Long> values) {
            addCriterion("deliver_product_id not in", values, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdBetween(Long value1, Long value2) {
            addCriterion("deliver_product_id between", value1, value2, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductIdNotBetween(Long value1, Long value2) {
            addCriterion("deliver_product_id not between", value1, value2, "deliverProductId");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameIsNull() {
            addCriterion("deliver_product_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameIsNotNull() {
            addCriterion("deliver_product_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameEqualTo(String value) {
            addCriterion("deliver_product_name =", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameNotEqualTo(String value) {
            addCriterion("deliver_product_name <>", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameGreaterThan(String value) {
            addCriterion("deliver_product_name >", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_product_name >=", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameLessThan(String value) {
            addCriterion("deliver_product_name <", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameLessThanOrEqualTo(String value) {
            addCriterion("deliver_product_name <=", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameLike(String value) {
            addCriterion("deliver_product_name like", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameNotLike(String value) {
            addCriterion("deliver_product_name not like", value, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameIn(List<String> values) {
            addCriterion("deliver_product_name in", values, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameNotIn(List<String> values) {
            addCriterion("deliver_product_name not in", values, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameBetween(String value1, String value2) {
            addCriterion("deliver_product_name between", value1, value2, "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andDeliverProductNameNotBetween(String value1, String value2) {
            addCriterion("deliver_product_name not between", value1, value2, "deliverProductName");
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

        public Criteria andTaskDeliverTimeIsNull() {
            addCriterion("task_deliver_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeIsNotNull() {
            addCriterion("task_deliver_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeEqualTo(Date value) {
            addCriterion("task_deliver_time =", value, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeNotEqualTo(Date value) {
            addCriterion("task_deliver_time <>", value, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeGreaterThan(Date value) {
            addCriterion("task_deliver_time >", value, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_deliver_time >=", value, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeLessThan(Date value) {
            addCriterion("task_deliver_time <", value, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_deliver_time <=", value, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeIn(List<Date> values) {
            addCriterion("task_deliver_time in", values, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeNotIn(List<Date> values) {
            addCriterion("task_deliver_time not in", values, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeBetween(Date value1, Date value2) {
            addCriterion("task_deliver_time between", value1, value2, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_deliver_time not between", value1, value2, "taskDeliverTime");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdIsNull() {
            addCriterion("task_deliverer_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdIsNotNull() {
            addCriterion("task_deliverer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdEqualTo(Long value) {
            addCriterion("task_deliverer_id =", value, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdNotEqualTo(Long value) {
            addCriterion("task_deliverer_id <>", value, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdGreaterThan(Long value) {
            addCriterion("task_deliverer_id >", value, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_deliverer_id >=", value, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdLessThan(Long value) {
            addCriterion("task_deliverer_id <", value, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdLessThanOrEqualTo(Long value) {
            addCriterion("task_deliverer_id <=", value, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdIn(List<Long> values) {
            addCriterion("task_deliverer_id in", values, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdNotIn(List<Long> values) {
            addCriterion("task_deliverer_id not in", values, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdBetween(Long value1, Long value2) {
            addCriterion("task_deliverer_id between", value1, value2, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererIdNotBetween(Long value1, Long value2) {
            addCriterion("task_deliverer_id not between", value1, value2, "taskDelivererId");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameIsNull() {
            addCriterion("task_deliverer_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameIsNotNull() {
            addCriterion("task_deliverer_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameEqualTo(String value) {
            addCriterion("task_deliverer_name =", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameNotEqualTo(String value) {
            addCriterion("task_deliverer_name <>", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameGreaterThan(String value) {
            addCriterion("task_deliverer_name >", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_deliverer_name >=", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameLessThan(String value) {
            addCriterion("task_deliverer_name <", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameLessThanOrEqualTo(String value) {
            addCriterion("task_deliverer_name <=", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameLike(String value) {
            addCriterion("task_deliverer_name like", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameNotLike(String value) {
            addCriterion("task_deliverer_name not like", value, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameIn(List<String> values) {
            addCriterion("task_deliverer_name in", values, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameNotIn(List<String> values) {
            addCriterion("task_deliverer_name not in", values, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameBetween(String value1, String value2) {
            addCriterion("task_deliverer_name between", value1, value2, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameNotBetween(String value1, String value2) {
            addCriterion("task_deliverer_name not between", value1, value2, "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusIsNull() {
            addCriterion("task_deliver_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusIsNotNull() {
            addCriterion("task_deliver_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusEqualTo(Long value) {
            addCriterion("task_deliver_status =", value, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusNotEqualTo(Long value) {
            addCriterion("task_deliver_status <>", value, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusGreaterThan(Long value) {
            addCriterion("task_deliver_status >", value, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("task_deliver_status >=", value, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusLessThan(Long value) {
            addCriterion("task_deliver_status <", value, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusLessThanOrEqualTo(Long value) {
            addCriterion("task_deliver_status <=", value, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusIn(List<Long> values) {
            addCriterion("task_deliver_status in", values, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusNotIn(List<Long> values) {
            addCriterion("task_deliver_status not in", values, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusBetween(Long value1, Long value2) {
            addCriterion("task_deliver_status between", value1, value2, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andTaskDeliverStatusNotBetween(Long value1, Long value2) {
            addCriterion("task_deliver_status not between", value1, value2, "taskDeliverStatus");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreIsNull() {
            addCriterion("deliver_check_score is null");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreIsNotNull() {
            addCriterion("deliver_check_score is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreEqualTo(Long value) {
            addCriterion("deliver_check_score =", value, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreNotEqualTo(Long value) {
            addCriterion("deliver_check_score <>", value, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreGreaterThan(Long value) {
            addCriterion("deliver_check_score >", value, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("deliver_check_score >=", value, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreLessThan(Long value) {
            addCriterion("deliver_check_score <", value, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreLessThanOrEqualTo(Long value) {
            addCriterion("deliver_check_score <=", value, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreIn(List<Long> values) {
            addCriterion("deliver_check_score in", values, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreNotIn(List<Long> values) {
            addCriterion("deliver_check_score not in", values, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreBetween(Long value1, Long value2) {
            addCriterion("deliver_check_score between", value1, value2, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckScoreNotBetween(Long value1, Long value2) {
            addCriterion("deliver_check_score not between", value1, value2, "deliverCheckScore");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdIsNull() {
            addCriterion("deliver_checker_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdIsNotNull() {
            addCriterion("deliver_checker_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdEqualTo(Long value) {
            addCriterion("deliver_checker_id =", value, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdNotEqualTo(Long value) {
            addCriterion("deliver_checker_id <>", value, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdGreaterThan(Long value) {
            addCriterion("deliver_checker_id >", value, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deliver_checker_id >=", value, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdLessThan(Long value) {
            addCriterion("deliver_checker_id <", value, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdLessThanOrEqualTo(Long value) {
            addCriterion("deliver_checker_id <=", value, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdIn(List<Long> values) {
            addCriterion("deliver_checker_id in", values, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdNotIn(List<Long> values) {
            addCriterion("deliver_checker_id not in", values, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdBetween(Long value1, Long value2) {
            addCriterion("deliver_checker_id between", value1, value2, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerIdNotBetween(Long value1, Long value2) {
            addCriterion("deliver_checker_id not between", value1, value2, "deliverCheckerId");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameIsNull() {
            addCriterion("deliver_checker_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameIsNotNull() {
            addCriterion("deliver_checker_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameEqualTo(String value) {
            addCriterion("deliver_checker_name =", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameNotEqualTo(String value) {
            addCriterion("deliver_checker_name <>", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameGreaterThan(String value) {
            addCriterion("deliver_checker_name >", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_checker_name >=", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameLessThan(String value) {
            addCriterion("deliver_checker_name <", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameLessThanOrEqualTo(String value) {
            addCriterion("deliver_checker_name <=", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameLike(String value) {
            addCriterion("deliver_checker_name like", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameNotLike(String value) {
            addCriterion("deliver_checker_name not like", value, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameIn(List<String> values) {
            addCriterion("deliver_checker_name in", values, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameNotIn(List<String> values) {
            addCriterion("deliver_checker_name not in", values, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameBetween(String value1, String value2) {
            addCriterion("deliver_checker_name between", value1, value2, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameNotBetween(String value1, String value2) {
            addCriterion("deliver_checker_name not between", value1, value2, "deliverCheckerName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeIsNull() {
            addCriterion("delivery_check_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeIsNotNull() {
            addCriterion("delivery_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeEqualTo(Date value) {
            addCriterion("delivery_check_time =", value, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeNotEqualTo(Date value) {
            addCriterion("delivery_check_time <>", value, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeGreaterThan(Date value) {
            addCriterion("delivery_check_time >", value, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_check_time >=", value, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeLessThan(Date value) {
            addCriterion("delivery_check_time <", value, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_check_time <=", value, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeIn(List<Date> values) {
            addCriterion("delivery_check_time in", values, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeNotIn(List<Date> values) {
            addCriterion("delivery_check_time not in", values, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_check_time between", value1, value2, "deliveryCheckTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_check_time not between", value1, value2, "deliveryCheckTime");
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

        public Criteria andDeliverProductNameLikeInsensitive(String value) {
            addCriterion("upper(deliver_product_name) like", value.toUpperCase(), "deliverProductName");
            return (Criteria) this;
        }

        public Criteria andTaskDelivererNameLikeInsensitive(String value) {
            addCriterion("upper(task_deliverer_name) like", value.toUpperCase(), "taskDelivererName");
            return (Criteria) this;
        }

        public Criteria andDeliverCheckerNameLikeInsensitive(String value) {
            addCriterion("upper(deliver_checker_name) like", value.toUpperCase(), "deliverCheckerName");
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
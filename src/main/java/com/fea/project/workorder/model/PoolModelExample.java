package com.fea.project.workorder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PoolModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoolModelExample() {
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

        public Criteria andWorkorderPoolIdIsNull() {
            addCriterion("workorder_pool_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdIsNotNull() {
            addCriterion("workorder_pool_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdEqualTo(Long value) {
            addCriterion("workorder_pool_id =", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdNotEqualTo(Long value) {
            addCriterion("workorder_pool_id <>", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdGreaterThan(Long value) {
            addCriterion("workorder_pool_id >", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_pool_id >=", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdLessThan(Long value) {
            addCriterion("workorder_pool_id <", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdLessThanOrEqualTo(Long value) {
            addCriterion("workorder_pool_id <=", value, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdIn(List<Long> values) {
            addCriterion("workorder_pool_id in", values, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdNotIn(List<Long> values) {
            addCriterion("workorder_pool_id not in", values, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdBetween(Long value1, Long value2) {
            addCriterion("workorder_pool_id between", value1, value2, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andWorkorderPoolIdNotBetween(Long value1, Long value2) {
            addCriterion("workorder_pool_id not between", value1, value2, "workorderPoolId");
            return (Criteria) this;
        }

        public Criteria andPoolNameIsNull() {
            addCriterion("pool_name is null");
            return (Criteria) this;
        }

        public Criteria andPoolNameIsNotNull() {
            addCriterion("pool_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoolNameEqualTo(String value) {
            addCriterion("pool_name =", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotEqualTo(String value) {
            addCriterion("pool_name <>", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameGreaterThan(String value) {
            addCriterion("pool_name >", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("pool_name >=", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameLessThan(String value) {
            addCriterion("pool_name <", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameLessThanOrEqualTo(String value) {
            addCriterion("pool_name <=", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameLike(String value) {
            addCriterion("pool_name like", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotLike(String value) {
            addCriterion("pool_name not like", value, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameIn(List<String> values) {
            addCriterion("pool_name in", values, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotIn(List<String> values) {
            addCriterion("pool_name not in", values, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameBetween(String value1, String value2) {
            addCriterion("pool_name between", value1, value2, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolNameNotBetween(String value1, String value2) {
            addCriterion("pool_name not between", value1, value2, "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolDescIsNull() {
            addCriterion("pool_desc is null");
            return (Criteria) this;
        }

        public Criteria andPoolDescIsNotNull() {
            addCriterion("pool_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPoolDescEqualTo(String value) {
            addCriterion("pool_desc =", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescNotEqualTo(String value) {
            addCriterion("pool_desc <>", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescGreaterThan(String value) {
            addCriterion("pool_desc >", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescGreaterThanOrEqualTo(String value) {
            addCriterion("pool_desc >=", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescLessThan(String value) {
            addCriterion("pool_desc <", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescLessThanOrEqualTo(String value) {
            addCriterion("pool_desc <=", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescLike(String value) {
            addCriterion("pool_desc like", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescNotLike(String value) {
            addCriterion("pool_desc not like", value, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescIn(List<String> values) {
            addCriterion("pool_desc in", values, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescNotIn(List<String> values) {
            addCriterion("pool_desc not in", values, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescBetween(String value1, String value2) {
            addCriterion("pool_desc between", value1, value2, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolDescNotBetween(String value1, String value2) {
            addCriterion("pool_desc not between", value1, value2, "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdIsNull() {
            addCriterion("pool_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdIsNotNull() {
            addCriterion("pool_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdEqualTo(Long value) {
            addCriterion("pool_manager_id =", value, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdNotEqualTo(Long value) {
            addCriterion("pool_manager_id <>", value, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdGreaterThan(Long value) {
            addCriterion("pool_manager_id >", value, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pool_manager_id >=", value, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdLessThan(Long value) {
            addCriterion("pool_manager_id <", value, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdLessThanOrEqualTo(Long value) {
            addCriterion("pool_manager_id <=", value, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdIn(List<Long> values) {
            addCriterion("pool_manager_id in", values, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdNotIn(List<Long> values) {
            addCriterion("pool_manager_id not in", values, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdBetween(Long value1, Long value2) {
            addCriterion("pool_manager_id between", value1, value2, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerIdNotBetween(Long value1, Long value2) {
            addCriterion("pool_manager_id not between", value1, value2, "poolManagerId");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameIsNull() {
            addCriterion("pool_manager_name is null");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameIsNotNull() {
            addCriterion("pool_manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameEqualTo(String value) {
            addCriterion("pool_manager_name =", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameNotEqualTo(String value) {
            addCriterion("pool_manager_name <>", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameGreaterThan(String value) {
            addCriterion("pool_manager_name >", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("pool_manager_name >=", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameLessThan(String value) {
            addCriterion("pool_manager_name <", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameLessThanOrEqualTo(String value) {
            addCriterion("pool_manager_name <=", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameLike(String value) {
            addCriterion("pool_manager_name like", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameNotLike(String value) {
            addCriterion("pool_manager_name not like", value, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameIn(List<String> values) {
            addCriterion("pool_manager_name in", values, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameNotIn(List<String> values) {
            addCriterion("pool_manager_name not in", values, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameBetween(String value1, String value2) {
            addCriterion("pool_manager_name between", value1, value2, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameNotBetween(String value1, String value2) {
            addCriterion("pool_manager_name not between", value1, value2, "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchIsNull() {
            addCriterion("is_auto_dispatch is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchIsNotNull() {
            addCriterion("is_auto_dispatch is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchEqualTo(Long value) {
            addCriterion("is_auto_dispatch =", value, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchNotEqualTo(Long value) {
            addCriterion("is_auto_dispatch <>", value, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchGreaterThan(Long value) {
            addCriterion("is_auto_dispatch >", value, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchGreaterThanOrEqualTo(Long value) {
            addCriterion("is_auto_dispatch >=", value, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchLessThan(Long value) {
            addCriterion("is_auto_dispatch <", value, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchLessThanOrEqualTo(Long value) {
            addCriterion("is_auto_dispatch <=", value, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchIn(List<Long> values) {
            addCriterion("is_auto_dispatch in", values, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchNotIn(List<Long> values) {
            addCriterion("is_auto_dispatch not in", values, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchBetween(Long value1, Long value2) {
            addCriterion("is_auto_dispatch between", value1, value2, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andIsAutoDispatchNotBetween(Long value1, Long value2) {
            addCriterion("is_auto_dispatch not between", value1, value2, "isAutoDispatch");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeIsNull() {
            addCriterion("workorder_selection_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeIsNotNull() {
            addCriterion("workorder_selection_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeEqualTo(Long value) {
            addCriterion("workorder_selection_type =", value, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeNotEqualTo(Long value) {
            addCriterion("workorder_selection_type <>", value, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeGreaterThan(Long value) {
            addCriterion("workorder_selection_type >", value, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("workorder_selection_type >=", value, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeLessThan(Long value) {
            addCriterion("workorder_selection_type <", value, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeLessThanOrEqualTo(Long value) {
            addCriterion("workorder_selection_type <=", value, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeIn(List<Long> values) {
            addCriterion("workorder_selection_type in", values, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeNotIn(List<Long> values) {
            addCriterion("workorder_selection_type not in", values, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeBetween(Long value1, Long value2) {
            addCriterion("workorder_selection_type between", value1, value2, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andWorkorderSelectionTypeNotBetween(Long value1, Long value2) {
            addCriterion("workorder_selection_type not between", value1, value2, "workorderSelectionType");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleIsNull() {
            addCriterion("auto_dispatch_rule is null");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleIsNotNull() {
            addCriterion("auto_dispatch_rule is not null");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleEqualTo(Long value) {
            addCriterion("auto_dispatch_rule =", value, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleNotEqualTo(Long value) {
            addCriterion("auto_dispatch_rule <>", value, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleGreaterThan(Long value) {
            addCriterion("auto_dispatch_rule >", value, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleGreaterThanOrEqualTo(Long value) {
            addCriterion("auto_dispatch_rule >=", value, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleLessThan(Long value) {
            addCriterion("auto_dispatch_rule <", value, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleLessThanOrEqualTo(Long value) {
            addCriterion("auto_dispatch_rule <=", value, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleIn(List<Long> values) {
            addCriterion("auto_dispatch_rule in", values, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleNotIn(List<Long> values) {
            addCriterion("auto_dispatch_rule not in", values, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleBetween(Long value1, Long value2) {
            addCriterion("auto_dispatch_rule between", value1, value2, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andAutoDispatchRuleNotBetween(Long value1, Long value2) {
            addCriterion("auto_dispatch_rule not between", value1, value2, "autoDispatchRule");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNull() {
            addCriterion("is_remind is null");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNotNull() {
            addCriterion("is_remind is not null");
            return (Criteria) this;
        }

        public Criteria andIsRemindEqualTo(Long value) {
            addCriterion("is_remind =", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotEqualTo(Long value) {
            addCriterion("is_remind <>", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThan(Long value) {
            addCriterion("is_remind >", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThanOrEqualTo(Long value) {
            addCriterion("is_remind >=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThan(Long value) {
            addCriterion("is_remind <", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThanOrEqualTo(Long value) {
            addCriterion("is_remind <=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindIn(List<Long> values) {
            addCriterion("is_remind in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotIn(List<Long> values) {
            addCriterion("is_remind not in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindBetween(Long value1, Long value2) {
            addCriterion("is_remind between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotBetween(Long value1, Long value2) {
            addCriterion("is_remind not between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andRemindCountIsNull() {
            addCriterion("remind_count is null");
            return (Criteria) this;
        }

        public Criteria andRemindCountIsNotNull() {
            addCriterion("remind_count is not null");
            return (Criteria) this;
        }

        public Criteria andRemindCountEqualTo(Double value) {
            addCriterion("remind_count =", value, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountNotEqualTo(Double value) {
            addCriterion("remind_count <>", value, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountGreaterThan(Double value) {
            addCriterion("remind_count >", value, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountGreaterThanOrEqualTo(Double value) {
            addCriterion("remind_count >=", value, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountLessThan(Double value) {
            addCriterion("remind_count <", value, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountLessThanOrEqualTo(Double value) {
            addCriterion("remind_count <=", value, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountIn(List<Double> values) {
            addCriterion("remind_count in", values, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountNotIn(List<Double> values) {
            addCriterion("remind_count not in", values, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountBetween(Double value1, Double value2) {
            addCriterion("remind_count between", value1, value2, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindCountNotBetween(Double value1, Double value2) {
            addCriterion("remind_count not between", value1, value2, "remindCount");
            return (Criteria) this;
        }

        public Criteria andRemindUnitIsNull() {
            addCriterion("remind_unit is null");
            return (Criteria) this;
        }

        public Criteria andRemindUnitIsNotNull() {
            addCriterion("remind_unit is not null");
            return (Criteria) this;
        }

        public Criteria andRemindUnitEqualTo(String value) {
            addCriterion("remind_unit =", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitNotEqualTo(String value) {
            addCriterion("remind_unit <>", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitGreaterThan(String value) {
            addCriterion("remind_unit >", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitGreaterThanOrEqualTo(String value) {
            addCriterion("remind_unit >=", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitLessThan(String value) {
            addCriterion("remind_unit <", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitLessThanOrEqualTo(String value) {
            addCriterion("remind_unit <=", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitLike(String value) {
            addCriterion("remind_unit like", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitNotLike(String value) {
            addCriterion("remind_unit not like", value, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitIn(List<String> values) {
            addCriterion("remind_unit in", values, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitNotIn(List<String> values) {
            addCriterion("remind_unit not in", values, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitBetween(String value1, String value2) {
            addCriterion("remind_unit between", value1, value2, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindUnitNotBetween(String value1, String value2) {
            addCriterion("remind_unit not between", value1, value2, "remindUnit");
            return (Criteria) this;
        }

        public Criteria andRemindIdIsNull() {
            addCriterion("remind_id is null");
            return (Criteria) this;
        }

        public Criteria andRemindIdIsNotNull() {
            addCriterion("remind_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemindIdEqualTo(Long value) {
            addCriterion("remind_id =", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotEqualTo(Long value) {
            addCriterion("remind_id <>", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdGreaterThan(Long value) {
            addCriterion("remind_id >", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdGreaterThanOrEqualTo(Long value) {
            addCriterion("remind_id >=", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdLessThan(Long value) {
            addCriterion("remind_id <", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdLessThanOrEqualTo(Long value) {
            addCriterion("remind_id <=", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdIn(List<Long> values) {
            addCriterion("remind_id in", values, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotIn(List<Long> values) {
            addCriterion("remind_id not in", values, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdBetween(Long value1, Long value2) {
            addCriterion("remind_id between", value1, value2, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotBetween(Long value1, Long value2) {
            addCriterion("remind_id not between", value1, value2, "remindId");
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

        public Criteria andPoolNameLikeInsensitive(String value) {
            addCriterion("upper(pool_name) like", value.toUpperCase(), "poolName");
            return (Criteria) this;
        }

        public Criteria andPoolDescLikeInsensitive(String value) {
            addCriterion("upper(pool_desc) like", value.toUpperCase(), "poolDesc");
            return (Criteria) this;
        }

        public Criteria andPoolManagerNameLikeInsensitive(String value) {
            addCriterion("upper(pool_manager_name) like", value.toUpperCase(), "poolManagerName");
            return (Criteria) this;
        }

        public Criteria andRemindUnitLikeInsensitive(String value) {
            addCriterion("upper(remind_unit) like", value.toUpperCase(), "remindUnit");
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
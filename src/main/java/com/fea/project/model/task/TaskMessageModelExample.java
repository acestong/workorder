package com.fea.project.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMessageModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskMessageModelExample() {
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

        public Criteria andTaskMessageIdIsNull() {
            addCriterion("task_message_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdIsNotNull() {
            addCriterion("task_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdEqualTo(Long value) {
            addCriterion("task_message_id =", value, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdNotEqualTo(Long value) {
            addCriterion("task_message_id <>", value, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdGreaterThan(Long value) {
            addCriterion("task_message_id >", value, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_message_id >=", value, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdLessThan(Long value) {
            addCriterion("task_message_id <", value, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("task_message_id <=", value, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdIn(List<Long> values) {
            addCriterion("task_message_id in", values, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdNotIn(List<Long> values) {
            addCriterion("task_message_id not in", values, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdBetween(Long value1, Long value2) {
            addCriterion("task_message_id between", value1, value2, "taskMessageId");
            return (Criteria) this;
        }

        public Criteria andTaskMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("task_message_id not between", value1, value2, "taskMessageId");
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

        public Criteria andMessageSenderIdIsNull() {
            addCriterion("message_sender_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdIsNotNull() {
            addCriterion("message_sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdEqualTo(Long value) {
            addCriterion("message_sender_id =", value, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdNotEqualTo(Long value) {
            addCriterion("message_sender_id <>", value, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdGreaterThan(Long value) {
            addCriterion("message_sender_id >", value, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("message_sender_id >=", value, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdLessThan(Long value) {
            addCriterion("message_sender_id <", value, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdLessThanOrEqualTo(Long value) {
            addCriterion("message_sender_id <=", value, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdIn(List<Long> values) {
            addCriterion("message_sender_id in", values, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdNotIn(List<Long> values) {
            addCriterion("message_sender_id not in", values, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdBetween(Long value1, Long value2) {
            addCriterion("message_sender_id between", value1, value2, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIdNotBetween(Long value1, Long value2) {
            addCriterion("message_sender_id not between", value1, value2, "messageSenderId");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameIsNull() {
            addCriterion("message_sender_name is null");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameIsNotNull() {
            addCriterion("message_sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameEqualTo(String value) {
            addCriterion("message_sender_name =", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameNotEqualTo(String value) {
            addCriterion("message_sender_name <>", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameGreaterThan(String value) {
            addCriterion("message_sender_name >", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("message_sender_name >=", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameLessThan(String value) {
            addCriterion("message_sender_name <", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameLessThanOrEqualTo(String value) {
            addCriterion("message_sender_name <=", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameLike(String value) {
            addCriterion("message_sender_name like", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameNotLike(String value) {
            addCriterion("message_sender_name not like", value, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameIn(List<String> values) {
            addCriterion("message_sender_name in", values, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameNotIn(List<String> values) {
            addCriterion("message_sender_name not in", values, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameBetween(String value1, String value2) {
            addCriterion("message_sender_name between", value1, value2, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNameNotBetween(String value1, String value2) {
            addCriterion("message_sender_name not between", value1, value2, "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNull() {
            addCriterion("message_content is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("message_content is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("message_content =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("message_content <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("message_content >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("message_content >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("message_content <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("message_content <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("message_content like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("message_content not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("message_content in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("message_content not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("message_content between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("message_content not between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeIsNull() {
            addCriterion("message_send_time is null");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeIsNotNull() {
            addCriterion("message_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeEqualTo(Date value) {
            addCriterion("message_send_time =", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeNotEqualTo(Date value) {
            addCriterion("message_send_time <>", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeGreaterThan(Date value) {
            addCriterion("message_send_time >", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("message_send_time >=", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeLessThan(Date value) {
            addCriterion("message_send_time <", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("message_send_time <=", value, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeIn(List<Date> values) {
            addCriterion("message_send_time in", values, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeNotIn(List<Date> values) {
            addCriterion("message_send_time not in", values, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeBetween(Date value1, Date value2) {
            addCriterion("message_send_time between", value1, value2, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("message_send_time not between", value1, value2, "messageSendTime");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdIsNull() {
            addCriterion("message_receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdIsNotNull() {
            addCriterion("message_receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdEqualTo(Long value) {
            addCriterion("message_receiver_id =", value, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdNotEqualTo(Long value) {
            addCriterion("message_receiver_id <>", value, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdGreaterThan(Long value) {
            addCriterion("message_receiver_id >", value, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("message_receiver_id >=", value, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdLessThan(Long value) {
            addCriterion("message_receiver_id <", value, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdLessThanOrEqualTo(Long value) {
            addCriterion("message_receiver_id <=", value, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdIn(List<Long> values) {
            addCriterion("message_receiver_id in", values, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdNotIn(List<Long> values) {
            addCriterion("message_receiver_id not in", values, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdBetween(Long value1, Long value2) {
            addCriterion("message_receiver_id between", value1, value2, "messageReceiverId");
            return (Criteria) this;
        }

        public Criteria andMessageReceiverIdNotBetween(Long value1, Long value2) {
            addCriterion("message_receiver_id not between", value1, value2, "messageReceiverId");
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

        public Criteria andMessageSenderNameLikeInsensitive(String value) {
            addCriterion("upper(message_sender_name) like", value.toUpperCase(), "messageSenderName");
            return (Criteria) this;
        }

        public Criteria andMessageContentLikeInsensitive(String value) {
            addCriterion("upper(message_content) like", value.toUpperCase(), "messageContent");
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
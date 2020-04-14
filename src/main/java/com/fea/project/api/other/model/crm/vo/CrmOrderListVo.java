package com.fea.project.api.other.model.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/9/11 9:59
 **/
@Builder
public class CrmOrderListVo implements IProjectBusinessModel {
    /**
     * 订单id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    /**
     * 订单编号(自动生成)
     */
    private String num;

    /**
     * 订单名称/订单标题
     */
    private String title;

    /**
     * 订单来源
     */
    private String sources;

    /**
     * 订单金额=含税总额
     */
    private BigDecimal money;
    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 订单状态(0-未开始 1-执行中 2-已完成)
     */
    private String status;
    /**
     * 客户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long customId;

    /**
     * 客户名称
     */
    private String customName;
    /**
     * 合同Id（客户下的合同)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long contractId;
    /**
     * 合同（客户下的合同)
     */
    private String contractName;
    /**
     * 负责销售
     */
    private String chargeSale;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 回款状态
     */
    private String paymentStatue;
    /**
     * 审核状态(0-未审核1--审核中 2-审核通过 3-驳回)
     */
    private String checkStatus;
    /**
     * 订单总金额
     */
    private BigDecimal totalMoney;
    /**
     * 币种
     */
    private String currency;
    /**
     * 下单时间
     */
    private Date orderTime;


    /**
     * 预计交货期
     */
    private Date planDelivery;
    /**
     * 主要联系人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long linkmanId;
    private String linkman;
    private String phone;
    private String place;
    /**
     * 收货人姓名
     */
    private String consignee;

    /**
     * 收货人电话
     */
    private String consigneePhone;

    /**
     * 收货人地址
     */
    private String consigneePlace;
    /**
     * 备注
     */
    private String remark;

    public CrmOrderListVo() {
    }

    public CrmOrderListVo(Long id, String num, String title, String sources, BigDecimal money, String orderType, String status, Long customId, String customName, Long contractId, String contractName, String chargeSale, String createdBy, Date createTime, String updatedBy, Date updateTime, String paymentStatue, String checkStatus, BigDecimal totalMoney, String currency, Date orderTime, Date planDelivery, Long linkmanId, String linkman, String phone, String place, String consignee, String consigneePhone, String consigneePlace, String remark) {
        this.id = id;
        this.num = num;
        this.title = title;
        this.sources = sources;
        this.money = money;
        this.orderType = orderType;
        this.status = status;
        this.customId = customId;
        this.customName = customName;
        this.contractId = contractId;
        this.contractName = contractName;
        this.chargeSale = chargeSale;
        this.createdBy = createdBy;
        this.createTime = createTime;
        this.updatedBy = updatedBy;
        this.updateTime = updateTime;
        this.paymentStatue = paymentStatue;
        this.checkStatus = checkStatus;
        this.totalMoney = totalMoney;
        this.currency = currency;
        this.orderTime = orderTime;
        this.planDelivery = planDelivery;
        this.linkmanId = linkmanId;
        this.linkman = linkman;
        this.phone = phone;
        this.place = place;
        this.consignee = consignee;
        this.consigneePhone = consigneePhone;
        this.consigneePlace = consigneePlace;
        this.remark = remark;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPlanDelivery() {
        return planDelivery;
    }

    public void setPlanDelivery(Date planDelivery) {
        this.planDelivery = planDelivery;
    }

    public Long getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(Long linkmanId) {
        this.linkmanId = linkmanId;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneePlace() {
        return consigneePlace;
    }

    public void setConsigneePlace(String consigneePlace) {
        this.consigneePlace = consigneePlace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPaymentStatue() {
        return paymentStatue;
    }

    public void setPaymentStatue(String paymentStatue) {
        this.paymentStatue = paymentStatue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }


    public String getChargeSale() {
        return chargeSale;
    }

    public void setChargeSale(String chargeSale) {
        this.chargeSale = chargeSale;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getShowName() {
        return title;
    }
}

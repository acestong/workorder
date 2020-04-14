package com.fea.project.model.feebudget;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/18.
 * 记账管理模块表 实体类
 */
@Builder
public class TallyModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long reimburseId;

    /**
     * 记账编码
     */
    private String tallyCode;

    /**
     * 记账分类
     */
    private Byte tallyType;

    /**
     * 费用类型id
     */
    private Long cateId;

    /**
     * 
     */
    private String cateName;

    /**
     * 费用类型字符串
     */
    private String cateStr;

    /**
     * 记账金额
     */
    private Double money;

    /**
     * 币种id
     */
    private Long currencyId;

    /**
     * 币种
     */
    private String currencyName;

    /**
     * 费用发生日期
     */
    private Date happenTime;

    /**
     * 费用发生地点
     */
    private String happenPlace;

    /**
     * 关联单据
     */
    private Byte relatedBill;

    /**
     * 关联单据id
     */
    private Long billId;

    /**
     * 关联单据名称
     */
    private String billName;

    /**
     * 记账行程类型：1交通、2住宿、3宴请、4外部会议、5拜访
     */
    private Byte travelType;

    /**
     * 行程id
     */
    private Long travelId;

    /**
     * 行程名称
     */
    private String travelName;

    /**
     * 
     */
    private String purpose;

    /**
     * 费用归属者类型：0个人，1部门
     */
    private Byte ownerType;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户联系人ids
     */
    private String contactIds;

    /**
     * 客户联系人名称
     */
    private String contacts;

    /**
     * 业务类型
     */
    private Byte businessType;

    /**
     * 业务id
     */
    private Long businessId;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 是否有发票,1是，0否
     */
    private Byte hasTicket;

    /**
     * 发票数量
     */
    private Integer ticketNum;

    /**
     * 发票说明
     */
    private String ticketRemark;

    /**
     * 
     */
    private Long regId;

    /**
     * 
     */
    private Long orgId;

    /**
     * 记账状态：0，未报销，1已报销
     */
    private Byte state;

    /**
     * 是否删除，0否，1是
     */
    private Byte delState;

    /**
     * 
     */
    private Long createUserId;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Long updateUserId;

    /**
     * 
     */
    private String updateUser;

    /**
     * 
     */
    private Date updateTime;

    public TallyModel (Long id, Long reimburseId, String tallyCode, Byte tallyType, Long cateId, String cateName, String cateStr, Double money, Long currencyId, String currencyName, Date happenTime, String happenPlace, Byte relatedBill, Long billId, String billName, Byte travelType, Long travelId, String travelName, String purpose, Byte ownerType, Long customerId, String customerName, String contactIds, String contacts, Byte businessType, Long businessId, String businessName, Byte hasTicket, Integer ticketNum, String ticketRemark, Long regId, Long orgId, Byte state, Byte delState, Long createUserId, String createUser, Date createTime, Long updateUserId, String updateUser, Date updateTime) {
        this.id = id;
        this.reimburseId = reimburseId;
        this.tallyCode = tallyCode;
        this.tallyType = tallyType;
        this.cateId = cateId;
        this.cateName = cateName;
        this.cateStr = cateStr;
        this.money = money;
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.happenTime = happenTime;
        this.happenPlace = happenPlace;
        this.relatedBill = relatedBill;
        this.billId = billId;
        this.billName = billName;
        this.travelType = travelType;
        this.travelId = travelId;
        this.travelName = travelName;
        this.purpose = purpose;
        this.ownerType = ownerType;
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactIds = contactIds;
        this.contacts = contacts;
        this.businessType = businessType;
        this.businessId = businessId;
        this.businessName = businessName;
        this.hasTicket = hasTicket;
        this.ticketNum = ticketNum;
        this.ticketRemark = ticketRemark;
        this.regId = regId;
        this.orgId = orgId;
        this.state = state;
        this.delState = delState;
        this.createUserId = createUserId;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUserId = updateUserId;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public TallyModel () {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReimburseId() {
        return reimburseId;
    }

    public void setReimburseId(Long reimburseId) {
        this.reimburseId = reimburseId;
    }

    public String getTallyCode() {
        return tallyCode;
    }

    public void setTallyCode(String tallyCode) {
        this.tallyCode = tallyCode == null ? null : tallyCode.trim();
    }

    public Byte getTallyType() {
        return tallyType;
    }

    public void setTallyType(Byte tallyType) {
        this.tallyType = tallyType;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public String getCateStr() {
        return cateStr;
    }

    public void setCateStr(String cateStr) {
        this.cateStr = cateStr == null ? null : cateStr.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName == null ? null : currencyName.trim();
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    public String getHappenPlace() {
        return happenPlace;
    }

    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace == null ? null : happenPlace.trim();
    }

    public Byte getRelatedBill() {
        return relatedBill;
    }

    public void setRelatedBill(Byte relatedBill) {
        this.relatedBill = relatedBill;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    public Byte getTravelType() {
        return travelType;
    }

    public void setTravelType(Byte travelType) {
        this.travelType = travelType;
    }

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName == null ? null : travelName.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Byte getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Byte ownerType) {
        this.ownerType = ownerType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getContactIds() {
        return contactIds;
    }

    public void setContactIds(String contactIds) {
        this.contactIds = contactIds == null ? null : contactIds.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public Byte getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(Byte hasTicket) {
        this.hasTicket = hasTicket;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTicketRemark() {
        return ticketRemark;
    }

    public void setTicketRemark(String ticketRemark) {
        this.ticketRemark = ticketRemark == null ? null : ticketRemark.trim();
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getDelState() {
        return delState;
    }

    public void setDelState(Byte delState) {
        this.delState = delState;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reimburseId=").append(reimburseId);
        sb.append(", tallyCode=").append(tallyCode);
        sb.append(", tallyType=").append(tallyType);
        sb.append(", cateId=").append(cateId);
        sb.append(", cateName=").append(cateName);
        sb.append(", cateStr=").append(cateStr);
        sb.append(", money=").append(money);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", currencyName=").append(currencyName);
        sb.append(", happenTime=").append(happenTime);
        sb.append(", happenPlace=").append(happenPlace);
        sb.append(", relatedBill=").append(relatedBill);
        sb.append(", billId=").append(billId);
        sb.append(", billName=").append(billName);
        sb.append(", travelType=").append(travelType);
        sb.append(", travelId=").append(travelId);
        sb.append(", travelName=").append(travelName);
        sb.append(", purpose=").append(purpose);
        sb.append(", ownerType=").append(ownerType);
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", contactIds=").append(contactIds);
        sb.append(", contacts=").append(contacts);
        sb.append(", businessType=").append(businessType);
        sb.append(", businessId=").append(businessId);
        sb.append(", businessName=").append(businessName);
        sb.append(", hasTicket=").append(hasTicket);
        sb.append(", ticketNum=").append(ticketNum);
        sb.append(", ticketRemark=").append(ticketRemark);
        sb.append(", regId=").append(regId);
        sb.append(", orgId=").append(orgId);
        sb.append(", state=").append(state);
        sb.append(", delState=").append(delState);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TallyModel other = (TallyModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReimburseId() == null ? other.getReimburseId() == null : this.getReimburseId().equals(other.getReimburseId()))
            && (this.getTallyCode() == null ? other.getTallyCode() == null : this.getTallyCode().equals(other.getTallyCode()))
            && (this.getTallyType() == null ? other.getTallyType() == null : this.getTallyType().equals(other.getTallyType()))
            && (this.getCateId() == null ? other.getCateId() == null : this.getCateId().equals(other.getCateId()))
            && (this.getCateName() == null ? other.getCateName() == null : this.getCateName().equals(other.getCateName()))
            && (this.getCateStr() == null ? other.getCateStr() == null : this.getCateStr().equals(other.getCateStr()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getCurrencyId() == null ? other.getCurrencyId() == null : this.getCurrencyId().equals(other.getCurrencyId()))
            && (this.getCurrencyName() == null ? other.getCurrencyName() == null : this.getCurrencyName().equals(other.getCurrencyName()))
            && (this.getHappenTime() == null ? other.getHappenTime() == null : this.getHappenTime().equals(other.getHappenTime()))
            && (this.getHappenPlace() == null ? other.getHappenPlace() == null : this.getHappenPlace().equals(other.getHappenPlace()))
            && (this.getRelatedBill() == null ? other.getRelatedBill() == null : this.getRelatedBill().equals(other.getRelatedBill()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillName() == null ? other.getBillName() == null : this.getBillName().equals(other.getBillName()))
            && (this.getTravelType() == null ? other.getTravelType() == null : this.getTravelType().equals(other.getTravelType()))
            && (this.getTravelId() == null ? other.getTravelId() == null : this.getTravelId().equals(other.getTravelId()))
            && (this.getTravelName() == null ? other.getTravelName() == null : this.getTravelName().equals(other.getTravelName()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getOwnerType() == null ? other.getOwnerType() == null : this.getOwnerType().equals(other.getOwnerType()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getContactIds() == null ? other.getContactIds() == null : this.getContactIds().equals(other.getContactIds()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getBusinessName() == null ? other.getBusinessName() == null : this.getBusinessName().equals(other.getBusinessName()))
            && (this.getHasTicket() == null ? other.getHasTicket() == null : this.getHasTicket().equals(other.getHasTicket()))
            && (this.getTicketNum() == null ? other.getTicketNum() == null : this.getTicketNum().equals(other.getTicketNum()))
            && (this.getTicketRemark() == null ? other.getTicketRemark() == null : this.getTicketRemark().equals(other.getTicketRemark()))
            && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDelState() == null ? other.getDelState() == null : this.getDelState().equals(other.getDelState()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReimburseId() == null) ? 0 : getReimburseId().hashCode());
        result = prime * result + ((getTallyCode() == null) ? 0 : getTallyCode().hashCode());
        result = prime * result + ((getTallyType() == null) ? 0 : getTallyType().hashCode());
        result = prime * result + ((getCateId() == null) ? 0 : getCateId().hashCode());
        result = prime * result + ((getCateName() == null) ? 0 : getCateName().hashCode());
        result = prime * result + ((getCateStr() == null) ? 0 : getCateStr().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getCurrencyId() == null) ? 0 : getCurrencyId().hashCode());
        result = prime * result + ((getCurrencyName() == null) ? 0 : getCurrencyName().hashCode());
        result = prime * result + ((getHappenTime() == null) ? 0 : getHappenTime().hashCode());
        result = prime * result + ((getHappenPlace() == null) ? 0 : getHappenPlace().hashCode());
        result = prime * result + ((getRelatedBill() == null) ? 0 : getRelatedBill().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillName() == null) ? 0 : getBillName().hashCode());
        result = prime * result + ((getTravelType() == null) ? 0 : getTravelType().hashCode());
        result = prime * result + ((getTravelId() == null) ? 0 : getTravelId().hashCode());
        result = prime * result + ((getTravelName() == null) ? 0 : getTravelName().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getOwnerType() == null) ? 0 : getOwnerType().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getContactIds() == null) ? 0 : getContactIds().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getBusinessName() == null) ? 0 : getBusinessName().hashCode());
        result = prime * result + ((getHasTicket() == null) ? 0 : getHasTicket().hashCode());
        result = prime * result + ((getTicketNum() == null) ? 0 : getTicketNum().hashCode());
        result = prime * result + ((getTicketRemark() == null) ? 0 : getTicketRemark().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDelState() == null) ? 0 : getDelState().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
package com.fea.project.model.feebudget;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/18.
 * 报销管理模块表 实体类
 */
@Builder
public class ReimburseModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 报销事由
     */
    private String name;

    /**
     * 流水编码
     */
    private String serialCode;

    /**
     * 报销分类：1出差，2日常，3采购
     */
    private Byte reimbType;

    /**
     * 记账金额
     */
    private Double money;

    /**
     * 币种id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long currencyId;

    /**
     * 币种
     */
    private String currencyName;

    /**
     * 费用报销日期
     */
    private Date applyDate;

    /**
     * 关联单据费用申请单0,任务1，市场线索2，销售线索3，机会4，合同5,项目6
     */
    private Byte relatedBill;

    /**
     * 关联单据id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long billId;

    /**
     * 关联单据名称
     */
    private String billName;

    /**
     * 
     */
    private String purpose;

    /**
     * 付款方式
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long paymentId;

    /**
     * 付款方式名称
     */
    private String paymentName;

    /**
     * 发票呈交方式
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long submitId;

    /**
     * 发票呈交方式名称
     */
    private String submitName;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
     * 申请人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long applyId;

    /**
     * 申请人名称
     */
    private String applyName;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateUserId;

    /**
     * 
     */
    private String updateUser;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 已生成付款单付款金额总和
     */
    private Double TOPAYMENTAMOUNT;

    /**
     * 可生成付款单付款金额
     */
    private Double NOTOPAYMENTAMOUNT;

    /**
     * 已付款金额
     */
    private Double PAIDAMOUNT;

    /**
     * 待付款金额
     */
    private Double NOPAIDAMOUNT;

    /**
     * 提交状态
     */
    private Byte SUBMITSTATUS;

    /**
     * 审批状态
     */
    private Byte APPROVALSTATUS;

    /**
     * 付款状态 1.未付款；2.部分付款；3，已付款；4，不可付款
     */
    private Byte PAYMENTSTATUS;

    /**
     * 部门ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long DEPID;

    /**
     * 部门名称
     */
    private String DEPNAME;

    /**
     * 提交申请关联申请表ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long APPID;
    /**
     * 费用类型
     */
    private String feeType;


    public ReimburseModel () {
        
    }

    public ReimburseModel(Long id, String name, String serialCode, Byte reimbType, Double money, Long currencyId, String currencyName, Date applyDate, Byte relatedBill, Long billId, String billName, String purpose, Long paymentId, String paymentName, Long submitId, String submitName, Long regId, Long orgId, Byte state, Byte delState, Long applyId, String applyName, Long createUserId, String createUser, Date createTime, Long updateUserId, String updateUser, Date updateTime, Double TOPAYMENTAMOUNT, Double NOTOPAYMENTAMOUNT, Double PAIDAMOUNT, Double NOPAIDAMOUNT, Byte SUBMITSTATUS, Byte APPROVALSTATUS, Byte PAYMENTSTATUS, Long DEPID, String DEPNAME, Long APPID, String feeType) {
        this.id = id;
        this.name = name;
        this.serialCode = serialCode;
        this.reimbType = reimbType;
        this.money = money;
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.applyDate = applyDate;
        this.relatedBill = relatedBill;
        this.billId = billId;
        this.billName = billName;
        this.purpose = purpose;
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.submitId = submitId;
        this.submitName = submitName;
        this.regId = regId;
        this.orgId = orgId;
        this.state = state;
        this.delState = delState;
        this.applyId = applyId;
        this.applyName = applyName;
        this.createUserId = createUserId;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUserId = updateUserId;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.TOPAYMENTAMOUNT = TOPAYMENTAMOUNT;
        this.NOTOPAYMENTAMOUNT = NOTOPAYMENTAMOUNT;
        this.PAIDAMOUNT = PAIDAMOUNT;
        this.NOPAIDAMOUNT = NOPAIDAMOUNT;
        this.SUBMITSTATUS = SUBMITSTATUS;
        this.APPROVALSTATUS = APPROVALSTATUS;
        this.PAYMENTSTATUS = PAYMENTSTATUS;
        this.DEPID = DEPID;
        this.DEPNAME = DEPNAME;
        this.APPID = APPID;
        this.feeType = feeType;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode == null ? null : serialCode.trim();
    }

    public Byte getReimbType() {
        return reimbType;
    }

    public void setReimbType(Byte reimbType) {
        this.reimbType = reimbType;
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    public Long getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Long submitId) {
        this.submitId = submitId;
    }

    public String getSubmitName() {
        return submitName;
    }

    public void setSubmitName(String submitName) {
        this.submitName = submitName == null ? null : submitName.trim();
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

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
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

    public Double getTOPAYMENTAMOUNT() {
        return TOPAYMENTAMOUNT;
    }

    public void setTOPAYMENTAMOUNT(Double TOPAYMENTAMOUNT) {
        this.TOPAYMENTAMOUNT = TOPAYMENTAMOUNT;
    }

    public Double getNOTOPAYMENTAMOUNT() {
        return NOTOPAYMENTAMOUNT;
    }

    public void setNOTOPAYMENTAMOUNT(Double NOTOPAYMENTAMOUNT) {
        this.NOTOPAYMENTAMOUNT = NOTOPAYMENTAMOUNT;
    }

    public Double getPAIDAMOUNT() {
        return PAIDAMOUNT;
    }

    public void setPAIDAMOUNT(Double PAIDAMOUNT) {
        this.PAIDAMOUNT = PAIDAMOUNT;
    }

    public Double getNOPAIDAMOUNT() {
        return NOPAIDAMOUNT;
    }

    public void setNOPAIDAMOUNT(Double NOPAIDAMOUNT) {
        this.NOPAIDAMOUNT = NOPAIDAMOUNT;
    }

    public Byte getSUBMITSTATUS() {
        return SUBMITSTATUS;
    }

    public void setSUBMITSTATUS(Byte SUBMITSTATUS) {
        this.SUBMITSTATUS = SUBMITSTATUS;
    }

    public Byte getAPPROVALSTATUS() {
        return APPROVALSTATUS;
    }

    public void setAPPROVALSTATUS(Byte APPROVALSTATUS) {
        this.APPROVALSTATUS = APPROVALSTATUS;
    }

    public Byte getPAYMENTSTATUS() {
        return PAYMENTSTATUS;
    }

    public void setPAYMENTSTATUS(Byte PAYMENTSTATUS) {
        this.PAYMENTSTATUS = PAYMENTSTATUS;
    }

    public Long getDEPID() {
        return DEPID;
    }

    public void setDEPID(Long DEPID) {
        this.DEPID = DEPID;
    }

    public String getDEPNAME() {
        return DEPNAME;
    }

    public void setDEPNAME(String DEPNAME) {
        this.DEPNAME = DEPNAME == null ? null : DEPNAME.trim();
    }

    public Long getAPPID() {
        return APPID;
    }

    public void setAPPID(Long APPID) {
        this.APPID = APPID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", serialCode=").append(serialCode);
        sb.append(", reimbType=").append(reimbType);
        sb.append(", money=").append(money);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", currencyName=").append(currencyName);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", relatedBill=").append(relatedBill);
        sb.append(", billId=").append(billId);
        sb.append(", billName=").append(billName);
        sb.append(", purpose=").append(purpose);
        sb.append(", paymentId=").append(paymentId);
        sb.append(", paymentName=").append(paymentName);
        sb.append(", submitId=").append(submitId);
        sb.append(", submitName=").append(submitName);
        sb.append(", regId=").append(regId);
        sb.append(", orgId=").append(orgId);
        sb.append(", state=").append(state);
        sb.append(", delState=").append(delState);
        sb.append(", applyId=").append(applyId);
        sb.append(", applyName=").append(applyName);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", TOPAYMENTAMOUNT=").append(TOPAYMENTAMOUNT);
        sb.append(", NOTOPAYMENTAMOUNT=").append(NOTOPAYMENTAMOUNT);
        sb.append(", PAIDAMOUNT=").append(PAIDAMOUNT);
        sb.append(", NOPAIDAMOUNT=").append(NOPAIDAMOUNT);
        sb.append(", SUBMITSTATUS=").append(SUBMITSTATUS);
        sb.append(", APPROVALSTATUS=").append(APPROVALSTATUS);
        sb.append(", PAYMENTSTATUS=").append(PAYMENTSTATUS);
        sb.append(", DEPID=").append(DEPID);
        sb.append(", DEPNAME=").append(DEPNAME);
        sb.append(", APPID=").append(APPID);
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
        ReimburseModel other = (ReimburseModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSerialCode() == null ? other.getSerialCode() == null : this.getSerialCode().equals(other.getSerialCode()))
            && (this.getReimbType() == null ? other.getReimbType() == null : this.getReimbType().equals(other.getReimbType()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getCurrencyId() == null ? other.getCurrencyId() == null : this.getCurrencyId().equals(other.getCurrencyId()))
            && (this.getCurrencyName() == null ? other.getCurrencyName() == null : this.getCurrencyName().equals(other.getCurrencyName()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getRelatedBill() == null ? other.getRelatedBill() == null : this.getRelatedBill().equals(other.getRelatedBill()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillName() == null ? other.getBillName() == null : this.getBillName().equals(other.getBillName()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getPaymentId() == null ? other.getPaymentId() == null : this.getPaymentId().equals(other.getPaymentId()))
            && (this.getPaymentName() == null ? other.getPaymentName() == null : this.getPaymentName().equals(other.getPaymentName()))
            && (this.getSubmitId() == null ? other.getSubmitId() == null : this.getSubmitId().equals(other.getSubmitId()))
            && (this.getSubmitName() == null ? other.getSubmitName() == null : this.getSubmitName().equals(other.getSubmitName()))
            && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDelState() == null ? other.getDelState() == null : this.getDelState().equals(other.getDelState()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getApplyName() == null ? other.getApplyName() == null : this.getApplyName().equals(other.getApplyName()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getTOPAYMENTAMOUNT() == null ? other.getTOPAYMENTAMOUNT() == null : this.getTOPAYMENTAMOUNT().equals(other.getTOPAYMENTAMOUNT()))
            && (this.getNOTOPAYMENTAMOUNT() == null ? other.getNOTOPAYMENTAMOUNT() == null : this.getNOTOPAYMENTAMOUNT().equals(other.getNOTOPAYMENTAMOUNT()))
            && (this.getPAIDAMOUNT() == null ? other.getPAIDAMOUNT() == null : this.getPAIDAMOUNT().equals(other.getPAIDAMOUNT()))
            && (this.getNOPAIDAMOUNT() == null ? other.getNOPAIDAMOUNT() == null : this.getNOPAIDAMOUNT().equals(other.getNOPAIDAMOUNT()))
            && (this.getSUBMITSTATUS() == null ? other.getSUBMITSTATUS() == null : this.getSUBMITSTATUS().equals(other.getSUBMITSTATUS()))
            && (this.getAPPROVALSTATUS() == null ? other.getAPPROVALSTATUS() == null : this.getAPPROVALSTATUS().equals(other.getAPPROVALSTATUS()))
            && (this.getPAYMENTSTATUS() == null ? other.getPAYMENTSTATUS() == null : this.getPAYMENTSTATUS().equals(other.getPAYMENTSTATUS()))
            && (this.getDEPID() == null ? other.getDEPID() == null : this.getDEPID().equals(other.getDEPID()))
            && (this.getDEPNAME() == null ? other.getDEPNAME() == null : this.getDEPNAME().equals(other.getDEPNAME()))
            && (this.getAPPID() == null ? other.getAPPID() == null : this.getAPPID().equals(other.getAPPID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSerialCode() == null) ? 0 : getSerialCode().hashCode());
        result = prime * result + ((getReimbType() == null) ? 0 : getReimbType().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getCurrencyId() == null) ? 0 : getCurrencyId().hashCode());
        result = prime * result + ((getCurrencyName() == null) ? 0 : getCurrencyName().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getRelatedBill() == null) ? 0 : getRelatedBill().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillName() == null) ? 0 : getBillName().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getPaymentId() == null) ? 0 : getPaymentId().hashCode());
        result = prime * result + ((getPaymentName() == null) ? 0 : getPaymentName().hashCode());
        result = prime * result + ((getSubmitId() == null) ? 0 : getSubmitId().hashCode());
        result = prime * result + ((getSubmitName() == null) ? 0 : getSubmitName().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDelState() == null) ? 0 : getDelState().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getApplyName() == null) ? 0 : getApplyName().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getTOPAYMENTAMOUNT() == null) ? 0 : getTOPAYMENTAMOUNT().hashCode());
        result = prime * result + ((getNOTOPAYMENTAMOUNT() == null) ? 0 : getNOTOPAYMENTAMOUNT().hashCode());
        result = prime * result + ((getPAIDAMOUNT() == null) ? 0 : getPAIDAMOUNT().hashCode());
        result = prime * result + ((getNOPAIDAMOUNT() == null) ? 0 : getNOPAIDAMOUNT().hashCode());
        result = prime * result + ((getSUBMITSTATUS() == null) ? 0 : getSUBMITSTATUS().hashCode());
        result = prime * result + ((getAPPROVALSTATUS() == null) ? 0 : getAPPROVALSTATUS().hashCode());
        result = prime * result + ((getPAYMENTSTATUS() == null) ? 0 : getPAYMENTSTATUS().hashCode());
        result = prime * result + ((getDEPID() == null) ? 0 : getDEPID().hashCode());
        result = prime * result + ((getDEPNAME() == null) ? 0 : getDEPNAME().hashCode());
        result = prime * result + ((getAPPID() == null) ? 0 : getAPPID().hashCode());
        return result;
    }
}
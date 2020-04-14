package com.fea.project.model.milestone;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/06.
 */
@TableNameAnno("t_project_milestone_deliverable")
@Builder
public class ProjectMilestoneDeliverableModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 里程碑交付物主键id
     */
    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 里程碑id
     */
    @NotNullAnno(value = "里程碑id",field = "milestoneId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long milestoneId;

    /**
     * 交付物名称
     */
    @NotNullAnno(value = "交付物名称",field = "deliverableName")
    private String deliverableName;

    /**
     * 交付物编号
     */
    private String deliverableNumber;

    /**
     * 关联交付要求id
     */
    @NotNullAnno(value = "交付要求",field = "deliveryId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliveryId;

    /**
     * 关联交付要求名称
     */
    private String deliveryName;

    /**
     * 交付物说明
     */
    private String description;
    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人姓名
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人姓名
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态(0正常，1删除)
     */
    private Integer delState;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 审核人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long verifyer;

    /**
     * 审核评分
     */
    private Double verifyerScore;

    /**
     * 审核状态
     */
    private Integer verifyerStatus;

    /**
     * 审核时间
     */
    private Date verifyerTime;

    /**
     * 交付人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deliver;

    /**
     * 交付状态
     */
    private Integer deliverStatus;

    /**
     * 交付时间
     */
    private Date deliverTime;

    public ProjectMilestoneDeliverableModel (Long id, Long milestoneId, String deliverableName, String deliverableNumber, Long deliveryId, String deliveryName, String description, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delState, Long orgId, Long regId, Long verifyer, Double verifyerScore, Integer verifyerStatus, Date verifyerTime, Long deliver, Integer deliverStatus, Date deliverTime) {
        this.id = id;
        this.milestoneId = milestoneId;
        this.deliverableName = deliverableName;
        this.deliverableNumber = deliverableNumber;
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
        this.description = description;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delState = delState;
        this.orgId = orgId;
        this.regId = regId;
        this.verifyer = verifyer;
        this.verifyerScore = verifyerScore;
        this.verifyerStatus = verifyerStatus;
        this.verifyerTime = verifyerTime;
        this.deliver = deliver;
        this.deliverStatus = deliverStatus;
        this.deliverTime = deliverTime;
    }

    public ProjectMilestoneDeliverableModel(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public ProjectMilestoneDeliverableModel () {

    }

    public ProjectMilestoneDeliverableModel (ProjectDeliverableVo model) {

        this.milestoneId = model.getBusinessId();
        this.deliverableName = model.getDeliverableName();

        this.deliveryId = model.getDeliveryId();
        this.deliveryName = model.getDeliveryName();

        this.description = model.getDescription();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Long milestoneId) {
        this.milestoneId = milestoneId;
    }

    public String getDeliverableName() {
        return deliverableName;
    }

    public void setDeliverableName(String deliverableName) {
        this.deliverableName = deliverableName == null ? null : deliverableName.trim();
    }

    public String getDeliverableNumber() {
        return deliverableNumber;
    }

    public void setDeliverableNumber(String deliverableNumber) {
        this.deliverableNumber = deliverableNumber == null ? null : deliverableNumber.trim();
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName == null ? null : deliveryName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelState() {
        return delState;
    }

    public void setDelState(Integer delState) {
        this.delState = delState;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getVerifyer() {
        return verifyer;
    }

    public void setVerifyer(Long verifyer) {
        this.verifyer = verifyer;
    }

    public Double getVerifyerScore() {
        return verifyerScore;
    }

    public void setVerifyerScore(Double verifyerScore) {
        this.verifyerScore = verifyerScore;
    }

    public Integer getVerifyerStatus() {
        return verifyerStatus;
    }

    public void setVerifyerStatus(Integer verifyerStatus) {
        this.verifyerStatus = verifyerStatus;
    }

    public Date getVerifyerTime() {
        return verifyerTime;
    }

    public void setVerifyerTime(Date verifyerTime) {
        this.verifyerTime = verifyerTime;
    }

    public Long getDeliver() {
        return deliver;
    }

    public void setDeliver(Long deliver) {
        this.deliver = deliver;
    }

    public Integer getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Integer deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", milestoneId=").append(milestoneId);
        sb.append(", deliverableName=").append(deliverableName);
        sb.append(", deliverableNumber=").append(deliverableNumber);
        sb.append(", deliveryId=").append(deliveryId);
        sb.append(", deliveryName=").append(deliveryName);
        sb.append(", description=").append(description);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delState=").append(delState);
        sb.append(", orgId=").append(orgId);
        sb.append(", regId=").append(regId);
        sb.append(", verifyer=").append(verifyer);
        sb.append(", verifyerScore=").append(verifyerScore);
        sb.append(", verifyerStatus=").append(verifyerStatus);
        sb.append(", verifyerTime=").append(verifyerTime);
        sb.append(", deliver=").append(deliver);
        sb.append(", deliverStatus=").append(deliverStatus);
        sb.append(", deliverTime=").append(deliverTime);
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
        ProjectMilestoneDeliverableModel other = (ProjectMilestoneDeliverableModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMilestoneId() == null ? other.getMilestoneId() == null : this.getMilestoneId().equals(other.getMilestoneId()))
                && (this.getDeliverableName() == null ? other.getDeliverableName() == null : this.getDeliverableName().equals(other.getDeliverableName()))
                && (this.getDeliverableNumber() == null ? other.getDeliverableNumber() == null : this.getDeliverableNumber().equals(other.getDeliverableNumber()))
                && (this.getDeliveryId() == null ? other.getDeliveryId() == null : this.getDeliveryId().equals(other.getDeliveryId()))
                && (this.getDeliveryName() == null ? other.getDeliveryName() == null : this.getDeliveryName().equals(other.getDeliveryName()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getDelState() == null ? other.getDelState() == null : this.getDelState().equals(other.getDelState()))
                && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
                && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
                && (this.getVerifyer() == null ? other.getVerifyer() == null : this.getVerifyer().equals(other.getVerifyer()))
                && (this.getVerifyerScore() == null ? other.getVerifyerScore() == null : this.getVerifyerScore().equals(other.getVerifyerScore()))
                && (this.getVerifyerStatus() == null ? other.getVerifyerStatus() == null : this.getVerifyerStatus().equals(other.getVerifyerStatus()))
                && (this.getVerifyerTime() == null ? other.getVerifyerTime() == null : this.getVerifyerTime().equals(other.getVerifyerTime()))
                && (this.getDeliver() == null ? other.getDeliver() == null : this.getDeliver().equals(other.getDeliver()))
                && (this.getDeliverStatus() == null ? other.getDeliverStatus() == null : this.getDeliverStatus().equals(other.getDeliverStatus()))
                && (this.getDeliverTime() == null ? other.getDeliverTime() == null : this.getDeliverTime().equals(other.getDeliverTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMilestoneId() == null) ? 0 : getMilestoneId().hashCode());
        result = prime * result + ((getDeliverableName() == null) ? 0 : getDeliverableName().hashCode());
        result = prime * result + ((getDeliverableNumber() == null) ? 0 : getDeliverableNumber().hashCode());
        result = prime * result + ((getDeliveryId() == null) ? 0 : getDeliveryId().hashCode());
        result = prime * result + ((getDeliveryName() == null) ? 0 : getDeliveryName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelState() == null) ? 0 : getDelState().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getVerifyer() == null) ? 0 : getVerifyer().hashCode());
        result = prime * result + ((getVerifyerScore() == null) ? 0 : getVerifyerScore().hashCode());
        result = prime * result + ((getVerifyerStatus() == null) ? 0 : getVerifyerStatus().hashCode());
        result = prime * result + ((getVerifyerTime() == null) ? 0 : getVerifyerTime().hashCode());
        result = prime * result + ((getDeliver() == null) ? 0 : getDeliver().hashCode());
        result = prime * result + ((getDeliverStatus() == null) ? 0 : getDeliverStatus().hashCode());
        result = prime * result + ((getDeliverTime() == null) ? 0 : getDeliverTime().hashCode());
        return result;
    }
}
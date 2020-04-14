package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MouldModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mouldId;

    private String mouldName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workOrderTypeId;

    private Long mouldVersion;

    private String mouldDesc;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Long delStatus;

    private static final long serialVersionUID = 1L;

    public Long getMouldId() {
        return mouldId;
    }

    public MouldModel withMouldId(Long mouldId) {
        this.setMouldId(mouldId);
        return this;
    }

    public void setMouldId(Long mouldId) {
        this.mouldId = mouldId;
    }

    public String getMouldName() {
        return mouldName;
    }

    public MouldModel withMouldName(String mouldName) {
        this.setMouldName(mouldName);
        return this;
    }

    public void setMouldName(String mouldName) {
        this.mouldName = mouldName == null ? null : mouldName.trim();
    }

    public Long getWorkOrderTypeId() {
        return workOrderTypeId;
    }

    public MouldModel withWorkOrderTypeId(Long workOrderTypeId) {
        this.setWorkOrderTypeId(workOrderTypeId);
        return this;
    }

    public void setWorkOrderTypeId(Long workOrderTypeId) {
        this.workOrderTypeId = workOrderTypeId;
    }

    public Long getMouldVersion() {
        return mouldVersion;
    }

    public MouldModel withMouldVersion(Long mouldVersion) {
        this.setMouldVersion(mouldVersion);
        return this;
    }

    public void setMouldVersion(Long mouldVersion) {
        this.mouldVersion = mouldVersion;
    }

    public String getMouldDesc() {
        return mouldDesc;
    }

    public MouldModel withMouldDesc(String mouldDesc) {
        this.setMouldDesc(mouldDesc);
        return this;
    }

    public void setMouldDesc(String mouldDesc) {
        this.mouldDesc = mouldDesc == null ? null : mouldDesc.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public MouldModel withOrgId(Long orgId) {
        this.setOrgId(orgId);
        return this;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCreateId() {
        return createId;
    }

    public MouldModel withCreateId(Long createId) {
        this.setCreateId(createId);
        return this;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public MouldModel withCreateBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MouldModel withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public MouldModel withUpdateId(Long updateId) {
        this.setUpdateId(updateId);
        return this;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public MouldModel withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public MouldModel withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getDelStatus() {
        return delStatus;
    }

    public MouldModel withDelStatus(Long delStatus) {
        this.setDelStatus(delStatus);
        return this;
    }

    public void setDelStatus(Long delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mouldId=").append(mouldId);
        sb.append(", mouldName=").append(mouldName);
        sb.append(", workOrderTypeId=").append(workOrderTypeId);
        sb.append(", mouldVersion=").append(mouldVersion);
        sb.append(", mouldDesc=").append(mouldDesc);
        sb.append(", orgId=").append(orgId);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
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
        MouldModel other = (MouldModel) that;
        return (this.getMouldId() == null ? other.getMouldId() == null : this.getMouldId().equals(other.getMouldId()))
            && (this.getMouldName() == null ? other.getMouldName() == null : this.getMouldName().equals(other.getMouldName()))
            && (this.getWorkOrderTypeId() == null ? other.getWorkOrderTypeId() == null : this.getWorkOrderTypeId().equals(other.getWorkOrderTypeId()))
            && (this.getMouldVersion() == null ? other.getMouldVersion() == null : this.getMouldVersion().equals(other.getMouldVersion()))
            && (this.getMouldDesc() == null ? other.getMouldDesc() == null : this.getMouldDesc().equals(other.getMouldDesc()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMouldId() == null) ? 0 : getMouldId().hashCode());
        result = prime * result + ((getMouldName() == null) ? 0 : getMouldName().hashCode());
        result = prime * result + ((getWorkOrderTypeId() == null) ? 0 : getWorkOrderTypeId().hashCode());
        result = prime * result + ((getMouldVersion() == null) ? 0 : getMouldVersion().hashCode());
        result = prime * result + ((getMouldDesc() == null) ? 0 : getMouldDesc().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelStatus() == null) ? 0 : getDelStatus().hashCode());
        return result;
    }
}
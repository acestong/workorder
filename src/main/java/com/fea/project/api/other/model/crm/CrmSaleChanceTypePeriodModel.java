package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/11.
 */
public class CrmSaleChanceTypePeriodModel implements Serializable {
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
     * 机会阶段id------------无效字段
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long periodId;

    /**
     * 机会阶段名称
     */
    private String periodName;

    /**
     * 阶段类型id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long saleChanceTypeId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 阶段说明
     */
    private String description;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     *
     */
    private Double stopTime;

    /**
     *
     */
    private String updateUser;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateUserId;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private Integer delState;

    public CrmSaleChanceTypePeriodModel(Long id, Long periodId, String periodName, Long saleChanceTypeId, Long regId, String description, Long orgId, Double stopTime, String updateUser, Long updateUserId, Date updateTime, Integer delState) {
        this.id = id;
        this.periodId = periodId;
        this.periodName = periodName;
        this.saleChanceTypeId = saleChanceTypeId;
        this.regId = regId;
        this.description = description;
        this.orgId = orgId;
        this.stopTime = stopTime;
        this.updateUser = updateUser;
        this.updateUserId = updateUserId;
        this.updateTime = updateTime;
        this.delState = delState;
    }

    public CrmSaleChanceTypePeriodModel() {

    }

    public CrmSaleChanceTypePeriodModel(Long regId, Long saleChanceTypeId) {
        this.regId = regId;
        this.saleChanceTypeId = saleChanceTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName == null ? null : periodName.trim();
    }

    public Long getSaleChanceTypeId() {
        return saleChanceTypeId;
    }

    public void setSaleChanceTypeId(Long saleChanceTypeId) {
        this.saleChanceTypeId = saleChanceTypeId;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Double getStopTime() {
        return stopTime;
    }

    public void setStopTime(Double stopTime) {
        this.stopTime = stopTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", periodId=").append(periodId);
        sb.append(", periodName=").append(periodName);
        sb.append(", saleChanceTypeId=").append(saleChanceTypeId);
        sb.append(", regId=").append(regId);
        sb.append(", description=").append(description);
        sb.append(", orgId=").append(orgId);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delState=").append(delState);
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
        CrmSaleChanceTypePeriodModel other = (CrmSaleChanceTypePeriodModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPeriodId() == null ? other.getPeriodId() == null : this.getPeriodId().equals(other.getPeriodId()))
                && (this.getPeriodName() == null ? other.getPeriodName() == null : this.getPeriodName().equals(other.getPeriodName()))
                && (this.getSaleChanceTypeId() == null ? other.getSaleChanceTypeId() == null : this.getSaleChanceTypeId().equals(other.getSaleChanceTypeId()))
                && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
                && (this.getStopTime() == null ? other.getStopTime() == null : this.getStopTime().equals(other.getStopTime()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getDelState() == null ? other.getDelState() == null : this.getDelState().equals(other.getDelState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPeriodId() == null) ? 0 : getPeriodId().hashCode());
        result = prime * result + ((getPeriodName() == null) ? 0 : getPeriodName().hashCode());
        result = prime * result + ((getSaleChanceTypeId() == null) ? 0 : getSaleChanceTypeId().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getStopTime() == null) ? 0 : getStopTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelState() == null) ? 0 : getDelState().hashCode());
        return result;
    }
}
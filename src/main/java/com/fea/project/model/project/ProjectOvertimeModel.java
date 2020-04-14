package com.fea.project.model.project;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProjectOvertimeModel implements Serializable {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date endTime;

    private Integer overTimeNum;

    private Integer overTimeType;

    private String workReportId;

    private Long createId;

    private String createBy;

    private Date createTime;

    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public ProjectOvertimeModel withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public ProjectOvertimeModel withStartTime(Date startTime) {
        this.setStartTime(startTime);
        return this;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public ProjectOvertimeModel withEndTime(Date endTime) {
        this.setEndTime(endTime);
        return this;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOverTimeNum() {
        return overTimeNum;
    }

    public ProjectOvertimeModel withOverTimeNum(Integer overTimeNum) {
        this.setOverTimeNum(overTimeNum);
        return this;
    }

    public void setOverTimeNum(Integer overTimeNum) {
        this.overTimeNum = overTimeNum;
    }

    public Integer getOverTimeType() {
        return overTimeType;
    }

    public ProjectOvertimeModel withOverTimeType(Integer overTimeType) {
        this.setOverTimeType(overTimeType);
        return this;
    }

    public void setOverTimeType(Integer overTimeType) {
        this.overTimeType = overTimeType;
    }

    public String getWorkReportId() {
        return workReportId;
    }

    public ProjectOvertimeModel withWorkReportId(String workReportId) {
        this.setWorkReportId(workReportId);
        return this;
    }

    public void setWorkReportId(String workReportId) {
        this.workReportId = workReportId == null ? null : workReportId.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public ProjectOvertimeModel withCreateId(Long createId) {
        this.setCreateId(createId);
        return this;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public ProjectOvertimeModel withCreateBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ProjectOvertimeModel withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public ProjectOvertimeModel withUpdateId(Long updateId) {
        this.setUpdateId(updateId);
        return this;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public ProjectOvertimeModel withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ProjectOvertimeModel withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
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
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", overTimeNum=").append(overTimeNum);
        sb.append(", overTimeType=").append(overTimeType);
        sb.append(", workReportId=").append(workReportId);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
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
        ProjectOvertimeModel other = (ProjectOvertimeModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getOverTimeNum() == null ? other.getOverTimeNum() == null : this.getOverTimeNum().equals(other.getOverTimeNum()))
            && (this.getOverTimeType() == null ? other.getOverTimeType() == null : this.getOverTimeType().equals(other.getOverTimeType()))
            && (this.getWorkReportId() == null ? other.getWorkReportId() == null : this.getWorkReportId().equals(other.getWorkReportId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getOverTimeNum() == null) ? 0 : getOverTimeNum().hashCode());
        result = prime * result + ((getOverTimeType() == null) ? 0 : getOverTimeType().hashCode());
        result = prime * result + ((getWorkReportId() == null) ? 0 : getWorkReportId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
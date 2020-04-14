package com.fea.project.model.project;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProjectMHourManageModel implements Serializable {
   /* @JsonFormat(shape = JsonFormat.Shape.STRING)*/
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date uploadTime;

    private Integer uploadTimenum;

    private String workReportId;

    private String overtimeId;

    private String remark;

    private Long createId;

    private String createBy;

    private Date createTime;

    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Integer confirmStatus; //确认状态 未确认为0

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public ProjectMHourManageModel withId(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public ProjectMHourManageModel withUploadTime(Date uploadTime) {
        this.setUploadTime(uploadTime);
        return this;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getUploadTimenum() {
        return uploadTimenum;
    }

    public ProjectMHourManageModel withUploadTimenum(Integer uploadTimenum) {
        this.setUploadTimenum(uploadTimenum);
        return this;
    }

    public void setUploadTimenum(Integer uploadTimenum) {
        this.uploadTimenum = uploadTimenum;
    }

    public String getWorkReportId() {
        return workReportId;
    }

    public ProjectMHourManageModel withWorkReportId(String workReportId) {
        this.setWorkReportId(workReportId);
        return this;
    }

    public void setWorkReportId(String workReportId) {
        this.workReportId = workReportId == null ? null : workReportId.trim();
    }

    public String getOvertimeId() {
        return overtimeId;
    }

    public ProjectMHourManageModel withOvertimeId(String overtimeId) {
        this.setOvertimeId(overtimeId);
        return this;
    }

    public void setOvertimeId(String overtimeId) {
        this.overtimeId = overtimeId == null ? null : overtimeId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public ProjectMHourManageModel withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public ProjectMHourManageModel withCreateId(Long createId) {
        this.setCreateId(createId);
        return this;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public ProjectMHourManageModel withCreateBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ProjectMHourManageModel withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public ProjectMHourManageModel withUpdateId(Long updateId) {
        this.setUpdateId(updateId);
        return this;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public ProjectMHourManageModel withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ProjectMHourManageModel withUpdateTime(Date updateTime) {
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
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", uploadTimenum=").append(uploadTimenum);
        sb.append(", workReportId=").append(workReportId);
        sb.append(", overtimeId=").append(overtimeId);
        sb.append(", remark=").append(remark);
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
        ProjectMHourManageModel other = (ProjectMHourManageModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getUploadTimenum() == null ? other.getUploadTimenum() == null : this.getUploadTimenum().equals(other.getUploadTimenum()))
            && (this.getWorkReportId() == null ? other.getWorkReportId() == null : this.getWorkReportId().equals(other.getWorkReportId()))
            && (this.getOvertimeId() == null ? other.getOvertimeId() == null : this.getOvertimeId().equals(other.getOvertimeId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getUploadTimenum() == null) ? 0 : getUploadTimenum().hashCode());
        result = prime * result + ((getWorkReportId() == null) ? 0 : getWorkReportId().hashCode());
        result = prime * result + ((getOvertimeId() == null) ? 0 : getOvertimeId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
package com.fea.project.model.project;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProjectConfirmTimeModel implements Serializable {
    private Long id;

    private Long reportuserid;

    private Long reportid;

    private Long reporttimenum;

    private Long confirmtimenum;

    private Long confirmuserid;

    private String confirmname;

    private Date confirmtime;

    private Integer confirmstatus;

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

    public ProjectConfirmTimeModel withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportuserid() {
        return reportuserid;
    }

    public ProjectConfirmTimeModel withReportuserid(Long reportuserid) {
        this.setReportuserid(reportuserid);
        return this;
    }

    public void setReportuserid(Long reportuserid) {
        this.reportuserid = reportuserid;
    }

    public Long getReportid() {
        return reportid;
    }

    public ProjectConfirmTimeModel withReportid(Long reportid) {
        this.setReportid(reportid);
        return this;
    }

    public void setReportid(Long reportid) {
        this.reportid = reportid;
    }

    public Long getReporttimenum() {
        return reporttimenum;
    }

    public ProjectConfirmTimeModel withReporttimenum(Long reporttimenum) {
        this.setReporttimenum(reporttimenum);
        return this;
    }

    public void setReporttimenum(Long reporttimenum) {
        this.reporttimenum = reporttimenum;
    }

    public Long getConfirmtimenum() {
        return confirmtimenum;
    }

    public ProjectConfirmTimeModel withConfirmtimenum(Long confirmtimenum) {
        this.setConfirmtimenum(confirmtimenum);
        return this;
    }

    public void setConfirmtimenum(Long confirmtimenum) {
        this.confirmtimenum = confirmtimenum;
    }

    public Long getConfirmuserid() {
        return confirmuserid;
    }

    public ProjectConfirmTimeModel withConfirmuserid(Long confirmuserid) {
        this.setConfirmuserid(confirmuserid);
        return this;
    }

    public void setConfirmuserid(Long confirmuserid) {
        this.confirmuserid = confirmuserid;
    }

    public String getConfirmname() {
        return confirmname;
    }

    public ProjectConfirmTimeModel withConfirmname(String confirmname) {
        this.setConfirmname(confirmname);
        return this;
    }

    public void setConfirmname(String confirmname) {
        this.confirmname = confirmname == null ? null : confirmname.trim();
    }

    public Date getConfirmtime() {
        return confirmtime;
    }

    public ProjectConfirmTimeModel withConfirmtime(Date confirmtime) {
        this.setConfirmtime(confirmtime);
        return this;
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public Integer getConfirmstatus() {
        return confirmstatus;
    }

    public ProjectConfirmTimeModel withConfirmstatus(Integer confirmstatus) {
        this.setConfirmstatus(confirmstatus);
        return this;
    }

    public void setConfirmstatus(Integer confirmstatus) {
        this.confirmstatus = confirmstatus;
    }

    public Long getCreateId() {
        return createId;
    }

    public ProjectConfirmTimeModel withCreateId(Long createId) {
        this.setCreateId(createId);
        return this;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public ProjectConfirmTimeModel withCreateBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ProjectConfirmTimeModel withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public ProjectConfirmTimeModel withUpdateId(Long updateId) {
        this.setUpdateId(updateId);
        return this;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public ProjectConfirmTimeModel withUpdateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ProjectConfirmTimeModel withUpdateTime(Date updateTime) {
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
        sb.append(", reportuserid=").append(reportuserid);
        sb.append(", reportid=").append(reportid);
        sb.append(", reporttimenum=").append(reporttimenum);
        sb.append(", confirmtimenum=").append(confirmtimenum);
        sb.append(", confirmuserid=").append(confirmuserid);
        sb.append(", confirmname=").append(confirmname);
        sb.append(", confirmtime=").append(confirmtime);
        sb.append(", confirmstatus=").append(confirmstatus);
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
        ProjectConfirmTimeModel other = (ProjectConfirmTimeModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReportuserid() == null ? other.getReportuserid() == null : this.getReportuserid().equals(other.getReportuserid()))
            && (this.getReportid() == null ? other.getReportid() == null : this.getReportid().equals(other.getReportid()))
            && (this.getReporttimenum() == null ? other.getReporttimenum() == null : this.getReporttimenum().equals(other.getReporttimenum()))
            && (this.getConfirmtimenum() == null ? other.getConfirmtimenum() == null : this.getConfirmtimenum().equals(other.getConfirmtimenum()))
            && (this.getConfirmuserid() == null ? other.getConfirmuserid() == null : this.getConfirmuserid().equals(other.getConfirmuserid()))
            && (this.getConfirmname() == null ? other.getConfirmname() == null : this.getConfirmname().equals(other.getConfirmname()))
            && (this.getConfirmtime() == null ? other.getConfirmtime() == null : this.getConfirmtime().equals(other.getConfirmtime()))
            && (this.getConfirmstatus() == null ? other.getConfirmstatus() == null : this.getConfirmstatus().equals(other.getConfirmstatus()))
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
        result = prime * result + ((getReportuserid() == null) ? 0 : getReportuserid().hashCode());
        result = prime * result + ((getReportid() == null) ? 0 : getReportid().hashCode());
        result = prime * result + ((getReporttimenum() == null) ? 0 : getReporttimenum().hashCode());
        result = prime * result + ((getConfirmtimenum() == null) ? 0 : getConfirmtimenum().hashCode());
        result = prime * result + ((getConfirmuserid() == null) ? 0 : getConfirmuserid().hashCode());
        result = prime * result + ((getConfirmname() == null) ? 0 : getConfirmname().hashCode());
        result = prime * result + ((getConfirmtime() == null) ? 0 : getConfirmtime().hashCode());
        result = prime * result + ((getConfirmstatus() == null) ? 0 : getConfirmstatus().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
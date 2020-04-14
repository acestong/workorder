package com.fea.project.model.interflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
public class ProjectInterflowVisitingModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 拜访交流主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 方式
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer way;

    /**
     * 联系人类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer contactType;

    /**
     * 联系人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long contactId;

    /**
     * 拜访用时
     */
    private String visitTimes;

    /**
     * 外出用时
     */
    private String times;

    /**
     * 内容
     */
    private String details;

    /**
     * 创建人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人名称
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态(0正常，1删除)
     */
    @JsonIgnore
    private Integer delStates;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 项目阶段
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;

    /**
     * 关联任务
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;

    /**
     * 出发时间
     */
    private Date departTime;

    /**
     * 签到时间
     */
    private Date signInTime;

    /**
     * 签退时间
     */
    private Date signOutTime;

    /**
     * 返回时间
     */
    private Date backTime;

    /**
     * 出发地点
     */
    private String departAddress;

    /**
     * 签到地点
     */
    private String signInAddress;

    /**
     * 签退地点
     */
    private String signOutAddress;

    /**
     * 返回地点
     */
    private String backAddress;

    public ProjectInterflowVisitingModel (Long id, String title, Integer type, Integer way, Integer contactType, Long contactId, String visitTimes, String times, String details, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStates, Long projectId, Long projectStep, Long taskId, Date departTime, Date signInTime, Date signOutTime, Date backTime, String departAddress, String signInAddress, String signOutAddress, String backAddress) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.way = way;
        this.contactType = contactType;
        this.contactId = contactId;
        this.visitTimes = visitTimes;
        this.times = times;
        this.details = details;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStates = delStates;
        this.projectId = projectId;
        this.projectStep = projectStep;
        this.taskId = taskId;
        this.departTime = departTime;
        this.signInTime = signInTime;
        this.signOutTime = signOutTime;
        this.backTime = backTime;
        this.departAddress = departAddress;
        this.signInAddress = signInAddress;
        this.signOutAddress = signOutAddress;
        this.backAddress = backAddress;
    }

    public ProjectInterflowVisitingModel(Long id) {
        this.id = id;
    }

    public ProjectInterflowVisitingModel () {
        
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
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(String visitTimes) {
        this.visitTimes = visitTimes == null ? null : visitTimes.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
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

    public Integer getDelStates() {
        return delStates;
    }

    public void setDelStates(Integer delStates) {
        this.delStates = delStates;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectStep() {
        return projectStep;
    }

    public void setProjectStep(Long projectStep) {
        this.projectStep = projectStep;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Date signOutTime) {
        this.signOutTime = signOutTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getDepartAddress() {
        return departAddress;
    }

    public void setDepartAddress(String departAddress) {
        this.departAddress = departAddress == null ? null : departAddress.trim();
    }

    public String getSignInAddress() {
        return signInAddress;
    }

    public void setSignInAddress(String signInAddress) {
        this.signInAddress = signInAddress == null ? null : signInAddress.trim();
    }

    public String getSignOutAddress() {
        return signOutAddress;
    }

    public void setSignOutAddress(String signOutAddress) {
        this.signOutAddress = signOutAddress == null ? null : signOutAddress.trim();
    }

    public String getBackAddress() {
        return backAddress;
    }

    public void setBackAddress(String backAddress) {
        this.backAddress = backAddress == null ? null : backAddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", type=").append(type);
        sb.append(", way=").append(way);
        sb.append(", contactType=").append(contactType);
        sb.append(", contactId=").append(contactId);
        sb.append(", visitTimes=").append(visitTimes);
        sb.append(", times=").append(times);
        sb.append(", details=").append(details);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delStates=").append(delStates);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectStep=").append(projectStep);
        sb.append(", taskId=").append(taskId);
        sb.append(", departTime=").append(departTime);
        sb.append(", signInTime=").append(signInTime);
        sb.append(", signOutTime=").append(signOutTime);
        sb.append(", backTime=").append(backTime);
        sb.append(", departAddress=").append(departAddress);
        sb.append(", signInAddress=").append(signInAddress);
        sb.append(", signOutAddress=").append(signOutAddress);
        sb.append(", backAddress=").append(backAddress);
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
        ProjectInterflowVisitingModel other = (ProjectInterflowVisitingModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getWay() == null ? other.getWay() == null : this.getWay().equals(other.getWay()))
            && (this.getContactType() == null ? other.getContactType() == null : this.getContactType().equals(other.getContactType()))
            && (this.getContactId() == null ? other.getContactId() == null : this.getContactId().equals(other.getContactId()))
            && (this.getVisitTimes() == null ? other.getVisitTimes() == null : this.getVisitTimes().equals(other.getVisitTimes()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelStates() == null ? other.getDelStates() == null : this.getDelStates().equals(other.getDelStates()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectStep() == null ? other.getProjectStep() == null : this.getProjectStep().equals(other.getProjectStep()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getDepartTime() == null ? other.getDepartTime() == null : this.getDepartTime().equals(other.getDepartTime()))
            && (this.getSignInTime() == null ? other.getSignInTime() == null : this.getSignInTime().equals(other.getSignInTime()))
            && (this.getSignOutTime() == null ? other.getSignOutTime() == null : this.getSignOutTime().equals(other.getSignOutTime()))
            && (this.getBackTime() == null ? other.getBackTime() == null : this.getBackTime().equals(other.getBackTime()))
            && (this.getDepartAddress() == null ? other.getDepartAddress() == null : this.getDepartAddress().equals(other.getDepartAddress()))
            && (this.getSignInAddress() == null ? other.getSignInAddress() == null : this.getSignInAddress().equals(other.getSignInAddress()))
            && (this.getSignOutAddress() == null ? other.getSignOutAddress() == null : this.getSignOutAddress().equals(other.getSignOutAddress()))
            && (this.getBackAddress() == null ? other.getBackAddress() == null : this.getBackAddress().equals(other.getBackAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getWay() == null) ? 0 : getWay().hashCode());
        result = prime * result + ((getContactType() == null) ? 0 : getContactType().hashCode());
        result = prime * result + ((getContactId() == null) ? 0 : getContactId().hashCode());
        result = prime * result + ((getVisitTimes() == null) ? 0 : getVisitTimes().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelStates() == null) ? 0 : getDelStates().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectStep() == null) ? 0 : getProjectStep().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getDepartTime() == null) ? 0 : getDepartTime().hashCode());
        result = prime * result + ((getSignInTime() == null) ? 0 : getSignInTime().hashCode());
        result = prime * result + ((getSignOutTime() == null) ? 0 : getSignOutTime().hashCode());
        result = prime * result + ((getBackTime() == null) ? 0 : getBackTime().hashCode());
        result = prime * result + ((getDepartAddress() == null) ? 0 : getDepartAddress().hashCode());
        result = prime * result + ((getSignInAddress() == null) ? 0 : getSignInAddress().hashCode());
        result = prime * result + ((getSignOutAddress() == null) ? 0 : getSignOutAddress().hashCode());
        result = prime * result + ((getBackAddress() == null) ? 0 : getBackAddress().hashCode());
        return result;
    }
}
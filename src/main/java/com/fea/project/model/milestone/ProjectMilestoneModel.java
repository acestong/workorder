package com.fea.project.model.milestone;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/26.
 * 项目里程碑 实体类
 */
@TableNameAnno(value = "t_project_milestone")
@AllArgsConstructor
@Builder
public class ProjectMilestoneModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    private Long id;

    /**
     * 里程碑名称
     */
    @NotNullAnno(value = "里程碑名称",field = "name")
    private String name;

    /**
     * 里程碑编号
     */
    private String number;

    /**
     * 里程碑类型（进度，回款，验收等里程碑）
     */
    @NotNullAnno(value = "里程碑类型",field = "type")
    private Long type;

    /**
     * 排序序号
     */
    private Integer sort;

    /**
     * 项目id
     */
    @NotNullAnno(value = "项目id",field = "projectId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 项目编号
     */
    private String code;

    /**
     * 关联项目阶段id
     */
    @NotNullAnno(value = "关联项目阶段id",field = "projectStageId")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStageId;

    /**
     * 关联项目阶段
     */
    private String projectStage;

    /**
     * 开始时间（上一里程碑完成时间）
     */
    private Date startTime;

    /**
     * 结束时间（里程碑时间）
     */
    @NotNullAnno(value = "里程碑时间",field = "endTime")
    private Date endTime;

    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerId;

    /**
     * 负责人
     */
    private String owner;

    /**
     * 负责团队id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long teamId;

    /**
     * 负责团队
     */
    private String team;

    /**
     * 里程碑目标
     */
    @NotNullAnno(value = "里程碑目标",field = "target")
    private String target;

    /**
     * 里程碑说明
     */
    private String remark;

    /**
     * 审核状态(1未提交，2已提交，已通过，已拒绝)
     */
    private Integer status;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 删除状态(0正常，1删除)
     */
    private Integer delStates;

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
     * 是否完成（0未完成，1已完成）
     */
    private Integer isFinish;

    /**
     * 确认完成时间
     */
    private Date finishTime;

    /**
     * 确认人
     */
    private String notarize;

    /**
     * 说明
     */
    private String description;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     *
     */
    private String updateBy;

    /**
     *
     */
    private Date updateTime;



    public ProjectMilestoneModel () {

    }

    public ProjectMilestoneModel(Long projectId) {
        this.projectId = projectId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getProjectStageId() {
        return projectStageId;
    }

    public void setProjectStageId(Long projectStageId) {
        this.projectStageId = projectStageId;
    }

    public String getProjectStage() {
        return projectStage;
    }

    public void setProjectStage(String projectStage) {
        this.projectStage = projectStage == null ? null : projectStage.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDelStates() {
        return delStates;
    }

    public void setDelStates(Integer delStates) {
        this.delStates = delStates;
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

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getNotarize() {
        return notarize;
    }

    public void setNotarize(String notarize) {
        this.notarize = notarize == null ? null : notarize.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", type=").append(type);
        sb.append(", sort=").append(sort);
        sb.append(", projectId=").append(projectId);
        sb.append(", code=").append(code);
        sb.append(", projectStageId=").append(projectStageId);
        sb.append(", projectStage=").append(projectStage);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", owner=").append(owner);
        sb.append(", teamId=").append(teamId);
        sb.append(", team=").append(team);
        sb.append(", target=").append(target);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", version=").append(version);
        sb.append(", delStates=").append(delStates);
        sb.append(", orgId=").append(orgId);
        sb.append(", regId=").append(regId);
        sb.append(", isFinish=").append(isFinish);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", notarize=").append(notarize);
        sb.append(", description=").append(description);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
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
        ProjectMilestoneModel other = (ProjectMilestoneModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
                && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
                && (this.getProjectStageId() == null ? other.getProjectStageId() == null : this.getProjectStageId().equals(other.getProjectStageId()))
                && (this.getProjectStage() == null ? other.getProjectStage() == null : this.getProjectStage().equals(other.getProjectStage()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
                && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
                && (this.getTeamId() == null ? other.getTeamId() == null : this.getTeamId().equals(other.getTeamId()))
                && (this.getTeam() == null ? other.getTeam() == null : this.getTeam().equals(other.getTeam()))
                && (this.getTarget() == null ? other.getTarget() == null : this.getTarget().equals(other.getTarget()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
                && (this.getDelStates() == null ? other.getDelStates() == null : this.getDelStates().equals(other.getDelStates()))
                && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
                && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
                && (this.getIsFinish() == null ? other.getIsFinish() == null : this.getIsFinish().equals(other.getIsFinish()))
                && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
                && (this.getNotarize() == null ? other.getNotarize() == null : this.getNotarize().equals(other.getNotarize()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getProjectStageId() == null) ? 0 : getProjectStageId().hashCode());
        result = prime * result + ((getProjectStage() == null) ? 0 : getProjectStage().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());
        result = prime * result + ((getTeam() == null) ? 0 : getTeam().hashCode());
        result = prime * result + ((getTarget() == null) ? 0 : getTarget().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDelStates() == null) ? 0 : getDelStates().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getIsFinish() == null) ? 0 : getIsFinish().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getNotarize() == null) ? 0 : getNotarize().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
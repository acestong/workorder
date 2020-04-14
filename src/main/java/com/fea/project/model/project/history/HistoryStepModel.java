package com.fea.project.model.project.history;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.project.vo.ProjectStepVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/19.
 */
@Data
@TableNameAnno(value = "t_project_history_step")
public class HistoryStepModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 项目
     */
    @JsonIgnore
    protected Long projectId;

    /**
     * 名称
     */
    @NotNullAnno(field = "name", value = "阶段名称")
    protected String name;

    /**
     * 阶段排序
     */
    protected Integer index;

    /**
     * 开始时间
     */
    protected Date startTime;

    /**
     * 结束时间
     */
    protected Date endTime;

    /**
     * 工期
     */
    protected Integer duration;

    /**
     * 责任人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long leader;

    /**
     * 阶段内容
     */
    protected String content;

    /**
     * 交付物
     */
    protected String deliverClaim;

    /**
     * 是否提交  0-未提交 1-已提交
     */
    protected Integer isSubmit;

    /**
     * 创建id
     */
    @JsonIgnore
    protected Long createId;

    /**
     * 创建人
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String createBy;

    /**
     * 创建时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date createTime;

    /**
     * 更新id
     */
    @JsonIgnore
    protected Long updateId;

    /**
     * 更新人
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String updateBy;

    /**
     * 更新时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date updateTime;

    /**
     * 删除标识
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     * 真实的业务id
     */
    @PrimaryKey(field = "id")
    protected Long originalId;

    /**
     * draft_project的主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long historyId;

    public HistoryStepModel (Long id, Long projectId, String name, Integer index, Date startTime, Date endTime, Integer duration, Long leader, String content, String deliverClaim, Integer isSubmit, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, Long originalId, Long historyId) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.leader = leader;
        this.content = content;
        this.deliverClaim = deliverClaim;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.originalId = originalId;
        this.historyId = historyId;
    }

    public HistoryStepModel () {

    }

    public HistoryStepModel(ProjectStepVo projectStepVo) {
        this.projectId = projectStepVo.getProjectId();
        this.name = projectStepVo.getName();
        this.index = projectStepVo.getIndex();
        this.startTime = projectStepVo.getStartTime();
        this.endTime = projectStepVo.getEndTime();
        this.duration = projectStepVo.getDuration();
        this.leader = projectStepVo.getLeader();
        this.content = projectStepVo.getContent();
        this.deliverClaim = projectStepVo.getDeliverClaim();
        this.createId = projectStepVo.getCreateId();
        this.createBy = projectStepVo.getCreateBy();
        this.createTime = projectStepVo.getCreateTime();
        this.updateId = projectStepVo.getUpdateId();
        this.updateBy = projectStepVo.getUpdateBy();
        this.updateTime = projectStepVo.getUpdateTime();
        this.delStatus = projectStepVo.getDelStatus();
        this.originalId = projectStepVo.getId();
    }

    public HistoryStepModel(Long historyId) {
        this.historyId = historyId;
    }


    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(new Date());
            this.setCreateBy(model.getRealName());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(new Date());
            this.setUpdateBy(model.getRealName());
        }
    }
}
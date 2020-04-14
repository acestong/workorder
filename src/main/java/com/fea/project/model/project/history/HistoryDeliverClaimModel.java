package com.fea.project.model.project.history;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/19.
 */
@Data
@TableNameAnno(value = "t_project_history_deliver_claim")
public class HistoryDeliverClaimModel implements Serializable {
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
     * 交付物名称
     */
    protected String name;

    /**
     * 交付时间
     */
    protected Date time;

    /**
     * 负责人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long leader;

    /**
     * 交付要求
     */
    protected String deliverClaim;

    /**
     * 备注
     */
    protected String remark;

    /**
     * 项目id
     */
    @JsonIgnore
    protected Long projectId;

    /**
     * 创建人id
     */
    @JsonIgnore
    protected Long createId;

    /**
     * 创建人名称
     */
    protected String createBy;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新人id
     */
    @JsonIgnore
    protected Long updateId;

    /**
     * 更新人名称
     */
    protected String updateBy;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 删除标识
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     * 交付人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long deliver;

    /**
     * 交付状态
     */
    protected Integer deliverStatus;

    /**
     * 交付时间
     */
    protected Date deliverTime;

    /**
     * 审核人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long verifyer;

    /**
     * 审核状态
     */
    protected Integer verifyerStatus;

    /**
     * 审核时间
     */
    protected Date verifyerTime;

    /**
     * 真实id
     */
    @JsonIgnore
    protected Long originalId;

    /**
     * 草稿id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long historyId;


    public HistoryDeliverClaimModel () {

    }

    public HistoryDeliverClaimModel(ProjectDeliverClaimVo projectDeliverClaimVo) {
        this.name = projectDeliverClaimVo.getName();
        this.time = projectDeliverClaimVo.getTime();
        this.leader = projectDeliverClaimVo.getLeader();
        this.deliverClaim = projectDeliverClaimVo.getDeliverClaim();
        this.remark = projectDeliverClaimVo.getRemark();
        this.projectId = projectDeliverClaimVo.getProjectId();
        this.createId = projectDeliverClaimVo.getCreateId();
        this.createBy = projectDeliverClaimVo.getCreateBy();
        this.createTime = projectDeliverClaimVo.getCreateTime();
        this.updateId = projectDeliverClaimVo.getUpdateId();
        this.updateBy = projectDeliverClaimVo.getUpdateBy();
        this.updateTime = projectDeliverClaimVo.getUpdateTime();
        this.delStatus = projectDeliverClaimVo.getDelStatus();
        this.deliver = projectDeliverClaimVo.getDeliver();
        this.deliverStatus = projectDeliverClaimVo.getDeliverStatus();
        this.deliverTime = projectDeliverClaimVo.getDeliverTime();
        this.verifyer = projectDeliverClaimVo.getVerifyer();
        this.verifyerStatus = projectDeliverClaimVo.getVerifyerStatus();
        this.verifyerTime = projectDeliverClaimVo.getVerifyerTime();
        this.originalId = projectDeliverClaimVo.getId();
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
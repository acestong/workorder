package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/30.
 */
@Data
@TableNameAnno("t_project_deliver_claim")
public class ProjectDeliverClaimModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    protected Long id;

    /**
     * 交付物名称
     */
    @NotNullAnno(value = "交付物", field = "name")
    protected String name;

    /**
     * 交付时间
     */
    @NotNullAnno(value = "交付时间", field = "time")
    protected Date time;

    /**
     * 交付人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "交付人", field = "leader")
    protected Long leader;

    /**
     * 交付要求
     */
    @NotNullAnno(value = "交付要求", field = "dliver_claim")
    protected String deliverClaim;

    /**
     * 备注
     */
    protected String remark;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "项目信息", field = "project_id")
    protected Long projectId;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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

    public ProjectDeliverClaimModel() {
    }

    public ProjectDeliverClaimModel(Long projectId) {
        this.projectId = projectId;
    }

    public ProjectDeliverClaimModel(DraftDeliverClaimModel model) {
        this.id = model.getOriginalId();
        this.name = model.getName();
        this.time = model.getTime();
        this.leader = model.getLeader();
        this.deliverClaim = model.getDeliverClaim();
        this.remark = model.getRemark();
        this.projectId = model.getProjectId();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.deliver = model.getDeliver();
        this.deliverStatus = model.getDeliverStatus();
        this.deliverTime = model.getDeliverTime();
        this.verifyer = model.getVerifyer();
        this.verifyerStatus = model.getVerifyerStatus();
        this.verifyerTime = model.getVerifyerTime();
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
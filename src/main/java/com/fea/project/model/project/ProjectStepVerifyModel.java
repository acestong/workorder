package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.model.project.draft.DraftStepVerifyModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/06.
 */
@Data
@TableNameAnno(value = "t_project_step_verify")
public class ProjectStepVerifyModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    private Long id;

    /**
     * 项目
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "step_id", value = "项目阶段")
    private Long stepId;

    /**
     * 名称
     */
    private Integer status;

    /**
     * 确认时间
     */
    private Date verifyTime;

    /**
     * 创建id
     */
    @JsonIgnore
    private Long createId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新id
     */
    @JsonIgnore
    private Long updateId;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 确认人
     */
    @JsonIgnore
    private Long verifyUser;

    /**
     * 确认人名称
     */
    private String verifyBy;

    /**
     * 确备注
     */
    private String remark;

    private Date startTime;
    private Date endTime;
    private BigDecimal workTime;


    public ProjectStepVerifyModel() {

    }

    public ProjectStepVerifyModel(ProjectStepModel model) {
        this.stepId = model.getId();
        this.status = ProjectStepStatusEnum.TYPE_UNVERIFY.getValue();
    }

    public ProjectStepVerifyModel(DraftStepVerifyModel model, Long stepId) {
        this.id = model.getOriginalId();
        this.stepId = stepId;
        this.status = model.getStatus();
        this.verifyTime = model.getVerifyTime();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.verifyUser = model.getVerifyUser();
        this.verifyBy = model.getVerifyBy();
        this.remark = model.getRemark();
        this.startTime = model.getStartTime();
        this.endTime = model.getEndTime();
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

    public void setVerifyInfo(SysUserModel sysUserModel) {
        this.setVerifyBy(sysUserModel.getRealName());
        this.setVerifyUser(sysUserModel.getUserId());
    }
}
package com.fea.project.model.project.history;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.model.project.ProjectStepVerifyModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/19.
 */
@Data
@TableNameAnno(value = "t_project_history_step_verify")
public class HistoryStepVerifyModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 项目
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepId;

    /**
     * 名称
     */
    private Integer status;

    /**
     * 阶段排序
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long verifyUser;

    /**
     * 确认人名称
     */
    private String verifyBy;

    /**
     * 确备注
     */
    private String remark;

    /**
     * 实际开始时间
     */
    private Date startTime;

    /**
     * 实际结束时间
     */
    private Date endTime;

    /**
     * 项目工时
     */
    private BigDecimal workTime;

    /**
     * t_project_step_verify主键id
     */
    @PrimaryKey(field = "id")
    private Long originalId;

    /**
     * 草稿id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long historyId;


    public HistoryStepVerifyModel () {

    }

    public HistoryStepVerifyModel(ProjectStepVerifyModel projectStepVerifyModel) {
        this.stepId = projectStepVerifyModel.getStepId();
        this.status = projectStepVerifyModel.getStatus();
        this.verifyTime = projectStepVerifyModel.getVerifyTime();
        this.createId = projectStepVerifyModel.getCreateId();
        this.createBy = projectStepVerifyModel.getCreateBy();
        this.createTime = projectStepVerifyModel.getCreateTime();
        this.updateId = projectStepVerifyModel.getUpdateId();
        this.updateBy = projectStepVerifyModel.getUpdateBy();
        this.updateTime = projectStepVerifyModel.getUpdateTime();
        this.verifyUser = projectStepVerifyModel.getVerifyUser();
        this.verifyBy = projectStepVerifyModel.getVerifyBy();
        this.remark = projectStepVerifyModel.getRemark();
        this.startTime = projectStepVerifyModel.getStartTime();
        this.endTime = projectStepVerifyModel.getEndTime();
        this.workTime = projectStepVerifyModel.getWorkTime();
        this.originalId = projectStepVerifyModel.getId();
    }

    public HistoryStepVerifyModel(HistoryStepModel model) {
        this.stepId = model.getId();
        this.status = ProjectStepStatusEnum.TYPE_UNVERIFY.getValue();
        this.historyId = model.getHistoryId();
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
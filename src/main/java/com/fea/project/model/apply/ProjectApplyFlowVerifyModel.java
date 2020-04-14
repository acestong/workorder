package com.fea.project.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.apply.ProjectApplyVerifyActionStatusEnum;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.model.apply.vo.ProjectApplyFlowVerifyVo;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.util.DateUtil;
import com.fea.project.util.UserUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/18.
 */
@Data
@TableNameAnno("t_project_apply_flow_verify")
public class ProjectApplyFlowVerifyModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    protected Long id;

    /**
     *
     */
    @JsonIgnore
    protected Long applyFlowId;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Long verifyerId;

    /**
     *
     */
    protected Integer verifyStatus;

    /**
     *
     */
    protected String verifyResult;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date actionTime;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String stopTime;

    /**
     *
     */
    protected String describe;

    /**
     *
     */
    @JsonIgnore
    protected Long createId;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String createBy;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date createTime;

    @NotNullAnno(field = "action_type", value = "操作类型")
    protected Integer actionType;

    public ProjectApplyFlowVerifyModel() {
    }


    public ProjectApplyFlowVerifyModel(Long userId, ProjectBusinessFlowVerifyerModel projectBusinessFlowVerifyerModel
            , SysUserModel sysUserModel, Boolean applyerEqualVerifyer, Long parentId) {
        Date date = new Date();
        this.applyFlowId = projectBusinessFlowVerifyerModel.getId();
        this.verifyerId = userId;
        if (parentId == null && applyerEqualVerifyer) {
            this.verifyStatus = ProjectApplyVerifyStatusEnum.TYPE_APPLY.getValue();
            this.verifyResult = ProjectApplyVerifyActionStatusEnum.TYPE_AGREE.getText();
            this.actionTime = date;
        } else if (applyerEqualVerifyer) {
            this.verifyStatus = ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue();
            this.verifyResult = ProjectApplyVerifyActionStatusEnum.TYPE_AGREE.getText();
            this.actionTime = date;
        } else {
            this.verifyStatus = ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue();
        }
        this.createId = sysUserModel.getUserId();
        this.createBy = sysUserModel.getRealName();
        this.createTime = date;
    }


    public void setBaseInfo(ProjectApplyFlowVerifyVo tmpModel, Date startTime) {
        Date date = new Date();
        if (tmpModel != null) {
            this.id = tmpModel.getId();
        }
        this.stopTime = DateUtil.getStopTime(startTime, date);
        this.verifyerId = UserUtil.getUserId();
        this.actionTime = date;

    }
}
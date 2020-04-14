package com.fea.project.model.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowVerifyerModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long listId;

    /**
     *
     */
    protected Integer personType;

    /**
     *
     */
    protected String detailStr;

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

    /**
     *
     */
    @JsonIgnore
    protected Long updateId;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String updateBy;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date updateTime;

    /**
     *
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;

    //流程签过类型，获签或是全签
    protected Integer verifyType;

    public ProjectFlowVerifyerModel() {
    }

    public ProjectFlowVerifyerModel(SysUserModel sysUserModel) {
        this.setUpdateId(sysUserModel.getUserId());
        this.setUpdateTime(new Date());
        this.setUpdateBy(sysUserModel.getRealName());
        this.delStatus = DeleteStatusEnum.DELETE.getStatus();
    }


    public ProjectFlowVerifyerModel(ProjectBusinessFlowVerifyerModel projectBusinessFlowVerifyerModel) {
        this.id = projectBusinessFlowVerifyerModel.getOriginalId();
        this.listId = projectBusinessFlowVerifyerModel.getListId();
        this.personType = projectBusinessFlowVerifyerModel.getPersonType();
        this.detailStr = projectBusinessFlowVerifyerModel.getDetailStr();
        this.createId = projectBusinessFlowVerifyerModel.getCreateId();
        this.createBy = projectBusinessFlowVerifyerModel.getCreateBy();
        this.createTime = projectBusinessFlowVerifyerModel.getCreateTime();
        this.updateId = projectBusinessFlowVerifyerModel.getUpdateId();
        this.updateBy = projectBusinessFlowVerifyerModel.getUpdateBy();
        this.updateTime = projectBusinessFlowVerifyerModel.getUpdateTime();
        this.delStatus = projectBusinessFlowVerifyerModel.getDelStatus();
        this.parentId = projectBusinessFlowVerifyerModel.getParentId();
        this.verifyType = projectBusinessFlowVerifyerModel.getVerifyType();
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
package com.fea.project.model.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/18.
 */
@Data
public class ProjectApplyModel implements Serializable {
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
    protected String applyCode;

    /**
     *
     */
    protected String name;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessId;

    /**
     *
     */
    protected String businessCode;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long applyerId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long applyDepart;

    /**
     *
     */
    protected Date applyTime;

    /**
     *
     */
    protected Integer verifyStatus;

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
    protected Integer applyType;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Long projectId;

    protected String stopTime;

    protected Long businessFlowId;

    public ProjectApplyModel() {
    }

    public ProjectApplyModel(Long businessId) {
        this.businessId = businessId;
    }

    public ProjectApplyModel(Long id, String applyCode, String name, Long businessId, String businessCode, Long applyerId, Long applyDepart, Date applyTime, Integer verifyStatus, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, Integer applyType, Long projectId, String stopTime, Long businessFlowId) {
        this.id = id;
        this.applyCode = applyCode;
        this.name = name;
        this.businessId = businessId;
        this.businessCode = businessCode;
        this.applyerId = applyerId;
        this.applyDepart = applyDepart;
        this.applyTime = applyTime;
        this.verifyStatus = verifyStatus;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.applyType = applyType;
        this.projectId = projectId;
        this.stopTime = stopTime;
        this.businessFlowId = businessFlowId;
    }

    public ProjectApplyModel(Long id, Integer verifyStatus) {
        this.id = id;
        this.verifyStatus = verifyStatus;
    }

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        Date date = new Date();
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(date);
            this.setCreateBy(model.getRealName());
            this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(date);
            this.setUpdateBy(model.getRealName());
        }
    }
}
package com.fea.project.model.flow;

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
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowListConditionModel implements Serializable {
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
     * 方法id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long listId;
    /**
     * 字段类型
     */
    protected Integer fieldType;
    /**
     * 过滤类型
     */
    protected Integer filterType;
    /**
     * 过滤值
     */
    protected String filterValue;

    /**
     * 条件字符串
     */
    @JsonIgnore
    protected String conditionStr;

    /**
     * 创建人id
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
     * 更新人id
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

    protected Integer actionCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long filterValueUnit;



    public ProjectFlowListConditionModel() {

    }

    public ProjectFlowListConditionModel(SysUserModel sysUserModel) {
        this.updateId = sysUserModel.getUserId();
        this.updateBy = sysUserModel.getRealName();
        this.updateTime = new Date();
        this.delStatus = DeleteStatusEnum.DELETE.getStatus();
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
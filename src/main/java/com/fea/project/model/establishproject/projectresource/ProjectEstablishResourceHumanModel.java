package com.fea.project.model.establishproject.projectresource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2020/01/10.
 */
@Data
public class ProjectEstablishResourceHumanModel implements Serializable {
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
     * 人员id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long userId;

    /**
     * 岗位级别
     */
    protected String dutyLevel;

    /**
     * 个人成本
     */
    protected BigDecimal personnelCost;

    /**
     * 投入时间
     */
    protected BigDecimal investTime;

    /**
     * 创建人id
     */
    @JsonIgnore
    protected Long createId;

    /**
     * 创建人
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
     * 更新人
     */
    protected String updateBy;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 删除标示
     */
    @JsonIgnore
    protected Integer delStatus;

    protected Long projectId;


    public ProjectEstablishResourceHumanModel () {

    }

    public ProjectEstablishResourceHumanModel(Long userId, SysUserModel sysUserModel, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
        this.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
    }

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(new Date());
            this.setCreateBy(model.getRealName());
            this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(new Date());
            this.setUpdateBy(model.getRealName());
        }
    }



}
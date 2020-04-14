package com.fea.project.model.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProjectFlowCopyerModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long listId;

    /**
     *
     */
    private Integer personType;

    /**
     *
     */
    private String detailStr;

    /**
     *
     */
    @JsonIgnore
    private Long createId;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    @JsonIgnore
    private Long updateId;

    /**
     *
     */
    private String updateBy;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    @JsonIgnore
    private Integer delStatus;


    public ProjectFlowCopyerModel() {
    }

    public ProjectFlowCopyerModel(SysUserModel sysUserModel) {
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
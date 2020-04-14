package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.project.pojo.ProjectContactorPojo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/24.
 */
@Data
@TableNameAnno(value = "t_project_project_contactor")
public class ProjectContactorModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 项目id
     */
    @NotNullAnno(field = "project_id", value = "项目id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    /**
     * 联系人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long contactorId;

    /**
     * 客户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long customerId;

    /**
     * 创建人
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
     * 更新人
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
    protected Integer delStatus;

    /**
     * 说明
     */
    protected String remark;

    public ProjectContactorModel() {
    }

    public ProjectContactorModel(ProjectContactorPojo model, Long contactorId) {
        this.projectId = model.getProjectId();
        this.contactorId = contactorId;
        this.customerId = model.getProjectId();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.remark = model.getRemark();
    }

    public void setUserInfo(SysUserModel sysUserModel, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(sysUserModel.getUserId());
            this.setCreateBy(sysUserModel.getRealName());
            this.setCreateTime(new Date());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(sysUserModel.getUserId());
            this.setUpdateBy(sysUserModel.getRealName());
            this.setUpdateTime(new Date());
        }
    }
}
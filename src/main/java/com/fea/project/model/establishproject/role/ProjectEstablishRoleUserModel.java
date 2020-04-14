package com.fea.project.model.establishproject.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishRoleUserPojo;
import com.fea.project.model.project.ProjectModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
@TableNameAnno(value = "t_project_establish_role_user")
public class ProjectEstablishRoleUserModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    protected Long id;

    /**
     * 角色id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "role_id", value = "角色信息")
    protected Long roleId;

    /**
     * 用户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long userId;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createId;

    /**
     * 创建人姓名
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
     * 更新人姓名
     */
    protected String updateBy;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 删除状态
     */
    @JsonIgnore
    protected Integer delStatus;

    public ProjectEstablishRoleUserModel() {

    }

    public ProjectEstablishRoleUserModel(Long id, Long roleId, Long userId, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
    }

    public ProjectEstablishRoleUserModel(ProjectEstablishRoleModel projectRoleModel, ProjectModel projectModel, SysUserModel sysUserModel, ActionEnum actionEnum) {
        this.roleId = projectRoleModel.getId();
        this.userId = projectModel.getLeader();
        this.setUserInfo(sysUserModel, actionEnum);
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
    }

    public ProjectEstablishRoleUserModel(Long userId, ProjectEstablishRoleUserPojo model) {
        this.roleId = model.getRoleId();
        this.userId = userId;
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
    }

    public ProjectEstablishRoleUserModel(ProjectEstablishUserModel establishLeader, Long roleId, SysUserModel sysUserModel) {
        this.roleId = roleId;
        this.userId = establishLeader.getId();
        this.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
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
package com.fea.project.model.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
@TableNameAnno(value = "t_project_role_authority")
public class ProjectRoleAuthorityModel implements Serializable {
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
     * 名称
     */
    @NotNullAnno(field = "name", value = "权限类型名称")
    protected String name;

    /**
     * 启用状态
     */
    protected Integer status;


    /**
     * 删除标识
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     * 创建人id
     */
    @JsonIgnore
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
    @JsonIgnore
    protected Long updateId;

    /**
     * 更新人姓名
     */
    protected String updateBy;

    /**
     * 更新人时间
     */
    protected Date updateTime;

    /**
     * 父节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;

    @JsonIgnore
    protected Long serialId;

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(new Date());
            this.setCreateBy(model.getRealName());
            this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            this.setStatus(EnableStatusEnum.ENABLE.getStatus());
            this.setSerialId(System.currentTimeMillis());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(new Date());
            this.setUpdateBy(model.getRealName());
        }
    }

}
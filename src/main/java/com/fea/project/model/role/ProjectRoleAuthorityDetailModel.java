package com.fea.project.model.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.configure.annotations.base.UniqueCheckAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/18.
 */
@Data
@TableNameAnno(value = "t_project_role_authority_detail")
public class ProjectRoleAuthorityDetailModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    private Long id;

    /**
     * 名称
     */
    @NotNullAnno(field = "name", value = "权限名称")
    private String name;

    /**
     * 启用状态
     */
    @NotNullAnno(field = "signatures", value = "权限特征码")
    @UniqueCheckAnno(field = "signatures", value = "权限特征码")
    private String signatures;

    /**
     * 删除标识
     */
    @JsonIgnore
    private Integer delStatus;

    /**
     * 创建人id
     */
    @JsonIgnore
    private Long createId;

    /**
     * 创建人姓名
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonIgnore
    private Long updateId;

    /**
     * 更新人姓名
     */
    private String updateBy;

    /**
     * 更新人时间
     */
    private Date updateTime;

    /**
     * 父节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long authorityId;

    @JsonIgnore
    private Long serialId;

    private Integer actionType;

    public ProjectRoleAuthorityDetailModel() {
    }

    public ProjectRoleAuthorityDetailModel(Long authorityId) {
        this.authorityId = authorityId;
    }

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(new Date());
            this.setCreateBy(model.getRealName());
            this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            this.setSerialId(System.currentTimeMillis());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(new Date());
            this.setUpdateBy(model.getRealName());
        }
    }
}
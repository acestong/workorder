package com.fea.project.model.establishproject.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.ConditionStatusAnno;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.team.ProjectDefaultRoleEnum;
import com.fea.project.model.establishproject.vo.ProjectEstablishProjectVo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
@TableNameAnno(value = "t_project_establish_role")
public class ProjectEstablishRoleModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 项目id
     */
    @ConditionStatusAnno(field = "project_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 角色名称
     */
    @NotNullAnno(field = "name", value = "角色名称")
    private String name;

    /**
     * 人天成本
     */
    private BigDecimal cost;

    /**
     * 角色描述
     */
    private String content;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人名称
     */
    private String createBy;

    /**
     * 创建人时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新人时间
     */
    private Date updateTime;

    /**
     * 删除状态
     */
    @JsonIgnore
    private Integer delStatus;

    private Integer canEdit;

    private String shortName;

    public ProjectEstablishRoleModel() {
    }

    public ProjectEstablishRoleModel(ProjectDefaultRoleEnum typeProjectAdmin, SysUserModel sysUserModel, ProjectEstablishProjectVo projectEstablishProjectVo, ActionEnum actionEnum) {
        this.projectId = projectEstablishProjectVo.getProjectId();
        this.name = typeProjectAdmin.getText();
        this.content = typeProjectAdmin.getText();
        this.setUserInfo(sysUserModel, actionEnum);
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
        this.canEdit = EnableStatusEnum.DISABLE.getStatus();
        this.shortName = typeProjectAdmin.getShortName();
    }

    public ProjectEstablishRoleModel(Long projectId) {
        this.projectId = projectId;
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
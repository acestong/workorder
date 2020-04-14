package com.fea.project.model.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityConfigPojo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
public class ProjectRoleAuthorityConfigModel implements Serializable {
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
    private Long roleId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long authorityDetailId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date createTime;

    public ProjectRoleAuthorityConfigModel() {
    }


    public ProjectRoleAuthorityConfigModel(Long roleId) {
        this.roleId = roleId;
    }

    public ProjectRoleAuthorityConfigModel(Long roleId, Long authorityDetailId, SysUserModel sysUserModel) {
        this.roleId = roleId;
        this.authorityDetailId = authorityDetailId;
        this.createId = sysUserModel.getUserId();
        this.createBy = sysUserModel.getRealName();
        this.createTime = new Date();

    }

    public static List<ProjectRoleAuthorityConfigModel> createList(ProjectRoleAuthorityConfigPojo model, SysUserModel sysUserModel) {
        return model.getAuthorityDetailIds().stream().map(tmp -> new ProjectRoleAuthorityConfigModel
                (model.getRoleId(), tmp, sysUserModel)).collect(Collectors.toList());
    }
}
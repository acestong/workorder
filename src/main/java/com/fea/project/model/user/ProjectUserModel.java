package com.fea.project.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.user.UserStatusEnum;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.team.pojo.ProjectTeamUserPojo;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/29.
 */
@Data
@TableNameAnno(value = "t_project_user")
public class ProjectUserModel implements Serializable {
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    /**
     * 项目用户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long userId;

    /**
     * 状态
     */
    protected Integer status;

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



    public ProjectUserModel(ProjectModel projectModel, Long userId, ActionEnum actionEnum) {
        this.projectId = projectModel.getId();
        this.userId = userId;
        this.status = UserStatusEnum.TYPE_NORMAL.getValue();
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.createId = projectModel.getCreateId();
            this.createBy = projectModel.getCreateBy();
            this.createTime = projectModel.getCreateTime();
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.createId = projectModel.getUpdateId();
            this.createBy = projectModel.getUpdateBy();
            this.createTime = projectModel.getUpdateTime();
        }
    }

    public ProjectUserModel() {

    }

    public ProjectUserModel(Long projectId, Integer status) {
        this.projectId = projectId;
        this.status = status;
    }


    public ProjectUserModel(Long userId, Long projectId, SysUserModel sysUserModel) {
        this.projectId = projectId;
        this.userId = userId;
        this.status = UserStatusEnum.TYPE_NORMAL.getValue();
        this.createId = sysUserModel.getUserId();
        this.createBy = sysUserModel.getRealName();
        this.createTime = new Date();
    }

    public ProjectUserModel(Long projectId) {
        this.projectId = projectId;
    }

    public ProjectUserModel(Long projectId, Long userId, SysUserModel sysUserModel, ActionEnum actionEnum) {
        this.projectId = projectId;
        this.userId = userId;
        this.status = UserStatusEnum.TYPE_NORMAL.getValue();
        this.setUserInfo(sysUserModel, actionEnum);
    }

    public static List<ProjectUserModel> createList(ProjectModel projectModel, ActionEnum actionEnum) {
        Set<Long> partners = new HashSet<>(projectModel.getPartners());
        partners.add(projectModel.getLeader());
        return partners.stream().map(tmp -> new ProjectUserModel(projectModel, tmp, actionEnum)).collect(Collectors.toList());
    }

    public static List<ProjectUserModel> createList(Set<Long> partners, Long projectId, SysUserModel sysUserModel, ActionEnum actionEnum) {
        return partners.stream().map(tmp -> new ProjectUserModel(projectId, tmp, sysUserModel, actionEnum)).collect(Collectors.toList());
    }

    public static List<ProjectUserModel> createList(ProjectTeamUserPojo model, Long projectId, SysUserModel sysUserModel) {
        if (model == null || ListUtil.isNullOrEmpty(model.getUserIds())) {
            return new ArrayList<>();
        }
        List<ProjectUserModel> models = new ArrayList<>();
        return model.getUserIds().stream().map(tmp -> new ProjectUserModel(tmp, projectId, sysUserModel)).collect(Collectors.toList());
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
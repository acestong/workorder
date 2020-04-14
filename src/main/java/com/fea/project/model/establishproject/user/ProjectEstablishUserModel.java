package com.fea.project.model.establishproject.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.user.UserStatusEnum;
import com.fea.project.model.establishproject.pojo.ProjectEstablishProjectPojo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamUserPojo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/29.
 */
@Data
@TableNameAnno(value = "t_project_establish_user")
public class ProjectEstablishUserModel implements Serializable {
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



    public ProjectEstablishUserModel(ProjectModel projectModel, Long userId, ActionEnum actionEnum) {
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

    public ProjectEstablishUserModel() {

    }

    public ProjectEstablishUserModel(Long projectId, Integer status) {
        this.projectId = projectId;
        this.status = status;
    }


    public ProjectEstablishUserModel(Long userId, Long projectId, SysUserModel sysUserModel) {
        this.projectId = projectId;
        this.userId = userId;
        this.status = UserStatusEnum.TYPE_NORMAL.getValue();
        this.createId = sysUserModel.getUserId();
        this.createBy = sysUserModel.getRealName();
        this.createTime = new Date();
    }

    public ProjectEstablishUserModel(Long projectId) {
        this.projectId = projectId;
    }


    public static List<ProjectEstablishUserModel> createList(ProjectEstablishProjectPojo projectModel, ActionEnum actionEnum) {
        Set<Long> partners = new HashSet<>(projectModel.getEstablishPartners());
        partners.add(projectModel.getEstablishLeader());
        return partners.stream().map(tmp -> new ProjectEstablishUserModel(projectModel, tmp, actionEnum)).collect(Collectors.toList());
    }



    public static List<ProjectEstablishUserModel> createList(ProjectEstablishTeamUserPojo model, Long projectId, SysUserModel sysUserModel) {
        if (model == null || ListUtil.isNullOrEmpty(model.getUserIds())) {
            return new ArrayList<>();
        }
        return model.getUserIds().stream().map(tmp -> new ProjectEstablishUserModel(tmp, projectId, sysUserModel)).collect(Collectors.toList());
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
package com.fea.project.model.team;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.ConditionStatusAnno;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.model.project.ProjectModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
@TableNameAnno("t_project_team")
public class ProjectTeamModel implements Serializable {
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
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ConditionStatusAnno(field = "project_id")
    protected Long projectId;

    /**
     *
     */
    @NotNullAnno(field = "name", value = "团队名称")
    protected String name;

    /**
     *
     */
    protected Long parentId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "leader", value = "团队负责人")
    protected Long leader;

    /**
     *
     */
    protected String content;

    /**
     *
     */
    protected String responsibility;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createId;

    /**
     *
     */
    protected String createBy;

    /**
     *
     */
    protected Date createTime;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long updateId;

    /**
     *
     */
    protected String updateBy;

    /**
     *
     */
    protected Date updateTime;

    /**
     *
     */
    @JsonIgnore
    protected Integer delStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long regId;

    protected Integer canDelete;

    protected Long index;

    protected String shortName;

    public ProjectTeamModel() {

    }


    public ProjectTeamModel(ProjectDefaultTeamEnum tmp) {
        this.name = tmp.getText();
        this.content = tmp.getResponsibility();
        this.responsibility = tmp.getResponsibility();
        this.canDelete = tmp.getCanDelete();
        this.index = tmp.getValue();
        this.shortName = tmp.getShortName();
    }

    public ProjectTeamModel(SysUserModel sysUserModel, ProjectModel projectModel, ActionEnum actionEnum) {
        this.projectId = projectModel.getId();
        this.name = projectModel.getName() + "项目团队";
        this.leader = projectModel.getLeader();
        this.content = this.name;
        this.setUserInfo(sysUserModel, actionEnum);
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
        this.regId = sysUserModel.getRegId();
        this.canDelete = ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getCanDelete();
        this.shortName = ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName();
        this.index = ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getValue();
    }

    public static List<ProjectTeamModel> createExchangeIndexList(List<ProjectTeamModel> projectTeamModels, SysUserModel userModel) {
        ProjectTeamModel first = projectTeamModels.get(0);
        ProjectTeamModel second = projectTeamModels.get(1);
        Long index = first.getIndex();
        first.setIndex(second.getIndex());
        second.setIndex(index);
        first.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        second.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        return projectTeamModels;
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
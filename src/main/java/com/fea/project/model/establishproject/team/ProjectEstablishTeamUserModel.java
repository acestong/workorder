package com.fea.project.model.establishproject.team;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.SortKeyQueryAnno;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamUserPojo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
@TableNameAnno(value = "t_project_establish_team_user")
public class ProjectEstablishTeamUserModel implements Serializable {
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
     * 队伍id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "team_id", value = "队伍id")
    protected Long teamId;

    /**
     * 用户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long userId;

    /**
     * 开始时间
     */
    @SortKeyQueryAnno(field = "start_time")
    protected Date startTime;

    /**
     * 结束时间
     */
    @SortKeyQueryAnno(field = "end_time")
    protected Date endTime;

    /**
     * 持续时间
     */
    @SortKeyQueryAnno(field = "duration")
    protected Integer duration;

    /**
     * 投入项目时间比例
     */
    @SortKeyQueryAnno(field = "time_percent")
    protected BigDecimal timePercent;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createId;

    /**
     * 创建人
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
     * 更新人
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

    //判断当前项目团队节点是否是根节点
    protected Boolean canRoot;


    public ProjectEstablishTeamUserModel() {
    }

    public ProjectEstablishTeamUserModel(ProjectEstablishUserModel projectEstablishUserModel, Long teamId, SysUserModel sysUserModel) {
        this.teamId = teamId;
        this.userId = projectEstablishUserModel.getId();
        this.startTime = projectEstablishUserModel.getCreateTime();
        this.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
    }

    public ProjectEstablishTeamUserModel(Long teamId) {
        this.teamId = teamId;
    }


    public ProjectEstablishTeamUserModel(Long userId, Long teamId, SysUserModel userModel) {
        this.teamId = teamId;
        this.userId = userId;
        this.setUserInfo(userModel, ActionEnum.INSERT_ACTION);
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
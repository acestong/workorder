package com.fea.project.model.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
@Data
@TableNameAnno(value = "t_project_config")
public class ProjectConfigModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    protected Long id;

    /**
     * 组织id
     */
    @JsonIgnore
    protected Long regId;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    /**
     * 类型id
     */
    @NotNullAnno(field = "type_id", value = "设置类型")
    protected Integer typeId;

    /**
     * 启用状态
     */
    @NotNullAnno(field = "state", value = "启用状态")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Integer state;

    /**
     * 备用字段，流程存储流程id，结项评价存储评价类型
     */
    protected String remark;

    /**
     * 创建人id
     */
    @JsonIgnore
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
    @JsonIgnore
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
     * 删除标示
     */
    @JsonIgnore
    protected Integer delStatus;

    protected String typeCode;

    protected String typeName;


    public ProjectConfigModel() {
    }

    public ProjectConfigModel(ProjectConfigEnum targetEnum, SysUserModel sysUserModel, Long projectId, Date date) {
        this.regId = sysUserModel.getRegId();
        this.projectId = projectId;
        this.typeId = targetEnum.getValue();
        this.state = EnableStatusEnum.ENABLE.getStatus();
        this.createId = sysUserModel.getUserId();
        this.createBy = sysUserModel.getRealName();
        this.createTime = date;
        this.updateId = sysUserModel.getUserId();
        this.updateBy = sysUserModel.getRealName();
        this.updateTime = date;
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
        this.typeCode = targetEnum.getType();
        this.typeName = targetEnum.getDescribe();
    }

    public ProjectConfigModel(Long projectId, Integer typeId) {
        this.projectId = projectId;
        this.typeId = typeId;
    }

    public static List<ProjectConfigModel> createList(ProjectConfigEnum[] values, SysUserModel sysUserModel, Long projectId) {
        List<ProjectConfigModel> list = new ArrayList<>();
        Date now = new Date();
        for (int i = 0; i < values.length; i++) {
            list.add(new ProjectConfigModel(values[i], sysUserModel, projectId, now));
        }
        return list;
    }

    public void setUserInfo(SysUserModel sysUserModel, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.createBy = sysUserModel.getRealName();
            this.createId = sysUserModel.getUserId();
            this.createTime = new Date();
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.updateBy = sysUserModel.getRealName();
            this.updateId = sysUserModel.getUserId();
            this.updateTime = new Date();
        }
    }

}
package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.*;
import com.fea.project.enums.base.ActionEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/23.
 */
@Data
@TableNameAnno(value = "t_project_step")
public class ProjectStepModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 项目
     */
    @NotNullAnno(value = "项目信息", field = "project_id")
    @ConditionStatusAnno(field = "project_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    /**
     * 名称
     */
    @NotNullAnno(value = "阶段名称", field = "name")
    @UniqueCheckAnno(value = "阶段名称", field = "name")
    protected String name;

    /**
     * 阶段排序
     */
    protected Integer index;

    /**
     * 开始时间
     */
    protected Date startTime;

    /**
     * 结束时间
     */
    protected Date endTime;

    /**
     * 工期
     */
    protected Integer duration;

    /**
     * 责任人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long leader;

    /**
     * 阶段内容
     */
    protected String content;

    /**
     * 交付物
     */
    protected String deliverClaim;

    /**
     * 删除标识
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     * 创建id
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
     * 更新id
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

    public ProjectStepModel() {
    }

    public ProjectStepModel(Long projectId) {
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
package com.fea.project.model.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.ConditionStatusAnno;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/08.
 */
@Data
@TableNameAnno(value = "t_project_config_estimate_percent")
public class ProjectConfigEstimatePercentModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    private Long id;

    /**
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ConditionStatusAnno(field = "project_id")
    private Long projectId;

    /**
     * 执行动作id
     */
    @NotNullAnno(field = "action_id", value = "比较符")
    private Integer actionId;

    /**
     * 执行动作名称
     */
    private String actionName;

    /**
     * 交付物评价设置主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;

    /**
     * 评价类型id
     */
    @NotNullAnno(field = "estimate_id", value = "评价类型")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long estimateId;

    /**
     * 评价类型名称
     */
    private String estimateName;

    /**
     * 类型id
     */
    @NotNullAnno(field = "type_id", value = "评价类型")
    private Integer typeId;

    /**
     * 权重值
     */
    private BigDecimal value;

    /**
     * 创建id
     */
    @JsonIgnore
    private Long createId;

    /**
     * 创建人
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
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    @JsonIgnore
    private Integer delStatus;

    public ProjectConfigEstimatePercentModel() {
    }

    public ProjectConfigEstimatePercentModel(Long businessId, Integer typeId) {
        this.businessId = businessId;
        this.typeId = typeId;
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
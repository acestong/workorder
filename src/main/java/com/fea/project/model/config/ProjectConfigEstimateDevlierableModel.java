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
@TableNameAnno(value = "t_project_config_estimate_devlierable")
public class ProjectConfigEstimateDevlierableModel implements Serializable {
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
    @ConditionStatusAnno(field = "project_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 交付物id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "deliverable_id", value = "交付物id为必填项")
    private Long deliverableId;

    /**
     * 质量评价权重
     */
    private BigDecimal qualityEstimateWeight;

    /**
     * 时间评价权重
     */
    private BigDecimal timeEstimateWeight;

    /**
     * 创建人id
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
     * 删除标示
     */
    @JsonIgnore
    private Integer delStatus;

    public ProjectConfigEstimateDevlierableModel() {
    }

    public ProjectConfigEstimateDevlierableModel(Long deliverableId) {
        this.deliverableId = deliverableId;
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
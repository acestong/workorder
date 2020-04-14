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
@TableNameAnno(value = "t_project_config_estimate_close")
public class ProjectConfigEstimateCloseModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
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
     * 结项id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(field = "close_id", value = "结项参数")
    private Long closeId;

    /**
     * 质量评价权重
     */
    private BigDecimal qualityEstimateWeight;

    /**
     * 时间评价权重
     */
    private BigDecimal timeEstimateWeight;

    /**
     * 价格评价权重
     */
    private BigDecimal priceEstimateWeight;

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
     * 更新id
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

    /**
     * 项目评价类型
     */
    @NotNullAnno(field = "type_id", value = "项目评价类型")
    private Integer typeId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepId;

    private BigDecimal stepWeight;

    public ProjectConfigEstimateCloseModel() {
    }

    public ProjectConfigEstimateCloseModel(Long closeId, Integer typeId) {
        this.closeId = closeId;
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
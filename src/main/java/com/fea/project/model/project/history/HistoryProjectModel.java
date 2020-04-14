package com.fea.project.model.project.history;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.RegAutoSetAnno;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.project.vo.ProjectVo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 * 项目信息表 实体类
 */
@Data
@TableNameAnno(value = "t_project_history_project")
public class HistoryProjectModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     *
     */
    protected String name;

    /**
     * 编号
     */
    protected String code;

    /**
     * 类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long type;

    /**
     * 优先级
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long priority;

    /**
     * 项目级别
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long level;

    /**
     * 风险级别
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long riskLevel;

    /**
     * 来源
     */
    protected Integer resource;

    /**
     * 关联的业务id
     */
    protected String connectId;

    /**
     * 其他类型使用-来源说明
     */
    protected String resourceDescribe;

    /**
     * 参与人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected List<Long> partners;

    /**
     * 申请人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long applyer;

    /**
     * 申请部门
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long applyDepart;

    /**
     * 计划开始时间
     */
    protected Date planStartTime;

    /**
     * 计划结束时间
     */
    protected Date planEndTime;

    /**
     * 项目工期
     */
    protected BigDecimal duration;

    /**
     * 项目负责人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long leader;

    /**
     * 备注
     */
    protected String remark;

    /**
     * 创建人id
     */
    @JsonIgnore
    protected Long createId;

    /**
     * 创建人名称
     */
    protected String createBy;

    /**
     * 创建人时间
     */
    protected Date createTime;

    /**
     * 更新人id
     */
    @JsonIgnore
    protected Long updateId;

    /**
     * 更新人名称
     */
    protected String updateBy;

    /**
     * 更新人时间
     */
    protected Date updateTime;

    /**
     * 删除标识
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     * 组织id
     */
    @JsonIgnore
    @RegAutoSetAnno
    protected Long regId;

    /**
     * 父项目
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;

    /**
     * 实际工期
     */
    protected BigDecimal realDuration;

    /**
     * 实际开始时间
     */
    protected Date realStartTime;

    /**
     * 实际结束时间
     */
    protected Date realEndTime;

    /**
     * 审核状态
     */
    protected Integer verifyStatus;

    /**
     * 是否立项
     */
    protected Integer establishment;

    /**
     * 项目状态
     */
    protected Integer projectStatus;

    /**
     * 执行状态
     */
    protected Integer actionStatus;

    /**
     * 版本号
     */
    protected Long version;

    /**
     * 草稿归属用户
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long draftUser;

    /**
     * 真实id
     */
    @PrimaryKey(field = "id")
    protected Long originalId;

    /**
     * 项目内容
     */
    protected String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long area;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long industry;

    protected BigDecimal budget;

    protected Long currencyId;



    public HistoryProjectModel () {
    }

    public HistoryProjectModel(ProjectVo projectVo, Long userId) {
        this.name = projectVo.getName();
        this.code = projectVo.getCode();
        this.type = projectVo.getType();
        this.priority = projectVo.getPriority();
        this.level = projectVo.getLevel();
        this.riskLevel = projectVo.getRiskLevel();
        this.resource = projectVo.getResource();
        this.connectId = projectVo.getConnectId();
        this.resourceDescribe = projectVo.getResourceDescribe();
        this.partners = projectVo.getPartners();
        this.applyer = projectVo.getApplyer();
        this.applyDepart = projectVo.getApplyDepart();
        this.planStartTime = projectVo.getPlanStartTime();
        this.planEndTime = projectVo.getPlanEndTime();
        this.duration = projectVo.getDuration();
        this.leader = projectVo.getLeader();
        this.remark = projectVo.getRemark();
        this.createId = projectVo.getCreateId();
        this.createBy = projectVo.getCreateBy();
        this.createTime = projectVo.getCreateTime();
        this.updateId = projectVo.getUpdateId();
        this.updateBy = projectVo.getUpdateBy();
        this.updateTime = projectVo.getUpdateTime();
        this.delStatus = projectVo.getDelStatus();
        this.regId = projectVo.getRegId();
        this.parentId = projectVo.getParentId();
        this.realDuration = projectVo.getRealDuration();
        this.realStartTime = projectVo.getRealStartTime();
        this.realEndTime = projectVo.getRealEndTime();
        this.verifyStatus = projectVo.getVerifyStatus();
        this.establishment = projectVo.getEstablishment();
        this.projectStatus = projectVo.getProjectStatus();
        this.actionStatus = projectVo.getActionStatus();
        this.version = projectVo.getVersion();
        this.originalId = projectVo.getId();
        this.content = projectVo.getContent();
        this.draftUser = userId;
        this.area = projectVo.getArea();
        this.industry = projectVo.getIndustry();
        this.budget = projectVo.getBudget();
        this.currencyId = projectVo.getCurrencyId();
    }

    public HistoryProjectModel(Long id) {
        this.id = id;
    }

    public HistoryProjectModel(Long id, Integer verifyStatus) {
        this.id = id;
        this.verifyStatus = verifyStatus;
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
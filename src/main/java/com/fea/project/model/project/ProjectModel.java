package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.*;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectActionStatusEnum;
import com.fea.project.enums.project.ProjectEstablishmentEnum;
import com.fea.project.enums.project.ProjectStatusEnum;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectStartModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2019/09/23.
 * 项目信息表 实体类
 */
@Data
@TableNameAnno(value = "t_project_project")
public class ProjectModel implements Serializable {
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

    @NotNullAnno(field = "name", value = "项目名称")
    protected String name;

    /**
     * 编号
     */
    protected String code;

    /**
     * 类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "项目类型", field = "type")
    @SortKeyQueryAnno(field = "type")
    protected Long type;

    /**
     * 优先级
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "项目优先级", field = "priority")
    @SortKeyQueryAnno(field = "priority")
    protected Long priority;

    /**
     * 项目级别
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "项目级别", field = "level")
    @SortKeyQueryAnno(field = "level")
    protected Long level;

    /**
     * 风险级别
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "风险级别", field = "risk_level")
    @SortKeyQueryAnno(field = "risk_level")
    protected Long riskLevel;

    /**
     * 来源
     */
    @NotNullAnno(value = "项目来源", field = "resource")
    @SortKeyQueryAnno(field = "resource")
    protected Integer resource;


    /**
     * 关联的业务id
     */
    protected String connectId;

    /**
     * 来源描述
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
    @NotNullAnno(value = "申请人", field = "applyer")
    @SortKeyQueryAnno(field = "applyer")
    protected Long applyer;

    /**
     * 申请部门
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @SortKeyQueryAnno(field = "apply_depart")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected BigDecimal duration;

    /**
     * 项目负责人
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNullAnno(value = "项目负责人", field = "leader")
    @SortKeyQueryAnno(field = "leader")
    protected Long leader;

    /**
     * 备注
     */
    protected String remark;

    /**
     * 项目内容
     */
    protected String content;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createId;

    /**
     * 创建人名称
     */
    protected String createBy;

    /**
     * 创建人时间
     */
    @SortKeyQueryAnno(field = "create_time")
    protected Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    protected Integer delStatus;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ConditionStatusAnno(field = "reg_id")
    protected Long regId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;

    /**
     * 实际工期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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

    protected Boolean attention;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long version;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long area;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long industry;

    protected BigDecimal budget;

    protected Long currencyId;




    public ProjectModel() {
    }


    public ProjectModel(Long id) {
        this.id = id;
    }

    public ProjectModel(Long id, Integer verifyStatus) {
        this.id = id;
        this.verifyStatus = verifyStatus;
    }

    public ProjectModel(Long id, Long version, Integer verifyStatus) {
        this(id, verifyStatus);
        this.version = version;
    }

    public ProjectModel(DraftProjectModel draftProjectModel, Long versionId) {
        this.id = draftProjectModel.getOriginalId();
        this.name = draftProjectModel.getName();
        this.code = draftProjectModel.getCode();
        this.type = draftProjectModel.getType();
        this.priority = draftProjectModel.getPriority();
        this.level = draftProjectModel.getLevel();
        this.riskLevel = draftProjectModel.getRiskLevel();
        this.resource = draftProjectModel.getResource();
        this.connectId = draftProjectModel.getConnectId();
        this.resourceDescribe = draftProjectModel.getResourceDescribe();
        this.partners = draftProjectModel.getPartners();
        this.applyer = draftProjectModel.getApplyer();
        this.applyDepart = draftProjectModel.getApplyDepart();
        this.planStartTime = draftProjectModel.getPlanStartTime();
        this.planEndTime = draftProjectModel.getPlanEndTime();
        this.duration = draftProjectModel.getDuration();
        this.leader = draftProjectModel.getLeader();
        this.remark = draftProjectModel.getRemark();
        this.content = draftProjectModel.getContent();
        this.updateId = draftProjectModel.getUpdateId();
        this.updateBy = draftProjectModel.getUpdateBy();
        this.updateTime = draftProjectModel.getUpdateTime();
        this.realDuration = draftProjectModel.getRealDuration();
        this.realStartTime = draftProjectModel.getRealStartTime();
        this.realEndTime = draftProjectModel.getRealEndTime();
        this.establishment = draftProjectModel.getEstablishment();
        this.version = versionId;
        this.area = draftProjectModel.getArea();
        this.industry = draftProjectModel.getIndustry();
        this.budget = draftProjectModel.getBudget();
        this.currencyId = draftProjectModel.getCurrencyId();
    }

    public ProjectModel(Long id, SysUserModel userModel) {
        this.id = id;
        this.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        this.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
    }

    public static ProjectModel createUpdateEstablishModel(Long id, Integer establishMent) {
        ProjectModel model = new ProjectModel();
        model.setId(id);
        model.setEstablishment(establishMent);
        return model;
    }

    public ProjectModel fillInsertBaseInfo(SysUserModel sysUserModel, String code) {
        this.setRegId(sysUserModel.getRegId());
        this.setCode(code);
        this.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        return this;
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

    public void setInitStatus() {
        this.verifyStatus = ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue();
        this.establishment = ProjectEstablishmentEnum.TYPE_ESTABLISHMENT_NOT.getValue();
        this.projectStatus = ProjectStatusEnum.getInitStatus();
        this.actionStatus = ProjectActionStatusEnum.getInitStatus();
    }

    public Set<Long> translateDicIdsToSet() {
        Set<Long> sets = new HashSet<>();
        if (this.getType() != null) {
            sets.add(this.getType());
        }
        if (this.getPriority() != null) {
            sets.add(this.getPriority());
        }
        if (this.getLevel() != null) {
            sets.add(this.getLevel());
        }
        if (this.getRiskLevel() != null) {
            sets.add(this.getRiskLevel());
        }
        return sets;
    }

    /**
     * 立项启动时，项目信息更新
     * @param model
     * @param userModel
     */
    public void setStartModel(ProjectEstablishProjectStartModel model, SysUserModel userModel) {
        this.setLeader(model.getLeader());
        this.setPlanStartTime(model.getPlanStartTime());
        this.setPlanEndTime(model.getPlanEndTime());
        this.setDuration(model.getDuration());
        this.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
    }
}
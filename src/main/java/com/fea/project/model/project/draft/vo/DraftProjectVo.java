package com.fea.project.model.project.draft.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.io.project.IProjectBusinessModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.vo.ProjectVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/12 9:58
 **/
@Data
public class DraftProjectVo extends DraftProjectModel {

    //关联业务models
    private List<IProjectBusinessModel> projectBusinessModels;


    private BigDecimal schedule;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long alarmLevel;

    private String applyerName;

    private String leaderName;

    private String parterNames;

    private String DeptName;

    /**
     * 关联业务名称
     */
    private String connectBusinessName;

    /**
     * 当前阶段
     */
    private Integer currentStep;

    private String currentStepName;

    /**
     * 审核状态
     */
    private String verifyStatusName;

    /**
     * 是否立项
     */
    private String establishmentName;

    /**
     * 项目状态
     */
    private String projectStatusName;

    /**
     * 执行状态
     */
    private String actionStatusName;

    private String typeName;

    private String priorityName;

    private String levelName;

    private String riskLevelName;

    private String resourceName;

    private String versionCode;

    public DraftProjectVo() {
    }

    public ProjectVo createProjectModel() {
        ProjectVo projectVo = new ProjectVo();
        projectVo.setId(this.getOriginalId());
        projectVo.setName(this.getName());
        projectVo.setCode(this.getCode());
        projectVo.setType(this.getType());
        projectVo.setPriority(this.getPriority());
        projectVo.setLevel(this.getLevel());
        projectVo.setRiskLevel(this.riskLevel);
        projectVo.setResource(this.getResource());
        projectVo.setConnectId(this.getConnectId());
        projectVo.setResourceDescribe(this.getResourceDescribe());
        projectVo.setPartners(this.getPartners());
        projectVo.setApplyer(this.getApplyer());
        projectVo.setApplyDepart(this.getApplyDepart());
        projectVo.setPlanStartTime(this.getPlanStartTime());
        projectVo.setPlanEndTime(this.getPlanEndTime());
        projectVo.setDuration(this.getDuration());
        projectVo.setLeader(this.getLeader());
        projectVo.setRemark(this.getRemark());
        projectVo.setContent(this.getContent());
        projectVo.setCreateId(this.getCreateId());
        projectVo.setCreateBy(this.getCreateBy());
        projectVo.setCreateTime(this.getCreateTime());
        projectVo.setUpdateId(this.getUpdateId());
        projectVo.setUpdateBy(this.getUpdateBy());
        projectVo.setUpdateTime(this.getUpdateTime());
        projectVo.setDelStatus(this.getDelStatus());
        projectVo.setRegId(this.getRegId());
        projectVo.setParentId(this.getParentId());
        projectVo.setRealDuration(this.getRealDuration());
        projectVo.setRealStartTime(this.getRealStartTime());
        projectVo.setRealEndTime(this.getRealEndTime());
        projectVo.setVerifyStatus(this.getVerifyStatus());
        projectVo.setEstablishment(this.getEstablishment());
        projectVo.setProjectStatus(this.getProjectStatus());
        projectVo.setActionStatus(this.getActionStatus());
        projectVo.setVersion(this.getVersion());
        return projectVo;
    }

    public void setExtentionInfo(ProjectVo projectVo) {
        this.projectBusinessModels = projectVo.getProjectBusinessModels();
        this.schedule = projectVo.getSchedule();
        this.alarmLevel = projectVo.getAlarmLevel();
        this.applyerName = projectVo.getApplyerName();
        this.leaderName = projectVo.getLeaderName();
        this.parterNames = projectVo.getParterNames();
        this.DeptName = projectVo.getDeptName();
        this.connectBusinessName = projectVo.getConnectBusinessName();
        this.currentStep = projectVo.getCurrentStep();
        this.currentStepName = projectVo.getCurrentStepName();
        this.verifyStatusName = projectVo.getVerifyStatusName();
        this.establishmentName = projectVo.getEstablishmentName();
        this.projectStatusName = projectVo.getProjectStatusName();
        this.actionStatusName = projectVo.getActionStatusName();
        this.typeName = projectVo.getTypeName();
        this.priorityName = projectVo.getPriorityName();
        this.levelName = projectVo.getLevelName();
        this.riskLevelName = projectVo.getRiskLevelName();
        this.resourceName = projectVo.getResourceName();
        this.versionCode = projectVo.getVersionCode();
    }
}

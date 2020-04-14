package com.fea.project.model.risk;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Builder
public class ProjectRiskModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orgId;

    /**
     * 项目id（自动带过来）
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    /**
     * 项目阶段id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stepId;

    /**
     * 项目阶段
     */
    private String stage;

    /**
     * 风险名称
     */
    private String name;

    /**
     * 风险类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long type;
    /**
     * 风险类型
     */
    private String typeString;

    /**
     * 是否可控 0-可控 1-不可控
     */
    private Integer isControl;
    private String isControlString;

    /**
     * 风险权重
     */
    private String weight;

    /**
     * 负责人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long chargeId;

    /**
     * 负责人
     */
    private String charge;

    /**
     * 产生原因
     */
    private String cause;

    /**
     * 风险后果
     */
    private String consequence;

    /**
     * 触发条件
     */
    private String triggerCondition;

    /**
     * 发生概率
     */
    private BigDecimal probability;
    private String probabilityString;

    /**
     * 影响程度
     */
    private BigDecimal impact;
    private String impactString;

    /**
     * 风险指数
     */
    private BigDecimal rating;
    private String ratingString;

    /**
     * 风险应对措施
     */
    private String solutons;

    /**
     * 风险应急计划
     */
    private String contingencyPlan;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
     * 是否删除
     */
    private Integer delStatus;
    /**
     * 项目风险评估
     */
    private List<ProjectRiskAssessModel> assessModels;
    /**
     * 风险评估计划
     */
    private List<ProjectRiskAssessPlanModel> projectRiskAssessPlanModels;

    /**
     * 风险应对措施附件
     */
    private List<ProjectRiskAppendixModel> solutonsAppendix;
    /**
     * 风险应急计划附件
     */
    private List<ProjectRiskAppendixModel> contingencyPlanAppendix;

    //是否评估
    private String isAssess;



    public ProjectRiskModel () {
        
    }

    public ProjectRiskModel(Long id, Long regId, Long orgId, Long projectId, Long stepId, String stage, String name, Long type, String typeString, Integer isControl, String isControlString, String weight, Long chargeId, String charge, String cause, String consequence, String triggerCondition, BigDecimal probability, String probabilityString, BigDecimal impact, String impactString, BigDecimal rating, String ratingString, String solutons, String contingencyPlan, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, List<ProjectRiskAssessModel> assessModels, List<ProjectRiskAssessPlanModel> projectRiskAssessPlanModels, List<ProjectRiskAppendixModel> solutonsAppendix, List<ProjectRiskAppendixModel> contingencyPlanAppendix, String isAssess) {
        this.id = id;
        this.regId = regId;
        this.orgId = orgId;
        this.projectId = projectId;
        this.stepId = stepId;
        this.stage = stage;
        this.name = name;
        this.type = type;
        this.typeString = typeString;
        this.isControl = isControl;
        this.isControlString = isControlString;
        this.weight = weight;
        this.chargeId = chargeId;
        this.charge = charge;
        this.cause = cause;
        this.consequence = consequence;
        this.triggerCondition = triggerCondition;
        this.probability = probability;
        this.probabilityString = probabilityString;
        this.impact = impact;
        this.impactString = impactString;
        this.rating = rating;
        this.ratingString = ratingString;
        this.solutons = solutons;
        this.contingencyPlan = contingencyPlan;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.assessModels = assessModels;
        this.projectRiskAssessPlanModels = projectRiskAssessPlanModels;
        this.solutonsAppendix = solutonsAppendix;
        this.contingencyPlanAppendix = contingencyPlanAppendix;
        this.isAssess = isAssess;
    }

    public String getProbabilityString() {
        return probabilityString;
    }

    public void setProbabilityString(String probabilityString) {
        this.probabilityString = probabilityString;
    }

    public String getImpactString() {
        return impactString;
    }

    public void setImpactString(String impactString) {
        this.impactString = impactString;
    }

    public String getRatingString() {
        return ratingString;
    }

    public void setRatingString(String ratingString) {
        this.ratingString = ratingString;
    }

    public String getIsAssess() {
        return isAssess;
    }

    public void setIsAssess(String isAssess) {
        this.isAssess = isAssess;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public List<ProjectRiskAssessModel> getAssessModels() {
        return assessModels;
    }

    public void setAssessModels(List<ProjectRiskAssessModel> assessModels) {
        this.assessModels = assessModels;
    }

    public List<ProjectRiskAppendixModel> getSolutonsAppendix() {
        return solutonsAppendix;
    }

    public void setSolutonsAppendix(List<ProjectRiskAppendixModel> solutonsAppendix) {
        this.solutonsAppendix = solutonsAppendix;
    }

    public List<ProjectRiskAppendixModel> getContingencyPlanAppendix() {
        return contingencyPlanAppendix;
    }

    public void setContingencyPlanAppendix(List<ProjectRiskAppendixModel> contingencyPlanAppendix) {
        this.contingencyPlanAppendix = contingencyPlanAppendix;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Integer getIsControl() {
        return isControl;
    }

    public void setIsControl(Integer isControl) {
        this.isControl = isControl;
    }

    public String getIsControlString() {
        return isControlString;
    }

    public void setIsControlString(String isControlString) {
        this.isControlString = isControlString;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Long getChargeId() {
        return chargeId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public String getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(String triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    public BigDecimal getImpact() {
        return impact;
    }

    public void setImpact(BigDecimal impact) {
        this.impact = impact;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getSolutons() {
        return solutons;
    }

    public void setSolutons(String solutons) {
        this.solutons = solutons;
    }

    public String getContingencyPlan() {
        return contingencyPlan;
    }

    public void setContingencyPlan(String contingencyPlan) {
        this.contingencyPlan = contingencyPlan;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public List<ProjectRiskAssessPlanModel> getProjectRiskAssessPlanModels() {
        return projectRiskAssessPlanModels;
    }

    public void setProjectRiskAssessPlanModels(List<ProjectRiskAssessPlanModel> projectRiskAssessPlanModels) {
        this.projectRiskAssessPlanModels = projectRiskAssessPlanModels;
    }
}
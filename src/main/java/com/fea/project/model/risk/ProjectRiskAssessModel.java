package com.fea.project.model.risk;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.risk.ProjectRiskAppendixModel;
import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/03/24.
 */
@Builder
public class ProjectRiskAssessModel implements Serializable {
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
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目阶段（从项目风险带过来）
     */
    private String stageIdString;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long stageId;
    private String stage;

    /**
     * 项目风险id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectRiskId;

    /**
     * 风险评估主题
     */
    private String theme;

    /**
     * 评估次数
     */
    private String times;

    /**
     * 评估报告主题
     */
    private String report;

    /**
     * 当前风险指数
     */
    private BigDecimal rating;

    /**
     * 评估时间
     */
    private Date time;

    /**
     * 评估人
     */
    private String evaluator;

    /**
     * 风险评估内容
     */
    private String content;

    /**
     * 是否提交  0-未提交 1-已提交
     */
    private Integer isSubmit;

    /**
     * 是否审核
     */
    private Integer isCheck;

    /**
     * 审核标题
     */
    private String checkTitle;

    /**
     * 审核说明
     */
    private String checkExplain;

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
     * 风险评估内容附件
     */
    private List<ProjectRiskAppendixModel> contentAppendix;
    //附件id
    private List<Long> appendixIds;



    public ProjectRiskAssessModel () {
        
    }

    public ProjectRiskAssessModel(Long id, Long regId, Long orgId, Long projectId, String projectName, String stageIdString, Long stageId, String stage, Long projectRiskId, String theme, String times, String report, BigDecimal rating, Date time, String evaluator, String content, Integer isSubmit, Integer isCheck, String checkTitle, String checkExplain, Long createId, String createBy, Date createTime, Long updateId, String updateBy, Date updateTime, Integer delStatus, List<ProjectRiskAppendixModel> contentAppendix, List<Long> appendixIds) {
        this.id = id;
        this.regId = regId;
        this.orgId = orgId;
        this.projectId = projectId;
        this.projectName = projectName;
        this.stageIdString = stageIdString;
        this.stageId = stageId;
        this.stage = stage;
        this.projectRiskId = projectRiskId;
        this.theme = theme;
        this.times = times;
        this.report = report;
        this.rating = rating;
        this.time = time;
        this.evaluator = evaluator;
        this.content = content;
        this.isSubmit = isSubmit;
        this.isCheck = isCheck;
        this.checkTitle = checkTitle;
        this.checkExplain = checkExplain;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateId = updateId;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delStatus = delStatus;
        this.contentAppendix = contentAppendix;
        this.appendixIds = appendixIds;
    }

    public String getStageIdString() {
        return stageIdString;
    }

    public void setStageIdString(String stageIdString) {
        this.stageIdString = stageIdString;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public List<ProjectRiskAppendixModel> getContentAppendix() {
        return contentAppendix;
    }

    public void setContentAppendix(List<ProjectRiskAppendixModel> contentAppendix) {
        this.contentAppendix = contentAppendix;
    }

    public List<Long> getAppendixIds() {
        return appendixIds;
    }

    public void setAppendixIds(List<Long> appendixIds) {
        this.appendixIds = appendixIds;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public Long getProjectRiskId() {
        return projectRiskId;
    }

    public void setProjectRiskId(Long projectRiskId) {
        this.projectRiskId = projectRiskId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report == null ? null : report.trim();
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator == null ? null : evaluator.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(Integer isSubmit) {
        this.isSubmit = isSubmit;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getCheckTitle() {
        return checkTitle;
    }

    public void setCheckTitle(String checkTitle) {
        this.checkTitle = checkTitle == null ? null : checkTitle.trim();
    }

    public String getCheckExplain() {
        return checkExplain;
    }

    public void setCheckExplain(String checkExplain) {
        this.checkExplain = checkExplain == null ? null : checkExplain.trim();
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
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", regId=").append(regId);
        sb.append(", orgId=").append(orgId);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", stage=").append(stage);
        sb.append(", projectRiskId=").append(projectRiskId);
        sb.append(", theme=").append(theme);
        sb.append(", times=").append(times);
        sb.append(", report=").append(report);
        sb.append(", rating=").append(rating);
        sb.append(", time=").append(time);
        sb.append(", evaluator=").append(evaluator);
        sb.append(", content=").append(content);
        sb.append(", isSubmit=").append(isSubmit);
        sb.append(", isCheck=").append(isCheck);
        sb.append(", checkTitle=").append(checkTitle);
        sb.append(", checkExplain=").append(checkExplain);
        sb.append(", createId=").append(createId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delStatus=").append(delStatus);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProjectRiskAssessModel other = (ProjectRiskAssessModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRegId() == null ? other.getRegId() == null : this.getRegId().equals(other.getRegId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(other.getStage()))
            && (this.getProjectRiskId() == null ? other.getProjectRiskId() == null : this.getProjectRiskId().equals(other.getProjectRiskId()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getReport() == null ? other.getReport() == null : this.getReport().equals(other.getReport()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getEvaluator() == null ? other.getEvaluator() == null : this.getEvaluator().equals(other.getEvaluator()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIsSubmit() == null ? other.getIsSubmit() == null : this.getIsSubmit().equals(other.getIsSubmit()))
            && (this.getIsCheck() == null ? other.getIsCheck() == null : this.getIsCheck().equals(other.getIsCheck()))
            && (this.getCheckTitle() == null ? other.getCheckTitle() == null : this.getCheckTitle().equals(other.getCheckTitle()))
            && (this.getCheckExplain() == null ? other.getCheckExplain() == null : this.getCheckExplain().equals(other.getCheckExplain()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelStatus() == null ? other.getDelStatus() == null : this.getDelStatus().equals(other.getDelStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRegId() == null) ? 0 : getRegId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
        result = prime * result + ((getProjectRiskId() == null) ? 0 : getProjectRiskId().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getReport() == null) ? 0 : getReport().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getEvaluator() == null) ? 0 : getEvaluator().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIsSubmit() == null) ? 0 : getIsSubmit().hashCode());
        result = prime * result + ((getIsCheck() == null) ? 0 : getIsCheck().hashCode());
        result = prime * result + ((getCheckTitle() == null) ? 0 : getCheckTitle().hashCode());
        result = prime * result + ((getCheckExplain() == null) ? 0 : getCheckExplain().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelStatus() == null) ? 0 : getDelStatus().hashCode());
        return result;
    }
}
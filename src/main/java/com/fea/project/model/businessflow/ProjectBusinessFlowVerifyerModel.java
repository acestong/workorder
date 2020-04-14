package com.fea.project.model.businessflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.model.apply.pojo.ProjectApplyFlowInfoPojo;
import com.fea.project.model.flow.ProjectFlowVerifyerModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowVerifyerModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long listId;

    /**
     * 
     */
    protected Integer personType;

    /**
     * 
     */
    protected String detailStr;

    /**
     * 
     */
    @JsonIgnore
    protected Long createId;

    /**
     * 
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String createBy;

    /**
     * 
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date createTime;

    /**
     * 
     */
    @JsonIgnore
    protected Long updateId;

    /**
     * 
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String updateBy;

    /**
     *
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date updateTime;

    /**
     *
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long parentId;

    /**
     *
     */
    protected Integer verifyType;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long originalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessFlowId;


    public ProjectBusinessFlowVerifyerModel() {

    }


    public ProjectBusinessFlowVerifyerModel(ProjectFlowVerifyerModel model) {
        this.listId = model.getListId();
        this.personType = model.getPersonType();
        this.detailStr = model.getDetailStr();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.verifyType = model.getVerifyType();
        this.parentId = model.getParentId();
        this.originalId = model.getId();
    }

    public ProjectApplyFlowInfoPojo createFirstStepVerifyModel() {
        ProjectApplyFlowInfoPojo projectApplyFlowInfoPojo = new ProjectApplyFlowInfoPojo();
        projectApplyFlowInfoPojo.setBusinessFlowVerifyId(this.getId());
        projectApplyFlowInfoPojo.setPersonType(this.getPersonType());
        projectApplyFlowInfoPojo.setVerifyType(this.getVerifyType());
        projectApplyFlowInfoPojo.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        projectApplyFlowInfoPojo.setCreateTime(new Date());
        return projectApplyFlowInfoPojo;
    }
}
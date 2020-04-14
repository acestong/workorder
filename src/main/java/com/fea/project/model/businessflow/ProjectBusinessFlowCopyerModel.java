package com.fea.project.model.businessflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.model.flow.vo.ProjectFlowCopyerVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowCopyerModel implements Serializable {
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

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long originalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessFlowId;


    public ProjectBusinessFlowCopyerModel() {
        
    }


    public ProjectBusinessFlowCopyerModel(ProjectFlowCopyerVo projectFlowCopyerModel) {
        this.listId = projectFlowCopyerModel.getListId();
        this.personType = projectFlowCopyerModel.getPersonType();
        this.detailStr = projectFlowCopyerModel.getDetailStr();
        this.createId = projectFlowCopyerModel.getCreateId();
        this.createBy = projectFlowCopyerModel.getCreateBy();
        this.createTime = projectFlowCopyerModel.getCreateTime();
        this.updateId = projectFlowCopyerModel.getUpdateId();
        this.updateBy = projectFlowCopyerModel.getUpdateBy();
        this.updateTime = projectFlowCopyerModel.getUpdateTime();
        this.delStatus = projectFlowCopyerModel.getDelStatus();
        this.originalId = projectFlowCopyerModel.getId();
    }
}
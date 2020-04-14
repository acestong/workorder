package com.fea.project.model.businessflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.model.flow.ProjectFlowListModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowListModel implements Serializable {
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
    protected Long flowId;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long index;

    /**
     *
     */
    protected String name;

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
    protected Integer typeId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long originalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessFlowId;

    public ProjectBusinessFlowListModel() {

    }


    public ProjectBusinessFlowListModel(ProjectFlowListModel model, Long businessFlowId) {
        this.flowId = model.getFlowId();
        this.index = model.getIndex();
        this.name = model.getName();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.typeId = model.getTypeId();
        this.originalId = model.getId();
        this.businessFlowId = businessFlowId;
    }
}
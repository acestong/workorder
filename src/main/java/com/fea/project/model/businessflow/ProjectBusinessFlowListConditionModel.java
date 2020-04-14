package com.fea.project.model.businessflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.model.flow.ProjectFlowListConditionModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowListConditionModel implements Serializable {
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
     * 方法id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long listId;

    /**
     * 字段类型
     */
    protected Integer fieldType;

    /**
     * 过滤类型
     */
    protected Integer filterType;

    /**
     * 过滤值
     */
    protected String filterValue;

    /**
     * 模型解析
     */
    protected String conditionStr;

    /**
     * 创建人id
     */
    @JsonIgnore
    protected Long createId;

    /**
     * 创建人
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String createBy;

    /**
     * 创建时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date createTime;

    /**
     * 更新人id
     */
    @JsonIgnore
    protected Long updateId;

    /**
     * 更新人
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String updateBy;

    /**
     * 更新时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date updateTime;

    /**
     * 删除标识
     */
    @JsonIgnore
    protected Integer delStatus;

    /**
     * 按钮类型
     */
    protected Integer actionCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long originalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessFlowId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long filterValueUnit;


    public ProjectBusinessFlowListConditionModel() {

    }

    public ProjectBusinessFlowListConditionModel(ProjectFlowListConditionModel model) {
        this.listId = model.getListId();
        this.fieldType = model.getFieldType();
        this.filterType = model.getFilterType();
        this.filterValue = model.getFilterValue();
        this.conditionStr = model.getConditionStr();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.actionCode = model.getActionCode();
        this.originalId = model.getId();
    }

}
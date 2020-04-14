package com.fea.project.model.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
public class ProjectFlowListModel implements Serializable {
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

    protected Integer typeId;

    public ProjectFlowListModel() {
    }

    public ProjectFlowListModel(SysUserModel model, Long flowId) {
        this.setUpdateId(model.getUserId());
        this.setUpdateTime(new Date());
        this.setUpdateBy(model.getRealName());
        this.setFlowId(flowId);
    }

    public ProjectFlowListModel(Long flowId) {
        this.flowId = flowId;
    }

    public static List<ProjectFlowListModel> createExchangeIndexList(List<ProjectFlowListModel> projectFlowListModels, SysUserModel userModel) {
        ProjectFlowListModel first = projectFlowListModels.get(0);
        ProjectFlowListModel second = projectFlowListModels.get(1);
        Long index = first.getIndex();
        first.setIndex(second.getIndex());
        second.setIndex(index);
        first.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        second.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        return projectFlowListModels;
    }

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(new Date());
            this.setCreateBy(model.getRealName());
            this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(new Date());
            this.setUpdateBy(model.getRealName());
        }
    }
}
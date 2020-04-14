package com.fea.project.model.businessflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/16.
 */
@Data
public class ProjectBusinessFlowModel implements Serializable {
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
    protected Long regId;

    /**
     *
     */
    protected String code;

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected Integer flowType;

    /**
     *
     */
    protected Integer state;

    /**
     *
     */
    protected Date startTime;

    /**
     *
     */
    protected Date endTime;

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
    protected Integer cantChangeVerifyer;

    /**
     *
     */
    protected Integer cantChangeCopyer;

    /**
     *
     */
    protected Integer verifyCantRevert;

    /**
     *
     */
    protected Integer copySetType;

    /**
     * 选填，如果填了，其他项目选择流程时，该流程无法获取
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long listId;

    /**
     * t_project_flow表真实id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long originalId;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectType;



    public ProjectBusinessFlowModel() {

    }

    public ProjectBusinessFlowModel(Long id, Long listId) {
        this.id = id;
        this.listId = listId;
    }

    public ProjectBusinessFlowModel(ProjectFlowVo projectFlowVo, ProjectBusinessFlowModel model) {
        this.regId = projectFlowVo.getRegId();
        this.code = projectFlowVo.getCode();
        this.name = projectFlowVo.getName();
        this.flowType = projectFlowVo.getFlowType();
        this.state = projectFlowVo.getState();
        this.startTime = projectFlowVo.getStartTime();
        this.endTime = projectFlowVo.getEndTime();
        this.createId = projectFlowVo.getCreateId();
        this.createBy = projectFlowVo.getCreateBy();
        this.createTime = projectFlowVo.getCreateTime();
        this.updateId = projectFlowVo.getUpdateId();
        this.updateBy = projectFlowVo.getUpdateBy();
        this.updateTime = projectFlowVo.getUpdateTime();
        this.delStatus = projectFlowVo.getDelStatus();
        this.cantChangeVerifyer = projectFlowVo.getCantChangeVerifyer();
        this.cantChangeCopyer = projectFlowVo.getCantChangeCopyer();
        this.verifyCantRevert = projectFlowVo.getVerifyCantRevert();
        this.copySetType = projectFlowVo.getCopySetType();
        this.projectId = projectFlowVo.getProjectId();
        this.originalId = projectFlowVo.getId();
        this.listId = model.getListId();
        this.projectType = projectFlowVo.getProjectType();
    }

}
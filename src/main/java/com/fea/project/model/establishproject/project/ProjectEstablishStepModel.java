package com.fea.project.model.establishproject.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.*;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/30.
 */
@Data
@TableNameAnno(value = "t_project_establish_step")
public class ProjectEstablishStepModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 立项阶段id
     */
    @NotNullAnno(field = "name", value = "立项阶段名称")
    protected String name;

    /**
     * 开始时间
     */
    @NotNullAnno(field = "start_time", value = "开始时间")
    protected Date startTime;

    /**
     * 结束时间
     */
    @NotNullAnno(field = "end_time", value = "结束时间")
    protected Date endTime;

    /**
     * 
     */
    @NotNullAnno(field = "establish_during", value = "阶段时长")
    protected BigDecimal establishDuring;

    /**
     *
     */
    @NotNullAnno(field = "leader", value = "负责人")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long leader;

    /**
     * 阶段内容
     */
    protected String content;

    /**
     * 备注
     */
    protected String remark;

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
    @ConditionStatusAnno(field = "project_id")
    protected Long projectId;

    protected Integer verifyStatus;

    /**
     * 排序号
     */
    @NotNullAnno(field = "`index`", value = "排序号")
    @UniqueCheckAnno(field = "`index`", value = "排序号")
    protected Integer index;
    /**
     * 流程启用状态
     */
    @NotNullAnno(field = "flow_state", value = "流程启用状态")
    protected Integer flowState;
    /**
     * 流程id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long flowId;

    public ProjectEstablishStepModel () {
        
    }

    public ProjectEstablishStepModel(Long projectId) {
        this.projectId = projectId;
    }

    public ProjectEstablishStepModel(Long id, Integer verifyStatus) {
        this.id = id;
        this.verifyStatus = verifyStatus;
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
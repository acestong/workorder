package com.fea.project.model.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.*;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/10.
 */
@Data
@TableNameAnno("t_project_flow")
public class ProjectFlowModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @PrimaryKey(field = "id")
    protected Long id;

    /**
     *
     */
    @ConditionStatusAnno(field = "reg_id")
    @RegAutoSetAnno
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long regId;

    /**
     *
     */
    @NotNullAnno(field = "code", value = "流程编号")
    @UniqueCheckAnno(field = "code", value = "流程编号")
    protected String code;

    /**
     *
     */
    @NotNullAnno(field = "name", value = "流程名称")
    @UniqueCheckAnno(field = "name", value = "流程名称")
    protected String name;

    /**
     *
     */
    @NotNullAnno(field = "flow_type", value = "流程类型")
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
    protected String createBy;

    /**
     *
     */
    protected Date createTime;

    /**
     *
     */
    @JsonIgnore
    protected Long updateId;

    /**
     *
     */
    protected String updateBy;

    /**
     *
     */
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
    @NotNullAnno(field = "copy_set_type", value = "抄送类型")
    protected Integer copySetType;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectType;

    public ProjectFlowModel() {
    }

    public ProjectFlowModel(Long id) {
        this.id = id;
    }

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        Date date = new Date();
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(date);
            this.setCreateBy(model.getRealName());
            this.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            this.setState(EnableStatusEnum.ENABLE.getStatus());
            this.setStartTime(new Date());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(date);
            this.setUpdateBy(model.getRealName());
        }
    }
}
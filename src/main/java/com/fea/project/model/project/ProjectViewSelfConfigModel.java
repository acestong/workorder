package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/28.
 */
@Data
public class ProjectViewSelfConfigModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long viewId;

    protected Integer fieldType;

    protected Integer filterType;

    protected String filterValue;

    protected String conditionStr;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createId;

    protected String createBy;

    protected Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long updateId;

    protected String updateBy;

    protected Date updateTime;

    @JsonIgnore
    protected Integer delStatus;

    protected Integer actionCode;

    public ProjectViewSelfConfigModel() {

    }

    public ProjectViewSelfConfigModel(Long viewId) {
        this.viewId = viewId;
    }

    public void setUserInfo(SysUserModel model, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(model.getUserId());
            this.setCreateTime(new Date());
            this.setCreateBy(model.getRealName());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(model.getUserId());
            this.setUpdateTime(new Date());
            this.setUpdateBy(model.getRealName());
        }
    }

}
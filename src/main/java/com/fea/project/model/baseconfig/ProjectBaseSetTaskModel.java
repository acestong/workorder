package com.fea.project.model.baseconfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.baseconfig.ProjectCodeDateStrEnum;
import com.fea.project.util.DateUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/05.
 */
@Data
public class ProjectBaseSetTaskModel implements Serializable {
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
     *
     */
    @JsonIgnore
    private Long regId;

    /**
     *
     */
    private Integer typeId;

    /**
     *
     */
    private String shortName;

    /**
     *
     */
    private Integer dataStr;

    /**
     *
     */
    @JsonIgnore
    private Long createId;

    /**
     *
     */
    private String createBy;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    @JsonIgnore
    private Long updateId;

    /**
     *
     */
    private String updateBy;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    @JsonIgnore
    private Integer delStatus;

    private Integer number;

    public ProjectBaseSetTaskModel() {

    }

    public ProjectBaseSetTaskModel(Long regId) {
        this.regId = regId;
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

    public String getPlanCodeNumber(Date date) {
        return this.getShortName() + DateUtil.getTimeStrByDateAndDateFormate(date
                , ProjectCodeDateStrEnum.getTargetDateFormat(this.dataStr));
    }
}
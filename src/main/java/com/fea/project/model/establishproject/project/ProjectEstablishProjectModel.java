package com.fea.project.model.establishproject.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.project.ProjectEstablishStartStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/23.
 */
@Data
public class ProjectEstablishProjectModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    protected Long id;

    /**
     * 
     */
    protected Long projectId;

    /**
     * 
     */
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
    protected Integer delStatus;

    /**
     * 产品研发标识
     */
    protected Integer productDevelopeFlag;

    /**
     * 产品名称
     */
    protected String productName;

    /**
     * 产品类型
     */
    protected Long productType;

    /**
     * 立项申请人
     */
    protected Long applyer;

    protected List<Long> establishPartners;

    protected Long establishLeader;

    protected Long regId;

    protected Long establishStep;

    protected Integer startStatus;

    protected Date startDate;

    protected Date establishTime;

    public ProjectEstablishProjectModel () {
        
    }

    public ProjectEstablishProjectModel(Long id) {
        this.id = id;
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

    /**
     * 立项启动，理想状态更新
     * @param userModel
     */
    public void setStartModel(SysUserModel userModel) {
        this.setStartDate(new Date());
        this.setStartStatus(ProjectEstablishStartStatusEnum.TYPE_START.getValue());
        this.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
    }
}
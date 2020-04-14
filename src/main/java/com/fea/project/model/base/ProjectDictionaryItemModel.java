package com.fea.project.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/25.
 */
@Data
public class ProjectDictionaryItemModel implements Serializable {


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序号
     */
    private Integer index;

    /**
     * 启用禁用状态
     */
    private String state;

    /**
     * 组织id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;


    /**
     * 删除状态
     */
    @JsonIgnore
    private Integer delStatus;

    /**
     * 字典id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dicId;

    /**
     * 父节点
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 创建人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;


    public ProjectDictionaryItemModel() {
    }


    public void setUserInfo(SysUserModel sysUserModel, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.createBy = sysUserModel.getRealName();
            this.createId = sysUserModel.getUserId();
            this.createTime = new Date();
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.updateBy = sysUserModel.getRealName();
            this.updateId = sysUserModel.getUserId();
            this.updateTime = new Date();
        }
    }

}
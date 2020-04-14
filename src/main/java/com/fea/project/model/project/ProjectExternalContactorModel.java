package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.NotNullAnno;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.annotations.base.TableNameAnno;
import com.fea.project.enums.base.ActionEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/24.
 */
@TableNameAnno(value = "t_project_project_contactor")
@Data
public class ProjectExternalContactorModel implements Serializable {
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
     * 项目id
     */
    @NotNullAnno(field = "project_id", value = "项目id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;


    /**
     * 联系人id
     */
    @NotNullAnno(field = "name", value = "姓名")
    protected String name;


    protected Integer sex;


    protected String companyName;


    protected String departmentName;


    protected String position;


    protected String phone;

    /**
     * 更新时间
     */
    protected String email;

    /**
     * 删除标识
     */
    protected String remark;

    /**
     * 创建id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long createId;

    /**
     * 创建人
     */
    protected String createBy;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long updateId;

    /**
     * 更新人
     */
    protected String updateBy;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 删除标识
     */
    protected Integer delStatus;

    public void setUserInfo(SysUserModel sysUserModel, ActionEnum actionEnum) {
        if (ActionEnum.INSERT_ACTION.equals(actionEnum)) {
            this.setCreateId(sysUserModel.getUserId());
            this.setCreateBy(sysUserModel.getRealName());
            this.setCreateTime(new Date());
        } else if (ActionEnum.UPDATE_ACTION.equals(actionEnum)) {
            this.setUpdateId(sysUserModel.getUserId());
            this.setUpdateBy(sysUserModel.getRealName());
            this.setUpdateTime(new Date());
        }
    }
}
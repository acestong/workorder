package com.fea.project.model.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.project.ProjectVersionSelectTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Administrator on 2019/12/14.
 */
@Data
public class ProjectVersionModel implements Serializable {
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
     * 项目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long projectId;

    /**
     * 初始版本1.00，每个版本自增1
     */
    protected String versionCode;

    /**
     * -1 历史版本，0草稿， 1正式版本
     */
    protected Integer selectFlag;

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
     * 草稿表id，历史版本表id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long businessId;

    public ProjectVersionModel () {
        
    }

    public ProjectVersionModel(Long projectId, Integer selectFlag, Long businessId, BigDecimal version, SysUserModel sysUserModel) {
        this.projectId = projectId;
        this.versionCode = Objects.equals(selectFlag, ProjectVersionSelectTypeEnum.TYPE_DRAFT.getValue())
                ? version.toPlainString():(version == null?BigDecimal.ZERO:version).add(BigDecimal.ONE).toPlainString();
        this.selectFlag = selectFlag;
        this.createId = sysUserModel.getUserId();
        this.createBy = sysUserModel.getRealName();
        this.createTime = new Date();
        this.businessId = businessId;
    }

    public ProjectVersionModel(Long projectId, Integer selectFlag, Long createId) {
        this.projectId = projectId;
        this.selectFlag = selectFlag;
        this.createId = createId;
    }

    public static ProjectVersionModel createNewDraftVersion(Long projectId, Long businessId, String versionCode, SysUserModel userModel) {
        ProjectVersionModel projectVersionModel = new ProjectVersionModel();
        projectVersionModel.setProjectId(projectId);
        projectVersionModel.setVersionCode(versionCode);
        projectVersionModel.setSelectFlag(ProjectVersionSelectTypeEnum.TYPE_DRAFT.getValue());
        projectVersionModel.setCreateId(userModel.getUserId());
        projectVersionModel.setCreateBy(userModel.getRealName());
        projectVersionModel.setCreateTime(new Date());
        projectVersionModel.setBusinessId(businessId);
        return projectVersionModel;
    }

    public ProjectVersionModel createNewRealVersion(SysUserModel sysUserModel) {
        ProjectVersionModel projectVersionModel = new ProjectVersionModel();
        projectVersionModel.setProjectId(this.projectId);
        projectVersionModel.setVersionCode(new BigDecimal(this.versionCode).add(BigDecimal.ONE).toPlainString());
        projectVersionModel.setSelectFlag(ProjectVersionSelectTypeEnum.TYPE_REAL.getValue());
        projectVersionModel.setCreateId(sysUserModel.getUserId());
        projectVersionModel.setCreateBy(sysUserModel.getRealName());
        projectVersionModel.setCreateTime(new Date());
        projectVersionModel.setBusinessId(this.businessId);
        return projectVersionModel;
    }
}
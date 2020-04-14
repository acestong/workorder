package com.fea.project.model.fieldconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2020/01/19.
 */
@Data
public class ProjectFieldConfigPersonModel implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long regId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String fieldName;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private Long createId;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createTime;



    public ProjectFieldConfigPersonModel () {
        
    }

    public ProjectFieldConfigPersonModel(Integer typeId, Long userId) {
        this.typeId = typeId;
        this.userId = userId;
    }

    public ProjectFieldConfigPersonModel(Long id, Long regId, Long userId, String fieldName, Integer typeId, Long createId, String createBy, Date createTime) {
        this.id = id;
        this.regId = regId;
        this.userId = userId;
        this.fieldName = fieldName;
        this.typeId = typeId;
        this.createId = createId;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public ProjectFieldConfigPersonModel(ProjectFieldConfigEnterpriseModel model, SysUserModel userModel) {
        this.regId = model.getRegId();
        this.userId = userModel.getUserId();
        this.fieldName = model.getFieldName();
        this.typeId = model.getTypeId();
        this.setUserInfo(userModel);
    }

    private void setUserInfo(SysUserModel userModel) {
        this.createId = userModel.getUserId();
        this.createBy = userModel.getRealName();
        this.createTime = new Date();
    }

    public static List<ProjectFieldConfigPersonModel> createListByEnterpriseList(List<ProjectFieldConfigEnterpriseModel> projectFieldConfigEnterpriseModels, SysUserModel userModel) {
        return projectFieldConfigEnterpriseModels.stream().map(x -> new ProjectFieldConfigPersonModel(x, userModel)).collect(Collectors.toList());
    }
}
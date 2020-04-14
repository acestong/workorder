package com.fea.project.model.fieldconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/01/19.
 */
@Data
public class ProjectFieldConfigEnterpriseModel implements Serializable {
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

    private String name;

    public ProjectFieldConfigEnterpriseModel() {
    }

    public ProjectFieldConfigEnterpriseModel(Long regId, Integer typeId) {
        this.regId = regId;
        this.typeId =typeId;
    }

    public static List<ProjectFieldConfigEnterpriseModel> createNewList(List<ProjectFieldConfigEnterpriseModel> list, Long regId, SysUserModel userModel) {
        list.forEach(x -> {
            x.setId(null);
            x.setRegId(regId);
            x.setUserInfo(userModel);
        });
        return list;
    }

    private void setUserInfo(SysUserModel userModel) {
        this.setCreateId(userModel.getUserId());
        this.setCreateBy(userModel.getRealName());
        this.setCreateTime(new Date());
    }
}
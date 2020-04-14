package com.fea.project.model.project.pojo;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.model.project.ProjectModel;
import lombok.Data;

import java.util.Date;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/27 16:36
 * 项目编码请求参数model
 **/
@Data
public class ProjectCodeQueryPojo {

    private Long regId;
    private Long projectType;
    private Boolean codeNull;
    private Long parentId;
    private Date currentTime;

    public ProjectCodeQueryPojo(ProjectModel projectModel, SysUserModel sysUserModel) {
        this.regId = sysUserModel.getRegId();
        this.projectType = projectModel.getType();
        this.parentId = projectModel.getParentId();
    }
}

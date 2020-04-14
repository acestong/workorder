package com.fea.project.model.role.vo;

import com.fea.project.model.role.ProjectRoleAuthorityModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/18 10:31
 * 项目角色权限
 **/
@Data
public class ProjectRoleAuthorityVo extends ProjectRoleAuthorityModel {

    List<ProjectRoleAuthorityDetailVo> labels;
    List<ProjectRoleAuthorityVo> children;

}

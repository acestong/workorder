package com.fea.project.model.role.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/18 11:29
 **/
@Data
public class ProjectRoleAuthorityConfigPojo {

    private Long roleId;

    private List<Long> authorityDetailIds;


}

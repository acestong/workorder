package com.fea.project.model.role.pojo;

import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 * @author wuqi
 * @date 2020-03-04 17:00
 */
@Data
public class ProjectRoleAuthorityDetailPojo extends ProjectRoleAuthorityDetailModel {

    private List<Long> ids;

}
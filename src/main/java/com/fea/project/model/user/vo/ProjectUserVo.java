package com.fea.project.model.user.vo;

import com.fea.project.model.user.ProjectUserModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/14 17:14
 **/
@Data
public class ProjectUserVo extends ProjectUserModel {

    private String name;

    private Long parentId;

    private Integer gender;

}

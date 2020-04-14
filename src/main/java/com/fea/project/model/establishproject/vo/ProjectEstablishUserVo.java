package com.fea.project.model.establishproject.vo;

import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/14 17:14
 **/
@Data
public class ProjectEstablishUserVo extends ProjectEstablishUserModel {

    private String name;

    private Long parentId;

    private Integer gender;

    public ProjectEstablishUserVo() {
    }
}

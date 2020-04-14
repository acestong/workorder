package com.fea.project.model.establishproject.pojo;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.project.ProjectModel;
import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/23 17:42
 **/
@Data
public class ProjectAndEstablishProjectPojo {

    private ProjectModel projectModel;

    private ProjectEstablishProjectModel projectEstablishProjectModel;

    public ProjectAndEstablishProjectPojo() {
    }

    public ProjectAndEstablishProjectPojo(ProjectEstablishProjectPojo pojo, SysUserModel userModel) {
        pojo.setUserInfo(userModel, ActionEnum.INSERT_ACTION);
        //由于立项和项目信息在一张表，所以在未立项成功之前，删除标识为删除，通过立项表反查项目表信息
        this.projectModel = pojo;
        this.projectEstablishProjectModel = pojo.createProjectEstablishProjectModel();
    }
}

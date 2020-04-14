package com.fea.project.model.establishproject.pojo;

import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleUserModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/17 14:01
 **/
@Data
public class ProjectEstablishRoleUserPojo extends ProjectEstablishRoleUserModel {

    private List<Long> userIds;

    private List<Long> ids;

    public ProjectEstablishRoleUserPojo() {
    }

    public ProjectEstablishRoleUserPojo(ProjectEstablishTeamUserPojo model) {
        this.userId = model.getUserId();
        this.userIds = model.getUserIds();
        this.roleId = model.getRoleId();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = DeleteStatusEnum.NOT_DELETE.getStatus();
    }
}

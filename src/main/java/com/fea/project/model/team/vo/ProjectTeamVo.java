package com.fea.project.model.team.vo;

import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.model.user.vo.ProjectUserVo;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/14 16:56
 **/
@Data
public class ProjectTeamVo extends ProjectTeamModel {

    private String leadName;

    private List<ProjectUserVo> projectUserVos;

    public ProjectTeamVo() {

    }


    public ProjectTeamVo(ProjectTeamModel model) {
        this.id = model.getId();
        this.projectId = model.getProjectId();
        this.name = model.getName();
        this.parentId = model.getParentId();
        this.leader = model.getLeader();
        this.content = model.getContent();
        this.responsibility = model.getResponsibility();
        this.createId = model.getCreateId();
        this.createBy = model.getCreateBy();
        this.createTime = model.getCreateTime();
        this.updateId = model.getUpdateId();
        this.updateBy = model.getUpdateBy();
        this.updateTime = model.getUpdateTime();
        this.delStatus = model.getDelStatus();
        this.regId = model.getRegId();
        this.canDelete = model.getCanDelete();
        this.index = model.getIndex();
        this.shortName = model.getShortName();
    }


}

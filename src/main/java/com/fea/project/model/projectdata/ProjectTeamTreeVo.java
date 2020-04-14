package com.fea.project.model.projectdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.team.vo.ProjectTeamVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */ /*
*
*/
@Data
public class ProjectTeamTreeVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long teamId;
    /**
     * 团队名称
     */
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    private List<FinalTreeVo> child;

    public ProjectTeamTreeVo() {
    }

    public ProjectTeamTreeVo(Long teamId, String name, Long parentId, List<FinalTreeVo> child) {
        this.teamId = teamId;
        this.name = name;
        this.parentId = parentId;
        this.child = child;
    }
    public ProjectTeamTreeVo(ProjectTeamVo teamVo) {
        this.teamId = teamVo.getId();
        this.name = teamVo.getName();
        this.parentId = teamVo.getParentId();
        this.child = new ArrayList<>();
    }
}

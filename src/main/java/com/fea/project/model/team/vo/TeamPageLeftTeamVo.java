package com.fea.project.model.team.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.enums.base.GenderTypeEnum;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.model.user.vo.ProjectUserVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 9:54
 **/
@Data
public class TeamPageLeftTeamVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<TeamPageLeftTeamVo> children;
    private Integer canDelete;
    private String shortName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    private Integer gender;

    public TeamPageLeftTeamVo(ProjectTeamVo tmp) {
        this.id = tmp.getId();
        this.name = tmp.getName();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.canDelete = tmp.getCanDelete();
        this.shortName = tmp.getShortName();
        List<TeamPageLeftTeamVo> list = new ArrayList<>();
        tmp.getProjectUserVos().forEach(projectUser -> {
            list.add(new TeamPageLeftTeamVo(projectUser));
        });
        this.children = list;
        this.parentId = tmp.getParentId();
    }

    public TeamPageLeftTeamVo(ProjectUserVo projectUser) {
        this.id = projectUser.getId();
        this.name = projectUser.getName();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.children = new ArrayList<>();
        this.parentId = projectUser.getParentId();
        this.gender = projectUser.getGender() == null ? GenderTypeEnum.TYPE_MALE.getValue() : projectUser.getGender();
    }

    public static TeamPageLeftTeamVo translateProjectTeamVo(List<ProjectTeamVo> list) {
        List<TeamPageLeftTeamVo> teams = new ArrayList<>();
        Long userId = null;
        for (ProjectTeamVo projectTeamVo : list) {
            if (ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName().equals(projectTeamVo.getShortName())) {
                userId = projectTeamVo.getId();
            }
            teams.add(new TeamPageLeftTeamVo(projectTeamVo));
        }
        Map<Long, TeamPageLeftTeamVo> map = teams.stream().collect(Collectors.toMap(TeamPageLeftTeamVo::getId, teamPageLeftTeamVo -> teamPageLeftTeamVo));
        teams.forEach(tmp -> {
            TeamPageLeftTeamVo model = map.get(tmp.getParentId());
            if (model != null) {
                model.getChildren().add(tmp);
            }
        });
        return map.get(userId);
    }


}

package com.fea.project.model.establishproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.enums.base.GenderTypeEnum;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
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
public class EstablishTeamPageLeftTeamVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<EstablishTeamPageLeftTeamVo> children;
    private Integer canDelete;
    private String shortName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;
    private Integer gender;

    public EstablishTeamPageLeftTeamVo(ProjectEstablishTeamVo tmp) {
        this.id = tmp.getId();
        this.name = tmp.getName();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.canDelete = tmp.getCanDelete();
        this.shortName = tmp.getShortName();
        List<EstablishTeamPageLeftTeamVo> list = new ArrayList<>();
        tmp.getProjectUserVos().forEach(projectUser -> {
            list.add(new EstablishTeamPageLeftTeamVo(projectUser));
        });
        this.children = list;
        this.parentId = tmp.getParentId();
    }

    public EstablishTeamPageLeftTeamVo(ProjectEstablishUserVo projectUser) {
        this.id = projectUser.getId();
        this.name = projectUser.getName();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.children = new ArrayList<>();
        this.parentId = projectUser.getParentId();
        this.gender = projectUser.getGender() == null ? GenderTypeEnum.TYPE_MALE.getValue() : projectUser.getGender();
    }

    public static EstablishTeamPageLeftTeamVo translateProjectTeamVo(List<ProjectEstablishTeamVo> list) {
        List<EstablishTeamPageLeftTeamVo> teams = new ArrayList<>();
        Long userId = null;
        for (ProjectEstablishTeamVo projectEstablishTeamVo : list) {
            if (ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName().equals(projectEstablishTeamVo.getShortName())) {
                userId = projectEstablishTeamVo.getId();
            }
            teams.add(new EstablishTeamPageLeftTeamVo(projectEstablishTeamVo));
        }
        Map<Long, EstablishTeamPageLeftTeamVo> map = teams.stream().collect(Collectors.toMap(EstablishTeamPageLeftTeamVo::getId, teamPageLeftTeamVo -> teamPageLeftTeamVo));
        teams.forEach(tmp -> {
            EstablishTeamPageLeftTeamVo model = map.get(tmp.getParentId());
            if (model != null) {
                model.getChildren().add(tmp);
            }
        });
        return map.get(userId);
    }


}

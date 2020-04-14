package com.fea.project.model.role.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.enums.base.GenderTypeEnum;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.model.role.ProjectRoleAuthorityModel;
import com.fea.project.model.team.vo.ProjectTeamVo;
import com.fea.project.model.user.vo.ProjectUserVo;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 9:54
 **/
@Data
public class RolePriorityPageLeftVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<RolePriorityPageLeftVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public RolePriorityPageLeftVo(ProjectRoleAuthorityModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.children = new ArrayList<>();
        this.parentId = model.getParentId();
    }

    public static List<RolePriorityPageLeftVo> translateProjectRolePriority(List<ProjectRoleAuthorityModel> list) {
        if(ListUtil.isNullOrEmpty(list)){
            return Collections.emptyList();
        }
        List<RolePriorityPageLeftVo> rolePriorityPageLeftVos = list.stream().map(RolePriorityPageLeftVo::new).collect(Collectors.toList());
        Map<Long, RolePriorityPageLeftVo> map = rolePriorityPageLeftVos.stream().collect(Collectors.toMap(RolePriorityPageLeftVo::getId, x -> x));
        rolePriorityPageLeftVos.forEach(x -> {
            if(Objects.isNull(x.getParentId())){
                return;
            }
            RolePriorityPageLeftVo tmp = map.get(x.getParentId());
            if(!Objects.isNull(tmp)){
                tmp.getChildren().add(x);
            }
        });
        return rolePriorityPageLeftVos.stream().filter(x -> x.getParentId() == null).collect(Collectors.toList());
    }


}

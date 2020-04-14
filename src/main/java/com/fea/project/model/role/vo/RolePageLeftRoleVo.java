package com.fea.project.model.role.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.role.ProjectRoleModel;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 9:54
 **/
@Data
public class RolePageLeftRoleVo<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<RolePageLeftRoleVo> children;
    private Integer canEdit;
    private String shortName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public RolePageLeftRoleVo(ProjectRoleModel tmp) {
        this.id = tmp.getId();
        this.name = tmp.getName();
        this.canEdit = tmp.getCanEdit();
        this.shortName = tmp.getShortName();
    }


    public static List<RolePageLeftRoleVo> createList(List<ProjectRoleModel> projectRoleModels) {
        return projectRoleModels.stream().map(RolePageLeftRoleVo::new).collect(Collectors.toList());
    }

}

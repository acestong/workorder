package com.fea.project.model.establishproject.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleModel;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 9:54
 **/
@Data
public class EstablishRolePageLeftRoleVo<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<EstablishRolePageLeftRoleVo> children;
    private Integer canEdit;
    private String shortName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public EstablishRolePageLeftRoleVo(ProjectEstablishRoleModel tmp) {
        this.id = tmp.getId();
        this.name = tmp.getName();
        this.canEdit = tmp.getCanEdit();
        this.shortName = tmp.getShortName();
    }


    public static List<EstablishRolePageLeftRoleVo> createList(List<ProjectEstablishRoleModel> projectEstablishRoleModels) {
        return projectEstablishRoleModels.stream().map(EstablishRolePageLeftRoleVo::new).collect(Collectors.toList());
    }

}

package com.fea.project.model.base.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 11:25
 **/
@Data
public class ProjectDictionaryItemSelectVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer type;
    private List<ProjectDictionaryItemSelectVo> projectDictionaryItemSelectVos;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public ProjectDictionaryItemSelectVo() {
    }

    public ProjectDictionaryItemSelectVo(ProjectDictionaryItemModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.type = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.parentId = model.getParentId();
        this.projectDictionaryItemSelectVos = new ArrayList<>();
    }

    public static List<ProjectDictionaryItemSelectVo> createList(List<ProjectDictionaryItemModel> list) {
        List<ProjectDictionaryItemSelectVo> projectDictionaryItemSelectVos = list.stream().map(ProjectDictionaryItemSelectVo::new).collect(Collectors.toList());
        List<ProjectDictionaryItemSelectVo> finalList = new ArrayList<>();
        Map<Long, ProjectDictionaryItemSelectVo> map = projectDictionaryItemSelectVos.stream().collect(Collectors.toMap(ProjectDictionaryItemSelectVo::getId, x -> x));
        projectDictionaryItemSelectVos.forEach(x -> {
            if (x.getParentId() == null || map.get(x.getParentId()) == null) {
                finalList.add(x);
                return;
            }
            ProjectDictionaryItemSelectVo vo = map.get(x.getParentId());
            vo.getProjectDictionaryItemSelectVos().add(x);
        });
        return finalList;
    }
}

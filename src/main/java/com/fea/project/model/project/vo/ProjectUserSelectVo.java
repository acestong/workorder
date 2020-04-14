package com.fea.project.model.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/16 12:16
 **/
@Data
public class ProjectUserSelectVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<ProjectUserSelectVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public ProjectUserSelectVo() {
    }

    public ProjectUserSelectVo(SysJobVo sysJobVo) {
        this.id = sysJobVo.getID();
        this.name = sysJobVo.getNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.parentId = sysJobVo.getPARENTID();
        this.children = sysJobVo.getSysUserModels().stream().map(x -> new ProjectUserSelectVo(x, this.id)).collect(Collectors.toList());
    }

    public ProjectUserSelectVo(SysUserModel sysUserModel, Long parentId) {
        this.id = sysUserModel.getUserId();
        this.name = sysUserModel.getRealName();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.parentId = parentId;
        this.children = Collections.emptyList();
    }

    public static List<ProjectUserSelectVo> createList(List<SysJobVo> sysJobModels) {
        if (ListUtil.isNullOrEmpty(sysJobModels)) {
            return Collections.emptyList();
        }
        List<ProjectUserSelectVo> list = sysJobModels.stream().map(ProjectUserSelectVo::new).collect(Collectors.toList());
        Map<Long, ProjectUserSelectVo> map = list.stream().collect(Collectors
                .toMap(ProjectUserSelectVo::getId, projectUserSelectVo -> projectUserSelectVo));
        List<ProjectUserSelectVo> finalList = new ArrayList<>(16);
        list.forEach(x -> {
            ProjectUserSelectVo tmpModel = map.get(x.getParentId());
            if (tmpModel == null) {
                finalList.add(x);
                return;
            }
            tmpModel.getChildren().add(x);
        });
        return finalList;
    }
}

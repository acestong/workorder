package com.fea.project.model.flow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysRoleModel;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/16 12:16
 **/
@Data
public class ProjectFlowPersonTypeSelectVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<ProjectFlowPersonTypeSelectVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public ProjectFlowPersonTypeSelectVo() {
    }

    public ProjectFlowPersonTypeSelectVo(Long id, String name, Integer tag, List<ProjectFlowPersonTypeSelectVo> children, Long parentId) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.children = children;
        this.parentId = parentId;
    }

    public ProjectFlowPersonTypeSelectVo(SysRoleModel x) {
        this.id = x.getROLEID();
        this.name = x.getROLENAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.children = new ArrayList<>();
        this.parentId = null;
    }
}

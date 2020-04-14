package com.fea.project.model.projectdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FinalTreeVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private Integer gender;
    private List<FinalTreeVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public FinalTreeVo() {
    }

    public FinalTreeVo(Long id, String name, Integer tag, Integer gender, List<FinalTreeVo> children, Long parentId) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.gender = gender;
        this.children = children;
        this.parentId = parentId;
    }
    public FinalTreeVo(ProjectTeamTreeVo projectTeamTreeVo) {
        this.id = projectTeamTreeVo.getTeamId();
        this.name = projectTeamTreeVo.getName();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.children = projectTeamTreeVo.getChild();
        this.parentId = projectTeamTreeVo.getParentId();
    }
    public FinalTreeVo(SysUserModel model, Long parentId) {
        this.id = model.getUserId();
        this.name = model.getRealName();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.gender = model.getGender();
        this.parentId = parentId;
    }
    public static List<FinalTreeVo> FinalTreeList(List<SysUserModel> models , Long parentId) {
        List<FinalTreeVo> list = new ArrayList<>();
        for (SysUserModel model : models){
            list.add(new FinalTreeVo(model,parentId));
        }
        return list;
    }
}

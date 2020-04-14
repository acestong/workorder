package com.fea.project.model.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.model.team.vo.TeamPageLeftTeamVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/3/17 17:20
 * 人员管辖类型数据
 **/
@Data
public class UserManageInfoVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    private Integer type;

    private Integer sex;

    private List<UserManageInfoVo> children;

    public UserManageInfoVo() {
    }

    public UserManageInfoVo(SysUserModel tmp, Long parentId) {
        this.id = tmp.getUserId();
        this.name = tmp.getRealName();
        this.parentId = parentId;
        this.type = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.sex = tmp.getGender();
    }

    public UserManageInfoVo(SysJobVo sysJobVo) {
        this.id = sysJobVo.getID();
        this.name = sysJobVo.getNAME();
        this.parentId = sysJobVo.getPARENTID();
        this.type = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.children = new ArrayList<>();
    }
}

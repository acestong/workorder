package com.fea.project.model.team.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysEmployeeModel;
import com.fea.project.api.other.model.base.SysOrgRegisterModel;
import com.fea.project.api.other.model.base.vo.SysDepartmentVo;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/16 12:16
 **/
@Data
public class TeamPersonSelectVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<TeamPersonSelectVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public TeamPersonSelectVo() {
    }

    public TeamPersonSelectVo(SysOrgRegisterModel sysOrgRegisterModel, List<SysDepartmentVo> sysDepartmentVos) {
        this(sysOrgRegisterModel);
        this.setChildren(TeamPersonSelectVo.createList(sysDepartmentVos));
    }

    public TeamPersonSelectVo(SysOrgRegisterModel sysOrgRegisterModel) {
        this.id = sysOrgRegisterModel.getREGID();
        this.name = sysOrgRegisterModel.getORGNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.parentId = null;
    }

    public TeamPersonSelectVo(SysDepartmentVo tmp) {
        this.id = tmp.getDEPID();
        this.name = tmp.getDEPNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.parentId = tmp.getPARENTID();
        this.children = tmp.getSysEmployeeModelList() == null ? new ArrayList<>() : tmp.getSysEmployeeModelList().stream().map(TeamPersonSelectVo::new).collect(Collectors.toList());
    }

    public TeamPersonSelectVo(SysEmployeeModel sysEmployeeModel) {
        this.id = sysEmployeeModel.getUSERID();
        this.name = sysEmployeeModel.getEMPNAME();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.parentId = sysEmployeeModel.getEMPID();
        this.children = new ArrayList<>();
    }

    public static List<TeamPersonSelectVo> createList(List<SysDepartmentVo> sysDepartmentVos) {
        List<TeamPersonSelectVo> list = sysDepartmentVos.stream().map(TeamPersonSelectVo::new).collect(Collectors.toList());
        Map<Long, TeamPersonSelectVo> map = list.stream().collect(Collectors
                .toMap(TeamPersonSelectVo::getId, teamPersonSelectVo -> teamPersonSelectVo));
        List<TeamPersonSelectVo> finalList = new ArrayList<>();
        list.forEach(tmp -> {
            TeamPersonSelectVo teamPersonSelectVo = map.get(tmp.getParentId());
            if (teamPersonSelectVo == null) {
                finalList.add(tmp);
                return;
            }
            teamPersonSelectVo.getChildren().add(tmp);
        });
        return finalList;
    }
}

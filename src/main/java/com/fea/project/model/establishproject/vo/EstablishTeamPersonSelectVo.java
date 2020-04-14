package com.fea.project.model.establishproject.vo;

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
public class EstablishTeamPersonSelectVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<EstablishTeamPersonSelectVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public EstablishTeamPersonSelectVo() {
    }

    public EstablishTeamPersonSelectVo(SysOrgRegisterModel sysOrgRegisterModel, List<SysDepartmentVo> sysDepartmentVos) {
        this(sysOrgRegisterModel);
        this.setChildren(EstablishTeamPersonSelectVo.createList(sysDepartmentVos));
    }

    public EstablishTeamPersonSelectVo(SysOrgRegisterModel sysOrgRegisterModel) {
        this.id = sysOrgRegisterModel.getREGID();
        this.name = sysOrgRegisterModel.getORGNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.parentId = null;
    }

    public EstablishTeamPersonSelectVo(SysDepartmentVo tmp) {
        this.id = tmp.getDEPID();
        this.name = tmp.getDEPNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.parentId = tmp.getPARENTID();
        this.children = tmp.getSysEmployeeModelList() == null ? new ArrayList<>() : tmp.getSysEmployeeModelList().stream().map(EstablishTeamPersonSelectVo::new).collect(Collectors.toList());
    }

    public EstablishTeamPersonSelectVo(SysEmployeeModel sysEmployeeModel) {
        this.id = sysEmployeeModel.getUSERID();
        this.name = sysEmployeeModel.getEMPNAME();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.parentId = sysEmployeeModel.getEMPID();
        this.children = new ArrayList<>();
    }

    public static List<EstablishTeamPersonSelectVo> createList(List<SysDepartmentVo> sysDepartmentVos) {
        List<EstablishTeamPersonSelectVo> list = sysDepartmentVos.stream().map(EstablishTeamPersonSelectVo::new).collect(Collectors.toList());
        Map<Long, EstablishTeamPersonSelectVo> map = list.stream().collect(Collectors
                .toMap(EstablishTeamPersonSelectVo::getId, teamPersonSelectVo -> teamPersonSelectVo));
        List<EstablishTeamPersonSelectVo> finalList = new ArrayList<>();
        list.forEach(tmp -> {
            EstablishTeamPersonSelectVo teamPersonSelectVo = map.get(tmp.getParentId());
            if (teamPersonSelectVo == null) {
                finalList.add(tmp);
                return;
            }
            teamPersonSelectVo.getChildren().add(tmp);
        });
        return finalList;
    }
}

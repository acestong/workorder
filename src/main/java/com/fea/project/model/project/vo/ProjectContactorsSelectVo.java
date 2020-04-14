package com.fea.project.model.project.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.customer.CrmContactModel;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.model.customer.CrmStructureModel;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.util.ListUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/16 12:16
 **/
@Data
public class ProjectContactorsSelectVo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private Integer tag;
    private List<ProjectContactorsSelectVo> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    public ProjectContactorsSelectVo() {
    }

    public ProjectContactorsSelectVo(CrmCustomerModel x) {
        this.id = x.getID();
        this.name = x.getNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.children = new ArrayList<>();
    }

    public ProjectContactorsSelectVo(CrmStructureModel x) {
        this.id = x.getID();
        this.name = x.getGROUPNAME();
        this.tag = ProjectTeamTagEnum.TYPE_TEAM.getValue();
        this.children = new ArrayList<>();
        this.parentId = x.getCUSTOMERID();
    }

    public ProjectContactorsSelectVo(CrmContactModel x) {
        this.id = x.getID();
        this.name = x.getCONTACTNAME();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.children = new ArrayList<>();
        this.parentId = x.getCUSTOMERID();
    }

    public ProjectContactorsSelectVo(CrmContactModel x, Long parentId) {
        this.id = x.getID();
        this.name = x.getCONTACTNAME();
        this.tag = ProjectTeamTagEnum.TYPE_USER.getValue();
        this.children = new ArrayList<>();
        this.parentId = parentId;
    }

    public static List<ProjectContactorsSelectVo> createList(List<CrmCustomerModel> crmCustomerModels, List<CrmStructureModel> crmStructureModels, List<CrmContactModel> crmContactModels) {
        if (ListUtil.isNullOrEmpty(crmCustomerModels)) {
            return new ArrayList<>();
        }
        List<ProjectContactorsSelectVo> list = crmCustomerModels.stream().map(ProjectContactorsSelectVo::new).collect(Collectors.toList());
        Map<Long, ProjectContactorsSelectVo> map = list.stream().collect(Collectors.toMap(ProjectContactorsSelectVo::getId, projectContactorsSelectVo -> projectContactorsSelectVo));
        Map<Long, ProjectContactorsSelectVo> crmStructureModelMap = new HashMap<>();
        crmStructureModels.forEach(x -> {
            ProjectContactorsSelectVo tmp = map.get(x.getCUSTOMERID());
            if (tmp == null) {
                return;
            }
            ProjectContactorsSelectVo tmpModel = new ProjectContactorsSelectVo(x);
            tmp.getChildren().add(tmpModel);
            crmStructureModelMap.put(tmpModel.getId(), tmpModel);
        });
        crmContactModels.forEach(x -> {
            ProjectContactorsSelectVo tmp = crmStructureModelMap.get(x.getSTRUCTUREID());
            if (tmp == null) {
                tmp = map.get(x.getCUSTOMERID());
                if (tmp == null) {
                    return;
                }
                tmp.getChildren().add(new ProjectContactorsSelectVo(x));
                return;
            }
            tmp.getChildren().add(new ProjectContactorsSelectVo(x, tmp.getId()));
        });
        return list;
    }
}

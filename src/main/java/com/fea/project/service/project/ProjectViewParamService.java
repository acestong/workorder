package com.fea.project.service.project;


import com.fea.project.api.other.model.crm.CrmDictionaryIndustryModel;
import com.fea.project.api.other.model.crm.CrmDictionaryRegionModel;
import com.fea.project.api.other.model.crm.vo.CrmDictionaryIndustryVo;
import com.fea.project.api.other.model.crm.vo.CrmDictionaryRegionVo;
import com.fea.project.api.other.service.crm.CrmDictionaryIndustryService;
import com.fea.project.api.other.service.crm.CrmDictionaryRegionService;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/28.
 */
@Service
public class ProjectViewParamService {

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private CrmDictionaryIndustryService crmDictionaryIndustryService;

    @Autowired
    private CrmDictionaryRegionService crmDictionaryRegionService;

    @Autowired
    private ProjectService projectService;



    public Object selectProjectLevel(Long regId) {
        List<ProjectDictionaryItemSelectVo> projectDictionaryItemSelectVos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_LEVEL.getValue(), regId));
        return projectDictionaryItemSelectVos.stream().map(x -> {
            Map<String, Object> map = new HashMap<>(2);
            map.put("value", x.getId() + "");
            map.put("text", x.getName());
            return map;
        }).collect(Collectors.toList());
    }

    public Object selectIndustry(Long regId) {
        List<CrmDictionaryIndustryModel> crmDictionaryIndustryModels = this.crmDictionaryIndustryService.selectUsefulIndustry(UserUtil.getUserRegId());
        return CrmDictionaryIndustryVo.createListByCrmDictionaryIndustryModel(crmDictionaryIndustryModels);
    }

    public Object selectRegion(Long userRegId) {
        List<CrmDictionaryRegionModel> crmDictionaryRegionModels = this.crmDictionaryRegionService.selectUsefulRegion(UserUtil.getUserRegId());
        return CrmDictionaryRegionVo.createListByCrmDictionaryRegionModel(crmDictionaryRegionModels);
    }

    public Object selectRiskLevel(Long regId) {
        List<ProjectDictionaryItemSelectVo> projectDictionaryItemSelectVos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RISK_TYPE.getValue(), regId));
        return projectDictionaryItemSelectVos.stream().map(x -> {
            Map<String, Object> map = new HashMap<>(2);
            map.put("value", x.getId() + "");
            map.put("text", x.getName());
            return map;
        }).collect(Collectors.toList());
    }

    public Object selectLeaders(Long userRegId) {
        return this.projectService.selectCurrentProjectUsers();
    }

    public Object selectOrgs(Long userRegId) {
        return  this.projectService.selectCurrentProjectDept();
    }
}
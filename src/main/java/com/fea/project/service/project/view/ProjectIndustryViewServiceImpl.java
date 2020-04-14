package com.fea.project.service.project.view;

import com.fea.project.api.other.service.crm.CrmDictionaryIndustryService;
import com.fea.project.service.project.view.io.IProjectDefaultViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 10:05
 * 项目行业
 **/
@Service
public class ProjectIndustryViewServiceImpl implements IProjectDefaultViewService {

    @Autowired
    private CrmDictionaryIndustryService crmDictionaryIndustryService;

    @Override
    public List<Map<String, Object>> queryParamByParent(Long parentId, Long regId) {
        return this.crmDictionaryIndustryService.selectIndustryByLevel(parentId, regId)
                .stream().map(x -> {
                    Map<String, Object> map = new HashMap<>(2);
                    map.put("value", x.getID());
                    map.put("text", x.getNAME());
                    return map;
                }).collect(Collectors.toList());
    }
}

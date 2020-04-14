package com.fea.project.service.project.view;

import com.fea.project.api.other.service.crm.CrmDictionaryRegionService;
import com.fea.project.service.project.view.io.IProjectDefaultViewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 14:24
 * 项目区域
 **/
public class ProjectAreaViewServiceImpl implements IProjectDefaultViewService {

    @Autowired
    private CrmDictionaryRegionService crmDictionaryRegionService;

    @Override
    public List<Map<String, Object>> queryParamByParent(Long parentId, Long regId) {
        return crmDictionaryRegionService.selectRegionByLevel(parentId, regId).stream()
                .map(x -> {
                    Map<String, Object> map = new HashMap<>(2);
                    map.put("value", x.getID());
                    map.put("text", x.getNAME());
                    return map;
                }).collect(Collectors.toList());
    }
}

package com.fea.project.service.project.view;

import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.service.base.ProjectDictionaryItemService;
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
 * 项目风险等级
 **/
@Service
public class ProjectRiskLevelViewServiceImpl implements IProjectDefaultViewService {

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Override
    public List<Map<String, Object>> queryParamByParent(Long parentId, Long regId) {
        return this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(
                new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RISK_LEVEL.getValue(), regId)).stream()
                .map(x -> {
                    Map<String, Object> map = new HashMap<>(2);
                    map.put("value", x.getId());
                    map.put("text", x.getName());
                    return map;
                }).collect(Collectors.toList());
    }
}

package com.fea.project.controller.base;

import com.fea.project.api.other.model.base.SysUriModel;
import com.fea.project.api.other.service.base.SysUriService;
import com.fea.project.configure.aop.AopPriorityCheck;
import com.fea.project.enums.base.EnableStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/3/6 11:04
 **/
@RestController
@RequestMapping("projectBasePriority")
public class ProjectBasePriorityController {

    @Autowired
    private SysUriService sysUriService;

    @RequestMapping("selectProjectPriority")
    public Map<String, Integer> selectProjectPriority(){
        Map<String, Integer> map = sysUriService.selectByCurrentUserProjectPriority(AopPriorityCheck.PROJECT_MANAGE_PRIORITY_STR)
                .stream().collect(Collectors.toMap(SysUriModel::getURICODE, x -> EnableStatusEnum.ENABLE.getStatus()));
        Map<String, Integer> allProjectPriority = sysUriService.selectByPriorityStr(AopPriorityCheck.PROJECT_MANAGE_PRIORITY_STR)
                .stream().collect(Collectors.toMap(SysUriModel::getURICODE, x -> EnableStatusEnum.DISABLE.getStatus()));
        map.putAll(allProjectPriority);
        return map;
    }

}

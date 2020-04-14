package com.fea.project.controller.fieldconfig;

import com.fea.project.model.fieldconfig.ProjectFieldConfigModel;
import com.fea.project.model.fieldconfig.ProjectFieldConfigPersonModel;
import com.fea.project.model.fieldconfig.pojo.ProjectUpdateFieldPojo;
import com.fea.project.service.fieldconfig.ProjectFieldConfigPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/01/19.
 */
@RestController
@RequestMapping("projectFieldConfigPerson")
public class ProjectFieldConfigPersonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFieldConfigPersonController.class);

    @Autowired
    private ProjectFieldConfigPersonService projectFieldConfigPersonService;

    @GetMapping(value = "selectColumnsByType")
    public List<Map<String, String>> selectColumnsByType(@RequestBody ProjectFieldConfigPersonModel model){
        return this.projectFieldConfigPersonService.selectColumnsByType(model);
    }

    @RequestMapping("selectConfigFieldByType")
    public Map<String, List<ProjectFieldConfigModel>> selectConfigFieldByType(@RequestBody ProjectFieldConfigPersonModel model){
        return this.projectFieldConfigPersonService.selectConfigFieldByType(model);
    }

    @RequestMapping("updateConfigField")
    public ProjectUpdateFieldPojo updateConfigField(@RequestBody ProjectUpdateFieldPojo model){
        return this.projectFieldConfigPersonService.updateConfigField(model);
    }

}
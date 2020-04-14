package com.fea.project.controller.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.service.baseconfig.ProjectCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/09/27.
 */
@RestController
@RequestMapping("projectCode")
public class ProjectCodeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectCodeController.class);


    @Autowired
    private ProjectCodeService projectCodeService;


    /**
     * 按模型选择
     */
    @RequestMapping("selectConfig")
    public ProjectCodeModel selectConfig() {
        return this.projectCodeService.selectConfig();
    }


    @RequestMapping("selectDateTypeMap")
    public List<Map<String, Object>> selectDateTypeMap() {
        return this.projectCodeService.selectDateTypeMap();
    }

}
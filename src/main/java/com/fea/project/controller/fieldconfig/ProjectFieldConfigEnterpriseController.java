package com.fea.project.controller.fieldconfig;

import com.fea.project.model.fieldconfig.ProjectFieldConfigEnterpriseModel;
import java.util.List;

import com.fea.project.service.fieldconfig.ProjectFieldConfigEnterpriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/01/19.
 */
@RestController
@RequestMapping("projectFieldConfigEnterprise")
public class ProjectFieldConfigEnterpriseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFieldConfigEnterpriseController.class);


    @Autowired
    private ProjectFieldConfigEnterpriseService projectFieldConfigEnterpriseService;


}
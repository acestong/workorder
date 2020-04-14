package com.fea.project.controller.apply;

import com.fea.project.model.apply.ProjectApplyAdviseModel;
import com.fea.project.service.apply.ProjectApplyAdviseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
@RestController
@RequestMapping("projectApplyAdvise")
public class ProjectApplyAdviseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectApplyAdviseController.class);


    @Autowired
    private ProjectApplyAdviseService projectApplyAdviseService;

}
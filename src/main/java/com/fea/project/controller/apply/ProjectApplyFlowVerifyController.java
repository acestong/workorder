package com.fea.project.controller.apply;

import com.fea.project.model.apply.pojo.ProjectApplyFlowVerifyPojo;
import com.fea.project.service.apply.ProjectApplyFlowVerifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/11/18.
 */
@RestController
@RequestMapping("projectApplyFlowVerify")
public class ProjectApplyFlowVerifyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectApplyFlowVerifyController.class);


    @Autowired
    private ProjectApplyFlowVerifyService projectApplyFlowVerifyService;

    @RequestMapping("updateModel")
    public ProjectApplyFlowVerifyPojo updateModel(@RequestBody ProjectApplyFlowVerifyPojo model) {
        return this.projectApplyFlowVerifyService.updateModel(model);
    }

}
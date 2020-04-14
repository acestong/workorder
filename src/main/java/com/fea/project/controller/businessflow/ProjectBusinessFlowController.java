package com.fea.project.controller.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import com.fea.project.model.businessflow.pojo.ProjectBusinessFlowPojo;
import com.fea.project.service.businessflow.ProjectBusinessFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/11/16.
 */
@RestController
@RequestMapping("projectBusinessFlow")
public class ProjectBusinessFlowController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessFlowController.class);


    @Autowired
    private ProjectBusinessFlowService projectBusinessFlowService;

    @RequestMapping("copyFlowToBusiness")
    public ProjectBusinessFlowModel copyFlowToBusiness(@RequestBody ProjectBusinessFlowPojo model) {
        return this.projectBusinessFlowService.copyFlowToBusiness(model);
    }


}
package com.fea.project.controller.establishproject.project;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishStepPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishStepVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.establishproject.project.ProjectEstablishStepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/12/30.
 */
@RestController
@RequestMapping("projectEstablishStep")
public class ProjectEstablishStepController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishStepController.class);


    @Autowired
    private ProjectEstablishStepService projectEstablishStepService;

    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/establishProject/establishStep")
    public List<ProjectEstablishStepVo> listByParam(@RequestBody ProjectModel model){
        return this.projectEstablishStepService.listByParam(model);
    }

    @RequestMapping("insertModel")
    @PermissionAnno("/projectManage/establishProject/insertEstablishStep")
    public ProjectEstablishStepPojo insertModel(@RequestBody ProjectEstablishStepPojo model){
        return this.projectEstablishStepService.insertModel(model);
    }

    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/establishProject/updateEstablishStep")
    public ProjectEstablishStepPojo updateModel(@RequestBody ProjectEstablishStepPojo model){
        return this.projectEstablishStepService.updateModel(model);
    }

    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/establishProject/deleteEstablishStep")
    public ProjectEstablishStepModel deleteModel(@RequestBody ProjectEstablishStepModel model){
        return this.projectEstablishStepService.deleteModel(model);
    }

    @RequestMapping("submitToVerify")
    @PermissionAnno("/projectManage/establishProject/submitEstablishStep")
    public ProjectEstablishStepModel submitToVerify(@RequestBody ProjectEstablishStepModel model){
        return this.projectEstablishStepService.submitToVerify(model);
    }
}
package com.fea.project.controller.establishproject.project;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.ProjectStepVerifyModel;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.service.project.ProjectStepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/09/23.
 */
@RestController
@RequestMapping("establishProjectStep")
public class EstablishProjectStepController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EstablishProjectStepController.class);


    @Autowired
    private ProjectStepService projectStepService;


    /**
     * 插入数据
     */
    @RequestMapping("insertModel")
    public ProjectStepModel insertModel(@RequestBody ProjectStepModel model) {
        return this.projectStepService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByProjectId")
    @PermissionAnno("/projectManage/establishProject/projectStep")
    public List<ProjectStepVo> listByProjectId(@RequestBody ProjectStepModel model) {
        return this.projectStepService.listByProjectId(model);
    }

    @RequestMapping("selectByProjectId")
    public List<Map<String, Object>> selectByProjectId(@RequestBody ProjectStepModel model) {
        return this.projectStepService.selectByProjectId(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/establishProject/updateProjectStep")
    public ProjectStepModel updateModel(@RequestBody ProjectStepModel model) {
        return this.projectStepService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/establishProject/deleteProjectStep")
    public ProjectStepModel deleteModel(@RequestBody ProjectStepModel model) {
        return this.projectStepService.deleteModel(model);
    }

    /**
     * 阶段确认
     */
    @RequestMapping("verifyProjectStep")
    public ProjectStepVerifyModel verifyProjectStep(@RequestBody ProjectStepVerifyModel model) {
        return this.projectStepService.verifyProjectStep(model);
    }

    @RequestMapping("selectVerifyProjectStepDetail")
    public ProjectStepVerifyModel selectVerifyProjectStepDetail(@RequestBody ProjectStepVerifyModel model) {
        return this.projectStepService.selectVerifyProjectStepDetail(model);
    }

    @RequestMapping("selectStep")
    public List<ProjectStepModel> findByProjectId(@RequestBody ProjectStepModel model) {
        return this.projectStepService.findByProjectId(model);
    }
}
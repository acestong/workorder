package com.fea.project.controller.establishproject.project;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectExternalContactorModel;
import com.fea.project.model.project.pojo.ProjectExternalContactorPojo;
import com.fea.project.service.project.ProjectExternalContactorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/10/24.
 */
@RestController
@RequestMapping("establishProjectExternalContactor")
public class EstablishProjectExternalContactorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EstablishProjectExternalContactorController.class);


    @Autowired
    private ProjectExternalContactorService projectExternalContactorService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    @PermissionAnno("/projectManage/establishProject/insertExternalContactors")
    public ProjectExternalContactorModel insert(@RequestBody ProjectExternalContactorModel model) {
        return this.projectExternalContactorService.insertModel(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/establishProject/externalContactors")
    public BasePageInfo<ProjectExternalContactorModel> listByParam(@RequestBody BasePageInfo<ProjectExternalContactorModel> model) {
        if (model == null || model.getModel().getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目信息异常，无法进行查询");
        }
        return this.projectExternalContactorService.listByParam(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    @PermissionAnno("/projectManage/establishProject/updateExternalContactors")
    public ProjectExternalContactorModel update(@RequestBody ProjectExternalContactorModel model) {
        return this.projectExternalContactorService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    @PermissionAnno("/projectManage/establishProject/deleteExternalContactors")
    public ProjectExternalContactorPojo delete(@RequestBody ProjectExternalContactorPojo model) {
        return this.projectExternalContactorService.deleteModels(model);
    }
}
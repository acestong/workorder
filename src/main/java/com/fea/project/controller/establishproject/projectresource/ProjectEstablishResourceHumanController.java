package com.fea.project.controller.establishproject.projectresource;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishResourceHumanPojo;
import com.fea.project.model.establishproject.projectresource.ProjectEstablishResourceHumanModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishResourceHumanVo;
import com.fea.project.service.establishproject.projectresource.ProjectEstablishResourceHumanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by Administrator on 2020/01/10.
 */
@RestController
@RequestMapping("projectEstablishResourceHuman")
public class ProjectEstablishResourceHumanController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishResourceHumanController.class);


    @Autowired
    private ProjectEstablishResourceHumanService projectEstablishResourceHumanService;

    /**
     * 插入数据
     */
    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/establishProject/queryHRResource")
    public List<ProjectEstablishResourceHumanVo> listByParam(@RequestBody BasePageInfo<ProjectEstablishResourceHumanModel> basePageInfo) {
        return this.projectEstablishResourceHumanService.listByParam(basePageInfo);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("insertUserList")
    @PermissionAnno("/projectManage/establishProject/insertHRResource")
    public ProjectEstablishResourceHumanPojo insertUserList(@RequestBody ProjectEstablishResourceHumanPojo projectEstablishResourceHumanPojo) {
        return this.projectEstablishResourceHumanService.insertUserList(projectEstablishResourceHumanPojo);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/establishProject/updateHRResource")
    public ProjectEstablishResourceHumanModel updateModel(@RequestBody ProjectEstablishResourceHumanModel model) {
        return this.projectEstablishResourceHumanService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/establishProject/deleteHRResource")
    public ProjectEstablishResourceHumanModel deleteModel(@RequestBody ProjectEstablishResourceHumanModel model) {
        return this.projectEstablishResourceHumanService.deleteModel(model);
    }
}
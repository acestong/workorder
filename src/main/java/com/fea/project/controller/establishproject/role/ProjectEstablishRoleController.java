package com.fea.project.controller.establishproject.role;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleModel;
import com.fea.project.model.establishproject.vo.EstablishRolePageLeftRoleVo;
import com.fea.project.service.establishproject.role.ProjectEstablishRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
@RestController
@RequestMapping("projectEstablishRole")
public class ProjectEstablishRoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishRoleController.class);


    @Autowired
    private ProjectEstablishRoleService projectEstablishRoleService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    @PermissionAnno("/projectManage/establishProject/insertEstablishRole")
    public ProjectEstablishRoleModel insert(@RequestBody ProjectEstablishRoleModel model) {
        return this.projectEstablishRoleService.insertModel(model);
    }

    /**
     * 查询角色左侧树状图
     */
    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/establishProject/establishRole")
    public List<EstablishRolePageLeftRoleVo> listByParam(@RequestBody ProjectEstablishRoleModel model) {
        return this.projectEstablishRoleService.listByParam(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    @PermissionAnno("/projectManage/establishProject/updateEstablishRole")
    public ProjectEstablishRoleModel update(@RequestBody ProjectEstablishRoleModel model) {
        return this.projectEstablishRoleService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    @PermissionAnno("/projectManage/establishProject/deleteEstablishRole")
    public ProjectEstablishRoleModel delete(@RequestBody ProjectEstablishRoleModel model) {
        return this.projectEstablishRoleService.deleteModel(model);
    }

    @RequestMapping("selectOne")
    public ProjectEstablishRoleModel selectOne(@RequestBody ProjectEstablishRoleModel model) {
        return this.projectEstablishRoleService.selectOne(model);
    }

}
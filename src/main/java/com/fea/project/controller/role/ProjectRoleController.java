package com.fea.project.controller.role;

import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.role.vo.RolePageLeftRoleVo;
import com.fea.project.service.role.ProjectRoleService;
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
@RequestMapping("projectRole")
public class ProjectRoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRoleController.class);


    @Autowired
    private ProjectRoleService projectRoleService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectRoleModel insert(@RequestBody ProjectRoleModel model) {
        return this.projectRoleService.insertModel(model);
    }

    /**
     * 查询角色左侧树状图
     */
    @RequestMapping("listByParam")
    public List<RolePageLeftRoleVo> listByParam(@RequestBody ProjectRoleModel model) {
        return this.projectRoleService.listByParam(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectRoleModel update(@RequestBody ProjectRoleModel model) {
        return this.projectRoleService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectRoleModel delete(@RequestBody ProjectRoleModel model) {
        return this.projectRoleService.deleteModel(model);
    }

    @RequestMapping("selectOne")
    public ProjectRoleModel selectOne(@RequestBody ProjectRoleModel model) {
        return this.projectRoleService.selectOne(model);
    }

}
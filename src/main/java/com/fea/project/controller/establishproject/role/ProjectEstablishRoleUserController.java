package com.fea.project.controller.establishproject.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishRoleUserPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishRoleUserVo;
import com.fea.project.service.establishproject.role.ProjectEstablishRoleUserService;
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
@RequestMapping("projectEstablishRoleUser")
public class ProjectEstablishRoleUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishRoleUserController.class);


    @Autowired
    private ProjectEstablishRoleUserService projectEstablishRoleUserService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    @PermissionAnno("/projectManage/establishProject/insertEstablishRoleUser")
    public ProjectEstablishRoleUserPojo insert(@RequestBody ProjectEstablishRoleUserPojo model) {
        return this.projectEstablishRoleUserService.insertModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    @PermissionAnno("projectManage/establishProject/deleteEstablishRoleUser")
    public ProjectEstablishRoleUserPojo delete(@RequestBody ProjectEstablishRoleUserPojo model) {
        return this.projectEstablishRoleUserService.deleteRoleUser(model);
    }

    @RequestMapping("listByParam")
    public BasePageInfo<ProjectEstablishRoleUserVo> listByParam(@RequestBody BasePageInfo<ProjectEstablishRoleUserModel> model) {
        if (model == null || model.getModel() == null || model.getModel().getRoleId() == null) {
            throw new SystemParamCheckException("传入的角色id异常，无法进行人员查询");
        }
        return this.projectEstablishRoleUserService.listByParam(model);
    }

    @RequestMapping("listUnRoleTeamUsers")
    public List<SysUserModel> listUnRoleTeamUsers(@RequestBody ProjectEstablishUserModel projectEstablishUserModel) {
        return this.projectEstablishRoleUserService.listUnRoleTeamUsers(projectEstablishUserModel);
    }
}
package com.fea.project.controller.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.role.ProjectRoleUserModel;
import com.fea.project.model.role.pojo.ProjectRoleUserPojo;
import com.fea.project.model.role.vo.ProjectRoleUserVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.role.ProjectRoleUserService;
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
@RequestMapping("projectRoleUser")
public class ProjectRoleUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRoleUserController.class);


    @Autowired
    private ProjectRoleUserService projectRoleUserService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectRoleUserPojo insert(@RequestBody ProjectRoleUserPojo model) {
        return this.projectRoleUserService.insertModel(model);
    }


    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectRoleUserPojo delete(@RequestBody ProjectRoleUserPojo model) {
        return this.projectRoleUserService.deleteRoleUser(model);
    }

    @RequestMapping("listByParam")
    public BasePageInfo<ProjectRoleUserVo> listByParam(@RequestBody BasePageInfo<ProjectRoleUserModel> model) {
        if (model == null || model.getModel() == null || model.getModel().getRoleId() == null) {
            throw new SystemParamCheckException("传入的角色id异常，无法进行人员查询");
        }
        return this.projectRoleUserService.listByParam(model);
    }

    @RequestMapping("listUnRoleTeamUsers")
    public List<SysUserModel> listUnRoleTeamUsers(@RequestBody ProjectUserModel projectUserModel) {
        return this.projectRoleUserService.listUnRoleTeamUsers(projectUserModel);
    }
}
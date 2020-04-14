package com.fea.project.controller.user;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.milestone.vo.UserListTeamVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.user.ProjectUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/29.
 */
@RestController
@RequestMapping("projectUser")
public class ProjectUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectUserController.class);


    @Autowired
    private ProjectUserService projectUserService;

    @RequestMapping("listByProjectId")
    public List<SysUserModel> listByProjectId(@RequestBody ProjectUserModel model) {
        return this.projectUserService.listByProjectId(model);
    }

    @RequestMapping("selectUserListByProjectId")
    public List<SysUserModel> selectUserListByProjectId(@RequestBody ProjectUserModel model) {
        return this.projectUserService.selectUserListByProjectId(model);
    }

    @RequestMapping("selectUnGroupUserListByProjectId")
    public List<SysUserModel> selectUnGroupUserListByProjectId(@RequestBody ProjectUserModel model) {
        return this.projectUserService.selectUnGroupUserListByProjectId(model);
    }
    /**
     * 获取项目下的人员列表及其所属团队
     */
    @RequestMapping("userListTeamByProjectId")
    public List<UserListTeamVo> userListTeamByProjectId(@RequestBody ProjectUserModel model) {
        List<UserListTeamVo> userListTeamVos = this.projectUserService.userListTeamByProjectId(model);
        return userListTeamVos;
    }

    @RequestMapping("selectNormalUserListByProjectId")
    public List<SysUserModel> selectNormalUserListByProjectId(@RequestBody ProjectEstablishUserModel model) {
        return this.projectUserService.selectNormalUserListByProjectId(model);
    }
}
package com.fea.project.controller.establishproject.user;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.service.establishproject.user.ProjectEstablishUserService;
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
@RequestMapping("projectEstablishUser")
public class ProjectEstablishUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishUserController.class);


    @Autowired
    private ProjectEstablishUserService projectEstablishUserService;

    @RequestMapping("listByProjectId")
    public List<SysUserModel> listByProjectId(@RequestBody ProjectEstablishUserModel model) {
        return this.projectEstablishUserService.listByProjectId(model);
    }

    @RequestMapping("selectUserListByProjectId")
    public List<SysUserModel> selectUserListByProjectId(@RequestBody ProjectEstablishUserModel model) {
        return this.projectEstablishUserService.selectUserListByProjectId(model);
    }

    @RequestMapping("selectUnGroupUserListByProjectId")
    public List<SysUserModel> selectUnGroupUserListByProjectId(@RequestBody ProjectEstablishUserModel model) {
        return this.projectEstablishUserService.selectUnGroupUserListByProjectId(model);
    }

    @RequestMapping("selectNormalUserListByProjectId")
    public List<SysUserModel> selectNormalUserListByProjectId(@RequestBody ProjectEstablishUserModel model) {
        return this.projectEstablishUserService.selectNormalUserListByProjectId(model);
    }
}
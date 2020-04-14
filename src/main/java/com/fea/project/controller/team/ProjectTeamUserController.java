package com.fea.project.controller.team;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.team.ProjectTeamUserModel;
import com.fea.project.model.team.pojo.ProjectTeamUserPojo;
import com.fea.project.model.team.vo.ProjectTeamUserVo;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.team.ProjectTeamUserService;
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
@RequestMapping("projectTeamUser")
public class ProjectTeamUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectTeamUserController.class);


    @Autowired
    private ProjectTeamUserService projectTeamUserService;


    /**
     * 项目添加人员，查询组织用户
     *
     * @param projectUserModel
     * @return
     */
    @RequestMapping("selectDeptUser")
    public List<TeamPersonSelectVo> selectDeptUser(@RequestBody ProjectUserModel projectUserModel) {
        return this.projectTeamUserService.selectDeptUser(projectUserModel);
    }

    @RequestMapping("selectDeptUserWithNoParam")
    public List<TeamPersonSelectVo> selectDeptUserWithNoParam() {
        return this.projectTeamUserService.selectDeptUserWithNoParam();
    }


    @RequestMapping("insertUserFromReg")
    public ProjectTeamUserModel insertUserFromReg(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.insertUserFromReg(model);
    }

    @RequestMapping("insertUserFromTeam")
    public ProjectTeamUserModel insertUserFromTeam(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.insertUserFromTeam(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByParam")
    public BasePageInfo<ProjectTeamUserVo> listByParam(@RequestBody BasePageInfo<ProjectTeamUserModel> basePageInfo) {
        if (basePageInfo == null || basePageInfo.getModel() == null || basePageInfo.getModel().getTeamId() == null) {
            throw new SystemParamCheckException("传入团队id异常无法进行查询");
        }
        return this.projectTeamUserService.listByParam(basePageInfo);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectTeamUserPojo update(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectTeamUserPojo delete(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.deleteModels(model);
    }

    /**
     * 退出项目
     * @param model
     * @return
     */
    @RequestMapping("leftProject")
    public ProjectTeamUserModel leftProject(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.leftProject(model);
    }

    @RequestMapping("enterProject")
    public ProjectTeamUserModel enterProject(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.enterProject(model);
    }

    /**
     * 退出团队
     * @param model
     * @return
     */
    @RequestMapping("leftTeam")
    public ProjectTeamUserPojo leftTeam(@RequestBody ProjectTeamUserPojo model) {
        return this.projectTeamUserService.leftTeam(model);
    }


}
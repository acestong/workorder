package com.fea.project.controller.establishproject.team;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamUserPojo;
import com.fea.project.model.establishproject.vo.EstablishTeamPersonSelectVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishTeamUserVo;
import com.fea.project.service.establishproject.team.ProjectEstablishTeamUserService;
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
@RequestMapping("projectEstablishTeamUser")
public class ProjectEstablishTeamUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishTeamUserController.class);


    @Autowired
    private ProjectEstablishTeamUserService projectEstablishTeamUserService;


    /**
     * 项目添加人员，查询组织用户
     *
     * @param projectUserModel
     * @return
     */
    @RequestMapping("selectDeptUser")
    public List<EstablishTeamPersonSelectVo> selectDeptUser(@RequestBody ProjectEstablishUserModel projectUserModel) {
        return this.projectEstablishTeamUserService.selectDeptUser(projectUserModel);
    }

    @RequestMapping("selectDeptUserWithNoParam")
    public List<EstablishTeamPersonSelectVo> selectDeptUserWithNoParam() {
        return this.projectEstablishTeamUserService.selectDeptUserWithNoParam();
    }


    @RequestMapping("insertUserFromReg")
    @PermissionAnno("/projectManage/establishProject/insertEstablishUser")
    public ProjectEstablishTeamUserModel insertUserFromReg(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.insertUserFromReg(model);
    }

    @RequestMapping("insertUserFromTeam")
    @PermissionAnno("/projectManage/establishProject/insertEstablishUser")
    public ProjectEstablishTeamUserModel insertUserFromTeam(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.insertUserFromTeam(model);
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByParam")
    public BasePageInfo<ProjectEstablishTeamUserVo> listByParam(@RequestBody BasePageInfo<ProjectEstablishTeamUserModel> basePageInfo) {
        if (basePageInfo == null || basePageInfo.getModel() == null || basePageInfo.getModel().getTeamId() == null) {
            throw new SystemParamCheckException("传入团队id异常无法进行查询");
        }
        return this.projectEstablishTeamUserService.listByParam(basePageInfo);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    @PermissionAnno("/projectManage/establishProject/updateEstablishUser")
    public ProjectEstablishTeamUserPojo update(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.updateModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    @PermissionAnno("/projectManage/establishProject/deleteEstablishUser")
    public ProjectEstablishTeamUserPojo delete(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.deleteModels(model);
    }

    /**
     * 退出项目
     * @param model
     * @return
     */
    @RequestMapping("leftProject")
    @PermissionAnno("/projectManage/establishProject/removeEstablishUser")
    public ProjectEstablishTeamUserModel leftProject(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.leftProject(model);
    }

    @RequestMapping("enterProject")
    public ProjectEstablishTeamUserModel enterProject(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.enterProject(model);
    }

    /**
     * 退出团队
     * @param model
     * @return
     */
    @RequestMapping("leftTeam")
    @PermissionAnno("/projectManage/establishProject/removeEstablishUser")
    public ProjectEstablishTeamUserPojo leftTeam(@RequestBody ProjectEstablishTeamUserPojo model) {
        return this.projectEstablishTeamUserService.leftTeam(model);
    }


}
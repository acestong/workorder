package com.fea.project.controller.role;

import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import com.fea.project.model.role.ProjectRoleAuthorityModel;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityConfigPojo;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityPojo;
import com.fea.project.model.role.vo.ProjectRoleAuthorityVo;
import com.fea.project.model.role.vo.RolePriorityPageLeftVo;
import com.fea.project.model.team.vo.TeamPageLeftTeamVo;
import com.fea.project.service.role.ProjectRoleAuthorityService;
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
@RequestMapping("projectRoleAuthority")
public class ProjectRoleAuthorityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRoleAuthorityController.class);


    @Autowired
    private ProjectRoleAuthorityService projectRoleAuthorityService;

    @RequestMapping("listRegAuthorityByRoleId")
    public List<ProjectRoleAuthorityVo> listRegAuthority(@RequestBody ProjectRoleModel model) {
        return this.projectRoleAuthorityService.listRegAuthority(model);
    }

    @RequestMapping("updateRoleAuthority")
    public ProjectRoleAuthorityConfigPojo updateRoleAuthority(@RequestBody ProjectRoleAuthorityConfigPojo model) {
        return this.projectRoleAuthorityService.updateRoleAuthority(model);
    }

    /**
     * 系统管理员查看所有的系统权限
     * @return
     */
    @RequestMapping("listAuthorityTypes")
    public List<ProjectRoleAuthorityModel> listAuthorityTypes(){
        return this.projectRoleAuthorityService.listAuthorityTypes();
    }



    /**
     * 插入项目角色权限类型
     * @param projectRoleAuthorityModel
     *        projectRoleAuthorityModel.name 为必填项 （权限类型名称）
     * @return projectRoleAuthorityModel
     */
    @RequestMapping("insertModel")
    public ProjectRoleAuthorityModel insertModel(@RequestBody ProjectRoleAuthorityModel projectRoleAuthorityModel){
        return this.projectRoleAuthorityService.insertModel(projectRoleAuthorityModel);
    }

    /**
     * 更新项目角色权限类型
     * @param projectRoleAuthorityModel
     *        projectRoleAuthorityModel.id 为必填项 （权限类型id）
     *        projectRoleAuthorityModel.name 为必填项 （权限类型名称）
     * @return projectRoleAuthorityModel
     */
    @RequestMapping("updateModel")
    public ProjectRoleAuthorityModel updateModel(@RequestBody ProjectRoleAuthorityModel projectRoleAuthorityModel){
        return this.projectRoleAuthorityService.updateModel(projectRoleAuthorityModel);
    }

    /**
     * 更新项目类型数据的位置
     * @param projectRoleAuthorityPojo
     *        projectRoleAuthorityPojo.ids 为必填项 （两个参数的集合）
     * @return projectRoleAuthorityPojo
     */
    @RequestMapping("exchangeAuthorityPosition")
    public ProjectRoleAuthorityPojo exchangeAuthorityPosition(@RequestBody ProjectRoleAuthorityPojo projectRoleAuthorityPojo){
        return this.projectRoleAuthorityService.exchangeAuthorityPosition(projectRoleAuthorityPojo);
    }

    /**
     * 删除项目角色权限类型
     * @param projectRoleAuthorityModel
     *        projectRoleAuthorityModel.id 为必填项 （权限类型id）
     * @return projectRoleAuthorityModel
     */
    @RequestMapping("deleteModel")
    public ProjectRoleAuthorityModel deleteModel(@RequestBody ProjectRoleAuthorityModel projectRoleAuthorityModel){
        return this.projectRoleAuthorityService.deleteModel(projectRoleAuthorityModel);
    }

    /**
     * 查询项目内部权限
     * @return
     */
    @RequestMapping("selectProjectRoleAuthority")
    public List<RolePriorityPageLeftVo> selectProjectRoleAuthority(){
        return this.projectRoleAuthorityService.selectProjectRoleAuthority();

    }
}
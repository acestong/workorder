package com.fea.project.controller.role;

import com.fea.project.enums.project.ProjectRoleAuthorityActionTypeEnum;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityDetailPojo;
import com.fea.project.service.role.ProjectRoleAuthorityDetailService;
import com.fea.project.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/09/23.
 */
@RestController
@RequestMapping("projectRoleAuthorityDetail")
public class ProjectRoleAuthorityDetailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRoleAuthorityDetailController.class);


    @Autowired
    private ProjectRoleAuthorityDetailService projectRoleAuthorityDetailService;

    /**
     * @param projectRoleAuthorityDetailModel
     *        projectRoleAuthorityDetailModel.authorityId 必填项 （权限详情中权限类型为必填项）
     * @return
     */
    @RequestMapping("listAuthorityDetailsByTypeId")
    public List<ProjectRoleAuthorityDetailModel> listAuthorityDetailsByTypeId(@RequestBody ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel){
        return this.projectRoleAuthorityDetailService.listAuthorityDetailsByTypeId(projectRoleAuthorityDetailModel.getAuthorityId());
    }


    /**
     * @param projectRoleAuthorityDetailModel
     *        projectRoleAuthorityDetailModel.name 必填项 （权限详情中权限名称）
     *        projectRoleAuthorityDetailModel.signatures 必填项 （权限详情中权限特征码）
     *        projectRoleAuthorityDetailModel.authorityId 必填项 （权限详情中权限类型）
     * @return
     */
    @RequestMapping("insertModel")
    public ProjectRoleAuthorityDetailModel insertModel(@RequestBody ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel){
        return this.projectRoleAuthorityDetailService.insertModel(projectRoleAuthorityDetailModel);
    }

    /**
     * @param projectRoleAuthorityDetailModel
     *        projectRoleAuthorityDetailModel.id 必填项 （权限详情中主键）
     *        projectRoleAuthorityDetailModel.name 选填 （权限详情中权限名称）
     *        projectRoleAuthorityDetailModel.signatures 选填 （权限详情中权限特征码）
     * @return
     */
    @RequestMapping("updateModel")
    public ProjectRoleAuthorityDetailModel updateModel(@RequestBody ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel){
        return this.projectRoleAuthorityDetailService.updateModel(projectRoleAuthorityDetailModel);
    }

    /**
     * @param projectRoleAuthorityDetailModel
     *        projectRoleAuthorityDetailModel.authorityId 必填项 （权限详情中权限类型为必填项）
     * @return
     */
    @RequestMapping("deleteModel")
    public ProjectRoleAuthorityDetailModel deleteModel(@RequestBody ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel){
        return this.projectRoleAuthorityDetailService.deleteModel(projectRoleAuthorityDetailModel);
    }

    /**
     * 更新项目类型数据的位置
     * @param projectRoleAuthorityDetailPojo
     *        projectRoleAuthorityDetailPojo.ids 为必填项 （两个参数的集合）
     * @return projectRoleAuthorityPojo
     */
    @RequestMapping("exchangeAuthorityDetailPosition")
    public ProjectRoleAuthorityDetailPojo exchangeAuthorityPosition(@RequestBody ProjectRoleAuthorityDetailPojo projectRoleAuthorityDetailPojo){
        return this.projectRoleAuthorityDetailService.exchangeAuthorityPosition(projectRoleAuthorityDetailPojo);
    }


    /**
     * 通过当前项目查询该项目下的用户权限
     * @param projectModel
     *        projectModel.id 必填项 （项目id）
     * @return
     */
    @RequestMapping("selectUserPriorityByProjectId")
    public Map<String, Integer> selectUserPriorityByProjectId(@RequestBody ProjectModel projectModel){
        return this.projectRoleAuthorityDetailService.selectUserPriorityByProjectId(projectModel, UserUtil.getUserId());
    }

    /**
     * 查询角色权限操作类型
     * @return
     */
    @RequestMapping("selectRoleAuthorityActionTypes")
    public List<Map<String, Object>> selectRoleAuthorityActionTypes(){
        return ProjectRoleAuthorityActionTypeEnum.getProjectRoleAuthorityActionTypes();
    }

}
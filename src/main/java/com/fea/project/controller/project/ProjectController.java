package com.fea.project.controller.project;

import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.vo.ProjectApplyVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.pojo.ProjectAttentionPojo;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectPriorityVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.model.project.vo.UserManageInfoVo;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.service.project.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2019/09/23.
 * 项目信息表 Controller
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);


    @Autowired
    private ProjectService projectService;

    /**
     * 获取创建或是更新的数据字典数据
     * @return
     */
    @RequestMapping("selectCreateOrUpdateBaseInfo")
    public Map<String, Object> selectCreateOrUpdateBaseInfo() {
        return this.projectService.selectCreateOrUpdateBaseInfo();
    }


    @RequestMapping("selectAreaAndIndustry")
    public Map<String, Object> selectAreaAndIndustry() {
        return this.projectService.selectAreaAndIndustry();
    }

    /**
     * 查询关联业务数据
     * @param model
     * @return
     */
    @RequestMapping("selectAssociatedBusiness")
    public Object selectAssociatedBusiness(@RequestBody ProjectModel model) {
        return this.projectService.selectAssociatedBusiness(model);
    }

    /**
     * 通过组织查询客户信息
     * @return
     */
    @RequestMapping("selectUsersByRegId")
    public Object selectUsersByRegId() {
        return this.projectService.selectUsersByRegId();
    }

    /**
     * 查询项目信息
     * @param pageInfo
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/projectManage")
    public BasePageInfo<ProjectVo> listByParam(@RequestBody BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        return this.projectService.listByParam(pageInfo);
    }

    /**
     * 新增项目
     *
     * @param projectModel
     * @return
     */
    @RequestMapping("insertModel")
    @PermissionAnno("/projectManage/projectManage/insertProject")
    public ProjectModel insertModel(@RequestBody ProjectModel projectModel) throws Exception {
        return this.projectService.insertModel(projectModel);
    }

    /**
     * 更新项目
     *
     * @param projectModel
     * @return
     */
    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/projectManage/updateProject")
    public ProjectModel updateModel(@RequestBody ProjectModel projectModel) {
        return this.projectService.updateModel(projectModel);
    }

    /**
     * 删除项目
     *
     * @param projectModel
     * @return
     */
    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/projectManage/deleteProject")
    public ProjectModel deleteModel(@RequestBody ProjectModel projectModel) {
        return this.projectService.deleteModel(projectModel);
    }

    /**
     * 关注项目
     *
     * @param model
     * @return
     */
    @RequestMapping("payAttentionModel")
    @PermissionAnno("/projectManage/projectManage/attentionAction")
    public ProjectAttentionPojo payAttentionModel(@RequestBody ProjectAttentionPojo model) {
        return this.projectService.payAttentionModel(model);
    }

    @RequestMapping("selectOne")
    public ProjectVo selectOne(@RequestBody ProjectModel projectModel) throws Exception {
        return this.projectService.selectOne(projectModel, false);
    }

    @RequestMapping("selectCurrentProjectUsers")
    public List<SysUserVo> selectCurrentProjectUsers() {
        return this.projectService.selectCurrentProjectUsers();
    }

    @RequestMapping("selectCurrentProjectDept")
    public List<TeamPersonSelectVo> selectCurrentProjectDept() {
        return this.projectService.selectCurrentProjectDept();
    }

    @RequestMapping("updateProjectContent")
    public ProjectModel updateProjectContent(@RequestBody ProjectModel model) {
        return this.projectService.updateProjectContent(model);
    }

    /**
     * 提交审核
     * @param projectModel
     * @return
     */
    @RequestMapping("submitToVerify")
    public ProjectModel submitToVerify(@RequestBody ProjectModel projectModel) {
        return this.projectService.submitToVerify(projectModel);
    }


    @RequestMapping("queryProjectPriority")
    public ProjectPriorityVo queryProjectPriority(@RequestBody ProjectModel projectModel) {
        return this.projectService.queryProjectPriority(projectModel);
    }


    @RequestMapping("queryManageUserInfo")
    public UserManageInfoVo queryManageUserInfo() {
        return this.projectService.queryManageUserInfo();
    }

    @RequestMapping("queryCurrentSelectChargeList")
    public BasePageInfo<ProjectVo> queryCurrentSelectChargeList(@RequestBody BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        return this.projectService.queryCurrentSelectChargeList(pageInfo);
    }

    @RequestMapping("selectVerifyStatus")
    public ProjectApplyVo selectVerifyStatus(@RequestBody ProjectModel model){
        return this.projectService.selectVerifyStatus(model, ProjectFlowTypeEnum.getProjectFlowTypes());
    }

}
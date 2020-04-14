package com.fea.project.controller.establishproject.project;

import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.vo.ProjectApplyVo;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectStartModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishProjectPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.pojo.ProjectAttentionPojo;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.service.establishproject.project.ProjectEstablishProjectService;
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
 * Created by Administrator on 2019/12/23.
 */
@RestController
@RequestMapping("projectEstablishProject")
public class ProjectEstablishProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectEstablishProjectController.class);


    @Autowired
    private ProjectEstablishProjectService projectEstablishProjectService;

    /**
     * 获取创建或是更新的数据字典数据
     * @return
     */
    @RequestMapping("selectCreateOrUpdateBaseInfo")
    public Map<String, Object> selectCreateOrUpdateBaseInfo() {
        return this.projectEstablishProjectService.selectCreateOrUpdateBaseInfo();
    }

    /**
     * 查询关联业务数据
     * @param model
     * @return
     */
    @RequestMapping("selectAssociatedBusiness")
    public Object selectAssociatedBusiness(@RequestBody ProjectEstablishProjectPojo model) {
        return this.projectEstablishProjectService.selectAssociatedBusiness(model);
    }

    /**
     * 查询产品类型
     * @return
     */
    @RequestMapping("selectProductTypes")
    public Object selectProductTypes() {
        return this.projectEstablishProjectService.selectProductTypes();
    }

    /**
     * 通过组织查询客户信息
     * @return
     */
    @RequestMapping("selectUsersByRegId")
    public Object selectUsersByRegId() {
        return this.projectEstablishProjectService.selectUsersByRegId();
    }

    /**
     * 查询项目信息
     * @param pageInfo
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @RequestMapping("listByParam")
    @PermissionAnno("/projectManage/establishProject")
    public BasePageInfo<ProjectEstablishVo> listByParam(@RequestBody BasePageInfo<ProjectEstablishProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        return this.projectEstablishProjectService.listByParam(pageInfo);
    }

    /**
     * 新增项目
     *
     * @param model
     * @return
     */
    @RequestMapping("insertModel")
    @PermissionAnno("/projectManage/establishProject/insertProject")
    public ProjectEstablishProjectPojo insertModel(@RequestBody ProjectEstablishProjectPojo model) throws Exception {
        return this.projectEstablishProjectService.insertModel(model);
    }

    /**
     * 更新项目
     *
     * @param model
     * @return
     */
    @RequestMapping("updateModel")
    @PermissionAnno("/projectManage/establishProject/updateProject")
    public ProjectEstablishProjectPojo updateModel(@RequestBody ProjectEstablishProjectPojo model) {
        return this.projectEstablishProjectService.updateModel(model);
    }

    /**
     * 删除项目
     *
     * @param projectModel
     * @return
     */
    @RequestMapping("deleteModel")
    @PermissionAnno("/projectManage/establishProject/deleteProject")
    public ProjectEstablishProjectPojo deleteModel(@RequestBody ProjectEstablishProjectPojo projectModel) {
        return this.projectEstablishProjectService.deleteModel(projectModel);
    }

    /**
     * 关注项目
     *
     * @param model
     * @return
     */
    @RequestMapping("payAttentionModel")
    @PermissionAnno("/projectManage/establishProject/attentionAction")
    public ProjectAttentionPojo payAttentionModel(@RequestBody ProjectAttentionPojo model) {
        return this.projectEstablishProjectService.payAttentionModel(model);
    }

    @RequestMapping("selectOne")
    public ProjectEstablishVo selectOne(@RequestBody ProjectModel projectModel) throws Exception {
        return this.projectEstablishProjectService.selectOne(projectModel);
    }

    @RequestMapping("selectCurrentProjectUsers")
    public List<SysUserVo> selectCurrentProjectUsers() {
        return this.projectEstablishProjectService.selectCurrentProjectUsers();
    }

    @RequestMapping("selectCurrentProjectDept")
    public List<TeamPersonSelectVo> selectCurrentProjectDept() {
        return this.projectEstablishProjectService.selectCurrentProjectDept();
    }

    @RequestMapping("updateProjectContent")
    public ProjectEstablishProjectPojo updateProjectContent(@RequestBody ProjectEstablishProjectPojo model) {
        return this.projectEstablishProjectService.updateProjectContent(model);
    }

    /**
     * 提交审核
     * @param model
     * @return
     */
    @RequestMapping("submitToVerify")
    @PermissionAnno("/projectManage/establishProject/submitProject")
    public ProjectEstablishProjectModel submitToVerify(@RequestBody ProjectEstablishProjectModel model) {
        return this.projectEstablishProjectService.submitToVerify(model);
    }

    /**
     * 启动项目
     * @param model
     * @return
     */
    @RequestMapping("startEstablishProject")
    @PermissionAnno("/projectManage/establishProject/startProject")
    public ProjectEstablishProjectStartModel startEstablishProject(@RequestBody ProjectEstablishProjectStartModel model) {
        return this.projectEstablishProjectService.startEstablishProject(model);
    }

    @RequestMapping("selectVerifyStatus")
    public ProjectApplyVo selectVerifyStatus(@RequestBody ProjectModel model){
        return this.projectEstablishProjectService.selectVerifyStatus(model, ProjectFlowTypeEnum.getEstablishProjectFlowTypes());
    }

}
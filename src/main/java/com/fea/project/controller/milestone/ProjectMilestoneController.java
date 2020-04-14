package com.fea.project.controller.milestone;


import com.fea.project.model.BasePageInfo;
import com.fea.project.model.config.ProjectConfigMilestoneModel;
import com.fea.project.model.milestone.ProjectMilestoneModel;
import com.fea.project.model.milestone.ProjectMilestoneVerifyModel;
import com.fea.project.model.milestone.vo.MilestoneRelateVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneInsertVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneVo;
import com.fea.project.model.milestone.vo.ProjectStepShowVo;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.service.config.ProjectConfigMilestoneService;
import com.fea.project.service.milestone.ProjectMilestoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2019/10/19
 * 项目里程碑 Controller
 */
@RestController
@RequestMapping("projectMilestone")
public class ProjectMilestoneController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMilestoneController.class);

    @Autowired
    private ProjectMilestoneService projectMilestoneService;
    @Autowired
    private ProjectConfigMilestoneService projectConfigMilestoneService;

    /**@RequestMapping("new")*/
    @ResponseBody
    public ProjectMilestoneModel newProjectMilestone(@RequestBody ProjectMilestoneModel model) throws Exception{
        ProjectMilestoneModel projectMilestoneModel = this.projectMilestoneService.newProjectMilestone(model);
        return projectMilestoneModel;
    }
    /**
     * 新增数据
     */
    @RequestMapping("insert")
    @ResponseBody
    public ProjectMilestoneInsertVo<ProjectMilestoneModel> insert(@RequestBody ProjectMilestoneInsertVo<ProjectMilestoneModel> model) throws Exception{
        if (this.projectMilestoneService.insertMilestone(model)) {
            return model;
        }
        return null;
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public ProjectMilestoneVo showInfo(@RequestBody ProjectMilestoneModel model) {

        return this.projectMilestoneService.getProjectMilestoneModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("edit")
    @ResponseBody
    public ProjectMilestoneModel update(@RequestBody ProjectMilestoneInsertVo<ProjectMilestoneModel> modelVo) {
        if (this.projectMilestoneService.updateById(modelVo)) {
            return modelVo.getModel();
        }
        return null;
    }

    @RequestMapping("getList")
    @ResponseBody
    public BasePageInfo<ProjectMilestoneVo> getList(@RequestBody BasePageInfo<ProjectMilestoneVo> model) {
        BasePageInfo<ProjectMilestoneVo> projectMilestone = projectMilestoneService.selectByFilterAndParams(model);
        return projectMilestone;
    }
    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    @ResponseBody
    public ProjectMilestoneModel deleteById(@RequestBody ProjectMilestoneModel model) {
        if (this.projectMilestoneService.deleteById(model)) {
            return model;
        }
        return null;
    }
    /**
     * 确认完成
     */
    @RequestMapping("finish")
    @ResponseBody
    public ProjectMilestoneModel finish(@RequestBody ProjectMilestoneModel model) {
        if (this.projectMilestoneService.finishById(model)) {
            return model;
        }
        return null;
    }
    /**
     * 获取里程碑类型列表
     */
    @RequestMapping("getMilestoneType")
    @ResponseBody
    public List<Map<String, Object>> getMilestoneType(@RequestBody ProjectConfigMilestoneModel model) {
        List<Map<String, Object>> typeList = projectConfigMilestoneService.selectTypeListByModel(model);
        return typeList;
    }
    /**
     * 获取里程碑视图
     */
    @RequestMapping("getMilestoneTypeAndCount")
    @ResponseBody
    public List<Map<String, Object>> getMilestoneTypeAndCount(@RequestBody ProjectMilestoneModel model) {
        List<Map<String, Object>> typeList = projectMilestoneService.milestoneTypeAndCountList(model);
        return typeList;
    }
    /**
     * 获取项目阶段，新增时用
     */
    @RequestMapping("projectStepByProjectId")
    @ResponseBody
    public List<Map<String, Object>> projectStepByProjectId(@RequestBody ProjectStepModel model) {
        List<Map<String, Object>> typeList = projectMilestoneService.projectStepByProjectId(model);
        return typeList;
    }
    /**
     * 获取项目阶段，展示面板用
     *
     */
    @RequestMapping("projectStepListByProjectId")
    @ResponseBody
    public List<ProjectStepShowVo> projectStepListByProjectId(@RequestBody ProjectStepModel model) {
        List<ProjectStepShowVo> typeList = projectMilestoneService.projectStepListByProjectId(model);
        return typeList;
    }
    /**
     * 获取项目阶段详情，展示面板用
     *
     */
    @RequestMapping("projectStepDetail")
    @ResponseBody
    public ProjectStepShowVo projectStepDetailByProjectId(@RequestBody ProjectStepModel model) {
        ProjectStepShowVo vo = projectMilestoneService.getStepDetail(model);
        return vo;
    }
    /**
     * 获取项目里程碑
     *
     */
    @RequestMapping("getMilestoneList")
    @ResponseBody
    public BasePageInfo<ProjectMilestoneVo> getMilestoneList(@RequestBody BasePageInfo<ProjectMilestoneVo> model) {
        BasePageInfo<ProjectMilestoneVo> projectMilestone = projectMilestoneService.selectByProjectId(model);
        return projectMilestone;
    }
    /**
     * 获取里程碑关联计划
     *
     */
    @RequestMapping("getMilestonePlanList")
    @ResponseBody
    public List<MilestoneRelateVo> getMilestonePlanList(@RequestBody ProjectMilestoneVo model) {
        List<MilestoneRelateVo> planModelVos = projectMilestoneService.selectPlanModelByMilestoneId(model.getId());
        return planModelVos;
    }
    /**
     * 获取里程碑关联任务
     *
     */
    @RequestMapping("getMilestoneTaskList")
    @ResponseBody
    public List<MilestoneRelateVo> getMilestoneTaskList(@RequestBody ProjectMilestoneVo model) {
        List<MilestoneRelateVo> planModelVos = projectMilestoneService.selectTaskModelByMilestoneId(model.getId());
        return planModelVos;
    }
    /**
     * 里程碑提交审批流程
     *
     */
    @RequestMapping("verifyMilestone")
    @ResponseBody
    public ProjectMilestoneVerifyModel verifyMilestone(@RequestBody ProjectMilestoneVerifyModel model) {
        ProjectMilestoneVerifyModel milestone = projectMilestoneService.verifyMilestone(model);
        return milestone;
    }

    /**
     * 里程碑变更
     */
    @RequestMapping("changeMilestone")
    @ResponseBody
    public List<ProjectMilestoneVo> changeMilestone(@RequestBody ProjectMilestoneModel model) {
        List<ProjectMilestoneVo> projectMilestoneModel = projectMilestoneService.changeMilestone(model);
        return projectMilestoneModel;
    }
    @RequestMapping("verifyMilestoneChange")
    @ResponseBody
    public ProjectMilestoneVerifyModel verifyMilestoneChange(@RequestBody ProjectMilestoneVerifyModel model) {
        ProjectMilestoneVerifyModel milestone = projectMilestoneService.verifyMilestoneChange(model);
        return milestone;
    }

    @RequestMapping("getProjectMilestoneInfo")
    @ResponseBody
    public ProjectMilestoneVerifyModel getProjectMilestoneInfo(@RequestBody ProjectMilestoneVerifyModel model) {
       return projectMilestoneService.getProjectMilestoneInfo(model);
    }
}
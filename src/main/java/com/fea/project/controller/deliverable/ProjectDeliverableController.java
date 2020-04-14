package com.fea.project.controller.deliverable;


import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.deliverable.ProjectDeliverableModel;
import com.fea.project.model.deliverable.vo.ProjectDeliverableInsertVo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import com.fea.project.model.projectdata.DataTeamVo;
import com.fea.project.model.task.vo.TaskAndSonTaskModelVo;
import com.fea.project.service.deliverable.ProjectDeliverableService;
import com.fea.project.service.task.ITaskService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/12/06
 */
@RestController
@RequestMapping("projectDeliverable")
public class ProjectDeliverableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDeliverableController.class);


    @Autowired
    private ProjectDeliverableService projectDeliverableService;
    @Autowired
    private ITaskService taskService;
    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectDeliverableVo insert(@RequestBody ProjectDeliverableInsertVo<ProjectDeliverableVo> model) {
        ProjectDeliverableVo deliverableVo = projectDeliverableService.addDeliverable(model);
        return deliverableVo;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("showList")
    public PageInfo<ProjectDeliverableVo> show(@RequestBody BasePageInfo<DataTeamVo> model) {
        PageInfo<ProjectDeliverableVo> deliverableList = projectDeliverableService.getDeliverableList(model);
        return deliverableList;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectDeliverableVo update(@RequestBody ProjectDeliverableInsertVo<ProjectDeliverableVo> model) {
        Boolean aBoolean = projectDeliverableService.editDeliverable(model);
        if (aBoolean){
            return model.getModel();
        }
        return null;
    }
    /**
     * 按主键更新
     */
    @RequestMapping("delete")
    public ProjectDeliverableVo delete(@RequestBody ProjectDeliverableVo model) {
        Boolean aBoolean = projectDeliverableService.deleteDeliverable(model);
        if (aBoolean){
            return model;
        }
        return null;
    }
    /**
     * 获取详情
     */
    @RequestMapping("getInfo")
    public ProjectDeliverableVo getDeliverableInfo(@RequestBody ProjectDeliverableVo model) {
        ProjectDeliverableVo deliverableInfo = projectDeliverableService.getDeliverableInfo(model);
        return deliverableInfo;
    }

    /**
     * 获取详情附件列表
     */
    @RequestMapping("getDeliverableAppendixList")
    public List<ProjectAppendixModel> getDeliverableAppendixList(@RequestBody ProjectDeliverableVo model) {
        List<ProjectAppendixModel> deliverableAppendixList = projectDeliverableService.getDeliverableAppendixList(model);
        return deliverableAppendixList;
    }

    /**
     * 获取项目交付要求
     */
    @RequestMapping("getProjectDeliverList")
    public BasePageInfo<ProjectDeliverClaimVo> getProjectDeliverList(@RequestBody BasePageInfo<ProjectDeliverClaimModel> model) {

        BasePageInfo<ProjectDeliverClaimVo> list = projectDeliverableService.getDeliveryListByProjectId(model);
        return list;
    }
    /**
     * 获取任务列表
     */
    @RequestMapping("getProjectTaskList")
    public BasePageInfo<TaskAndSonTaskModelVo> getProjectTaskList(@RequestBody BasePageInfo<TaskAndSonTaskModelVo> model) {
        BasePageInfo<TaskAndSonTaskModelVo> list = taskService.selectTaskListByProjectId(model);
        return list;
    }

    /**
     * 提交审核
     */
    @RequestMapping("verifyDeliverable")
    public ProjectDeliverableModel verifyDliverable(@RequestBody ProjectDeliverableModel model) {
        ProjectDeliverableModel deliverableVo = projectDeliverableService.verifyDeliverable(model);
        return deliverableVo;
    }

}
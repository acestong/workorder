package com.fea.project.controller.milestone;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliverableVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryInsertVo;
import com.fea.project.service.milestone.ProjectMilestoneDeliverableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/10/22.
 */
@RestController
@RequestMapping("projectMilestoneDeliverable")
public class ProjectMilestoneDeliverableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMilestoneDeliverableController.class);


    @Autowired
    private ProjectMilestoneDeliverableService projectMilestoneDeliverableService;
    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectMilestoneDeliverableModel insert(@RequestBody ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliverableModel> model) throws Exception{
        if (this.projectMilestoneDeliverableService.insertSelective(model)) {
            return model.getModel();
        }
        return null;
    }
    /**
     * 按模型选择
     */
    @RequestMapping("showList")
    public BasePageInfo<ProjectMilestoneDeliverableVo> show(@RequestBody BasePageInfo<ProjectMilestoneDeliverableModel> model) {
        //ProjectMilestoneDeliverableModel model = new ProjectMilestoneDeliverableModel();
        //根据传入里程碑id查询
        return this.projectMilestoneDeliverableService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectMilestoneDeliverableModel update(@RequestBody ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliverableModel> model) {
        if (this.projectMilestoneDeliverableService.update(model)) {
            return model.getModel();
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectMilestoneDeliverableModel delete(@RequestBody ProjectMilestoneDeliverableModel model) {
        if (this.projectMilestoneDeliverableService.deleteById(model)) {
            return model;
        }
        return null;
    }
    /**
     * 提交审核
     */
    @RequestMapping("verifyDeliverable")
    public ProjectMilestoneDeliverableModel verifyDeliverable(@RequestBody ProjectMilestoneDeliverableModel model) {
        ProjectMilestoneDeliverableModel deliverable = projectMilestoneDeliverableService.verifyMilestoneDeliverable(model);
        return deliverable;
    }
}
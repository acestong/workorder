package com.fea.project.controller.milestone;

import com.fea.project.model.milestone.ProjectMilestoneDeliveryModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryInsertVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryVo;
import com.fea.project.service.milestone.ProjectMilestoneDeliveryService;
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
 * @date 2019/10/21
 * 项目里程碑交付物 Controller
 */
@RestController
@RequestMapping("projectMilestoneDelivery")
public class ProjectMilestoneDeliveryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMilestoneDeliveryController.class);


    @Autowired
    private ProjectMilestoneDeliveryService projectMilestoneDeliveryService;

    /**
     * 按模型选择
     */
    @RequestMapping("showList")
    public List<ProjectMilestoneDeliveryVo> showList(@RequestBody ProjectMilestoneDeliveryModel model) {
        List<ProjectMilestoneDeliveryVo> projectMilestoneDeliveryVos = projectMilestoneDeliveryService.selectByMilestoneId(model.getMilestoneId());
        return projectMilestoneDeliveryVos;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliveryModel> insert(@RequestBody ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliveryModel> model) {
        if (this.projectMilestoneDeliveryService.insertSelective(model)) {
            return model;
        }
        return null;
    }

   /**
    * 按主键更新
    */
    @RequestMapping("update")
    public ProjectMilestoneDeliveryModel update(@RequestBody ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliveryModel> model) {
        if (this.projectMilestoneDeliveryService.update(model)) {
            return model.getModel();
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectMilestoneDeliveryModel delete(@RequestBody ProjectMilestoneDeliveryModel model) {
        if (this.projectMilestoneDeliveryService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
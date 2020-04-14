package com.fea.project.controller.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowListConditionModel;
import com.fea.project.service.businessflow.ProjectBusinessFlowListConditionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
@RestController
@RequestMapping("projectBusinessFlowListCondition")
public class ProjectBusinessFlowListConditionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessFlowListConditionController.class);


    @Autowired
    private ProjectBusinessFlowListConditionService projectBusinessFlowListConditionService;

    /**
     * 跳转页面
     */
    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("projectbusinessflowlistcondition");
        return mv;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectBusinessFlowListConditionModel insert(@RequestBody ProjectBusinessFlowListConditionModel model) {
        if (this.projectBusinessFlowListConditionService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectBusinessFlowListConditionModel> show() {
        ProjectBusinessFlowListConditionModel model = new ProjectBusinessFlowListConditionModel();
        return this.projectBusinessFlowListConditionService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectBusinessFlowListConditionModel update(@RequestBody ProjectBusinessFlowListConditionModel model) {
        if (this.projectBusinessFlowListConditionService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectBusinessFlowListConditionModel delete(@RequestBody ProjectBusinessFlowListConditionModel model) {
        if (this.projectBusinessFlowListConditionService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
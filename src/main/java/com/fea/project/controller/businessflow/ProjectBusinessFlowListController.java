package com.fea.project.controller.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowListModel;
import com.fea.project.service.businessflow.ProjectBusinessFlowListService;
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
@RequestMapping("projectBusinessFlowList")
public class ProjectBusinessFlowListController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessFlowListController.class);


    @Autowired
    private ProjectBusinessFlowListService projectBusinessFlowListService;

    /**
     * 跳转页面
     */
    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("projectbusinessflowlist");
        return mv;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectBusinessFlowListModel insert(@RequestBody ProjectBusinessFlowListModel model) {
        if (this.projectBusinessFlowListService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectBusinessFlowListModel> show() {
        ProjectBusinessFlowListModel model = new ProjectBusinessFlowListModel();
        return this.projectBusinessFlowListService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectBusinessFlowListModel update(@RequestBody ProjectBusinessFlowListModel model) {
        if (this.projectBusinessFlowListService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectBusinessFlowListModel delete(@RequestBody ProjectBusinessFlowListModel model) {
        if (this.projectBusinessFlowListService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
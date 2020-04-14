package com.fea.project.controller.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowCopyerModel;
import com.fea.project.service.businessflow.ProjectBusinessFlowCopyerService;
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
@RequestMapping("projectBusinessFlowCopyer")
public class ProjectBusinessFlowCopyerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessFlowCopyerController.class);


    @Autowired
    private ProjectBusinessFlowCopyerService projectBusinessFlowCopyerService;

    /**
     * 跳转页面
     */
    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("projectbusinessflowcopyer");
        return mv;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectBusinessFlowCopyerModel insert(@RequestBody ProjectBusinessFlowCopyerModel model) {
        if (this.projectBusinessFlowCopyerService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectBusinessFlowCopyerModel> show() {
        ProjectBusinessFlowCopyerModel model = new ProjectBusinessFlowCopyerModel();
        return this.projectBusinessFlowCopyerService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectBusinessFlowCopyerModel update(@RequestBody ProjectBusinessFlowCopyerModel model) {
        if (this.projectBusinessFlowCopyerService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectBusinessFlowCopyerModel delete(@RequestBody ProjectBusinessFlowCopyerModel model) {
        if (this.projectBusinessFlowCopyerService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
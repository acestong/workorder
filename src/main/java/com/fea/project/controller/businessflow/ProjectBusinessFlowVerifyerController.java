package com.fea.project.controller.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.service.businessflow.ProjectBusinessFlowVerifyerService;
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
@RequestMapping("projectBusinessFLowVerifyer")
public class ProjectBusinessFlowVerifyerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBusinessFlowVerifyerController.class);


    @Autowired
    private ProjectBusinessFlowVerifyerService projectBusinessFLowVerifyerService;

    /**
     * 跳转页面
     */
    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("projectbusinessflowverifyer");
        return mv;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectBusinessFlowVerifyerModel insert(@RequestBody ProjectBusinessFlowVerifyerModel model) {
        if (this.projectBusinessFLowVerifyerService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectBusinessFlowVerifyerModel> show() {
        ProjectBusinessFlowVerifyerModel model = new ProjectBusinessFlowVerifyerModel();
        return this.projectBusinessFLowVerifyerService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectBusinessFlowVerifyerModel update(@RequestBody ProjectBusinessFlowVerifyerModel model) {
        if (this.projectBusinessFLowVerifyerService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectBusinessFlowVerifyerModel delete(@RequestBody ProjectBusinessFlowVerifyerModel model) {
        if (this.projectBusinessFLowVerifyerService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
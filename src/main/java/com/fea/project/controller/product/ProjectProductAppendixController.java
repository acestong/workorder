package com.fea.project.controller.product;


import com.fea.project.model.product.ProjectProductAppendixModel;
import java.util.List;

import com.fea.project.service.product.ProjectProductAppendixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/03/23.
 */
@RestController
@RequestMapping("projectProductAppendix")
public class ProjectProductAppendixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductAppendixController.class);


    @Autowired
    private ProjectProductAppendixService projectProductAppendixService;

    /**
     * 新增产品详情页面附件附件
     */
    @RequestMapping("insert")
    public ProjectProductAppendixModel insert(@RequestBody ProjectProductAppendixModel model) {
        model.setBusinessName("产品详情");
        if (this.projectProductAppendixService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 新增产规格附件
     */
    @RequestMapping("addSpecificAppendix")
    public ProjectProductAppendixModel addSpecificAppendix(@RequestBody ProjectProductAppendixModel model) {
        if (this.projectProductAppendixService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectProductAppendixModel> show() {
        ProjectProductAppendixModel model = new ProjectProductAppendixModel();
        return this.projectProductAppendixService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectProductAppendixModel update(@RequestBody ProjectProductAppendixModel model) {
        if (this.projectProductAppendixService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectProductAppendixModel delete(@RequestBody ProjectProductAppendixModel model) {
        if (this.projectProductAppendixService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
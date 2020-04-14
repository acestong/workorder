package com.fea.project.controller.product;


import com.fea.project.model.product.ProjectProductModel;
import java.util.List;

import com.fea.project.service.product.ProjectProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/03/19.
 */
@RestController
@RequestMapping("projectProduct")
public class ProjectProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductController.class);


    @Autowired
    private ProjectProductService projectProductService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectProductModel insert(@RequestBody ProjectProductModel model) {
        if (this.projectProductService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectProductModel> show() {
        ProjectProductModel model = new ProjectProductModel();
        return this.projectProductService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectProductModel update(@RequestBody ProjectProductModel model) {
        if (this.projectProductService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectProductModel delete(@RequestBody ProjectProductModel model) {
        if (this.projectProductService.deleteById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 产品详情
     */
    @RequestMapping("detail")
    public ProjectProductModel detail(@RequestBody ProjectProductModel model) {
        ProjectProductModel detail = projectProductService.detail(model);
        return detail;
    }
}
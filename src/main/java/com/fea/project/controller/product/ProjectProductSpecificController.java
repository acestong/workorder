package com.fea.project.controller.product;

import com.fea.project.model.product.ProjectProductSpecificModel;
import java.util.List;

import com.fea.project.service.product.ProjectProductSpecificService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/03/20.
 */
@RestController
@RequestMapping("projectProductSpecific")
public class ProjectProductSpecificController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductSpecificController.class);


    @Autowired
    private ProjectProductSpecificService projectProductSpecificService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectProductSpecificModel insert(@RequestBody ProjectProductSpecificModel model) {
        if (this.projectProductSpecificService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectProductSpecificModel> show() {
        ProjectProductSpecificModel model = new ProjectProductSpecificModel();
        return this.projectProductSpecificService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectProductSpecificModel update(@RequestBody ProjectProductSpecificModel model) {
        if (this.projectProductSpecificService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectProductSpecificModel delete(@RequestBody ProjectProductSpecificModel model) {
        if (this.projectProductSpecificService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
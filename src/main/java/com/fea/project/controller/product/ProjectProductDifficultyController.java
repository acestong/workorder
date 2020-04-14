package com.fea.project.controller.product;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.product.ProjectProductDifficultyModel;
import java.util.List;

import com.fea.project.service.product.ProjectProductDifficultyService;
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
@RequestMapping("projectProductDifficulty")
public class ProjectProductDifficultyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductDifficultyController.class);


    @Autowired
    private ProjectProductDifficultyService projectProductDifficultyService;


    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectProductDifficultyModel insert(@RequestBody ProjectProductDifficultyModel model) {
        if (this.projectProductDifficultyService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 列表
     */
    @RequestMapping("show")
    public BasePageInfo<ProjectProductDifficultyModel> show(@RequestBody BasePageInfo<ProjectProductDifficultyModel> model) {
        BasePageInfo<ProjectProductDifficultyModel> basePageInfo = projectProductDifficultyService.selectByFilterAndOrderParams(model);
        return basePageInfo;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectProductDifficultyModel update(@RequestBody ProjectProductDifficultyModel model) {
        if (this.projectProductDifficultyService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectProductDifficultyModel delete(@RequestBody ProjectProductDifficultyModel model) {
        if (this.projectProductDifficultyService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
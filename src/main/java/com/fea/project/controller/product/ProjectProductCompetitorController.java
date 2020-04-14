package com.fea.project.controller.product;


import com.fea.project.model.BasePageInfo;
import com.fea.project.model.product.ProjectProductCompetitorModel;
import java.util.List;

import com.fea.project.service.product.ProjectProductCompetitorService;
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
@RequestMapping("projectProductCompetitor")
public class ProjectProductCompetitorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductCompetitorController.class);


    @Autowired
    private ProjectProductCompetitorService projectProductCompetitorService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectProductCompetitorModel insert(@RequestBody ProjectProductCompetitorModel model) {
        if (this.projectProductCompetitorService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public BasePageInfo<ProjectProductCompetitorModel> show(@RequestBody BasePageInfo<ProjectProductCompetitorModel> model) {
        BasePageInfo<ProjectProductCompetitorModel> basePageInfo = projectProductCompetitorService.selectByFilterAndOrderParams(model);
        return basePageInfo;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectProductCompetitorModel update(@RequestBody ProjectProductCompetitorModel model) {
        if (this.projectProductCompetitorService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectProductCompetitorModel delete(@RequestBody ProjectProductCompetitorModel model) {
        if (this.projectProductCompetitorService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
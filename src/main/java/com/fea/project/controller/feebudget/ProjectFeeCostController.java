package com.fea.project.controller.feebudget;


import com.fea.project.model.feebudget.ProjectFeeCostModel;
import com.fea.project.service.feebudget.ProjectFeeCostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/16.
 */
@RestController
@RequestMapping("projectFeeCost")
public class ProjectFeeCostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFeeCostController.class);


    @Autowired
    private ProjectFeeCostService projectFeeCostService;

    /**
     * 新增物料成本/其他成本
     */
    @RequestMapping("insert")
    public ProjectFeeCostModel insert(@RequestBody ProjectFeeCostModel model) {
        if (this.projectFeeCostService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 物料成本列表
     */
    @RequestMapping("materialCostList")
    public List<ProjectFeeCostModel> materialCostList(@RequestBody ProjectFeeCostModel model) {
        return this.projectFeeCostService.materialCostList(model);
    }

    /**
     * 其他成本列表
     */
    @RequestMapping("otherCostlList")
    public List<ProjectFeeCostModel> otherCostlList(@RequestBody ProjectFeeCostModel model) {
        return this.projectFeeCostService.otherCostlList(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectFeeCostModel update(@RequestBody ProjectFeeCostModel model) {
        if (this.projectFeeCostService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectFeeCostModel delete(@RequestBody ProjectFeeCostModel model) {
        if (this.projectFeeCostService.deleterojectFeeCost(model)) {
            return model;
        }
        return null;
    }
}
package com.fea.project.controller.risk;


import com.fea.project.model.risk.ProjectRiskAssessPlanModel;
import com.fea.project.service.risk.ProjectRiskAssessPlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@RestController
@RequestMapping("projectRiskAssessPlan")
public class ProjectRiskAssessPlanController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRiskAssessPlanController.class);


    @Autowired
    private ProjectRiskAssessPlanService projectRiskAssessPlanService;

    /**
     * 按模型选择
     */
    @RequestMapping("list")
    public List<ProjectRiskAssessPlanModel> list(@RequestBody ProjectRiskAssessPlanModel model) {
        return this.projectRiskAssessPlanService.selectByModel(model);
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectRiskAssessPlanModel delete(@RequestBody ProjectRiskAssessPlanModel model) {
        if (this.projectRiskAssessPlanService.deleteProjectRiskAssessPlan(model)) {
            return model;
        }
        return null;
    }
    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectRiskAssessPlanModel update(@RequestBody ProjectRiskAssessPlanModel model) {
        if (this.projectRiskAssessPlanService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 跳转页面
     */
    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("projectriskassessplan");
        return mv;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectRiskAssessPlanModel insert(@RequestBody ProjectRiskAssessPlanModel model) {
        if (this.projectRiskAssessPlanService.insert(model)) {
            return model;
        }
        return null;
    }


}
package com.fea.project.controller.risk;


import com.fea.project.model.BasePageInfo;
import com.fea.project.model.risk.ProjectRiskAppendixModel;
import com.fea.project.model.risk.ProjectRiskAssessModel;
import com.fea.project.service.risk.ProjectRiskAppendixService;
import com.fea.project.service.risk.ProjectRiskAssessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/12/03.
 */
@RestController
@RequestMapping("projectRiskAssess")
public class ProjectRiskAssessController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRiskAssessController.class);


    @Autowired
    private ProjectRiskAssessService projectRiskAssessService;
    @Autowired
    private ProjectRiskAppendixService projectRiskAppendixService;

    /**
     * 新建项目风险评估
     */
    @RequestMapping("insert")
    public ProjectRiskAssessModel insert(@RequestBody ProjectRiskAssessModel model) {
        ProjectRiskAssessModel riskAssessModel = projectRiskAssessService.addProjectRiskAssess(model);
        return riskAssessModel;
    }
    /**
     * 新建项目风险评估提交
     */
    @RequestMapping("insertSubmit")
    public ProjectRiskAssessModel insertSubmit(@RequestBody ProjectRiskAssessModel model) {
        if (this.projectRiskAssessService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 分页查询项目风险评估列表
     */
    @RequestMapping("list")
    public BasePageInfo<ProjectRiskAssessModel> list(@RequestBody BasePageInfo<ProjectRiskAssessModel> model) {
        BasePageInfo<ProjectRiskAssessModel> pageInfo = projectRiskAssessService.selectByFilterAndOrderParams(model);
        return pageInfo;
    }

    /**
     *新增风险评估附件
     */
    @RequestMapping("/addAppendix")
    public ProjectRiskAppendixModel addPlanAppendix(@RequestBody ProjectRiskAppendixModel model){
        model.setBusinessName("风险评估内容");
        projectRiskAppendixService.insertSelective(model);
        return model;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("detail")
    public ProjectRiskAssessModel detail(@RequestBody ProjectRiskAssessModel model) {
        ProjectRiskAssessModel projectRiskAssessModel = projectRiskAssessService.selectById(model);
        return projectRiskAssessModel;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectRiskAssessModel update(@RequestBody ProjectRiskAssessModel model) {
        if (this.projectRiskAssessService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectRiskAssessModel delete(@RequestBody ProjectRiskAssessModel model) {
        if (this.projectRiskAssessService.deleteById(model.getId())) {
            return model;
        }
        return null;
    }

    /**
     * 项目风险评估提交审批
     */
    @RequestMapping("check")
    public ProjectRiskAssessModel check(@RequestBody ProjectRiskAssessModel model) {
        if (this.projectRiskAssessService.updateById(model)) {
            return model;
        }
        return null;
    }
}
package com.fea.project.controller.risk;


import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.risk.ProjectRiskAppendixModel;
import com.fea.project.model.risk.ProjectRiskModel;
import com.fea.project.model.risk.vo.ProjectRiskVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.risk.ProjectRiskAppendixService;
import com.fea.project.service.risk.ProjectRiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@RestController
@RequestMapping("projectRisk")
public class ProjectRiskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRiskController.class);


    @Autowired
    private ProjectRiskService projectRiskService;
    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;
    @Autowired
    private ProjectRiskAppendixService projectRiskAppendixService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增项目风险
     */
    @RequestMapping("insert")
    public ProjectRiskModel insert(@RequestBody ProjectRiskModel model) {
        boolean b = projectRiskService.insertSelective(model);
        return model;
    }

    /**
     * 分页查询项目风险列表
     */
    @RequestMapping("show")
    public BasePageInfo<ProjectRiskModel> show(@RequestBody BasePageInfo<ProjectRiskModel> model) {
        BasePageInfo<ProjectRiskModel> projectRiskModelBasePageInfo = projectRiskService.selectByFilterAndOrderParams(model);
        return projectRiskModelBasePageInfo;
    }

    /**
     * 项目风险详情
     */
    @RequestMapping("detail")
    public ProjectRiskModel detail(@RequestBody ProjectRiskModel model) {
        ProjectRiskModel projectRiskModel = projectRiskService.selectById(model);
        return projectRiskModel;
    }


    /**
     * 编辑项目风险
     */
    @RequestMapping("update")
    public ProjectRiskModel update(@RequestBody ProjectRiskModel model) {
        if (this.projectRiskService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 风险预警
     */
    @RequestMapping("warning")
    public List<ProjectRiskVo> warning(@RequestBody ProjectRiskModel model) {
        List<ProjectRiskVo> projectRiskVos = projectRiskService.selectByModel(model);
        return projectRiskVos;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectRiskModel delete(@RequestBody ProjectRiskModel model) {
        if (this.projectRiskService.deleteById(model)) {
            return model;
        }
        return null;
    }

    /**
     *获取风险类型数据字典
     */
    @RequestMapping("/getProjectRiskType")
    public List<ProjectDictionaryItemSelectVo> getProjectRiskType() throws Exception{
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectDictionaryModel projectDictionaryModel = new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RISK_TYPE.getValue(),
                currentUsr.getRegId());
        List<ProjectDictionaryItemSelectVo> vos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(projectDictionaryModel);
        return vos;
    }

    /**
     *新增风险应对措施附件
     */
    @RequestMapping("/addSolutionAppendix")
    public ProjectRiskAppendixModel addSolutionAppendix(@RequestBody ProjectRiskAppendixModel model){
        model.setBusinessName("应对措施");
        projectRiskAppendixService.insertSelective(model);
        return model;
    }

    /**
     *新增风险应急计划附件
     */
    @RequestMapping("/addPlanAppendix")
    public ProjectRiskAppendixModel addPlanAppendix(@RequestBody ProjectRiskAppendixModel model){
        model.setBusinessName("应急计划");
        projectRiskAppendixService.insertSelective(model);
        return model;
    }


    /**
     * 删除附件deleteById
     */
    @RequestMapping("/deleteAppendix")
    public ProjectRiskAppendixModel deleteAppendix(@RequestBody ProjectRiskAppendixModel model){
        boolean b = projectRiskAppendixService.deleteById(model);
        return model;
    }
}
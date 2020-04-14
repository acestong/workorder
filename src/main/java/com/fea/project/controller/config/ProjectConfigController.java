package com.fea.project.controller.config;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.config.pojo.ProjectConfigDetailPojo;
import com.fea.project.model.config.pojo.ProjectConfigPojo;
import com.fea.project.model.config.vo.ProjectConfigDetailVo;
import com.fea.project.model.flow.pojo.ProjectFlowPojo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.service.config.ProjectConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/08.
 */
@RestController
@RequestMapping("projectConfig")
public class ProjectConfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectConfigController.class);


    @Autowired
    private ProjectConfigService projectConfigService;


    /**
     * 查询设置详情
     */
    @RequestMapping("listByParam")
    public ProjectConfigDetailVo listByParam(@RequestBody ProjectConfigPojo model) throws Exception {
        return this.projectConfigService.listByParam(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateByProjectConfigModel")
    public ProjectConfigDetailPojo updateByProjectConfigModel(@RequestBody ProjectConfigDetailPojo model) throws Exception {
        return this.projectConfigService.updateByProjectConfigModel(model);
    }

    /**
     * 查询当前流程设置可选流程
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("selectProjectFlowByParam")
    public BasePageInfo<ProjectFlowVo> selectProjectFlowByParam(@RequestBody BasePageInfo<ProjectFlowPojo> model) {
        if (model == null || model.getModel() == null || model.getModel().getFlowType() == null || model.getModel().getProjectId() == null) {
            throw new SystemParamCheckException("传入的参数异常，无法查询该类型下的流程信息")
                    .appendAlaramMsg("flowType: " + model.getModel().getFlowType() + " projectId: " + model.getModel().getProjectId());
        }
        return this.projectConfigService.selectProjectFlowByParam(model);
    }

    /**
     * 查询当前流程设置可选操作符
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("selectActionCode")
    public List<Map<String, Object>> selectActionCode() {
        return this.projectConfigService.selectActionCode();
    }

    /**
     * 查询当前流程设置可选评价结果级别
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("selectProjectEstimateLevel")
    public List<ProjectDictionaryItemSelectVo> selectProjectEstimateLevel() {
        return this.projectConfigService.selectProjectEstimateLevel();
    }

}
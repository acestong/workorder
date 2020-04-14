package com.fea.project.controller.project;

import com.fea.project.model.project.ProjectViewSelfConfigModel;
import com.fea.project.service.project.ProjectViewSelfConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/28.
 */
@RestController
@RequestMapping("projectViewSelfConfig")
public class ProjectViewSelfConfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectViewSelfConfigController.class);


    @Autowired
    private ProjectViewSelfConfigService projectViewSelfConfigService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectViewSelfConfigModel insert(@RequestBody ProjectViewSelfConfigModel model) {
        if (this.projectViewSelfConfigService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectViewSelfConfigModel> show() {
        ProjectViewSelfConfigModel model = new ProjectViewSelfConfigModel();
        return this.projectViewSelfConfigService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectViewSelfConfigModel update(@RequestBody ProjectViewSelfConfigModel model) {
        if (this.projectViewSelfConfigService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectViewSelfConfigModel delete(@RequestBody ProjectViewSelfConfigModel model) {
        if (this.projectViewSelfConfigService.deleteById(model)) {
            return model;
        }
        return null;
    }

    @RequestMapping("queryProjectSelfConfigViewParam")
    public Map<Integer, Object> queryProjectSelfConfigViewParam() {
        return this.projectViewSelfConfigService.queryProjectSelfConfigViewParam();
    }
}
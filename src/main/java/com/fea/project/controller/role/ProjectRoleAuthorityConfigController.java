package com.fea.project.controller.role;

import com.fea.project.model.role.ProjectRoleAuthorityConfigModel;
import com.fea.project.service.role.ProjectRoleAuthorityConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
@RestController
@RequestMapping("projectRoleAuthorityConfig")
public class ProjectRoleAuthorityConfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRoleAuthorityConfigController.class);


    @Autowired
    private ProjectRoleAuthorityConfigService projectRoleAuthorityConfigService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectRoleAuthorityConfigModel insert(@RequestBody ProjectRoleAuthorityConfigModel model) {
        if (this.projectRoleAuthorityConfigService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectRoleAuthorityConfigModel> show() {
        ProjectRoleAuthorityConfigModel model = new ProjectRoleAuthorityConfigModel();
        return this.projectRoleAuthorityConfigService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectRoleAuthorityConfigModel update(@RequestBody ProjectRoleAuthorityConfigModel model) {
        if (this.projectRoleAuthorityConfigService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectRoleAuthorityConfigModel delete(@RequestBody ProjectRoleAuthorityConfigModel model) {
        if (this.projectRoleAuthorityConfigService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
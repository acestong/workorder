package com.fea.project.controller.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeShortNameModel;
import com.fea.project.service.baseconfig.ProjectCodeShortNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 */
@RestController
@RequestMapping("projectCodeShortName")
public class ProjectCodeShortNameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectCodeShortNameController.class);


    @Autowired
    private ProjectCodeShortNameService projectCodeShortNameService;


    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectCodeShortNameModel insert(@RequestBody ProjectCodeShortNameModel model) {
        if (this.projectCodeShortNameService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectCodeShortNameModel> show() {
        ProjectCodeShortNameModel model = new ProjectCodeShortNameModel();
        return this.projectCodeShortNameService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectCodeShortNameModel update(@RequestBody ProjectCodeShortNameModel model) {
        if (this.projectCodeShortNameService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectCodeShortNameModel delete(@RequestBody ProjectCodeShortNameModel model) {
        if (this.projectCodeShortNameService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
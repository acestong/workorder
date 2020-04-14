package com.fea.project.controller.appendix;

import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.service.appendix.ProjectAppendixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/10/25.
 * 附件表  Controller
 */
@RestController
@RequestMapping("projectAppendix")
public class ProjectAppendixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectAppendixController.class);


    @Autowired
    private ProjectAppendixService projectAppendixService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectAppendixModel insert(@RequestBody ProjectAppendixModel model) {
        if (this.projectAppendixService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("showList")
    public List<ProjectAppendixModel> show(@RequestBody ProjectAppendixModel model) {
        //ProjectAppendixModel model = new ProjectAppendixModel();
        return this.projectAppendixService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectAppendixModel update(@RequestBody ProjectAppendixModel model) {
        if (this.projectAppendixService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectAppendixModel delete(@RequestBody ProjectAppendixModel model) {
        if (this.projectAppendixService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
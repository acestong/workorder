package com.fea.project.controller.base;

import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.service.base.ProjectDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/09/25.
 */
@RestController
@RequestMapping("projectDictionary")
public class ProjectDictionaryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDictionaryController.class);


    @Autowired
    private ProjectDictionaryService projectDictionaryService;


    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectDictionaryModel insert(@RequestBody ProjectDictionaryModel model) {
        if (this.projectDictionaryService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listAll")
    public List<ProjectDictionaryModel> listAll() {
        return this.projectDictionaryService.listAll();
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectDictionaryModel update(@RequestBody ProjectDictionaryModel model) {
        if (this.projectDictionaryService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectDictionaryModel delete(@RequestBody ProjectDictionaryModel model) {
        if (this.projectDictionaryService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
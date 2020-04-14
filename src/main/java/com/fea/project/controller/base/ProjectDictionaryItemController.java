package com.fea.project.controller.base;

import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
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
@RequestMapping("projectDictionaryItem")
public class ProjectDictionaryItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDictionaryItemController.class);


    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectDictionaryItemModel insert(@RequestBody ProjectDictionaryItemModel model) {
        if (this.projectDictionaryItemService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("listByDicId")
    public List<ProjectDictionaryItemSelectVo> listByDicId(@RequestBody ProjectDictionaryModel model) {
        return this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectDictionaryItemModel update(@RequestBody ProjectDictionaryItemModel model) {
        if (this.projectDictionaryItemService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectDictionaryItemModel delete(@RequestBody ProjectDictionaryItemModel model) {
        if (this.projectDictionaryItemService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
package com.fea.project.controller.interflow;

import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import java.util.List;

import com.fea.project.service.interflow.ProjectInterflowContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@RestController
@RequestMapping("projectInterflowContacts")
public class ProjectInterflowContactsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowContactsController.class);


    @Autowired
    private ProjectInterflowContactsService projectInterflowContactsService;
    /**
     * 获取外部联系人列表
     */
    @RequestMapping("contactsList")
    public List<ProjectInterflowContactsModel> getContactsList(@RequestBody ProjectInterflowContactsModel model) {
        List<ProjectInterflowContactsModel> contactsModelList = this.projectInterflowContactsService.selectByModel(model);
        return contactsModelList;
    }
    /**
     * 插入数据
     */
    @RequestMapping("insertContacts")
    public ProjectInterflowContactsModel insert(@RequestBody ProjectInterflowContactsModel model) {
        ProjectInterflowContactsModel insert = this.projectInterflowContactsService.insert(model);
        return insert;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateContacts")
    public ProjectInterflowContactsModel update(@RequestBody ProjectInterflowContactsModel model) {
        if (this.projectInterflowContactsService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteContacts")
    public ProjectInterflowContactsModel delete(@RequestBody ProjectInterflowContactsModel model) {
        if (this.projectInterflowContactsService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
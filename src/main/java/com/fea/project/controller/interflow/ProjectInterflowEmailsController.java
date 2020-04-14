package com.fea.project.controller.interflow;


import com.fea.project.model.interflow.ProjectInterflowEmailsModel;
import java.util.List;

import com.fea.project.model.interflow.vo.InterflowCommonVo;
import com.fea.project.model.interflow.vo.ProjectInterflowEmailsModelVo;
import com.fea.project.service.interflow.ProjectInterflowEmailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/01/09.
 */
@RestController
@RequestMapping("projectInterflowEmails")
public class ProjectInterflowEmailsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowEmailsController.class);


    @Autowired
    private ProjectInterflowEmailsService projectInterflowEmailsService;

    /**
     * 插入数据
     */
    @RequestMapping("insertEmails")
    public InterflowCommonVo insert(@RequestBody InterflowCommonVo<ProjectInterflowEmailsModel> model) {
        InterflowCommonVo insert = this.projectInterflowEmailsService.insert(model);

        return insert;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("getEmailsInfo")
    public InterflowCommonVo<ProjectInterflowEmailsModelVo> getEmailsInfo(@RequestBody ProjectInterflowEmailsModel model) {
        InterflowCommonVo<ProjectInterflowEmailsModelVo> phoneModelVo = this.projectInterflowEmailsService.getPhoneModelVo(model);
        return phoneModelVo;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateEmails")
    public InterflowCommonVo update(@RequestBody InterflowCommonVo<ProjectInterflowEmailsModel> model) {
        InterflowCommonVo<ProjectInterflowEmailsModel> update = this.projectInterflowEmailsService.update(model);
        return update;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteEmails")
    public ProjectInterflowEmailsModel delete(@RequestBody ProjectInterflowEmailsModel model) {
        if (this.projectInterflowEmailsService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
package com.fea.project.controller.interflow;

import com.fea.project.model.interflow.ProjectInterflowMeetingAppendixModel;
import java.util.List;

import com.fea.project.service.interflow.ProjectInterflowMeetingAppendixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@RestController
@RequestMapping("projectInterflowMeetingAppendix")
public class ProjectInterflowMeetingAppendixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowMeetingAppendixController.class);


    @Autowired
    private ProjectInterflowMeetingAppendixService projectInterflowMeetingAppendixService;

    /**
     * 插入数据
     */
    @RequestMapping("insertMeetingAppendix")
    public ProjectInterflowMeetingAppendixModel insert(@RequestBody ProjectInterflowMeetingAppendixModel model) {
        if (this.projectInterflowMeetingAppendixService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateMeetingAppendix")
    public ProjectInterflowMeetingAppendixModel update(@RequestBody ProjectInterflowMeetingAppendixModel model) {
        if (this.projectInterflowMeetingAppendixService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteMeetingAppendix")
    public ProjectInterflowMeetingAppendixModel delete(@RequestBody ProjectInterflowMeetingAppendixModel model) {
        if (this.projectInterflowMeetingAppendixService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
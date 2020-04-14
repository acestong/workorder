package com.fea.project.controller.interflow;


import com.fea.project.model.interflow.ProjectInterflowMeetingModel;
import java.util.List;

import com.fea.project.model.interflow.vo.InterflowMeetingVo;
import com.fea.project.service.interflow.ProjectInterflowMeetingService;
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
@RequestMapping("projectInterflowMeeting")
public class ProjectInterflowMeetingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowMeetingController.class);


    @Autowired
    private ProjectInterflowMeetingService projectInterflowMeetingService;

    /**
     * 插入数据
     */
    @RequestMapping("insertMeeting")
    public InterflowMeetingVo insert(@RequestBody InterflowMeetingVo<ProjectInterflowMeetingModel> model) {
        if (this.projectInterflowMeetingService.insert(model)) {
            return model;
        }
        return null;
    }
    @RequestMapping("getMeetingInfo")
    public InterflowMeetingVo getMeetingInfo(@RequestBody ProjectInterflowMeetingModel model) {
        InterflowMeetingVo interflowMeetingVo = projectInterflowMeetingService.selectById(model);
        return interflowMeetingVo;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateMeeting")
    public InterflowMeetingVo update(@RequestBody InterflowMeetingVo<ProjectInterflowMeetingModel> model) {
        this.projectInterflowMeetingService.update(model);
        return model;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteMeeting")
    public ProjectInterflowMeetingModel delete(@RequestBody ProjectInterflowMeetingModel model) {

        if (this.projectInterflowMeetingService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
package com.fea.project.controller.interflow;


import com.fea.project.model.interflow.ProjectInterflowMeetingAgendaModel;
import java.util.List;

import com.fea.project.service.interflow.ProjectInterflowMeetingAgendaService;
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
@RequestMapping("projectInterflowMeetingAgenda")
public class ProjectInterflowMeetingAgendaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowMeetingAgendaController.class);


    @Autowired
    private ProjectInterflowMeetingAgendaService projectInterflowMeetingAgendaService;

    /**
     * 插入数据
     */
    @RequestMapping("insertAgenda")
    public ProjectInterflowMeetingAgendaModel insert(@RequestBody ProjectInterflowMeetingAgendaModel model) {
        if (this.projectInterflowMeetingAgendaService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("showAgenda")
    public List<ProjectInterflowMeetingAgendaModel> show() {
        ProjectInterflowMeetingAgendaModel model = new ProjectInterflowMeetingAgendaModel();
        return this.projectInterflowMeetingAgendaService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateAgenda")
    public ProjectInterflowMeetingAgendaModel update(@RequestBody ProjectInterflowMeetingAgendaModel model) {
        if (this.projectInterflowMeetingAgendaService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteAgenda")
    public ProjectInterflowMeetingAgendaModel delete(@RequestBody ProjectInterflowMeetingAgendaModel model) {
        if (this.projectInterflowMeetingAgendaService.deleteById(model)) {
            return model;
        }
        return null;
    }
}
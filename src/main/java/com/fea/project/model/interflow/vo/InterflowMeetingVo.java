package com.fea.project.model.interflow.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import com.fea.project.model.interflow.ProjectInterflowMeetingAgendaModel;
import com.fea.project.model.interflow.ProjectInterflowMeetingAppendixModel;
import com.fea.project.model.interflow.ProjectInterflowMeetingModel;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class InterflowMeetingVo<T> {

    private T meetingModel;

    private List<ProjectInterflowContactsModel> contactModels;

    private List<ProjectInterflowMeetingAgendaModel> agendaModels;

    private List<ProjectInterflowMeetingAppendixModel> meetingAppendixModels;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> appendixIds;

    public InterflowMeetingVo() {
    }

    public InterflowMeetingVo(T meetingModel, List<ProjectInterflowContactsModel> contactModels, List<ProjectInterflowMeetingAgendaModel> agendaModels, List<ProjectInterflowMeetingAppendixModel> meetingAppendixModels) {
        this.meetingModel = meetingModel;
        this.contactModels = contactModels;
        this.agendaModels = agendaModels;
        this.meetingAppendixModels = meetingAppendixModels;
    }
}

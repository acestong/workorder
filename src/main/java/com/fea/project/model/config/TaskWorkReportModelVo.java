package com.fea.project.model.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.task.TaskModel;
import lombok.Data;

import java.util.Date;

@Data
public class TaskWorkReportModelVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workReportId;

    private String workReportTitle;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
    
    private TaskModel taskModel;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workReporterId;
    
    private String workReporterName;

    private String workTaskContent; 

    private Date actualTaskStartTime;

    private Date actualTaskEndTime;

    private Long actualTaskDuration;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Long delStatus;

    private static final long serialVersionUID = 1L;
}

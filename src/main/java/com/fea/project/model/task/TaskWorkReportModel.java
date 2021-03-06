package com.fea.project.model.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskWorkReportModel implements Serializable {
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
    
    private Double taskProgrossRate;
    
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
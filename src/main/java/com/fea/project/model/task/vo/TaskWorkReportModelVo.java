package com.fea.project.model.task.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.task.TaskWorkReportModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskWorkReportModelVo extends TaskWorkReportModel{
	
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Long> appendixIds;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appendixId;
    
    private Date taskEndTime;
    
    private Date taskStartTime;
    
    
}

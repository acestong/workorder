package com.fea.project.model.task.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.TaskResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseModelVo {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskResponseId;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
    
    private TaskModel taskModel;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskResponseMethod;

    private String taskResponseMethodStr;
    
    private Date taskStartTime;

    private Date taskEndTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskDuration; 

    private Date taskDeadline;

    private String taskResponseDesc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;

    private String createBy;

    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;

    private String updateBy;

    private Date updateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long delStatus;

	public TaskResponseModelVo(TaskResponseModel model) {
		super();
		this.taskResponseId = model.getTaskResponseId();
		this.taskId = model.getTaskId();
		this.taskModel = model.getTaskModel();
		this.taskResponseMethod = model.getTaskResponseMethod();
		this.taskStartTime = model.getTaskStartTime();
		this.taskEndTime = model.getTaskEndTime();
		this.taskDuration = model.getTaskDuration();
		this.taskDeadline = model.getTaskDeadline();
		this.taskResponseDesc = model.getTaskResponseDesc();
		this.createId = model.getCreateId();
		this.createBy = model.getCreateBy();
		this.createTime = model.getCreateTime();
		this.updateId = model.getUpdateId();
		this.updateBy = model.getUpdateBy();
		this.updateTime = model.getUpdateTime();
		this.delStatus = model.getDelStatus();
	}

    
    
}

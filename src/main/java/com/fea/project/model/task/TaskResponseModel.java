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
public class TaskResponseModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskResponseId;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
    
    private TaskModel taskModel;

    private Long taskResponseMethod;

    private Date taskStartTime;

    private Date taskEndTime;

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

    private Long delStatus;

    private static final long serialVersionUID = 1L;

}
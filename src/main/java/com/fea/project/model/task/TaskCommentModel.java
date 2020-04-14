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
public class TaskCommentModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskCommentId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskDeliverProductId;
    
    private TaskModel taskModel;

    private Long validDuration; 

    private Double taskScore;
    
    private Double taskDeliverProductScore;
    
    private Double totalScore;

    private Date taskCommentTime;
    
    private String resultDesc;

    private Long createId;

    private String createBy;

    private Date createTime;

    private Long updateId;

    private String updateBy;

    private Date updateTime;

    private Long delStatus;

    private static final long serialVersionUID = 1L;

}
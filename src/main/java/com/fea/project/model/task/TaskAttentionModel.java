package com.fea.project.model.task;

import java.io.Serializable;
import java.util.Date;

import com.fea.project.enums.task.TaskAttentionStatusEnum;
import com.fea.project.util.UserUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskAttentionModel implements Serializable {
    private Long attentionId;

    private Long taskId;

    private Long attentionStatus;

    private Long userId;

    private Date attentionTime;

    private static final long serialVersionUID = 1L;

    public TaskAttentionModel(Long taskId ,TaskAttentionStatusEnum e) {
    	this.taskId = taskId;
    	this.attentionStatus = e.getStatus().longValue();
    	this.userId = UserUtil.getUserId();
    	this.attentionTime = new Date();
    }
}
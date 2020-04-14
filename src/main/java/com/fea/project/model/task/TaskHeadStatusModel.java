package com.fea.project.model.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.enums.task.TaskHeadShowStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/*
 * taskHeadStatusId为表头Id，
 * curUserId为当前用户Id，
 * taskResourceType为业务类型Id，需要根据用户Id和业务类型Id进行存储，每个用户每条业务类型只能在数据库储存一条
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskHeadStatusModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskHeadStatusId;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long curUserId;

    private Long taskId;

    private Long taskName;

    private Long taskNum;

    private Long parentTaskId;

    private Long projectId;

    private Long projectStep;

    private Long priority;

    private Long taskStartTime;

    private Long taskEndTime;

    private Long taskDeadline;

    private Long taskDuration;

    private Long taskLeaderId;

    private Long taskLeaderName;

    private Long taskTeamId;

    private Long taskTeamName;

    private Long taskDispatchMethod;

    private Long taskDispatcherId;

    private Long taskDispatchUserId;

    private Long taskParticipants;

    private Long taskRemindHour;

    private Long taskContent;

    private Long taskRemark;

    private Long workTaskStatus;

    private Long workTaskNum;

    private Long cancelTaskStatus;

    private Long cancelTaskReason;

    private Long stopTaskStatus;

    private Long stopTaskReason;

    private Long restartTaskStatus;

    private Long restartTaskReason;

    private Long taskProgrossRate;

    private Long taskResponseId;

    private Long taskStatus;

    private Long taskAttentionStatus;

    private Long taskQuestion;

    private Long taskType;

    private Long createId;

    private Long createBy;

    private Long createTime;

    private Long updateId;

    private Long updateBy;

    private Long updateTime;

    private Long delStatus;
    
    private Long milestoneId;
    
    private Long planTransferId;
    
    private Long taskResourceType;
    
    private Long resourceBusinessId;
    
    private Long workOrderId;
    
    private Long customerId;
    
    private Long contactId;

    private static final long serialVersionUID = 1L;

    /*
     * 无参构造器中赋默认初始值
     */
  public TaskHeadStatusModel(Long taskResourceType) {
		this.taskId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskName = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskNum = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.parentTaskId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.projectId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.projectStep = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.priority = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskStartTime = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskEndTime = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskDeadline = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskDuration = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskLeaderId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskLeaderName = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskTeamId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskTeamName = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskDispatchMethod = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskDispatcherId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskDispatchUserId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskParticipants = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskRemindHour = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskContent = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskRemark = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.workTaskStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.workTaskNum = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.cancelTaskStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.cancelTaskReason = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.stopTaskStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.stopTaskReason = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.restartTaskStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.restartTaskReason = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskProgrossRate = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskResponseId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskAttentionStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskQuestion = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskType = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.createId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.createBy = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.createTime = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.updateId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.updateBy = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.updateTime = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.delStatus = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.milestoneId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.planTransferId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskResourceType = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.resourceBusinessId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.workOrderId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.customerId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.contactId = TaskHeadShowStatusEnum.SHOWN.getStatus().longValue();
		this.taskResourceType = taskResourceType;
  }


   

   
}
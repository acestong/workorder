package com.fea.project.model.task.vo;

import com.fea.project.model.task.TaskModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpdcaTaskModelVo extends TaskModel{

	private static final long serialVersionUID = 1L;

	private String owner;
	
	private Long orgId;
	
	private String relationRoutineName;
	
	private String businessName;
	
	private String busSourceName;
	
	public OpdcaTaskModelVo(TaskModel taskModel) {
		super.setCancelTaskReason(taskModel.getCancelTaskReason());
		super.setCancelTaskStatus(taskModel.getCancelTaskStatus());
		super.setContactId(taskModel.getContactId());
		super.setCreateBy(taskModel.getCreateBy());
		super.setCreateId(taskModel.getCreateId());
		super.setCreateTime(taskModel.getCreateTime());
		super.setCustomerId(taskModel.getCustomerId());
		super.setDelStatus(taskModel.getDelStatus());
		super.setLeaderIdOrTeamId(taskModel.getLeaderIdOrTeamId());
		super.setMilestoneId(taskModel.getMilestoneId());
		super.setParentTaskId(taskModel.getParentTaskId());
		super.setPlanTransferId(taskModel.getPlanTransferId());
		super.setPriority(taskModel.getPriority());
		super.setProjectId(taskModel.getProjectId());
		super.setProjectStep(taskModel.getProjectStep());
		super.setResourceBusinessId(taskModel.getResourceBusinessId());
		super.setRestartTaskReason(taskModel.getRestartTaskReason());
		super.setRestartTaskStatus(taskModel.getRestartTaskStatus());
		super.setStopTaskReason(taskModel.getStopTaskReason());
		super.setStopTaskStatus(taskModel.getStopTaskStatus());
		super.setTaskAttentionStatus(taskModel.getTaskAttentionStatus());
		super.setTaskContent(taskModel.getTaskContent());
		super.setTaskDeadline(taskModel.getTaskDeadline());
		super.setTaskDispatcherId(taskModel.getTaskDispatcherId());
		super.setTaskDispatchMethod(taskModel.getTaskDispatchMethod());
		super.setTaskDispatchUserId(taskModel.getTaskDispatchUserId());
		super.setTaskDuration(taskModel.getTaskDuration());
		super.setTaskEndTime(taskModel.getTaskEndTime());
		super.setTaskId(taskModel.getTaskId());
		super.setTaskLeaderId(taskModel.getTaskLeaderId());
		super.setTaskName(taskModel.getTaskName());
		super.setTaskNum(taskModel.getTaskNum());
		super.setTaskParticipants(taskModel.getTaskParticipants());
		super.setTaskProgrossRate(taskModel.getTaskProgrossRate());
		super.setTaskQuestion(taskModel.getTaskQuestion());
		super.setTaskRemark(taskModel.getTaskRemark());
		super.setTaskRemindHour(taskModel.getTaskRemindHour());
		super.setTaskResourceType(taskModel.getTaskResourceType());
		super.setTaskResponseId(taskModel.getTaskResponseId());
		super.setTaskStartTime(taskModel.getTaskStartTime());
		super.setTaskStatus(taskModel.getTaskStatus());
		super.setTaskTeamId(taskModel.getTaskTeamId());
		super.setTaskTeamName(taskModel.getTaskTeamName());
		super.setTaskType(taskModel.getTaskType());
		super.setUpdateBy(taskModel.getUpdateBy());
		super.setUpdateId(taskModel.getUpdateId());
		super.setUpdateTime(taskModel.getUpdateTime());
		super.setWorkOrderId(taskModel.getWorkOrderId());
		super.setWorkTaskNum(taskModel.getWorkTaskNum());
		super.setWorkTaskStatus(taskModel.getWorkTaskStatus());
	}
	
}

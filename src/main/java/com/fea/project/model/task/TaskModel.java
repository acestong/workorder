package com.fea.project.model.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.enums.task.*;
import com.fea.project.model.baseconfig.ProjectCodeTaskRegChildModel;
import com.fea.project.model.plan.PlanModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TaskModel implements Serializable {
	//任务Id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
//任务名
    private String taskName;
//任务编号
    private String taskNum;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    父任务Id
    private Long parentTaskId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    项目Id
    private Long projectId;
//    项目阶段
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;  
//    优先级
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long priority;
//    任务开始时间
    private Date taskStartTime;
//    任务结束时间
    private Date taskEndTime;
//    任务截止完成时间
    private Date taskDeadline;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    任务工时
    private Long taskDuration;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    负责人或者团队方式传参
    private Long leaderIdOrTeamId;
//    任务负责人Id
    private Long taskLeaderId;
//    任务负责人名称
    private String taskLeaderName;
//    任务团队Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskTeamId;
//任务团队名称
    private String taskTeamName;
//    任务分配方式
    private Long taskDispatchMethod;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    任务分配人Id
    private Long taskDispatcherId;
    
    //任务分配人姓名
    private String taskDispatcherName;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    被分配人Id
    private Long taskDispatchUserId;
//    里程碑Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long milestoneId;
//    参与人外键Id（不在用）
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskParticipants;
//    任务提醒时间
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskRemindHour;
//    任务内容
    private String taskContent;
//    任务备注
    private String taskRemark;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    工作任务状态
    private Long workTaskStatus;
//    工作任务编号
    private String workTaskNum;
//    删除任务状态
    private Long cancelTaskStatus;
//    删除任务原因
    private String cancelTaskReason;
//    中止任务状态
    private Long stopTaskStatus;
//    中止任务原因
    private String stopTaskReason;
//    重启任务状态
    private Long restartTaskStatus;
//    重启任务原因
    private String restartTaskReason;
//    任务进度
    private Double taskProgrossRate;
//    任务响应Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskResponseId;
//    任务状态（根据此字段判断草稿或正式任务）
    private Long taskStatus;
//    任务关注状态
    private Long taskAttentionStatus;
//    提出问题id
    private Long taskQuestion;
//    项目类型
    private Long taskType;
//    创建人id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;
//    创建人
    private String createBy;
//    创建时间
    private Date createTime;
//    修改人id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateId;
//    修改人
    private String updateBy;
//    修改时间
    private Date updateTime;
//    删除状态
    private Long delStatus;
//    计划转任务id（记录原始的计划id）
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planTransferId; 
//    任务来源id
    private Long taskResourceType;
//    来源业务id
    private Long resourceBusinessId;
//    工单id
    private Long workOrderId;
//    客户id
    private Long customerId;
//    联系人id
    private Long contactId;
//	老系统任务id
    private Long oldTaskId;
//工序Id
    private Long procedureId;
    
    
    private static final long serialVersionUID = 1L;

	public TaskModel(PlanModel planModel) {
		super();
		this.planTransferId = planModel.getPlanId();
		this.taskName = planModel.getPlanName();
//		this.taskNum = taskNum;
//		this.parentTaskId = planModel.getParentPlanId();需求确定计划转为任务后，舍弃父计划字段
		this.projectId = planModel.getProjectId();
		this.projectStep = planModel.getProjectStep();
		this.priority = planModel.getPriority();
		this.taskStartTime = planModel.getPlanStarttime();
		this.taskEndTime = planModel.getPlanEndtime();
		this.taskDeadline = planModel.getPlanDeadline();
		this.taskDuration = planModel.getPlanDuration();
		this.taskLeaderId = planModel.getPlanLeaderId();
//		this.taskLeaderName = taskLeaderName;
		this.taskTeamId = planModel.getPlanTeamId();
//		this.taskTeamName = 
//		this.taskDispatchMethod = taskDispatchMethod;
//		this.taskDispatcherId = taskDispatcherId;
//		this.taskDispatchUserId = taskDispatchUserId;
		this.taskRemindHour = planModel.getPlanRemindHour();
		this.taskContent = planModel.getPlanContent();
		this.taskRemark = planModel.getPlanRemark();
		/*
		 * 默认计划转为任务时，为非工作、非取消、非中止、非重启状态
		 */
		this.workTaskStatus = WorkTaskStatusEnum.IS_NOT_WORKTASK.getStatus().longValue();
//		this.workTaskNum = workTaskNum;
		this.cancelTaskStatus = CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus().longValue();
//		this.cancelTaskReason = cancelTaskReason;
		this.stopTaskStatus = StopTaskStatusEnum.NOT_STOP_TASK.getStatus().longValue();
//		this.stopTaskReason = stopTaskReason;
		this.restartTaskStatus = RestartTaskStatusEnum.NOT_RESTART_TASK.getStatus().longValue();
//		this.restartTaskReason = restartTaskReason;
		this.taskProgrossRate = 0d;
//		this.taskResponseId = taskResponseId;
		this.taskStatus = TaskStatusEnum.UNPERMITTED.getStatus().longValue();
		this.taskAttentionStatus = TaskAttentionStatusEnum.NOT_ATTENTION.getStatus().longValue();
//		this.taskQuestion = taskQuestion;
		this.taskType = planModel.getPlanType();
		this.createBy = planModel.getCreateBy();
		this.createId = planModel.getCreateId();
		this.createTime = planModel.getCreateTime();
		this.updateBy = planModel.getUpdateBy();
		this.updateId = planModel.getUpdateId();
		this.updateTime = planModel.getUpdateTime();
		this.delStatus = planModel.getDelStatus();
		this.milestoneId = planModel.getPlanMilestoneId();
		this.taskResourceType = TaskResourceEnum.PROJECT_TASK.getStatus().longValue();
		this.resourceBusinessId = planModel.getProjectId();
	}

    
    
}
package com.fea.project.model.task;

import java.io.Serializable;
import java.util.Date;

import com.fea.project.enums.plan.PlanPorityEnum;
import com.fea.project.enums.task.CancelTaskStatusEnum;
import com.fea.project.enums.task.TaskResourceEnum;
import com.fea.project.model.task.vo.OpdcaTaskModelVo;
import com.fea.project.util.UserUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpdcaTaskModel implements Serializable {
    private Long id;

    private String code;

    private String name;

    private Integer classType;

    private Integer taskType;

    private Integer timeClass;

    private Integer sourceType;

    private Integer busSourceType;

    private Long busSourceId;

    private String busSourceName;

    private Integer timeType;

    private Date planStartTime;

    private Date planEndTime;

    private Double planWorkhours;

    private Long priorityId;

    private String priority;

    private String description;

    private Integer hasloan;

    private Long payeeId;

    private String payee;

    private Long loantypeid;

    private String loantypename;

    private Integer visitType;

    private Long applyId;

    private Integer auditStatus;

    private Integer taskCategory;

    private Long parentId;

    private Integer journeyType;

    private Integer lockStatus;

    private String createUser;

    private Long createUserId;

    private Date createTime;

    private String updateUser;

    private Long updateUserId;

    private Date updateTime;

    private String owner;

    private Long ownerId;

    private Long applicationfeeId;

    private Double totalMoney;

    private Double finalMoney;

    private Long currencyId;

    private Integer delState;

    private Integer executionState;

    private Double workHours;

    private Double workSpeed;

    private Date startTime;

    private Date endTime;

    private Integer responseStatus;

    private Date responseTime;

    private Long taskAssignId;

    private Long regId;

    private Long orgId;

    private Integer taskStatus;

    private String travelCode;

    private Integer delayNum;

    private Integer signState;

    private Integer isStart;

    private Integer isSignIn;

    private Integer isSignOut;

    private Double difficultyRate;

    private Double outWorkHours;

    private Long remindTimeId;

    private Long relationRoutineId;

    private Byte relationRoutineType;

    private String relationRoutineName;

    private Byte businessType;

    private Long businessId;

    private String businessName;

    private Long newTaskId;

    private static final long serialVersionUID = 1L;

    
    public OpdcaTaskModel(OpdcaTaskModelVo taskModel) {
    	this.code = "new_"+taskModel.getWorkTaskNum();
    	this.name = taskModel.getTaskName();
    	this.classType = 2; //计划=1,任务=2
    	this.taskType = 1;  //日常=1、出差=2、外出=3   0=其他（年、季等）
    	if(taskModel.getTaskResourceType() != null) {
    		this.sourceType = 100 + taskModel.getTaskResourceType().intValue();      
    		this.busSourceType = 100 + taskModel.getTaskResourceType().intValue();    
    	}
    	this.busSourceId = (taskModel.getProjectId() != null ?  taskModel.getProjectId() : taskModel.getResourceBusinessId());  //来源于项目或者其他任务
    	this.timeType = 2 ; //全天=1、非全天=2
    	this.planStartTime = taskModel.getTaskStartTime();
    	this.planEndTime = taskModel.getTaskEndTime();
    	if(taskModel.getTaskDuration() != null) {
    		this.planWorkhours = taskModel.getTaskDuration().doubleValue();
    	}
    	this.priorityId = taskModel.getPriority();
    	if(taskModel.getPriority() != null) {
    		this.priority = PlanPorityEnum.getValue(taskModel.getPriority().intValue());
    	}
    	this.description = taskModel.getTaskRemark();
    	this.taskCategory = 1; //主任务=1、子任务=2、行程=3,老系统中，除外出之外，其他任务无子任务
    	this.lockStatus = 0;  //0 未锁定  1 已锁定
    	this.responseStatus = 2;  //0 未分配  1 待响应  2已接受  3已拒绝，老系统要求只有此字段为2时才可显示
    	this.createUserId = taskModel.getCreateId() ;
    	this.createUser = taskModel.getCreateBy();
    	this.createTime = taskModel.getCreateTime();
    	this.updateUser = taskModel.getUpdateBy();
    	this.updateUserId = taskModel.getUpdateId();
    	this.updateTime = taskModel.getUpdateTime();
    	this.ownerId = taskModel.getTaskLeaderId();
    	if(taskModel.getDelStatus() != null) {
    		this.delState = taskModel.getDelStatus().intValue();
    	}
    	Date date = new Date();
    	if(taskModel.getTaskStartTime().getTime() - date.getTime() >0) {
    		//开始时间在当前时间之后
    		this.executionState = 0;//未开始状态
    	}else if(taskModel.getTaskEndTime().getTime() - date.getTime() > 0) {
    		//当前时间在结束时间之后，认为任务已经完成
    		this.executionState = 3;
    	}else {
    		//当前时间在起始时间之间
    		this.executionState = 1;//进行中状态
    	}
    	System.out.println(taskModel.getCancelTaskStatus()+"!@!~!!!!!!!!!"+taskModel);
    	if(taskModel.getCancelTaskStatus() != null && taskModel.getCancelTaskStatus() == CancelTaskStatusEnum.CANCEL_TASK.getStatus().longValue()) {
    		//工作任务为空时
    		this.executionState = 2;
    	}
    	this.regId = UserUtil.getUserRegId();
    	if(taskModel.getPlanTransferId() != null) {
    		this.taskStatus = 3;
    	}else {
    		this.taskStatus = 2;  // 	1 计划    2 任务   3 任务作为计划审批通过
    	}
    	if(taskModel.getTaskResourceType() != null && taskModel.getTaskResourceType() == TaskResourceEnum.NORMAL_TASK.getStatus().longValue() && taskModel.getResourceBusinessId() != null) {
    		//为常规任务且业务来源Id不为空即为工单任务
    		this.relationRoutineId = taskModel.getResourceBusinessId();
    		this.relationRoutineType = 7 ; //7工单，8任务
    	}else {
    		this.relationRoutineId = taskModel.getResourceBusinessId();
    		this.relationRoutineType = 8 ; //7工单，8任务
    	}
    	if(taskModel.getTaskResourceType() != null) {
    		this.businessType = (byte)(100 + taskModel.getTaskResourceType().byteValue());
    	}
    	this.businessId = (taskModel.getProjectId() == null ? taskModel.getResourceBusinessId() : taskModel.getProjectId());
    	this.newTaskId = taskModel.getTaskId();
    	
    	//======================================
    	//以下字段需要在service层查出有taskModel补给OpdcaTaskModelVo
    	this.owner = taskModel.getOwner();
    	this.orgId = taskModel.getOrgId();
    	this.relationRoutineName = taskModel.getRelationRoutineName();
    	this.businessName = taskModel.getBusinessName();
    	this.busSourceName = taskModel.getBusSourceName();
    }
}
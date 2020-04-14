package com.fea.project.model.task.vo;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.task.TaskModel;

import io.jsonwebtoken.lang.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskAndSonTaskModelVo extends TaskModel implements Serializable{
	private static final long serialVersionUID = 1L;
    
	//存放子任务
    private List<TaskAndSonTaskModelVo> children;
//项目阶段字符串
    private String projectStepStr;
//    优先级字符串
    private String priorityStr;
//    参与人列表字符串
    private List<UserIdAndNameInfo> taskParticipantList;
//    父任务名称
    private String parentTaskName;
//任务模型
    private TaskModel model;
//    项目阶段集合
    private List<Long> projectStepList;
//    计划转任务Id
    private Long planTransferId;
//    职位Id
    private Long jobId;
//    实际工时
    private Long actualTaskDuration;
    
    //实际开始时间
    private Date actualTaskStartTime;
    
    //实际结束时间
    private Date actualTaskEndTime;

}
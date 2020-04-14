package com.fea.project.model.task.vo;

import com.fea.project.model.task.TaskCommentModel;
import com.fea.project.model.task.TaskDeliverProductModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskCommentModelVo extends TaskCommentModel{
	
	private static final long serialVersionUID = 1L;

		//交付物名称
	    private String deliverProductName;
	    //任务开始时间
	    private Date taskStartTime;
	    //任务结束时间
	    private Date taskEndTime;
	    //任务工时
	    private Long taskDuration;
	    //实际开始时间
	    private Date actualTaskStartTime;
	    //实际结束时间
	    private Date actualTaskEndTime;
	    //实际工时
	    private Long actualTaskDuration; 
	    //交付物列表
	    private List<TaskDeliverProductModel> deliverProductList;
	    
	    private Date deliverProductTime;

}

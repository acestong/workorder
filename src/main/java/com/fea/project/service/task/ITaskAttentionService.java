package com.fea.project.service.task;

import com.fea.project.model.task.TaskAttentionModel;

public interface ITaskAttentionService {

	void Insert(Long taskId);
	
	TaskAttentionModel selectOneByTaskId(Long TaskId);
	
	Integer updateByTaskId(Long TaskId);
}

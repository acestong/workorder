package com.fea.project.service.task;

import com.fea.project.model.task.TaskMessageModel;

import java.util.List;

public interface ITaskMessageService {

	void save(TaskMessageModel taskMessageModel);
	void delete(TaskMessageModel taskMessageModel);
	void update(TaskMessageModel taskMessageModel);
	List<TaskMessageModel> getAll(Long taskId);
	TaskMessageModel getOne(Long taskMessageId,Long taskId);
} 

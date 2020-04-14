package com.fea.project.service.task;

import com.fea.project.model.task.TaskNumModel;

import java.util.List;

public interface ITaskNumService {

	void save();
	List<TaskNumModel> selectByConUserId(Long isSonTask);
	void updateByCurUserIdAndIsSonTask(TaskNumModel taskNumModel);
}

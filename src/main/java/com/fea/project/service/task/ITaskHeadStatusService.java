package com.fea.project.service.task;

import com.fea.project.model.task.TaskHeadStatusModel;

public interface ITaskHeadStatusService {

	void save(TaskHeadStatusModel model);
	TaskHeadStatusModel selectByCurUserIdAndTaskResourceType(Long taskResourceType);
	void updateByCurUserId(TaskHeadStatusModel model);
}

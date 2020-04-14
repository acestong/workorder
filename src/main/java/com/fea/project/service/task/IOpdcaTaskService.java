package com.fea.project.service.task;

import java.util.List;

import com.fea.project.model.task.OpdcaTaskModel;
import com.fea.project.model.task.TaskModel;

public interface IOpdcaTaskService {

	Integer save(OpdcaTaskModel opdcaTaskModel);
	
	Integer update(OpdcaTaskModel opdcaTaskModel);
	
	boolean selectExistedWorkTaskIdList(TaskModel taskModel);
}

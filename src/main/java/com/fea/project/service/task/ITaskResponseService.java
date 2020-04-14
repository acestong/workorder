package com.fea.project.service.task;

import com.fea.project.model.task.TaskResponseModel;
import com.fea.project.model.task.vo.TaskResponseModelVo;

import java.util.List;

public interface ITaskResponseService {

	void save(TaskResponseModel taskResponseModel);
	void delete(TaskResponseModel taskResponseModel);
	void update(TaskResponseModel taskResponseModel);
	List<TaskResponseModelVo> getAll(Long taskId);
	TaskResponseModel getOne(TaskResponseModel taskResponseModel);
}
 
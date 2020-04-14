package com.fea.project.service.task;

import com.fea.project.model.task.TaskCommentModel;
import com.fea.project.model.task.vo.TaskCommentModelVo;

import java.util.List;

public interface ITaskCommentService {

	void save(TaskCommentModel taskCommentModel);
	void delete(TaskCommentModel taskCommentModel);
	void update(TaskCommentModel taskCommentModel);
	List<TaskCommentModelVo> getAll(Long businessId);
	TaskCommentModel getOne(Long taskCommentId,Long businessId);
}
 
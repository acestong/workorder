package com.fea.project.service.task;

import com.fea.project.model.task.TaskParticipantModel;
import com.fea.project.model.task.vo.UserIdAndNameInfo;

import java.util.List;
import java.util.Map;

public interface ITaskParticipantService {

	Map<String,Object> save(TaskParticipantModel taskParticipantModel);
	List<UserIdAndNameInfo> getAll(Long taskId);
	List<TaskParticipantModel> getAllModel(Long taskId);
	Map<String,Object> delete(Long taskPanticipantId);
	Map<String,Object> update(TaskParticipantModel taskParticipantModel);
	
	Integer deleteByTaskId(Long taskId);
	Integer insertByList(List<TaskParticipantModel> list);
}

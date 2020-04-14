package com.fea.project.service.task.impl;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskParticipantModelMapper;
import com.fea.project.model.task.TaskParticipantModel;
import com.fea.project.model.task.vo.UserIdAndNameInfo;
import com.fea.project.service.task.ITaskParticipantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TaskParticipantServiceImpl implements ITaskParticipantService {

	@Resource
	private TaskParticipantModelMapper mapper;
	
	@Override
	public Map<String, Object> save(TaskParticipantModel taskParticipantModel) {
		// TODO Auto-generated method stub
		if(taskParticipantModel==null) {
			throw new SystemParamCheckException("传入模型为空，无法进行新增");
		}
		mapper.insertSelective(taskParticipantModel);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("taskParticipantId", taskParticipantModel.getTaskPanticipantId().toString());
		return map;
	}

	@Override
	public List<UserIdAndNameInfo> getAll(Long taskId) {
		// TODO Auto-generated method stub
		if(taskId == null) {
			throw new SystemParamCheckException("传入参数为空，无法进行查询");
		}
		List<UserIdAndNameInfo> selectAllByTaskId = mapper.selectAllByTaskId(taskId);
		return selectAllByTaskId;
	}

	@Override
	public Map<String, Object> delete(Long taskPanticipantId) {
		// TODO Auto-generated method stub
		if(taskPanticipantId == null) {
			throw new SystemParamCheckException("传入参数为空，无法进行删除");
		}
		Map<String, Object> map = new HashMap<>();
		mapper.deleteByPrimaryKey(taskPanticipantId);
		return map;
	}

	@Override
	public Map<String, Object> update(TaskParticipantModel taskParticipantModel) {
		// TODO Auto-generated method stub
		if(taskParticipantModel == null || taskParticipantModel.getTaskPanticipantId() == null) {
			throw new SystemParamCheckException("传入参数为空，无法进行更新");
		}
		Map<String, Object> map = new HashMap<>();
		mapper.updateByPrimaryKeySelective(taskParticipantModel);
		return map;
	}

	@Override
	public List<TaskParticipantModel> getAllModel(Long taskId) {
		// TODO Auto-generated method stub
		if(taskId == null) {
			throw new SystemParamCheckException("传入参数为空，无法进行查询");
		}
		return mapper.selectByExample(taskId);
	}

	/**
	 * 批量插入参与人
	 */
	@Override
	public Integer insertByList(List<TaskParticipantModel> list) {
		// TODO Auto-generated method stub
		return list.size() == 0 ? null : mapper.insertByList(list);
	}

	@Override
	public Integer deleteByTaskId(Long taskId) {
		// TODO Auto-generated method stub
		return taskId== null ? null : mapper.deleteByTaskId(taskId);
	}

}

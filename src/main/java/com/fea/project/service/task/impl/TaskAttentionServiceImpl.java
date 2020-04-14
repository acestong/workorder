package com.fea.project.service.task.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fea.project.dao.task.TaskAttentionModelMapper;
import com.fea.project.enums.task.TaskAttentionStatusEnum;
import com.fea.project.model.task.TaskAttentionModel;
import com.fea.project.service.task.ITaskAttentionService;

/**
 * 任务关注model
 * @author st
 *
 */
@Service
@Transactional
public class TaskAttentionServiceImpl implements ITaskAttentionService {

	@Resource
	private TaskAttentionModelMapper mapper;
	
	/**
	 * 新建关注，在建任务的同时默认新建
	 */
	@Override
	public void Insert(Long taskId) {
		// TODO Auto-generated method stub
		mapper.insertSelective(new TaskAttentionModel(taskId, TaskAttentionStatusEnum.NOT_ATTENTION));
	}

	/**
	 * 通过任务id获取关注model
	 */
	@Override
	public TaskAttentionModel selectOneByTaskId(Long TaskId) {
		// TODO Auto-generated method stub
		return mapper.selectByTaskId(TaskId);
	}

	@Override
	public Integer updateByTaskId(Long TaskId) {
		// TODO Auto-generated method stub
		TaskAttentionModel model = mapper.selectByTaskId(TaskId);
		if(model.getAttentionStatus() == TaskAttentionStatusEnum.ATTENTION.getStatus().longValue()) {
			model.setAttentionStatus( TaskAttentionStatusEnum.NOT_ATTENTION.getStatus().longValue());
		}else {
			model.setAttentionStatus( TaskAttentionStatusEnum.ATTENTION.getStatus().longValue());
		}
		return mapper.updateByTaskId(model);
	}

}

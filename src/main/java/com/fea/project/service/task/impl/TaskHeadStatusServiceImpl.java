package com.fea.project.service.task.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.task.TaskHeadStatusModelMapper;
import com.fea.project.model.task.TaskHeadStatusModel;
import com.fea.project.model.task.vo.TaskHeadModelVo;
import com.fea.project.service.task.ITaskHeadStatusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TaskHeadStatusServiceImpl implements ITaskHeadStatusService {

	@Resource
	private TaskHeadStatusModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	
	@Override
	public void save(TaskHeadStatusModel model) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCurUserId(currentUsr.getUserId());
		mapper.insertSelective(model);
	}

	@Override
	public TaskHeadStatusModel selectByCurUserIdAndTaskResourceType(Long taskResourceType) {
		// TODO Auto-generated method stub
		return mapper.selectByCurUserIdAndTaskResourceType(new TaskHeadModelVo(sysUserService.getCurrentUsr().getUserId(), taskResourceType));
	}

	@Override
	public void updateByCurUserId(TaskHeadStatusModel model) {
		// TODO Auto-generated method stub
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		model.setCurUserId(currentUsr.getUserId());
		mapper.updateByCurUserIdSelective(model);
	}

}

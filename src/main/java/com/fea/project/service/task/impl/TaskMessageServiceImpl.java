package com.fea.project.service.task.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskMessageModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.task.TaskMessageModel;
import com.fea.project.service.task.ITaskMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaskMessageServiceImpl implements ITaskMessageService {

	@Resource
	private TaskMessageModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	
	@Override 
	public void save(TaskMessageModel taskMessageModel) {
		// TODO Auto-generated method stub
		if ( taskMessageModel == null) {
            throw new SystemParamCheckException("交付要求模型传入为空，无法进行新增");
        }
		taskMessageModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskMessageModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskMessageModel.setCreateTime(new Date());
		taskMessageModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(taskMessageModel);
	}

	@Override
	public void delete(TaskMessageModel taskMessageModel) {
		// TODO Auto-generated method stub
		if ( taskMessageModel.getTaskId() == null || taskMessageModel.getTaskMessageId()==null|| taskMessageModel == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行删除");
        }
		taskMessageModel = mapper.selectByPrimaryKeyWithDelStatus(taskMessageModel);
		if ( taskMessageModel == null) {
            throw new SystemParamCheckException("该条数据不存在，无法进行删除");
        }
		taskMessageModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		taskMessageModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		taskMessageModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(taskMessageModel);
	}

	@Override
	public void update(TaskMessageModel taskMessageModel) {
		// TODO Auto-generated method stub
		if ( taskMessageModel == null || taskMessageModel.getTaskMessageId() == null) {
            throw new SystemParamCheckException("id或模型传入为空，无法进行修改");
        }
		taskMessageModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		taskMessageModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		taskMessageModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(taskMessageModel);
	}

	@Override
	public List<TaskMessageModel> getAll(Long taskId) {
		// TODO Auto-generated method stub
		if ( taskId == null ) {
            throw new SystemParamCheckException("传入参数任务id为空，无法进行查询");
        }
		List<TaskMessageModel> selectAllWithDelStatus = mapper.selectAllWithDelStatus(taskId);
		if ( selectAllWithDelStatus == null ) {
            throw new SystemParamCheckException("数据不存在");
        }
		return selectAllWithDelStatus;
	}

	@Override
	public TaskMessageModel getOne(Long taskMessageId, Long taskId) {
		// TODO Auto-generated method stub
		if ( taskMessageId == null || taskId == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		TaskMessageModel taskMessageModel = new TaskMessageModel();
		taskMessageModel.setTaskId(taskId);
		taskMessageModel.setTaskMessageId(taskMessageId);
		taskMessageModel = mapper.selectByPrimaryKeyWithDelStatus(taskMessageModel);
		if ( taskMessageModel == null) {
            throw new SystemParamCheckException("该条数据不存在");
        }
		return taskMessageModel;
	}

	

}

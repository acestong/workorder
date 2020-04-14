package com.fea.project.service.task.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.TaskResponseModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.task.TaskResponseStatusEnum;
import com.fea.project.model.task.TaskResponseModel;
import com.fea.project.model.task.vo.TaskResponseModelVo;
import com.fea.project.service.task.ITaskResponseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaskResponseServiceImpl implements ITaskResponseService {

	@Resource
	private TaskResponseModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	 
	@Override
	public void save(TaskResponseModel taskResponseModel) {
		// TODO Auto-generated method stub
		if ( taskResponseModel == null) {
            throw new SystemParamCheckException("任务模型传入为空，无法进行新增");
        }
		taskResponseModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskResponseModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskResponseModel.setCreateTime(new Date());
		taskResponseModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(taskResponseModel);
	}

	@Override
	public void delete(TaskResponseModel taskResponseModel) {
		// TODO Auto-generated method stub
		if ( taskResponseModel == null) {
            throw new SystemParamCheckException("任务模型传入为空，无法进行新增");
        }
		taskResponseModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskResponseModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskResponseModel.setCreateTime(new Date());
		taskResponseModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(taskResponseModel);
	}

	@Override
	public void update(TaskResponseModel taskResponseModel) {
		// TODO Auto-generated method stub
		if ( taskResponseModel.getTaskId() == null || taskResponseModel.getTaskResponseId()==null|| taskResponseModel == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行删除");
        }
		taskResponseModel = mapper.selectByPrimaryKeyWithDelStatus(taskResponseModel);
		if ( taskResponseModel == null) {
            throw new SystemParamCheckException("该条数据不存在，无法进行删除");
        }
		taskResponseModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		taskResponseModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		taskResponseModel.setCreateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(taskResponseModel);
	}

	@Override
	public List<TaskResponseModelVo> getAll(Long taskId) {
		// TODO Auto-generated method stub
		if ( taskId == null ) {
            throw new SystemParamCheckException("传入参数任务id为空，无法进行查询");
        }
		List<TaskResponseModel> selectAllWithDelStatus = mapper.selectAllWithDelStatus(taskId);
		if ( selectAllWithDelStatus == null ) {
            throw new SystemParamCheckException("数据不存在");
        }
		List<TaskResponseModelVo> listTemp = new ArrayList<TaskResponseModelVo>();
		for (TaskResponseModel taskResponseModel : selectAllWithDelStatus) {
			TaskResponseModelVo modelVo = new TaskResponseModelVo(taskResponseModel);
			modelVo.setTaskResponseMethodStr(TaskResponseStatusEnum.getValue(taskResponseModel.getTaskResponseMethod().intValue()));
			listTemp.add(modelVo);
		}
		return listTemp;
	}

	@Override
	public TaskResponseModel getOne(TaskResponseModel taskResponseModel) {
		// TODO Auto-generated method stub
		if ( taskResponseModel.getTaskResponseId() == null || taskResponseModel.getTaskId() == null ) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
		taskResponseModel = mapper.selectByPrimaryKeyWithDelStatus(taskResponseModel);
		if ( taskResponseModel == null) {
            throw new SystemParamCheckException("该条数据不存在");
        }
		return taskResponseModel;
	}

	

}

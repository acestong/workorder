package com.fea.project.service.task.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.task.OpdcaTaskModelMapper;
import com.fea.project.model.task.OpdcaTaskModel;
import com.fea.project.model.task.TaskModel;
import com.fea.project.service.task.IOpdcaTaskService;

@Service
@Transactional
public class OpdcaTaskServiceImpl implements IOpdcaTaskService {

	@Resource
	private OpdcaTaskModelMapper mapper; 
	
	@Override
	public Integer save(OpdcaTaskModel opdcaTaskModel) {
		// TODO Auto-generated method stub
		return mapper.insert(opdcaTaskModel);
	}

	/**
	 * 判断起始时间内老系统中是否已经存在工作任务，因新旧系统数据同步，此方法弃用
	 *  select COUNT(id) from l2cplat_opdca_v2_ceshi.t_opdca_task 
	 *  where plan_start_time >= '传入的结束时间' or plan_end_time <= '传入的开始时间'
	 * @return true: 已存在，false： 不存在
	 */
	@Override
	public boolean selectExistedWorkTaskIdList(TaskModel taskModel) {
		// TODO Auto-generated method stub
		if(taskModel.getTaskStartTime() == null || taskModel.getTaskEndTime() == null) {
			throw new SystemParamCheckException("起止时间必填");
		}
		return mapper.selectExistedWorkTaskIdCount(taskModel) > 0 ;
	}

	@Override
	public Integer update(OpdcaTaskModel opdcaTaskModel) {
		// TODO Auto-generated method stub
		if(opdcaTaskModel == null || opdcaTaskModel.getId() == null) {
			throw new SystemParamCheckException("传入参数异常，无法修改！");
		}
		return mapper.updateByPrimaryKeySelective(opdcaTaskModel);
	}

}

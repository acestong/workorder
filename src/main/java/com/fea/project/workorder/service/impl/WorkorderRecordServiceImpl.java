package com.fea.project.workorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.WorkorderRecordModelMapper;
import com.fea.project.workorder.model.WorkorderRecordModel;
import com.fea.project.workorder.service.IWorkorderRecordService;

@Service(version = "1.0.0",timeout = 6000)
@Component
public class WorkorderRecordServiceImpl implements IWorkorderRecordService {

	@Resource
	private WorkorderRecordModelMapper mapper;
	/**
	 * 新增操作记录
	 */
	@Override
	@Transactional
	public Integer insert(WorkorderRecordModel model) {
		// TODO Auto-generated method stub
		return mapper.insert(model);
	}
	
	/**
	 * 获取操作记录列表
	 */
	@Override
	@Transactional
	public List<WorkorderRecordModel> selectByWorkorderId(Long workorderId) {
		// TODO Auto-generated method stub
		return workorderId == null ? null : mapper.selectByWorkorderId(workorderId);
	}

}

package com.fea.project.workorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.PoolAutoDispatchModelMapper;
import com.fea.project.workorder.model.PoolAutoDispatchModel;
import com.fea.project.workorder.model.vo.PoolAutoDispatchModelVo;
import com.fea.project.workorder.service.IPoolAutoDispatchService;

/**
 * 入池自动分配Service
 * @author st
 * @since 2020/03/18
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class PoolAutoDispatchServcieImpl implements IPoolAutoDispatchService {

	@Resource
	private PoolAutoDispatchModelMapper mapper;
	@Resource
	private PoolDispatchUserServiceImpl poolDispatchUserService;

	@Override
	@Transactional
	public Integer insertByList(Long workorderPoolId, List<PoolAutoDispatchModelVo> list) {
		// TODO Auto-generated method stub
		if(workorderPoolId == null || list.size() == 0) {
			return null;
		}
		int insertByList = mapper.insertByList(workorderPoolId, list);
		list.stream().forEach((modelVo)->{
			poolDispatchUserService.insertByList(workorderPoolId, modelVo.getAutoDispatchId(), modelVo.getDispatchUserList());
		});
		return insertByList;
	}
	
	
	
	
}

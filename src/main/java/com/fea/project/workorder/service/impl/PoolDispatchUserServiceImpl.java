package com.fea.project.workorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.PoolDispatchUserModelMapper;
import com.fea.project.workorder.model.PoolDispatchUserModel;
import com.fea.project.workorder.service.IPoolDispatchUserService;
/**
 * 工单池自动分配用户Service
 * @author st
 * @since 2020/03/18
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class PoolDispatchUserServiceImpl implements IPoolDispatchUserService {

	@Resource
	private PoolDispatchUserModelMapper mapper;
	@Override
	@Transactional
	public Integer insertByList(Long workorderPoolId, Long autoDispatchId, List<PoolDispatchUserModel> list) {
		// TODO Auto-generated method stub
		if(workorderPoolId == null || autoDispatchId == null || list.size() == 0) {
			return null;
		}
		
		return mapper.insertByList(workorderPoolId, autoDispatchId, list);
	}
	@Override
	@Transactional
	public PoolDispatchUserModel selectModelByPoolId(Long poolId) {
		// TODO Auto-generated method stub
		return poolId == null ? null :mapper.selectModelByPoolId(poolId);
	}
	@Override
	@Transactional
	public Integer updateByPrimaryKey(PoolDispatchUserModel model) {
		// TODO Auto-generated method stub
		return model.getWorkorderCount() == null ? null :mapper.updateByPrimaryKey(model);
	}

}

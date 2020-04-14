package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.PoolDispatchUserModel;

public interface IPoolDispatchUserService {

	Integer insertByList(Long workorderPoolId,Long autoDispatchId ,List<PoolDispatchUserModel> list);

	 PoolDispatchUserModel selectModelByPoolId(Long poolId);
	 
	 Integer updateByPrimaryKey(PoolDispatchUserModel model);
}

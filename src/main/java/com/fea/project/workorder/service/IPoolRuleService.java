package com.fea.project.workorder.service;

import java.util.List;

import com.fea.project.workorder.model.PoolRuleModel;

public interface IPoolRuleService {

	Integer insertList(Long workorderPoolId, List<PoolRuleModel> list);
	
	 List<PoolRuleModel> selectListByPoolId(Long workorderPoolId);
}

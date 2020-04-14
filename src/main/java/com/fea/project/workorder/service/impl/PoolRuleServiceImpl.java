package com.fea.project.workorder.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.fea.project.workorder.dao.PoolRuleModelMapper;
import com.fea.project.workorder.model.PoolRuleModel;
import com.fea.project.workorder.service.IPoolRuleService;

/**
 * 工单池入池规则Service
 * @author st
 * @since 2020/03/18
 *
 */
@Service(version = "1.0.0",timeout = 6000)
@Component
public class PoolRuleServiceImpl implements IPoolRuleService {

	@Resource
	private PoolRuleModelMapper mapper;
	
	/**
	 * 按list新增入池规则
	 */
	@Override
	@Transactional
	public Integer insertList(Long workorderPoolId, List<PoolRuleModel> list) {
		// TODO Auto-generated method stub
		if(workorderPoolId == null || list.size() == 0) {
			return null;
		}
		return mapper.insertByList(workorderPoolId, list);
	}

	/**
	 * 通过工单池id获取到所有的入池规则列表
	 */
	@Override
	@Transactional
	public List<PoolRuleModel> selectListByPoolId(Long workorderPoolId) {
		// TODO Auto-generated method stub
		return workorderPoolId == null ? null : mapper.selectListByPoolId(workorderPoolId);
	}

}

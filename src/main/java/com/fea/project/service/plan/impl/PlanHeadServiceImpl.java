package com.fea.project.service.plan.impl;


import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.plan.PlanHeadStatusModelMapper;
import com.fea.project.model.plan.PlanHeadStatusModel;
import com.fea.project.service.plan.IPlanHeadStatusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PlanHeadServiceImpl implements IPlanHeadStatusService {

	@Resource
	private PlanHeadStatusModelMapper mapper;
	
	@Resource
    private SysUserService sysUserService;
	 
	/*
	 * 生产环境，未能获取到当前用户
	 */
	@Override
	public void save(PlanHeadStatusModel planHeadStatusModel) {
		// TODO Auto-generated method stub
		planHeadStatusModel.setCurUserId(sysUserService.getCurrentUsr().getUserId());
		mapper.insert(planHeadStatusModel);
	}

	@Override
	public void delete(Long curUserId) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(curUserId);

	}

	@Override
	public void update(PlanHeadStatusModel planHeadStatusModel) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(planHeadStatusModel);
	}

	@Override
	public PlanHeadStatusModel getOne(Long curUserId) {
		// TODO Auto-generated method stub
		PlanHeadStatusModel selectByPrimaryKey = mapper.selectByCurUserId(curUserId);
		return selectByPrimaryKey;
	}
	
	

}

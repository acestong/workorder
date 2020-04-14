package com.fea.project.service.plan.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.PlanParticipantModelMapper;
import com.fea.project.model.plan.PlanParticipantModel;
import com.fea.project.model.plan.vo.ProjectUserIdAndNameInfoModelVO;
import com.fea.project.service.plan.IPlanParticipantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PlanParticipantServiceImpl implements IPlanParticipantService {

	@Resource
	private PlanParticipantModelMapper mapper;
	
	@Resource
	private SysUserService sysUserService;
	@Override
	public List<Long> save(List<Long> planParticipantUserIds) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		List<Long> result = new ArrayList<>();
			for (Long planPaticipantUserId : planParticipantUserIds) {
				PlanParticipantModel record = new PlanParticipantModel();
				record.setPlanPaticipantUserId(planPaticipantUserId);
				mapper.insertSelective(record);
				result.add(record.getPlanPanticipantId());
			} 
		return result;
	}

	@Override
	public List<ProjectUserIdAndNameInfoModelVO> getAll(Long planId) {
		// TODO Auto-generated method stub
		List<ProjectUserIdAndNameInfoModelVO> selectByExample = mapper.selectAllByPlanId(planId);
		return selectByExample;
	}

	/*
	 * 
	 */
	@Override
	public Map<String, Object> delete(PlanParticipantModel participantModel) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		mapper.deleteByPrimaryKey(participantModel.getPlanPanticipantId());
		return map;
	}

	@Override
	public Map<String, Object> update(PlanParticipantModel participantModel) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		mapper.updateByPrimaryKeySelective(participantModel);
		return map;
	}

	@Override
	public PlanParticipantModel selectOneByPlanIdAndPlanPaticipantUserId(Long planId,Long planPaticipantUserId) {
		// TODO Auto-generated method stub
		if(planId==null||planPaticipantUserId==null) {
			throw new SystemParamCheckException("传入参数异常");
		}
		PlanParticipantModel planParticipantModel = new PlanParticipantModel(null, planId, 
				planPaticipantUserId,sysUserService.selectById(planPaticipantUserId).getRealName());
		return mapper.selectOneByPlanIdAndPlanPaticipantUserId(planParticipantModel);
	}

	@Override
	public Long save(PlanParticipantModel participantModel) {
		// TODO Auto-generated method stub
		if(participantModel==null||participantModel.getPlanId()==null||participantModel.getPlanPaticipantUserId()==null) {
			throw new SystemParamCheckException("传入参数异常，无法进行新增");
		}
		mapper.insert(participantModel);
		return participantModel.getPlanPanticipantId();
	}

	@Override
	public List<PlanParticipantModel> getAllPlanParticipantList(Long planId) {
		// TODO Auto-generated method stub
		if(planId==null) {
			throw new SystemParamCheckException("传入参数异常，无法进行新增");
		}
		return mapper.selectByExample(planId);
	}

	@Override
	public List<PlanParticipantModel> selectPlanParticipantListByPlanId(Long planId) {
		// TODO Auto-generated method stub
		if(planId==null) {
			throw new SystemParamCheckException("传入参数异常，无法进行新增");
		}
		return mapper.selectPlanParticipantListByPlanId(planId);
	}

	@Override
	public Integer insertByList(List<PlanParticipantModel> list) {
		// TODO Auto-generated method stub
		return list.size() == 0 ? null : mapper.insertByList(list);
	}

	@Override
	public Integer deleteByPlanId(Long planId) {
		// TODO Auto-generated method stub
		return planId == null ? null : mapper.deleteByPlanId(planId);
	}

}

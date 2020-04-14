package com.fea.project.service.plan.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.PlanAssociationModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.plan.RelationshipEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.PlanAssociationModel;
import com.fea.project.model.plan.vo.BusinessAssociationShowModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.service.plan.IPlanAssociationService;
import com.fea.project.service.project.ProjectStepService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关联计划业务层
 * @author st
 * @since 2019/11/1 11:48
 *
 */
@Service
@Transactional
public class PlanAssociationServiceImpl implements IPlanAssociationService{

	 
	@Resource
	private PlanAssociationModelMapper mapper;
	
	@Resource
    private SysUserService sysUserService;
	
	@Resource
	private ProjectStepService projectStepService;
	/*
	 * 新增
	 */
	@Override 
	public Map<String, Object> save(PlanAssociationModel planAssociationModel) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		planAssociationModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		planAssociationModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		planAssociationModel.setCreateTime(new Date());
		planAssociationModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(planAssociationModel);
		map.put("businessAssociationId", planAssociationModel.getPlanAssociationId().toString());
		return map;
	}

	/*
	 * 删除
	 */
	@Override
	public Map<String, Object> delete(Long planAssociationId) {
		// TODO Auto-generated method stub
		if ( planAssociationId == null) {
            throw new SystemParamCheckException("关联附件id传入异常，无法进行删除");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		PlanAssociationModel selectByPrimaryKeyWithDelStatus = mapper.selectByPrimaryKeyWithDelStatus(planAssociationId);
		selectByPrimaryKeyWithDelStatus.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		selectByPrimaryKeyWithDelStatus.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		selectByPrimaryKeyWithDelStatus.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(selectByPrimaryKeyWithDelStatus);
		return map;
	}

	/*
	 * 修改
	 */
	@Override
	public Map<String, Object> update(PlanAssociationModel planAssociationModel) {
		// TODO Auto-generated method stub
		if ( planAssociationModel == null || planAssociationModel.getPlanAssociationId() == null) {
            throw new SystemParamCheckException("关联附件id传入异常，无法进行修改");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		planAssociationModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		planAssociationModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		planAssociationModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(planAssociationModel);
		return map;
	}

	/*
	 * 获取所有
	 */
	@Override
	public List<BusinessAssociationShowModelVo> getAll(PageInfoFromFrontModel page) {
		// TODO Auto-generated method stub
		if ( page.getBusinessId() == null && page.getPlanId() == null) {
            throw new SystemParamCheckException("业务id传入异常，无法进行查询");
        }
		List<BusinessAssociationShowModelVo> selectByExample = mapper.selectAllByPlanIdWithDelStatus(page);
		selectByExample.stream().forEach((modelVo)->{
			modelVo.setPlanStepStr(projectStepService.selectById(modelVo.getPlanStep()).getName());
			modelVo.setRelationShipStatusStr(RelationshipEnum.getValue(modelVo.getPlanRelationship().intValue()));
		});
		return selectByExample;
	}

	/*
	 * 获取一个
	 */
	@Override
	public Map<String, Object> getOne(Long planAssociationId) {
		// TODO Auto-generated method stub
		if ( planAssociationId == null) {
            throw new SystemParamCheckException("关联附件id传入异常，无法进行查询");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		PlanAssociationModel selectByPrimaryKey = mapper.selectByPrimaryKeyWithDelStatus(planAssociationId);
		map.put("selectData", selectByPrimaryKey);
		return map;
	}

	@Override
	public Map<String, Object> getAssociationInfoByPlanId(Long planId) {
		// TODO Auto-generated method stub
		if ( planId == null) {
            throw new SystemParamCheckException("关联附件id传入异常，无法进行查询");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("AssoxiationInfos", mapper.selectAssociationInfoByPlanId(planId));
		return map;
	}

	@Override
	public List<PlanAssociationModel> getAll(Long planId) {
		// TODO Auto-generated method stub
		return mapper.selectByExampleWithDelStatus(planId);
	}

	/**
	 * 批量修改业务id
	 */
	@Override
	public Integer updateByList(Long businessId, List<Long> list) {
		// TODO Auto-generated method stub
		return businessId == null || list.size()== 0 ? null : mapper.updateByList(businessId, list);
	}

	
	/**
	 * 通过业务id统一删除
	 */
	@Override
	public Integer deleteByBusinessId(Long businessId) {
		// TODO Auto-generated method stub
		return businessId == null ? null : mapper.deleteByBusinessId(businessId);
	}
}

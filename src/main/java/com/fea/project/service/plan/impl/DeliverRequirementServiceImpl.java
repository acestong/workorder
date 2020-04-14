package com.fea.project.service.plan.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.DeliverRequirementModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.DeliverRequirementModel;
import com.fea.project.model.plan.vo.AppendixShowDataModelVo;
import com.fea.project.model.plan.vo.DeliverRequirementModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IDeliverRequirementService;
import com.fea.project.service.plan.IPlanAppendixService;
import com.fea.project.service.plan.IPlanService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 交付要求业务层控制器
 * @author st
 * @since 2019/11/1 11:15
 *
 */

@Service
@Transactional
public class DeliverRequirementServiceImpl implements IDeliverRequirementService{

	 
	@Resource
	private DeliverRequirementModelMapper mapper;

	@Resource
    private SysUserService sysUserService;
	
	@Resource
	private IPlanService planService;
	
	@Resource
	private IPlanAppendixService planAppendixService;
	/* 
	 * 新增
	 */
	@Override
	public Map<String, Object> save(DeliverRequirementModel deliverRequirementModel,List<Long> appendixIds) {
		Map<String,Object> map = new HashMap<>();
		deliverRequirementModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		deliverRequirementModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		deliverRequirementModel.setCreateTime(new Date());
		deliverRequirementModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		 mapper.insert(deliverRequirementModel);
		 map.put("deliverRequirementId", deliverRequirementModel.getPlanDeliverRequirementId().toString());
		 for (Long appendixId : appendixIds) {
			UpdateBusinessIdInProjectAppendixModelVo<DeliverRequirementModel> model = new UpdateBusinessIdInProjectAppendixModelVo<DeliverRequirementModel>();
			model.setAppendixId(appendixId);
			model.setBusinessAppendixId(deliverRequirementModel.getPlanDeliverRequirementId());
			mapper.updateBusinessIdInTProjectAppendix(model);
		}
		 return map;
	} 

	/*
	 * 删除,假删除，只修改delStatus的状态
	 */
	@Override
	public Map<String, Object> delete(Long planDeliverRequirementId) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		if ( planDeliverRequirementId == null) {
            throw new SystemParamCheckException("交付要求id传入异常，无法进行删除");
        }
		DeliverRequirementModel deliverRequirementModel = null;
		deliverRequirementModel = mapper.selectByPrimaryKeyWithDelStatus(planDeliverRequirementId);
		mapper.updateByPrimaryKeySelectiveWithDelStatus(deliverRequirementModel);
		return map;
	}

	/*
	 * 修改
	 */
	@Override
	public Map<String, Object> update(DeliverRequirementModel deliverRequirementModel) {
		// TODO Auto-generated method stub
		if ( deliverRequirementModel == null || deliverRequirementModel.getPlanDeliverRequirementAppendixId() == null) {
            throw new SystemParamCheckException("交付要求id传入异常，无法进行修改");
        }
		Map<String,Object> map = new HashMap<>();
        deliverRequirementModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
        deliverRequirementModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
        deliverRequirementModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(deliverRequirementModel);
		return map;
	}

	/*
	 * 获取所有非删除状态下的集合信息
	 */
	@Override
	public List<DeliverRequirementModel> getAll(PageInfoFromFrontModel page) {
		// TODO Auto-generated method stub
		if ( page == null && page.getBusinessId() == null && page.getPlanId() == null) {
            throw new SystemParamCheckException("计划id传入异常，无法进行查询");
        }
		List<DeliverRequirementModel> modelList = mapper.selectAllByPlanIdWithDelStatus(page);
		return modelList;
	}

	/*
	 * 获取一个非删除状态下的集合信息
	 */
	@Override
	public Map<String, Object> getOne(Long planDeliverRequirementId) {
		// TODO Auto-generated method stub
		if ( planDeliverRequirementId == null) {
            throw new SystemParamCheckException("交付要求id传入异常，无法进行查询");
        }
		Map<String,Object> map = new HashMap<>();
		DeliverRequirementModel selectByPrimaryKey = mapper.selectByPrimaryKeyWithDelStatus(planDeliverRequirementId);
		map.put("selectData", selectByPrimaryKey);
		return map;
	}

	@Override
	public List<DeliverRequirementModel> getAll(Long planId) {
		// TODO Auto-generated method stub
		if(planId ==null) {
			throw new SystemParamCheckException("交付要求id传入异常，无法进行查询");
		}
		return mapper.selectByExampleWithDelStatus(planId);
	}

	/**
	 * 通过业务id统一修改
	 */
	@Override
	public Integer updateByList(Long businessId, List<Long> list) {
		// TODO Auto-generated method stub
		return businessId == null || list.size() == 0 ? null : mapper.updateByList(businessId, list);
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

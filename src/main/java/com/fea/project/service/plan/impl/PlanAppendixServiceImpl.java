package com.fea.project.service.plan.impl;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.PlanAppendixModelMapper;
import com.fea.project.enums.AppendixTypeEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.plan.PlanAppendixTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.plan.vo.AppendixModelVo;
import com.fea.project.model.plan.vo.AppendixShowDataModelVo;
import com.fea.project.model.plan.vo.BusinessAppendixModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.plan.IPlanAppendixService;
import com.fea.project.service.plan.IPlanService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 
 * 计划附件业务层
 * @author st
 * @since 2019/11/1 10:31
 *
 */
@Service
@Transactional
public class PlanAppendixServiceImpl implements IPlanAppendixService {

	@Resource
	private PlanAppendixModelMapper mapper;
	

	@Resource
    private SysUserService sysUserService;
	
	@Resource
	private IPlanService planService;
	
	@Resource
	private ProjectAppendixService projectAppendixService;
	/* 
	 * 新增
	 */
	@Override
	public Map<String,Object> save(PlanAppendixModel planAppendixModel,List<Long> appendixIds) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		planAppendixModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		planAppendixModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		planAppendixModel.setCreateTime(new Date());
		planAppendixModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(planAppendixModel);
		map.put("businessAppendixId", planAppendixModel.getBusinessAppendixId().toString());
		 projectAppendixService.updateByBusinessIdAndIds(planAppendixModel.getBusinessAppendixId(), appendixIds);
		return map;
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Long planAppendixId) {
		// TODO Auto-generated method stub
		if ( planAppendixId == null) {
            throw new SystemParamCheckException("计划附件id传入异常，无法进行删除");
        }
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		PlanAppendixModel selectByPrimaryKeyWithDelStatus = mapper.selectByPrimaryKey(planAppendixId);
		selectByPrimaryKeyWithDelStatus.setUpdateId(currentUsr.getUserId());
		selectByPrimaryKeyWithDelStatus.setUpdateBy(currentUsr.getRealName());
		selectByPrimaryKeyWithDelStatus.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(selectByPrimaryKeyWithDelStatus);
	}

	/*
	 * 更新
	 */
	@Override
	public void update(PlanAppendixModel planAppendixModel) {
		// TODO Auto-generated method stub
		if ( planAppendixModel == null || planAppendixModel.getBusinessAppendixId()==null) {
            throw new SystemParamCheckException("计划附件id传入异常，无法进行删除");
        }
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		planAppendixModel.setUpdateId(currentUsr.getUserId());
		planAppendixModel.setUpdateBy(currentUsr.getRealName());
		planAppendixModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(planAppendixModel);
	}

	/*
	 * 获取所有计划附件模型
	 */
	@Override
	public List<AppendixModelVo> getAll(PageInfoFromFrontModel page) {
		if (page.getBusinessId()==null && page.getPlanTransferId() == null) {
            throw new SystemParamCheckException("计划id传入异常，无法进行查询");
        }
		// TODO Auto-generated method stub
		List<AppendixModelVo> list = mapper.selectAllByBusinessIdWithDelStatus(page);
		list.stream().forEach(item -> {
			if(item != null)
			item.setBusinessAppendixTypeStr(PlanAppendixTypeEnum.getValue(item.getBusinessAppendixType().intValue()));
		});
		return list;
	}
	@Override
	public Map<String, Object> getOne(Long planAppendixId) {
		// TODO Auto-generated method stub
		if ( planAppendixId == null) {
            throw new SystemParamCheckException("计划附件id传入异常，无法进行查询");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		PlanAppendixModel selectByPrimaryKey = mapper.selectByPrimaryKeyWithDelStatus(planAppendixId);
		map.put("selectData", selectByPrimaryKey);
		return map;
	}

	@Override
	public List<PlanAppendixModel> getAll(Long businessId) {
		// TODO Auto-generated method stub
		 if ( businessId == null) {
		 	throw new SystemParamCheckException("计划附件id传入异常，无法进行查询");
		 }
		 return mapper.selectByExampleWithDelStatus(businessId);
	}

	/**
	 * 批量修改业务id
	 */
	@Override
	public Integer updateByList(Long businessId, List<Long> list, String businessName, Long projectId,
			Long projectStep) {
		// TODO Auto-generated method stub
		return businessId == null || list.size() == 0 ? null :mapper.updateByList(businessId, list, businessName, projectId, projectStep);
	}

	/**
	 * 通过业务id统一删除
	 */
	@Override
	public Integer deleteByBusinessId(Long businessId) {
		// TODO Auto-generated method stub
		return businessId == null ? null : mapper.deleteByBusinessId(businessId);
	}

	   /**
     * 通过主键获取详情
     * @param planAppendixId
     * @return
     */
	@Override
	public BusinessAppendixModelVo selectByBusinessAppendixId(Long businessAppendixId) {
		// TODO Auto-generated method stub
		BusinessAppendixModelVo modelVo = mapper.selectByBusinessAppendixId(businessAppendixId);
		modelVo.setAppendixInfoList(projectAppendixService.selectIdAndNameByBusiness(businessAppendixId));
		modelVo.setBusinessAppendixTypeStr(PlanAppendixTypeEnum.getValue(modelVo.getBusinessAppendixType().intValue()));
		return modelVo;
	}

	/**
	 * 
	 */
	@Override
	public Integer update_v2(BusinessAppendixModelVo businessAppendixModelVo) {
		// TODO Auto-generated method stub
		if(businessAppendixModelVo == null) {
			return null;
		}
		mapper.updateByPrimaryKeySelective(businessAppendixModelVo);
		if(businessAppendixModelVo.getAppendixIdList() != null) {
			projectAppendixService.updateByBusinessIdAndIds(businessAppendixModelVo.getBusinessAppendixId(), businessAppendixModelVo.getAppendixIdList());
		}
		return null;
	}
	
	
}

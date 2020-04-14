package com.fea.project.service.plan.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.QualityRequirementModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.plan.PlanAppendixTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.QualityRequirementModel;
import com.fea.project.model.plan.vo.AppendixShowDataModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.QualityRequirementModelVo;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IPlanService;
import com.fea.project.service.plan.IQualityRequirementService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 质量要求业务层
 * @author st
 * @since 2019/11/1 16:22
 *
 */
@Service
@Transactional
public class QualityRequirementServiceImpl implements IQualityRequirementService {

	
	
	@Resource
	private QualityRequirementModelMapper mapper;
	
	@Resource
    private SysUserService sysUserService;
	
	@Resource
	private IPlanService planService;
	/*
	 * 新增
	 */ 
	@Override
	public Map<String, Object> save(QualityRequirementModel qualityRequirementModel,List<Long> appendixIds) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		qualityRequirementModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		qualityRequirementModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		qualityRequirementModel.setCreateTime(new Date());
		qualityRequirementModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insertSelective(qualityRequirementModel);
		map.put("qualityRequirementId", qualityRequirementModel.getPlanQualityRequirementId().toString());
		 for (Long appendixId : appendixIds) {
				UpdateBusinessIdInProjectAppendixModelVo<QualityRequirementModel> model = new UpdateBusinessIdInProjectAppendixModelVo<QualityRequirementModel>();
				model.setAppendixId(appendixId);
				model.setBusinessAppendixId(qualityRequirementModel.getPlanQualityRequirementId());
				mapper.updateBusinessIdInTProjectAppendix(model);
			}
		return map;
		
	}

	/*
	 * 删除
	 */
	@Override
	public Map<String, Object> delete(Long planQualityRequirementId) {
		// TODO Auto-generated method stub
		if ( planQualityRequirementId == null) {
            throw new SystemParamCheckException("质量要求id传入异常，无法进行删除");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		QualityRequirementModel selectByPrimaryKeyWithDelStatus = mapper.selectByPrimaryKeyWithDelStatus(planQualityRequirementId);
		selectByPrimaryKeyWithDelStatus.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		selectByPrimaryKeyWithDelStatus.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		selectByPrimaryKeyWithDelStatus.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(selectByPrimaryKeyWithDelStatus);
		return map;
	}

	@Override
	public Map<String, Object> update(QualityRequirementModel qualityRequirementModel) {
		// TODO Auto-generated method stub
		if ( qualityRequirementModel == null || qualityRequirementModel.getPlanQualityAppendixId()==null) {
            throw new SystemParamCheckException("质量要求id传入异常，无法进行修改");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		qualityRequirementModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		qualityRequirementModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		qualityRequirementModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(qualityRequirementModel);
		return map;
	}

	@Override
	public List<Object> getAll(PageInfoFromFrontModel page) {
		// TODO Auto-generated method stub
		if ( page == null || page.getPlanId()==null) {
            throw new SystemParamCheckException("计划id传入异常，无法进行查询");
        }
		List<QualityRequirementModel> selectByExample = mapper.selectAllByPlanIdWithDelStatus(page);
//		AppendixShowDataModelVo<QualityRequirementModel> modelVo = new AppendixShowDataModelVo<>();
		List<Object> listTemp = new ArrayList<Object>();
		selectByExample.stream().forEach((qualityRequirementModel)->{
			QualityRequirementModelVo modelVo = new QualityRequirementModelVo(qualityRequirementModel);
			modelVo.setAppendixInfos(planService.selectAppendixIDAndNameInfoByBusinessId(qualityRequirementModel.getPlanQualityRequirementId()));
			listTemp.add(modelVo);
		});
		return listTemp;
	}

	@Override
	public Map<String, Object> getOne(Long planQualityRequirementId) {
		// TODO Auto-generated method stub
		if ( planQualityRequirementId ==null) {
            throw new SystemParamCheckException("质量要求id传入异常，无法进行查询");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		QualityRequirementModel selectByPrimaryKey = mapper.selectByPrimaryKeyWithDelStatus(planQualityRequirementId);
		map.put("selectData", selectByPrimaryKey);
		return map;
	}

	@Override
	public List<QualityRequirementModel> getAll(Long planId) {
		// TODO Auto-generated method stub
		if(planId==null) {
			  throw new SystemParamCheckException("id传入异常，无法进行查询");
		}
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

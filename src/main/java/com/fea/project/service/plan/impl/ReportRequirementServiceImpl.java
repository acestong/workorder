package com.fea.project.service.plan.impl;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.ReportRequirementModelMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.plan.PlanReportRequirementMethodEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.ReportRequirementModel;
import com.fea.project.model.plan.vo.AppendixShowDataModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.ReportRequirementModelVo;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.service.plan.IPlanService;
import com.fea.project.service.plan.IReportRequirementService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/*
 * 汇报要求控制层
 */
@Service
@Transactional
public class ReportRequirementServiceImpl implements IReportRequirementService {

	
	@Resource
	private ReportRequirementModelMapper mapper;
	
	@Resource
    private SysUserService sysUserService;
	
	@Resource
	private IPlanService planService;
	/*
	 * 增加
	 */ 
	@Override
	public Map<String, Object> save(ReportRequirementModel reportRequirementModel,List<Long> appendixIds) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map = new HashMap<String, Object>();
		reportRequirementModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
		reportRequirementModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
		reportRequirementModel.setCreateTime(new Date());
		reportRequirementModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
		mapper.insert(reportRequirementModel);
		map.put("reportRequirementId", reportRequirementModel.getPlanReportRequirementId().toString());
		for (Long appendixId : appendixIds) {
			UpdateBusinessIdInProjectAppendixModelVo<ReportRequirementModel> model = new UpdateBusinessIdInProjectAppendixModelVo<ReportRequirementModel>();
			model.setAppendixId(appendixId);
			model.setBusinessAppendixId(reportRequirementModel.getPlanReportRequirementId());
			mapper.updateBusinessIdInTProjectAppendix(model);
		}
		return map;
	}

	/*
	 * 删除
	 */
	@Override
	public Map<String, Object> delete(Long planReportRequirementId) {
		// TODO Auto-generated method stub
		if ( planReportRequirementId == null) {
            throw new SystemParamCheckException("汇报要求id传入异常，无法进行删除");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		ReportRequirementModel selectByPrimaryKeyWithDelStatus = mapper.selectByPrimaryKeyWithDelStatus(planReportRequirementId);
		selectByPrimaryKeyWithDelStatus.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		selectByPrimaryKeyWithDelStatus.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		selectByPrimaryKeyWithDelStatus.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelectiveWithDelStatus(selectByPrimaryKeyWithDelStatus);
		return map;
	}

	@Override
	public Map<String, Object> update(ReportRequirementModel reportRequirementModel) {
		// TODO Auto-generated method stub
		if ( reportRequirementModel == null || reportRequirementModel.getPlanReportRequirementId()==null) {
            throw new SystemParamCheckException("汇报要求id传入异常，无法进行修改");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		reportRequirementModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
		reportRequirementModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
		reportRequirementModel.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(reportRequirementModel);
		return map;
	}

	@Override
	public List<ReportRequirementModelVo> getAll(PageInfoFromFrontModel page) {
		// TODO Auto-generated method stub
		if ( page == null || page.getPlanId()==null) {
            throw new SystemParamCheckException("计划id传入异常，无法进行查询");
        }
		List<ReportRequirementModel> modelList = mapper.selectAllByPlanIdWithDelStatus(page);
		List<ReportRequirementModelVo> modelVoList = new ArrayList<ReportRequirementModelVo>();
		modelList.stream().forEach((model)->{
			ReportRequirementModelVo modelVo = new ReportRequirementModelVo(model);
			//添加附件id及名称列表信息
			modelVo.setAppendixInfos(planService.selectAppendixIDAndNameInfoByBusinessId(model.getPlanReportRequirementId()));
			//添加汇报方式str
			modelVo.setPlanReportRequirementMethodStr(PlanReportRequirementMethodEnum.getValue(model.getPlanReportRequirementMethod().intValue()));
			modelVoList.add(modelVo);
		});
		
		return modelVoList;
	}

	@Override
	public Map<String, Object> getOne(Long planReportRequirementId) {
		// TODO Auto-generated method stub
		if ( planReportRequirementId ==null) {
            throw new SystemParamCheckException("汇报要求id传入异常，无法进行查询");
        }
		Map<String,Object> map = new HashMap<String, Object>();
		ReportRequirementModel selectByPrimaryKey = mapper.selectByPrimaryKeyWithDelStatus(planReportRequirementId);
		map.put("statusData",selectByPrimaryKey);
		return map;
	}

	@Override
	public List<ReportRequirementModel> getAll(Long planId) {
		// TODO Auto-generated method stub
		if ( planId ==null) {
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

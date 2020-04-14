package com.fea.project.service.plan;

import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.plan.vo.AppendixModelVo;
import com.fea.project.model.plan.vo.BusinessAppendixModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IPlanAppendixService {

	Map<String,Object> save(PlanAppendixModel planAppendixModel,List<Long> appendixIds);
	void delete(Long planAppendixId);
	void update(PlanAppendixModel planAppendixModel);
	List<AppendixModelVo> getAll(PageInfoFromFrontModel page);
	List<PlanAppendixModel> getAll(Long businessId);
	Map<String,Object> getOne(Long planAppendixId);
	
	Integer updateByList( Long businessId , List<Long> list ,String businessName,Long projectId,Long projectStep);
	Integer deleteByBusinessId(Long businessId);
	
	
	   /**
     * 通过主键获取详情
     * @param planAppendixId
     * @return
     */
    BusinessAppendixModelVo selectByBusinessAppendixId(Long businessAppendixId);
    
    Integer update_v2(BusinessAppendixModelVo businessAppendixModelVo);
}
  
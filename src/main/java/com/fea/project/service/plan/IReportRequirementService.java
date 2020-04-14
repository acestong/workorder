package com.fea.project.service.plan;

import com.fea.project.model.plan.ReportRequirementModel;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.ReportRequirementModelVo;

import java.util.List;
import java.util.Map;

public interface IReportRequirementService {

	Map<String,Object> save(ReportRequirementModel reportRequirementModel,List<Long> appendixIds);
	Map<String,Object> delete(Long planReportRequirementId);
	Map<String,Object> update(ReportRequirementModel reportRequirementModel);
	List<ReportRequirementModelVo> getAll(PageInfoFromFrontModel page);
	List<ReportRequirementModel> getAll(Long planId);
	Map<String,Object> getOne(Long planReportRequirementId);
	
	 /*
     * 批量修改交付要求的业务id
     */
    Integer updateByList(Long businessId , List<Long>list);
    Integer deleteByBusinessId(Long businessId);
}
  
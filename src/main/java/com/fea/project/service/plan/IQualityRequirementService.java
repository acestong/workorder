package com.fea.project.service.plan;

import com.fea.project.model.plan.QualityRequirementModel;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;

import java.util.List;
import java.util.Map;

public interface IQualityRequirementService {

	Map<String,Object> save(QualityRequirementModel qualityRequirementModel,List<Long> appendixIds);
	Map<String,Object> delete(Long planQualityRequirementId);
	Map<String,Object> update(QualityRequirementModel qualityRequirementModel);
	List<Object> getAll(PageInfoFromFrontModel page);
	List<QualityRequirementModel> getAll(Long planId);
	Map<String,Object> getOne(Long planQualityRequirementId);
	
	  /*
     * 批量修改交付要求的业务id
     */
    Integer updateByList(Long businessId , List<Long>list);
    Integer deleteByBusinessId(Long businessId);
}
  
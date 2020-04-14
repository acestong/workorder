package com.fea.project.service.plan;

import com.fea.project.model.plan.DeliverRequirementModel;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface IDeliverRequirementService {

	Map<String, Object> save(DeliverRequirementModel deliverRequirementModel,List<Long> appendixIds);
	Map<String, Object> delete(Long planDeliverRequirementId);
	Map<String,Object> update(DeliverRequirementModel deliverRequirementModel);
	List<DeliverRequirementModel> getAll(PageInfoFromFrontModel page);
	List<DeliverRequirementModel> getAll(Long taskId);
	Map<String,Object> getOne(Long planDeliverRequirementId);
	
	Integer updateByList(Long businessId ,List<Long>list);
	Integer deleteByBusinessId(Long businessId);
}
  
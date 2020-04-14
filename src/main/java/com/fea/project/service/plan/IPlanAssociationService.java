package com.fea.project.service.plan;

import com.fea.project.model.plan.PlanAssociationModel;
import com.fea.project.model.plan.vo.BusinessAssociationShowModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IPlanAssociationService {

	Map<String,Object> save(PlanAssociationModel planAssociationModel);
	Map<String,Object> delete(Long planAssociationId);
	Map<String,Object> update(PlanAssociationModel planAssociationModel);
	List<BusinessAssociationShowModelVo> getAll(PageInfoFromFrontModel page);
	List<PlanAssociationModel> getAll(Long planId);
	Map<String,Object> getOne(Long planAssociationId);
	Map<String,Object> getAssociationInfoByPlanId(Long planId);
	
	  /*
     * 批量修改交付要求的业务id
     */
    Integer updateByList(Long businessId , List<Long>list);
    Integer deleteByBusinessId(Long businessId);
}
  
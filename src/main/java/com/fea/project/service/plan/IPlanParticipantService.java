package com.fea.project.service.plan;

import com.fea.project.model.plan.PlanParticipantModel;
import com.fea.project.model.plan.vo.ProjectUserIdAndNameInfoModelVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IPlanParticipantService {

	List<Long> save(List<Long> planParticipantUserIds);
	Long save(PlanParticipantModel participantModel);
	List<ProjectUserIdAndNameInfoModelVO> getAll(Long planId);
	List<PlanParticipantModel> selectPlanParticipantListByPlanId(Long planId);
	List<PlanParticipantModel> getAllPlanParticipantList(Long planId);
	Map<String,Object> delete(PlanParticipantModel participantModel);
	Map<String,Object> update(PlanParticipantModel participantModel);
	PlanParticipantModel selectOneByPlanIdAndPlanPaticipantUserId(Long planId,Long planPaticipantUserId);
	
	 Integer insertByList(List<PlanParticipantModel> list);
	 Integer deleteByPlanId(Long planId);
}
 
package com.fea.project.service.plan;

import com.fea.project.model.plan.PlanHeadStatusModel;

public interface IPlanHeadStatusService {

	void save(PlanHeadStatusModel planHeadStatusModel);
	void delete(Long planHeadStatusId);
	void update(PlanHeadStatusModel planHeadStatusModel);
	PlanHeadStatusModel getOne(Long curUserId);
}
 
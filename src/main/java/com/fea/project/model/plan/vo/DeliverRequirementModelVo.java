package com.fea.project.model.plan.vo;

import java.util.Date;
import java.util.List;

import com.fea.project.model.plan.DeliverRequirementModel;
import com.fea.project.model.plan.PlanAppendixModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverRequirementModelVo extends DeliverRequirementModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PlanAppendixModel> appendixInfosList;
	
}

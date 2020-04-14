package com.fea.project.model.plan.vo;

import com.fea.project.model.plan.PlanAssociationModel;

import lombok.Data;

@Data
public class BusinessAssociationShowModelVo extends PlanAssociationModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String planAssociationName;
	
	
	private String planStepStr;
	
	
	private String leaderName;
	
	
	private String teamName;
	
	
	private String relationShipStatusStr;
	
	
	private String executeStatusStr;
	
}

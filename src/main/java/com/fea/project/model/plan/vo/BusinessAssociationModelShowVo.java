package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class BusinessAssociationModelShowVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planAssociationId;
	
	private String planAssociationName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planStep;
	
	private String planStepStr;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING) 
	private Long leaderId;
	
	private String leaderName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long teamId;
	
	private String teamName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long relationshipStatus;
	
	private Long relationShipStatusStr;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long executeStatus;
	
	private String executeStatusStr;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long delStatus;
}

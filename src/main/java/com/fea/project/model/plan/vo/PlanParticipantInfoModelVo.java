package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class PlanParticipantInfoModelVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long participantId;
	
	private String participantName; 
}

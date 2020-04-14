package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.PlanModel;
import lombok.Data;

import java.util.List;

@Data
public class PlanWithAllAppendixModelVO {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessAppendixId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long qualityRequirementId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long reportRequirementId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long deliverRequirementId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessAssociationId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessPanticipantId;
	private String businessName;
	
	
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> businessAppendixIds; 
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> qualityRequirementIds;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> reportRequirementIds;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> deliverRequirementIds;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> businessAssociationIds;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> businessParticipantUserIds;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> businessPanticipantIds;
    
    private PlanModel model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectStep;
}

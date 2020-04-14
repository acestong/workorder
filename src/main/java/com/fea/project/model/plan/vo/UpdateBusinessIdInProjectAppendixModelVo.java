package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
public class UpdateBusinessIdInProjectAppendixModelVo<T> {

	private T model;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long appendixId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long deliverRequirementId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long qualityRequirementId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long reportRequirementId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long BusinessAppendixId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Long> appendixIds; 
	
	private String businessName;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long projectId;
	
	private Long businessType;
	
	private Long projectStep;
}

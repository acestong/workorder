package com.fea.project.model.task.vo;

import lombok.Data;

import java.util.List;

@Data
public class UpdateBusinessIdInProjectAppendixModelVo<T> {

	private T model;
	private Long appendixId;
	private Long deliverRequirementId;
	private Long qualityRequirementId;
	private Long reportRequirementId;
	private Long taskAppendixId;
	private Long deliverProductId;
	private List<Long> appendixIds; 
}

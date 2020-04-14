package com.fea.project.model.task.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.task.TaskModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskWithAllAppendixModelVo {

	private TaskModel model;
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
	private Long taskPanticipantId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
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
    private List<Long> taskParticipantUserIds;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> taskPanticipantIds;
    
    /*
     * 为保证资料模块可查询，此处添加资料模块所需的字段
     */
    private Long projectId;
    
    private Long projectStep;
    
    private Long businessType;
    
    public TaskWithAllAppendixModelVo(Long businessId,Long businessAssociationId) {
    	this.businessId = businessId;
    	this.businessAssociationId = businessAssociationId;
    }
    
    public TaskWithAllAppendixModelVo(Long businessId,Long businessAppendixId,Long projectId,Long projectStep) {
    	this.businessId = businessId;
    	this.businessAppendixId = businessAppendixId;
    	this.projectId = projectId;
    	this.projectStep = projectStep;
    }
    
    public TaskWithAllAppendixModelVo(Long businessId) {
    	this.businessId = businessId;
    }
}
 
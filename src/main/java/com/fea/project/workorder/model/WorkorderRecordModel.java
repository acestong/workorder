package com.fea.project.workorder.model;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.workorder.configure.annotation.WorkorderLogAnno;
import com.fea.project.workorder.enums.OptionResultEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkorderRecordModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long recordId;

    private String optionTitle;

    private String operationName;

    private Long resultType;

    private String result;

    private String optionUserType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long optionUserId;

    private String optionUserName;

    private String optionTimeType;

    private Date optionTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    private static final long serialVersionUID = 1L;

    
    public WorkorderRecordModel(WorkorderLogAnno annotation, Long userId, String realName) {
		// TODO Auto-generated constructor stub
    	Long resultType = annotation.resultType();
    	this.resultType = resultType;
    	this.optionTitle = OptionResultEnum.getRecordTitle(resultType.intValue());
    	this.operationName = OptionResultEnum.getValue(resultType.intValue());
    	this.optionTimeType = OptionResultEnum.getTimeType(resultType.intValue());
    	this.optionUserType = OptionResultEnum.getPersonType(resultType.intValue());
    	this.optionUserId = userId;
    	this.optionUserName = realName;
    	this.optionTime = new Date();
    	
	}
  
}
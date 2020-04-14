package com.fea.project.workorder.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionModel implements Serializable {
    private Long optionId;

    private String optionName;

    private Date optionTime;

    private Date planStartTime;

    private Date planEndTime;

    private Date actualStartTime;

    private Date actualEndTime;

    private Long businessType;

    private Long businessId;

    private String businessName;
    
    private Long workorderId;

    private static final long serialVersionUID = 1L;
    
    public OptionModel(Date actualStartTime , Date actualEndTime){
    	this.optionName = "";
    	this.optionTime = new Date();
    	this.actualEndTime = actualEndTime;
    	this.actualStartTime = actualStartTime;
    	
    }
}
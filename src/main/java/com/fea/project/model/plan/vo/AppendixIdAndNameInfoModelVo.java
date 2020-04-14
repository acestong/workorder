package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AppendixIdAndNameInfoModelVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long appendixId; 
	private String appendixName;  
}
 
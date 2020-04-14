package com.fea.project.model.plan.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.PlanAppendixModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppendixModelVo {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessAppendixId;
	
	private String businessAppendixName;
	
	private Long businessAppendixType;
	
	private String businessAppendixTypeStr;
	
	private String businessAppendixDesc;
	
	private List<AppendixInfosVo> appendixInfosList;
}

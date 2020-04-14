package com.fea.project.model.plan.vo;

import java.util.List;

import com.fea.project.model.plan.PlanAppendixModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAppendixModelVo extends PlanAppendixModel {

	private static final long serialVersionUID = 1L;

	private String businessAppendixTypeStr;
	
	private List<AppendixIdAndNameInfoModelVo> appendixInfoList;
	
	private List<Long> appendixIdList;
}

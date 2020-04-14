package com.fea.project.model.task.vo;

import java.util.List;

import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.task.TaskWorkReportModel;

import lombok.Data;

@Data
public class ReportModelVo extends TaskWorkReportModel {
	
	

	private static final long serialVersionUID = 1L;
	
	private Double taskProgrossRate;
	
	private List<PlanAppendixModel> appendixList;
	

	
}

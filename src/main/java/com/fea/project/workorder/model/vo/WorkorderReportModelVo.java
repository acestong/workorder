package com.fea.project.workorder.model.vo;

import java.util.Date;

import com.fea.project.workorder.model.WorkorderReportModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工单汇报Vo
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkorderReportModelVo extends WorkorderReportModel{

	private static final long serialVersionUID = 1L;

	
	private String status;
	
	private Date planStartTime;
	
	private Date planEndTime;
	
	private Double planWorkHour;
}

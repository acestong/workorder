package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.workorder.model.ProcedureReportModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工序汇报modelVo
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureReportModelVo extends ProcedureReportModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 插入数据时使用,仅存id
	 */
	private List<Long> appendixList;
	
	/**
	 * 返回附件中存的id和name
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<AppendixIdAndNameInfoModelVo> appendixInfoList;
	
}

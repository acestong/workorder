package com.fea.project.model.plan.vo;

import java.io.Serializable;
import java.util.List;

import com.fea.project.model.plan.ReportRequirementModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequirementModelVo extends ReportRequirementModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 汇报方式字符串
	 */
	private String planReportRequirementMethodStr;
	
	/**
	 * 附件id及名称列表
	 */
	private List<AppendixIdAndNameInfoModelVo> appendixInfos;  
	
	
	public ReportRequirementModelVo(ReportRequirementModel model) {
		super(model.getPlanReportRequirementId(), model.getPlanReportRequirementTheme(), model.getPlanReportRequirementTime(), 
				model.getPlanReportRequirementMethod(), model.getPlanReportRequirement(), model.getPlanReportAppendixId(), 
				model.getAppendixModel(), model.getPlanId(), model.getPlanModel(), model.getCreateId(), model.getCreateBy(),
				model.getCreateTime(), model.getUpdateId(), model.getUpdateBy(), model.getUpdateTime(), model.getDelStatus());
	}
}

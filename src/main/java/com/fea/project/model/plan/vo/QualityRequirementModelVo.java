package com.fea.project.model.plan.vo;

import java.util.List;

import com.fea.project.model.plan.QualityRequirementModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualityRequirementModelVo extends QualityRequirementModel{

	private static final long serialVersionUID = 1L;
	
	
	private List<AppendixIdAndNameInfoModelVo> appendixInfos;  
	
	public QualityRequirementModelVo(QualityRequirementModel model) {
		super.setCreateBy(model.getCreateBy());
		super.setCreateId(model.getCreateId());
		super.setCreateTime(model.getCreateTime());
		super.setDelStatus(model.getDelStatus());
		super.setPlanId(model.getPlanId());
		super.setPlanQualityAppendixId(model.getPlanQualityAppendixId());
		super.setPlanQualityRequirementContent(model.getPlanQualityRequirementContent());
		super.setPlanQualityRequirementId(model.getPlanQualityRequirementId());
		super.setPlanQualityRequirementName(model.getPlanQualityRequirementName());
		super.setUpdateBy(model.getUpdateBy());
		super.setUpdateId(model.getUpdateId());
		super.setUpdateTime(model.getUpdateTime());
	}
}

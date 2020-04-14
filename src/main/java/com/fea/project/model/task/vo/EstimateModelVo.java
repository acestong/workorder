package com.fea.project.model.task.vo;

import java.util.List;

import com.fea.project.model.task.PercentSettingModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimateModelVo {

	/*
	 * 质量权重
	 */
	private Double qualityEstimateWeight;
	/*
	 * 时间权重
	 */
	private Double timeEstimateWeight;
	/*
	 * 优秀，优异 ，及格等相关设置集合
	 */
	private List<PercentSettingModelVo> actionList;
}

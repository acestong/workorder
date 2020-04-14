package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fea.project.workorder.model.PoolModel;
import com.fea.project.workorder.model.PoolRuleModel;
import com.fea.project.workorder.model.VisiblePersonModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工单池modelVo
 * @author st
 * @since 2020/03/18
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolModelVo extends PoolModel{

	private static final long serialVersionUID = 1L;

	private List<PoolRuleModel> ruleList;
	
	private List<PoolAutoDispatchModelVo> dispatchList;
	
	private List<VisiblePersonModel> visiblePersonList;
}

package com.fea.project.workorder.model.vo;

import com.fea.project.workorder.model.PoolModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AOP中 AutoDispatchWorkorderHandler中使用的modelVo
 * @author st
 * @since 2020/03/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolExistModelVo {

	private PoolModel pool;
	
	private Boolean isContainRule;
}

package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.workorder.model.MouldModel;
import com.fea.project.workorder.model.ProcedureModel;

import lombok.Data;

/**
 * 工单模板modelVo
 * @author st
 * @since 2020/03/20
 *
 */
@Data
public class MouldModelVo extends MouldModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 工序id列表，新建时使用
	 */
	private List<Long> procedureList;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<ProcedureModelVo> procedureInfoList;
}

package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.workorder.model.ParticipantModel;
import com.fea.project.workorder.model.ProcedureModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工序模板id
 * @author st
 * @since 2020/03/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureModelVo extends ProcedureModel {

	private static final long serialVersionUID = 1L;
	
	//附件id列表,新建时使用
	private List<Long> appendixList;
	
	//参与人列表
	private List<ParticipantModel> participantList;
	
	//前置工序名称
	private String preProcedureName;
	
	//附件列表信息，详情页面使用
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<AppendixIdAndNameInfoModelVo> appendixInfoList;

}

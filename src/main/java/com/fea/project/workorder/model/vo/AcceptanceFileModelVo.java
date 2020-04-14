package com.fea.project.workorder.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.workorder.model.AcceptanceFileModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验收文件modelVo
 * @author Administrator
 * @since 2020/03/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcceptanceFileModelVo extends AcceptanceFileModel{

	private static final long serialVersionUID = 1L;
	
	
	private List<Long> appendixList;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<AppendixIdAndNameInfoModelVo> appendixInfoList;
}

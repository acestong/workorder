package com.fea.project.workorder.model.vo;

import com.fea.project.workorder.model.AcceptanceContentModel;

import lombok.Data;

/**
 * 验收内容ModelVo
 * @author st
 * @sicne 2020/03/24
 *
 */
@Data
public class AcceptanceContentModelVo extends AcceptanceContentModel {

	private static final long serialVersionUID = 1L;

	private String unitStr;
	
	private String conclusionStr;
}

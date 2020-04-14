package com.fea.project.workorder.model.vo;

import com.fea.project.workorder.model.AcceptanceModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcceptanceModelVo extends AcceptanceModel{

	private static final long serialVersionUID = 1L;

	private String conclusionStr;
}

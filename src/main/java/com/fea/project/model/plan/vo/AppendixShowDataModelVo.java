package com.fea.project.model.plan.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppendixShowDataModelVo<T> {

	private T model;
	private List<AppendixIdAndNameInfoModelVo> appendixInfos;  
	private String planAppendixTypeStr;
}
 
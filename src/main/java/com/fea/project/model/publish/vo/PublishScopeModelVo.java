package com.fea.project.model.publish.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.publish.PublishScopeModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PublishScopeModelVo extends PublishScopeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//获取可见范围中的部门集合,Long 存放部门id，String存放部门名称
	@JsonFormat(shape = JsonFormat.Shape.STRING)
		private List<Map<Long,String>> scopeDepartmentList;
		
		//获取可见范围中的用户集合,Long 存放用户id，String存放用户名称
	@JsonFormat(shape = JsonFormat.Shape.STRING)
		private List<Map<Long,String>> scopePersonList;
}

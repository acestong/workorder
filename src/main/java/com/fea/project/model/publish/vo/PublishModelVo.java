package com.fea.project.model.publish.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.publish.PublishModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PublishModelVo extends PublishModel {

	//后台接收ip获取定位
	private String ip;
	
	//获取可见范围中的部门集合,Long 存放部门id，String存放部门名称
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Map<Long,String>> scopeDepartmentList;
	
	//获取可见范围中的用户集合,Long 存放用户id，String存放用户名称
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Map<Long,String>> scopePersonList;
	
	//获取@提醒的用户id以及用户名集合，Long 存放用户id，String存放用户名称
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Map<Long,String>> appointUserList;
	
	//上传所有附件，存放附件id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Long> appendixIdList;	
	
	//上传图片id和路径集合，Long存放图片上传id，String存放图片路径
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private List<Map<Long,String>> imageInfoList;
}

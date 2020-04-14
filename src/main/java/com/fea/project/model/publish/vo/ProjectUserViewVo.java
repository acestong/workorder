package com.fea.project.model.publish.vo;

import lombok.Data;

@Data
public class ProjectUserViewVo {

	//项目Id
	private Long projectId;
	//团队Id
	private Long teamId;
	//团队名称
	private String teamName;
	//用户Id
	private Long userId;
	//用户名称
	private String userName;
	//手机号
	private String phone;
	//邮箱
	private String email;
	//性别
	private Long gender;
	//性别字符串
	private String genderStr;
}

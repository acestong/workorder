package com.fea.project.model.publish.vo;

import lombok.Data;

import java.util.Date;

@Data
public class EmpInfoVo {
	//用户员工Id
	private Long empId;
	//员工姓名
	private String empName;
	//员工编码
	private String empCode;
	//公司名称
	private String orgName;
	//部门名称
	private String deptName;
	//性别
	private Long gender;
	//性别字符串
	private String genderStr;
	//邮箱
	private String email;
	//固定电话
	private String telephone;
	//手机
	private String phone;
	//职业
	private String job;
	//用户头像
	private String imagePath;
	//工作状态
	private Long workStatus;
	//工作状态str
	private String workStatusStr;
	//任务开始时间
	private Date taskStartTime;
	//任务结束时间
	private Date taskEndTime;
	//任务工时
	private Long workHour;
}

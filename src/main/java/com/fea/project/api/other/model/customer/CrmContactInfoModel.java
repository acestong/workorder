package com.fea.project.api.other.model.customer;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author st
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrmContactInfoModel implements Serializable{

	private static final long serialVersionUID = 1L;

	/*
	 * 联系人Id
	 */
	private Long id;
	
	/*
	 * 联系人名称
	 */
	private String contactName;
	
	/*
	 * 联系电话
	 */
	private String tel;
	
	/*
	 * 电子邮箱
	 */
	private String email;
	
	/*
	 * 部门名称
	 */
	private String departmentName;
	
	/*
	 * 职位名称
	 */
	private String position;
	
	/*
	 * 详细地址
	 */
	private String address;

}

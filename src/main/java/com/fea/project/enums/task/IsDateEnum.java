package com.fea.project.enums.task;

public enum IsDateEnum {

	IS_DATE(0,"需要日期"),
	IS_NOT_DATE(1,"不需要日期");
	
	private Integer status;
	private String info;
	private IsDateEnum(Integer status, String info) {
		this.status = status;
		this.info = info;
	}
	public Integer getStatus() {
		return status;
	}
	public String getInfo() {
		return info;
	}
	 
	
}

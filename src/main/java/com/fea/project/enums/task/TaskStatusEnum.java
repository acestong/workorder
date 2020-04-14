package com.fea.project.enums.task;

public enum TaskStatusEnum {

	UNPERMITTED(0,"草稿状态"),
	PASS(1,"提交状态");
	
	private Integer status;
	private String info;
	private TaskStatusEnum(Integer status, String info) {
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

package com.fea.project.enums.task;

public enum TaskSortEnum {

	TASK(0,"任务"),
	SON_TASK(1,"子任务");
	
	private Integer status;
	private String info;
	private TaskSortEnum(Integer status, String info) {
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

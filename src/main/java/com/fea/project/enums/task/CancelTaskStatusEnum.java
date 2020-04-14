package com.fea.project.enums.task;

public enum CancelTaskStatusEnum {

	CANCEL_TASK(0,"取消任务"),
	NOT_CANCEL_TASK(1,"未取消任务");
	
	private Integer status;
	private String info;
	private CancelTaskStatusEnum(Integer status, String info) {
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

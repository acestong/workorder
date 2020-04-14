package com.fea.project.enums.task;

public enum StopTaskStatusEnum {

	STOP_TASK(0,"终止任务"),
	NOT_STOP_TASK(1,"未终止任务");
	
	private Integer status;
	private String info;
	private StopTaskStatusEnum(Integer status, String info) {
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

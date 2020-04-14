package com.fea.project.enums.task;

public enum RestartTaskStatusEnum {

	RESTART_TASK(0,"重启任务"),
	NOT_RESTART_TASK(1,"未重启任务");
	
	private Integer status;
	private String info;
	private RestartTaskStatusEnum(Integer status, String info) {
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

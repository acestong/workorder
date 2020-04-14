package com.fea.project.enums.task;

public enum WorkTaskStatusEnum {

	IS_WORKTASK(0,"工作任务"),
	IS_NOT_WORKTASK(1,"非工作任务");
	
	private Integer status;
	private String info;
	private WorkTaskStatusEnum(Integer status, String info) {
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

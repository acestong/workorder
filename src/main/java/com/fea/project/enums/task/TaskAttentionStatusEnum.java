package com.fea.project.enums.task;

public enum TaskAttentionStatusEnum {

	ATTENTION(1,"关注"),
	NOT_ATTENTION(0,"取消关注");
	
	private Integer status;
	private String info;
	private TaskAttentionStatusEnum(Integer status, String info) {
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

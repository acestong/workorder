package com.fea.project.enums.task;

public enum IsHeadLetterEnum {

	IS_HEAD_LETTER(0,"需要开头字母"),
	IS_NOT_HEAD_LETTER(1,"不需要开头字母");
	
	private Integer status;
	private String info;
	private IsHeadLetterEnum(Integer status, String info) {
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

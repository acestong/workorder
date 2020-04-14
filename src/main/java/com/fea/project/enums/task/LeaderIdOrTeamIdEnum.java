package com.fea.project.enums.task;

public enum LeaderIdOrTeamIdEnum {

	LEADER(0,"负责人"),
	TEAM(1,"团队");
	
	private Integer status;
	private String info;
	private LeaderIdOrTeamIdEnum(Integer status, String info) {
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

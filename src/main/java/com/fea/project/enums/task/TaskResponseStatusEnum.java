package com.fea.project.enums.task;


public enum TaskResponseStatusEnum {

	RRSPONSE_TASK(1,"响应任务"),
	NOT_RESPONSE_TASK(2,"退回任务");
	
	private Integer status;
	private String info;
	private TaskResponseStatusEnum(Integer status, String info) {
		this.status = status;
		this.info = info;
	}
	public Integer getStatus() {
		return status;
	}
	public String getInfo() {
		return info;
	}
	 
	public static String getValue(Integer value) {  
		TaskResponseStatusEnum[] taskResponseStatusEnums = values();  
        for (TaskResponseStatusEnum taskResponseStatusEnum : taskResponseStatusEnums) {  
            if (taskResponseStatusEnum.getStatus().equals(value)) {  
                return taskResponseStatusEnum.getInfo();  
            }  
        }  
        return null;  
    }  
}

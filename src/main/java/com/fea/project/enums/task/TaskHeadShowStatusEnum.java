package com.fea.project.enums.task;

public enum TaskHeadShowStatusEnum {

	SHOWN(0,"显示"),
	Hidden(1,"隐藏");
	
	private Integer status;
	private String info;
	private TaskHeadShowStatusEnum(Integer status, String info) {
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
		TaskHeadShowStatusEnum[] taskModelEnums = values();  
        for (TaskHeadShowStatusEnum taskModelEnum : taskModelEnums) {  
            if (taskModelEnum.getStatus().equals(value)) {  
                return taskModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

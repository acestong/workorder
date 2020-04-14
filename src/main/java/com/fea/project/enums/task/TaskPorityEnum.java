package com.fea.project.enums.task;

public enum TaskPorityEnum {

	HIGHEST(1,"最高"),
	HIGH(2,"高"),
	MIDDLE(3,"中"),
	LOW(4,"低");
	 
	private Integer status;
	private String info;
	
	private TaskPorityEnum(Integer status, String info) {
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
		TaskPorityEnum[] planModelEnums = values();  
        for (TaskPorityEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

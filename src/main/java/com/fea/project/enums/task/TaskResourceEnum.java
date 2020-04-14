package com.fea.project.enums.task;

public enum TaskResourceEnum {

	PROJECT_TASK(0,"项目任务"),
	NORMAL_TASK(1,"常规任务"),
	GROUP_TASK(2,"协作组任务"),
	SALE_CHANCE_TASK(3,"销售机会任务"),
	MARKET_CLUE_TASK(4,"市场线索任务");
	
	private Integer status;
	private String info;
	private TaskResourceEnum(Integer status, String info) {
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
		TaskResourceEnum[] taskResourceEnums = values();  
        for (TaskResourceEnum taskResourceEnum : taskResourceEnums) {  
            if (taskResourceEnum.getStatus().equals(value)) {  
                return taskResourceEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

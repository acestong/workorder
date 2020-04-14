package com.fea.project.enums.plan;

public enum PlanExecutionStatusEnum {
 
	SHOWN(0,"显示"),
	HIDDEN(1,"隐藏");
	
	private Integer status;
	private String info;
	private PlanExecutionStatusEnum(Integer status, String info) {
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
		PlanExecutionStatusEnum[] planModelEnums = values();  
        for (PlanExecutionStatusEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

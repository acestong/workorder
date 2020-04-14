package com.fea.project.enums.plan;

public enum PlanHeadShowStatusEnum {

	SHOWN(0,"显示"),
	Hidden(1,"隐藏");
	
	private Integer status;
	private String info;
	private PlanHeadShowStatusEnum(Integer status, String info) {
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
		PlanHeadShowStatusEnum[] planModelEnums = values();  
        for (PlanHeadShowStatusEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

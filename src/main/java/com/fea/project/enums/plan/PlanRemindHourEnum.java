package com.fea.project.enums.plan;

/**
 * 新建计划提醒时间
 * @author st
 * @since 2019/11/4 9:50
 *
 */
public enum PlanRemindHourEnum {
 
	HALF_HOUR(1,"0.5H"),
	HOUR(2,"1H"),
	HOUR_AND_A_HALF(3,"1.5H"),
	TWO_HOUR(4,"2H");
	
	private Integer status;
	private String info;
	 
	private PlanRemindHourEnum(Integer status, String info) {
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
		PlanRemindHourEnum[] planModelEnums = values();  
        for (PlanRemindHourEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

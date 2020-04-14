package com.fea.project.enums.plan;

/**
 *项目阶段枚举
 * @author st
 * @since 2019/11/4 9:58
 *
 */
public enum ProjectStepEnum {

	PERIOD_ONE(1,"第一阶段"),
	PERIOD_TWO(2,"第二阶段"),
	PERIOD_THREE(3,"第三阶段");
	 
	private Integer status;
	private String info;
	
	 
	private ProjectStepEnum(Integer status, String info) {
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
		ProjectStepEnum[] planModelEnums = values();  
        for (ProjectStepEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

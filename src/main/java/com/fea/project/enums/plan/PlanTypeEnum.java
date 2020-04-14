package com.fea.project.enums.plan;
/**
 * 计划版本枚举
 * @author st
 * @since 2019/11/4 9:54
 *
 */
public enum PlanTypeEnum {

	PLAN(1,"项目计划"),
	TEAM_PLAN(2,"团队计划"),
	TEAMER_PLAN(3,"团队成员计划");
	  
	private Integer status;
	private String info;
	
	
	private PlanTypeEnum(Integer status, String info) {
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
		PlanTypeEnum[] planCheckStatusEnums = values();  
        for (PlanTypeEnum planCheckStatusEnum : planCheckStatusEnums) {  
            if (planCheckStatusEnum.getStatus().equals(value)) {  
                return planCheckStatusEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

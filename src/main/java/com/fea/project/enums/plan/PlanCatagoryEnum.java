package com.fea.project.enums.plan;
/**
 * 计划版本枚举
 * @author st
 * @since 2019/11/4 9:54
 *
 */
public enum PlanCatagoryEnum {

	PROJECT_PLAN(1,"项目计划"),
	PROJECT_USER_PLAN(2,"项目成员计划"),
	TEAM_PLAN(3,"团队计划"),
	TEAM_USER_PLAN(4,"团队成员计划"),
	USER_PLAN(5,"个人计划");
	  
	private Integer status;
	private String info;
	
	
	private PlanCatagoryEnum(Integer status, String info) {
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
		PlanCatagoryEnum[] planModelEnums = values();  
        for (PlanCatagoryEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

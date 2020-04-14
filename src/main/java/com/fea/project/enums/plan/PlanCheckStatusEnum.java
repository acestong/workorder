package com.fea.project.enums.plan;
/**
 * 计划版本枚举
 * @author st
 * @since 2019/11/4 9:54
 *
 */
public enum PlanCheckStatusEnum {

	NOT_COMMIT(0,"未提交"),
	COMMITTED(1,"已提交"),
	CHECKING(2,"审批中"),
	PASS(3,"已通过"),
	UNPASS(4,"未通过");
	  
	private Integer status;
	private String info;
	
	
	private PlanCheckStatusEnum(Integer status, String info) {
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
		PlanCheckStatusEnum[] planCheckStatusEnums = values();  
        for (PlanCheckStatusEnum planCheckStatusEnum : planCheckStatusEnums) {  
            if (planCheckStatusEnum.getStatus().equals(value)) {  
                return planCheckStatusEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

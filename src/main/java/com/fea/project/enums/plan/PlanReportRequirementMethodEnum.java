package com.fea.project.enums.plan;

/**
 * 汇报计划方式枚举
 * @author st
 * @since 2019/11/4 9:51
 *
 */
public enum PlanReportRequirementMethodEnum {
 
	WITTEN(1,"书面汇报"),
	FACE_TO_FACE(2,"当面汇报"),
	APPOINTMENT(3,"会议汇报"),
	CELLPHONE(4,"电话汇报"),
	EMILE(5,"邮件汇报");
	 
	private Integer status;
	private String info;
	
	
	private PlanReportRequirementMethodEnum(Integer status, String info) {
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
		PlanReportRequirementMethodEnum[] planModelEnums = values();  
        for (PlanReportRequirementMethodEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

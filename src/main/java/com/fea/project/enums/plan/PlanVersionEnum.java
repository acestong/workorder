package com.fea.project.enums.plan;
/**
 * 计划版本枚举
 * @author st
 * @since 2019/11/4 9:54
 *
 */
public enum PlanVersionEnum {

	V1_0(1,"V1.0版本"),
	V2_0(2,"V2.0版本");
	 
	private Integer status;
	private String info;
	 
	
	private PlanVersionEnum(Integer status, String info) {
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
		PlanVersionEnum[] planModelEnums = values();  
        for (PlanVersionEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

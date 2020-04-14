package com.fea.project.enums.plan;

/**
 * 关联计划中关联关系枚举
 * @author st
 * @since 2019/11/4 9:33
 *
 */
public enum PlanAssociationRelationshipEnum {
 
	back(1,"back"),
	front(2,"front");
	
	private Integer status;
	private String info;
	
	 
	private PlanAssociationRelationshipEnum(Integer status, String info) {
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
		PlanAssociationRelationshipEnum[] planModelEnums = values();  
        for (PlanAssociationRelationshipEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {  
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  

	
	
}

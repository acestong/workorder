package com.fea.project.enums.plan;

public enum RelationshipEnum {

	FRONT(1,"前置关系"),
	BACK(2,"后置关系"),
	PARALLEL(3,"并行关系");
	 
	private Integer status;
	private String info;
	
	private RelationshipEnum(Integer status, String info) {
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
		RelationshipEnum[] planModelEnums = values();  
        for (RelationshipEnum planModelEnum : planModelEnums) {  
            if (planModelEnum.getStatus().equals(value)) {
                return planModelEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

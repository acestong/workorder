package com.fea.project.enums.publish;


public enum ScopeEnum {

	DEPARTMENT(0,"部门"),
	PERSON(1,"个人");
	
	private Integer status;
    private String info;
    
	private ScopeEnum(Integer status, String info) {
		this.status = status;
		this.info = info;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	 
		public static String getValue(Integer value) {  
			ScopeEnum[] isReadEnums = values();  
	        for (ScopeEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

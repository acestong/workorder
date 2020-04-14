package com.fea.project.enums.publish;


public enum GenderEnum {

	MALE(1,"男"),
	FEMALE(2,"女"),
	SECRET(3,"保密");
	
	private Integer status;
    private String info;
    
	private GenderEnum(Integer status, String info) {
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
			GenderEnum[] isReadEnums = values();  
	        for (GenderEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

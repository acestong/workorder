package com.fea.project.enums.publish;


public enum IsReadEnum {

	IS_NOT_READ(0,"未读"),
	IS_READ(1,"已读");
	
	private Integer status;
    private String info;
    
	private IsReadEnum(Integer status, String info) {
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
			IsReadEnum[] isReadEnums = values();  
	        for (IsReadEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

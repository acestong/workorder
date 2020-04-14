package com.fea.project.enums.publish;


public enum BusinessTypeEnum {

	DESKTOP_PUB(1,"动态"),
	PROJECT_PUB(2,"项目动态"),
	GROUP_PUB(3,"协作组动态");
	
	private Integer status;
    private String info;
    
	private BusinessTypeEnum(Integer status, String info) {
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
			BusinessTypeEnum[] isReadEnums = values();  
	        for (BusinessTypeEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

package com.fea.project.enums.publish;


public enum PublicScopeEnum {

	PUBLIC(1,"公开"),
	PARTICIALLY(0,"部分可见"),
	ALL_PROJECR_MEMBER(2,"全部项目组成员"),
	PARTICIALLY_PROJECR_MEMBER(3,"部分可见");
	
	private Integer status;
    private String info;
    
	private PublicScopeEnum(Integer status, String info) {
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
			PublicScopeEnum[] isReadEnums = values();  
	        for (PublicScopeEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

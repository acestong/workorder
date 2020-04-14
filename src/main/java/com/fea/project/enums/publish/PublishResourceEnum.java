package com.fea.project.enums.publish;


public enum PublishResourceEnum {

	PC(1,"PC客户端"),
	IPHONE(2,"iPhone客户端"),
	ANDROID(3,"Android客户端");
	
	private Integer status;
    private String info;
    
	private PublishResourceEnum(Integer status, String info) {
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
			PublishResourceEnum[] isReadEnums = values();  
	        for (PublishResourceEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

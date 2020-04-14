package com.fea.project.enums.publish;


public enum IsTransmitedPublishEnum {

	IS_TRANSMIT_PUBLISH(0,"转发的动态"),
	IS_NOT_TRANSMIT_PUBLISH(1,"非转发的动态");
	
	private Integer status;
    private String info;
    
	private IsTransmitedPublishEnum(Integer status, String info) {
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
			IsTransmitedPublishEnum[] isReadEnums = values();  
	        for (IsTransmitedPublishEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

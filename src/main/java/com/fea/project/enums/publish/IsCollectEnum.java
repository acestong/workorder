package com.fea.project.enums.publish;


public enum IsCollectEnum {

	COLLECT(0,"收藏"),
	NOT_COLLECT(1,"取消收藏");
	
	private Integer status;
    private String info;
    
	private IsCollectEnum(Integer status, String info) {
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
			IsCollectEnum[] isReadEnums = values();  
	        for (IsCollectEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

package com.fea.project.enums.publish;


public enum CommentTypeEnum {

	COMMENT(1,"评论"),
	REPLY(2,"回复");
	
	private Integer status;
    private String info;
    
	private CommentTypeEnum(Integer status, String info) {
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
			CommentTypeEnum[] isReadEnums = values();  
	        for (CommentTypeEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

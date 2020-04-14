package com.fea.project.enums.publish;


public enum PublishNavigateTypeEnum {

	ALL_PUBLISH(1,"全部"),
	MY_APPOINT(2,"@我"),
	MY_COLLECT(3,"我的收藏"),
	LIKE_ME(4,"赞我的"),
	MY_COMMENT(5,"我评论的"),
	COMMENT_ME(6,"评论我的"),
	MY_TRANSMIT(7,"我转发的"),
	TRANSMIT_ME(8,"转发我的");
	
	private Integer status;
    private String info;
    
	private PublishNavigateTypeEnum(Integer status, String info) {
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
			PublishNavigateTypeEnum[] isReadEnums = values();  
	        for (PublishNavigateTypeEnum isReadEnum : isReadEnums) {  
	            if (isReadEnum.getStatus().equals(value)) {  
	                return isReadEnum.getInfo();  
	            }  
	        }  
	        return null;  
	    }  
    
    
}

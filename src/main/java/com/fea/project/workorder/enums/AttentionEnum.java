package com.fea.project.workorder.enums;


public enum AttentionEnum {
	ATTENTION(1,"关注"),
	NOT_ATTENTION(2,"取消关注");
	
	
	private Integer status;
	private String info;
	
	private AttentionEnum(Integer status, String info) {
		this.status = status;
		this.info = info;
	} 

	public Integer getStatus() {
		return status;
	}


	public String getInfo() {
		return info;
	}

	
	public static String getValue(Integer value) {  
		AttentionEnum[] es = values();  
        for (AttentionEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

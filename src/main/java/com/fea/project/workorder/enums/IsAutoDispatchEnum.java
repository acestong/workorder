package com.fea.project.workorder.enums;


public enum IsAutoDispatchEnum {
	AUTO_DISPATCH(1,"自动分配"),
	NOT_AUTO_DISPATCH(2,"不自动分配");
	
	
	private Integer status;
	private String info;
	
	private IsAutoDispatchEnum(Integer status, String info) {
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
		IsAutoDispatchEnum[] es = values();  
        for (IsAutoDispatchEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

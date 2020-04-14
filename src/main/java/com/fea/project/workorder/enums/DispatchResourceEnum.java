package com.fea.project.workorder.enums;


public enum DispatchResourceEnum {
	WORKORDER_POOL(1,"工单池自动分配");
	
	
	private Integer status;
	private String info;
	
	private DispatchResourceEnum(Integer status, String info) {
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
		DispatchResourceEnum[] es = values();  
        for (DispatchResourceEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

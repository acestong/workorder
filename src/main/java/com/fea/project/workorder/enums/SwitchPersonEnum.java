package com.fea.project.workorder.enums;


public enum SwitchPersonEnum {
	RECEITOR(1,"接收人"),
	LEADER(2,"负责人");
	
	
	private Integer status;
	private String info;
	
	private SwitchPersonEnum(Integer status, String info) {
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
		SwitchPersonEnum[] es = values();  
        for (SwitchPersonEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

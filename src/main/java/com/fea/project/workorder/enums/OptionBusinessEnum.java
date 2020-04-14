package com.fea.project.workorder.enums;


public enum OptionBusinessEnum {
	PROCEDURE(1,"工序");
	
	
	private Integer status;
	private String info;
	
	private OptionBusinessEnum(Integer status, String info) {
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
		OptionBusinessEnum[] es = values();  
        for (OptionBusinessEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

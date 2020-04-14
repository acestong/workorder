package com.fea.project.workorder.enums;


public enum PriorityEnum {
	HIGHEST(1,"最高"),
	HIGH(2,"高"),
	MIDDLE(3,"中"),
	LOW(4,"低"),
	LOWEST(5,"最低");
	
	
	private Integer status;
	private String info;
	
	private PriorityEnum(Integer status, String info) {
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
		PriorityEnum[] es = values();  
        for (PriorityEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

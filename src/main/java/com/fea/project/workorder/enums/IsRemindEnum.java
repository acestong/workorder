package com.fea.project.workorder.enums;


public enum IsRemindEnum {
	REMIND(1,"提醒"),
	NOT_REMIND(2,"不提醒");
	
	
	private Integer status;
	private String info;
	
	private IsRemindEnum(Integer status, String info) {
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
		IsRemindEnum[] es = values();  
        for (IsRemindEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

package com.fea.project.enums.task;

public enum ActionNameEnum {

	GT(0,">"),
	GTE(1,">="),
	EQ(2,"="),
	LT(3,"<"),
	LTE(4,"<="),
	NEQ(5,"!=");
	 
	private Integer status;
	private String info;
	
	private ActionNameEnum(Integer status, String info) {
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
		ActionNameEnum[] es = values();  
        for (ActionNameEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
	
	
}

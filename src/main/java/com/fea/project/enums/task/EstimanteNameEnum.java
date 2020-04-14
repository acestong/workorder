package com.fea.project.enums.task;

public enum EstimanteNameEnum {

	EXCELLENT(0,"优异"),
	GOOD(1,"优秀"),
	OK(2,"合格"),
	BADLY(3,"差"),
	WORST(4,"极差");
	
	private Integer status;
	private String info;
	private EstimanteNameEnum(Integer status, String info) {
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
		EstimanteNameEnum[] es = values();  
        for (EstimanteNameEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

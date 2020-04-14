package com.fea.project.workorder.enums;


public enum ProductTroubleSortEnum {
	NO_BOOT(1,"不能开机"),
	BLUE_SCREEN(2,"开机后蓝屏"),
	NO_LOGIN(3,"开机后无法登陆"),
	LOGIN_CRUSH(4,"开机后登陆崩溃");
	
	
	private Integer status;
	private String info;
	
	private ProductTroubleSortEnum(Integer status, String info) {
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
		ProductTroubleSortEnum[] es = values();  
        for (ProductTroubleSortEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

package com.fea.project.workorder.enums;


public enum CreateIdOrSuperiorIdEnum {
	CTREATE_ID(1,"创建人"),
	SUPORIOR_ID(2,"直属上级");
	
	
	private Integer status;
	private String info;
	
	private CreateIdOrSuperiorIdEnum(Integer status, String info) {
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
		CreateIdOrSuperiorIdEnum[] es = values();  
        for (CreateIdOrSuperiorIdEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

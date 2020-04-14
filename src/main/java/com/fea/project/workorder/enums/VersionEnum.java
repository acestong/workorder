package com.fea.project.workorder.enums;


public enum VersionEnum {
	ABOVE_STANDARD(1,"合格--优于标准"),
	SUIT_STANDARD(2,"合格--符合标准"),
	BELOW_STANDARD(3,"不合格--低于标准"),
	NOT_SUIT_STANDARD(4,"不合格--不符合标准");
	
	
	private Integer status;
	private String info;
	
	private VersionEnum(Integer status, String info) {
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
		VersionEnum[] es = values();  
        for (VersionEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

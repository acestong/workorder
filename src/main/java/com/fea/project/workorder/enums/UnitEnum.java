package com.fea.project.workorder.enums;


public enum UnitEnum {
	TAI(1,"台"),
	TIAO(2,"条"),
	TAO(3,"套"),
	GE(4,"个"),
	ZHANG(5,"张"),
	XIANG(6,"箱");
	
	
	private Integer status;
	private String info;
	
	private UnitEnum(Integer status, String info) {
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
		UnitEnum[] es = values();  
        for (UnitEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

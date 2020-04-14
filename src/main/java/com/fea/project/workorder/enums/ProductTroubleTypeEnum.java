package com.fea.project.workorder.enums;


public enum ProductTroubleTypeEnum {
	BOOT_FAILUR(1,"开机故障"),
	DISK_FAILUR(2,"硬盘故障"),
	SYSTEM_CRUSH(3,"系统崩溃"),
	CPU_OVERHEATING(4,"CPU过热");
	
	
	
	private Integer status;
	private String info;
	
	private ProductTroubleTypeEnum(Integer status, String info) {
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
		ProductTroubleTypeEnum[] es = values();  
        for (ProductTroubleTypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

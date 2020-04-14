package com.fea.project.workorder.enums;


public enum TypeEnum {
	WORKORDER(1,"创建工单"),
	WO_REPORT(2,"工单汇报"),
	PC_REPORT(3,"工序汇报"),
	WO_ACCEPTANCE(4,"工单验收"),
	WO_COMMENT(5,"工单评价"),
	WO_CLOSE(6,"工单关闭");
	
	
	private Integer status;
	private String info;
	
	private TypeEnum(Integer status, String info) {
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
		TypeEnum[] es = values();  
        for (TypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

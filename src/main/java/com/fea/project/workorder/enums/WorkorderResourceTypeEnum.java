package com.fea.project.workorder.enums;


public enum WorkorderResourceTypeEnum {
	CUSTOMER(1,"客户工单"),
	INNER(2,"内部工单"),
	SUPPLY(3,"供应商工单"),
	AGENT(4,"代理商工单"),
	OTHER(5,"其他工单");
	
	
	
	private Integer status;
	private String info;
	
	private WorkorderResourceTypeEnum(Integer status, String info) {
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
		WorkorderResourceTypeEnum[] es = values();  
        for (WorkorderResourceTypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

package com.fea.project.workorder.enums;


public enum BusinessTypeEnum {
	MARKET_CLUE(1,"市场线索"),
	SALE_CLUE(2,"销售线索"),
	SALE_OPPORTUNITY(3,"销售机会"),
	SALE_PROJECT(4,"销售项目"),
	POJECT(5,"项目"),
	CONTRACT(6,"合同"),
	ORDER(7,"订单"),
	WORKORDER(8,"工单");
	
	
	private Integer status;
	private String info;
	
	private BusinessTypeEnum(Integer status, String info) {
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
		BusinessTypeEnum[] es = values();  
        for (BusinessTypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

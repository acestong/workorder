package com.fea.project.workorder.enums;


public enum WorkorderTypeEnum {
	PRE_SALE_WORKORDER(1,"售前工单"),
	POST_SALE_REMOTE(2,"售后远程"),
	POST_SALE_SCENE(3,"售后现场"),
	MARKET_ACTIVITY(4,"市场活动"),
	MEETING(5,"会议"),
	OTHER(6,"其他");
	
	
	private Integer status;
	private String info;
	
	private WorkorderTypeEnum(Integer status, String info) {
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
		WorkorderTypeEnum[] es = values();  
        for (WorkorderTypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

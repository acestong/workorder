package com.fea.project.workorder.enums;


public enum OptionResultEnum {
	WORKORDER_TYPE(1,"工单类型","创建人","创建时间","创建工单"),
	RESPONSE_RESULT(2,"响应结果","分配人","分配时间","工单响应"),
	DISPATCH_WORKORDER(3,"工单负责人","分配人","分配时间","分配工单"),
	WORKORDER_REPORT(4,"工单进度","汇报人","汇报时间","工单汇报"),
	WORKORDER_ACTIVATE(5,"","激活人","激活时间","工单激活"),
	WORKORDER_ACCEPTANCE(6,"验收结果","验收人","验收时间","工单验收"),
	WORKORDER_COMMENT(7,"工单评价","汇报人","汇报时间","工单评价"),
	WORKORDER_CLOSE(8,"","关闭人","关闭时间","工单关闭");
	
	
	private Integer status;
	private String info;
	private String personType;
	private String timeType;
	private String title;
	
	private OptionResultEnum(Integer status, String info,String personType,String timeType,String title) {
		this.status = status;
		this.info = info;
		this.personType = personType;
		this.timeType = timeType;
		this.title = title;
	} 

	public Integer getStatus() {
		return status;
	}


	public String getInfo() {
		return info;
	}
	
	public String getPersonType() {
		return personType;
	}
	
	public String getTimeType() {
		return timeType;
	}
	public String getTitle() {
		return title;
	}

	
	public static String getValue(Integer value) {  
		OptionResultEnum[] es = values();  
        for (OptionResultEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
	public static String getPersonType(Integer value) {  
		OptionResultEnum[] es = values();  
		for (OptionResultEnum e : es) {  
			if (e.getStatus().equals(value)) {  
				return e.getPersonType();  
			}  
		}  
		return null;  
	}  
	public static String getTimeType(Integer value) {  
		OptionResultEnum[] es = values();  
		for (OptionResultEnum e : es) {  
			if (e.getStatus().equals(value)) {  
				return e.getTimeType();  
			}  
		}  
		return null;  
	}  
	public static String getRecordTitle(Integer value) {  
		OptionResultEnum[] es = values();  
		for (OptionResultEnum e : es) {  
			if (e.getStatus().equals(value)) {  
				return e.getTitle();  
			}  
		}  
		return null;  
	}  
}

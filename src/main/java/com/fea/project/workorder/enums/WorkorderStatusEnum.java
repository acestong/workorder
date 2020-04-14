package com.fea.project.workorder.enums;


public enum WorkorderStatusEnum {
	UNCOMMITED(1,"未提交"),
	UNRESPONSE(2,"待响应"),
	REVOKE(3,"已撤销"),
	REJECT(4,"已驳回"),
	COMFIRMED(5,"已确认"),
	PROCEEDING(6,"处理中"),
	RESOLVED(7,"已完成"),
	CLOSED(8,"已关闭"),
	RESTART(9,"已激活");
	
	private Integer status;
	private String info;
	
	private WorkorderStatusEnum(Integer status, String info) {
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
		WorkorderStatusEnum[] es = values();  
        for (WorkorderStatusEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

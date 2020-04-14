package com.fea.project.workorder.enums;


public enum ResultTypeEnum {
	WO_TYPE(1,"工单类型"),
	RESP_RESULT(2,"响应结果"),
	DISPATCH_PROCEDURE_LEADER(3,"分配工序负责人"),
	WO_REPORT(4,"工单汇报"),
	RESTRAT_PERSON(5,"激活人"),
	ACCOMPLISH_RESULT(6,"验收结果"),
	WO_COMMENT(7,"工单评价"),
	WO_RATE(8,"工单进度"),
	WO_FINISH(9,"关闭人");
	
	
	private Integer status;
	private String info;
	
	private ResultTypeEnum(Integer status, String info) {
		this.status = status;
		this.info = info;
	} 

	public Integer getStatus() {
		return status;
	}
	
	public int getIntStatus() {
		return status;
	}


	public String getInfo() {
		return info;
	}

	
	public static String getValue(Integer value) {  
		ResultTypeEnum[] es = values();  
        for (ResultTypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

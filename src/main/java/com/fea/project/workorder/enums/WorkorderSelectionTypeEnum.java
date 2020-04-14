package com.fea.project.workorder.enums;


public enum WorkorderSelectionTypeEnum {
	INDUSTRY(1,"按所属行业"),
	EARE(2,"按所属区域"),
	DEPT(3,"按所属部门"),
	PRODUCT(4,"按关联产品"),
	SORT(5,"按工单分类"),
	RESOURCE(6,"按工单来源");
	
	
	private Integer status;
	private String info;
	
	private WorkorderSelectionTypeEnum(Integer status, String info) {
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
		WorkorderSelectionTypeEnum[] es = values();  
        for (WorkorderSelectionTypeEnum e : es) {  
            if (e.getStatus().equals(value)) {  
                return e.getInfo();  
            }  
        }  
        return null;  
    }  
}

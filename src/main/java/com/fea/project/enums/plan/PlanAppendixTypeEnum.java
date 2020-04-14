package com.fea.project.enums.plan;

/**
 * 上传文件类型枚举
 * @author st
 * @since 2019/11/4 9:26
 *
 */
public enum PlanAppendixTypeEnum {
 
	Other(1,"输入物"),
	PPT(2,"参考物"),
	ZIP(3,"其他"); 
	
	private Integer status;
    private String info;
    
    PlanAppendixTypeEnum(Integer status,String info){
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
		PlanAppendixTypeEnum[] planAppendixTypeEnums = values();  
        for (PlanAppendixTypeEnum planAppendixTypeEnum : planAppendixTypeEnums) {  
            if (planAppendixTypeEnum.getStatus().equals(value)) {  
                return planAppendixTypeEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	
}

package com.fea.project.enums.task;

/**
 * 上传文件类型枚举
 * @author st
 * @since 2019/11/4 9:26
 *
 */
public enum TaskAppendixTypeEnum {
 
	Other(1,"其他"),
	PPT(2,"PPT"),
	ZIP(3,"ZIP"),
	IMAGE(4,"图片"),
	WORD(5,"Word"),
	PDF(6,"PDF"),
	EXCEL(7,"Excel");
	 
	private Integer status;
    private String info;
    
    TaskAppendixTypeEnum(Integer status,String info){
    	this.status = status;
        this.info = info;
    }

	public Integer getStatus() {
		return status;
	}


	public String getInfo() {
		return info;
	}

    
    
}

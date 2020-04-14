package com.fea.project.enums.task;


public enum TaskLeftNavigationEnum {

	MY_DRAWF_TASK(1,"我的任务草稿"),
	MY_RESPONSIBLE_TASK(2,"我负责的任务"),
	DISPATCHED_TASK_TO_ME(3,"分配给我的任务"),
	DISPATCHED_TASK_BY_ME(4,"我分配的任务"),
	PARTICIPATED_TASK_BY_ME(5,"我参与的任务"),
	ATTENTIONED_TASK_BY_ME(6,"我关注的任务"),
	MY_COMMENTED_TASK(7,"我的评价任务"),
	COMMENT_TASK_BY_ME(8,"待我评价的任务");
	
	
	private Integer status;
	private String info;
	private TaskLeftNavigationEnum(Integer status, String info) {
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
		TaskLeftNavigationEnum[] taskLeftNavigationEnums = values();  
        for (TaskLeftNavigationEnum taskLeftNavigationEnum : taskLeftNavigationEnums) {  
            if (taskLeftNavigationEnum.getStatus().equals(value)) {  
                return taskLeftNavigationEnum.getInfo();  
            }  
        }  
        return null;  
    }  
	 
	
}

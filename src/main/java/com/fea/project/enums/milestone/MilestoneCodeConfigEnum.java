package com.fea.project.enums.milestone;

/**
 * @author Administrator
 */

public enum MilestoneCodeConfigEnum {
    MILESTONE_NUMBER(1,"里程碑编号","XMLCB"),
    MILESTONE_DELIVERABLE_NUMBER(2,"里程碑交付物编号","LIBJF"),
    PROJECT_DELIVERABLE_NUMBER(3,"项目交付物编号","XMJF"),
    TASK_DELIVERABLE_NUMBER(4,"任务交付物编号","RWJF");
    private Integer type;
    private String description;
    private String prefix;

    MilestoneCodeConfigEnum(Integer type, String description, String prefix) {
        this.type = type;
        this.description = description;
        this.prefix = prefix;
    }
    public static String queryPrefix(Integer type){
        for (int i = 0; i< MilestoneCodeConfigEnum.values().length; i++){
            MilestoneCodeConfigEnum ase= MilestoneCodeConfigEnum.values()[i];
            if (ase.getType().equals(type)){
                return ase.getPrefix();
            }
        }
        return null;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

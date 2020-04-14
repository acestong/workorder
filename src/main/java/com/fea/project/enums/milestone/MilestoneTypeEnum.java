package com.fea.project.enums.milestone;

import com.fea.project.model.config.ProjectConfigMilestoneModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */

public enum MilestoneTypeEnum {

    PROGRESS_MILESTONE(1,"进度里程碑"),
    PAYMENT_MILESTONE(2,"回款里程碑"),
    ACCEPTANCE_MILESTONE(3,"验收里程碑");

    private Integer index;
    private String name;

    MilestoneTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }
    public static List<ProjectConfigMilestoneModel> getMilestoneTypeList(){
        List<ProjectConfigMilestoneModel> list = new ArrayList<>();
        for (MilestoneTypeEnum value : MilestoneTypeEnum.values()) {
            list.add(ProjectConfigMilestoneModel.builder()
                    .name(value.name)
                    .index(value.index)
                    .build()
            );
        }
        return list;
    }
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

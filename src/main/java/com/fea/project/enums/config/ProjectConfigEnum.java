package com.fea.project.enums.config;

import com.fea.project.enums.base.EnableStatusEnum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/8 9:16
 * 流程配置-项目计划设置
 **/
public enum ProjectConfigEnum {

    PROJECT_PLAN_START_PLAN(1, "project", "是否启用项目计划"),
    PROJECT_CREATE_VERIFY(16, "verify_set", "项目创建是否需要审批"),
    VERIFY_SET_PROJECT_PLAN_VERIFY(2, "verify_set", "项目计划是否需要审批"),
    VERIFY_SET_PROJECT_TEAM_PLAN_VERIFY(3, "verify_set", "项目团队计划是否需要审批"),
    VERIFY_SET_PROJECT_TEAMER_PLAN_VERIFY(4, "verify_set", "项目成员计划是否需要审批"),
    VERIFY_SET_TASK_DELIVERABLE_VERIFY(5, "verify_set", "项目任务交付物是否需要审批"),
    VERIFY_SET_PROJECT_FINISH_VERIFY(6, "verify_set", "项目结项是否需要审批"),
    VERIFY_SET_PROJECT_BUDGET_VERIFY(7, "verify_set", "项目预算是否需要审批"),
    PROJECT_CHANGE_VERIFY(17, "change_apply", "项目变更是否需要审批"),
    CHANGE_APPLY_PROJECT_PLAN_CHANGE_VERIFY(8, "change_apply", "项目计划变更是否需要审批"),
    CHANGE_APPLY_PROJECT_TEAM_PLAN_CHANGE_VERIFY(9, "change_apply", "项目团队计划变更是否需要审批"),
    CHANGE_APPLY_PROJECT_TEAMER_PLAN_CHANGE_VERIFY(10, "change_apply", "项目成员计划变更是否需要审批"),
    CHANGE_APPLY_PROJECT_BUDGET_PLAN_CHANGE_VERIFY(11, "change_apply", "项目预算变更是否需要审批"),
    PROJECT_WORKING_TIME_SET(12, "working_time_set", "项目工时确认时间周期"),
    DELIVERABLE_PROJECT_DELIVERABLE_ESTIMATE(13, "deliverable", "交付物是否需要评价"),
    TASK_PROJECT_TASK_ESTIMATE(14, "task", "项目任务是否需要评价"),
    CLOSE_PROJECT_CLOSE_ESTIMATE(15, "close", "项目结项是否需要评价"),
    TASK_PROJECT_TASK_PROGRESS_ESTIMATE(18, "task_progress", "项目任务计算设置"),
    VERIFY_SET_PROJECT_DELIVERABLE_VERIFY(20,"verify_set","项目交付物是否需要审批"),
    VERIFY_SET_MILESTONE_DELIVERABLE_VERIFY(21,"verify_set","项目里程碑交付物是否需要审批"),
    VERIFY_SET_PROJECT_MILESTONE_VERIFY(22, "verify_set", "项目里程碑是否需要审批"),
    CHANGE_APPLY_PROJECT_MILESTONE_CHANGE_VERIFY(23, "change_apply", "项目里程碑变更是否需要审批");
    //PROJECT_FEE_DUBGET_VERIFY(24,"verify_set","项目预算是否需要审批"),
    //PROJECT_FEE_DUBGET_CHANGE_VERIFY(25,"change_apply","项目预算变更是否需要审批");

    private Integer value;
    private String type;
    private String describe;

    public static Map<Integer, String> getTypeMap() {
        return Stream.of(ProjectConfigEnum.values()).collect(Collectors.toMap(ProjectConfigEnum::getValue, ProjectConfigEnum::getType));
    }

    public static List<Integer> getFlowTypeId() {
        return new ArrayList<Integer>() {{
            add(VERIFY_SET_PROJECT_PLAN_VERIFY.getValue());
            add(VERIFY_SET_PROJECT_TEAM_PLAN_VERIFY.getValue());
            add(VERIFY_SET_PROJECT_TEAMER_PLAN_VERIFY.getValue());
            add(VERIFY_SET_TASK_DELIVERABLE_VERIFY.getValue());
            add(VERIFY_SET_PROJECT_FINISH_VERIFY.getValue());
            add(VERIFY_SET_PROJECT_BUDGET_VERIFY.getValue());
            add(CHANGE_APPLY_PROJECT_PLAN_CHANGE_VERIFY.getValue());
            add(CHANGE_APPLY_PROJECT_TEAM_PLAN_CHANGE_VERIFY.getValue());
            add(CHANGE_APPLY_PROJECT_TEAMER_PLAN_CHANGE_VERIFY.getValue());
            add(CHANGE_APPLY_PROJECT_BUDGET_PLAN_CHANGE_VERIFY.getValue());
            add(PROJECT_CREATE_VERIFY.getValue());
            add(PROJECT_CHANGE_VERIFY.getValue());
            add(VERIFY_SET_PROJECT_DELIVERABLE_VERIFY.getValue());
            add(VERIFY_SET_MILESTONE_DELIVERABLE_VERIFY.getValue());
            add(VERIFY_SET_PROJECT_MILESTONE_VERIFY.getValue());
            add(CHANGE_APPLY_PROJECT_MILESTONE_CHANGE_VERIFY.getValue());
            //add(PROJECT_FEE_DUBGET_VERIFY.getValue());
            //add(PROJECT_FEE_DUBGET_CHANGE_VERIFY.getValue());
        }};
    }

    ProjectConfigEnum(Integer value, String type, String describe) {
        this.value = value;
        this.type = type;
        this.describe = describe;
    }

    public static List<Integer> getNeedInputFLowIdList() {
        List<Integer> list = new ArrayList<>();
        ProjectConfigEnum[] enums = ProjectConfigEnum.values();
        for (ProjectConfigEnum targetEnum : enums) {
            if (!targetEnum.getValue().equals(PROJECT_PLAN_START_PLAN.value)
                    && !targetEnum.getValue().equals(DELIVERABLE_PROJECT_DELIVERABLE_ESTIMATE.value)
                    && !targetEnum.getValue().equals(TASK_PROJECT_TASK_ESTIMATE.value)
                    && !targetEnum.getValue().equals(PROJECT_WORKING_TIME_SET.value)
                    && !targetEnum.getValue().equals(TASK_PROJECT_TASK_PROGRESS_ESTIMATE.value)
                    && !targetEnum.getValue().equals(CLOSE_PROJECT_CLOSE_ESTIMATE.value)) {
                list.add(targetEnum.getValue());
            }
        }
        return list;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new LinkedHashMap<>(16);
        ProjectConfigEnum[] enums = ProjectConfigEnum.values();
        for (int i = 0; i < enums.length; i++) {
            map.put(enums[i].value, enums[i].describe);
        }
        return map;
    }

    public static Integer setStart() {
        return 1;
    }

    public static Integer setClose() {
        return 0;
    }

    public static ProjectConfigEnum[] getConfigType(Integer isEstablish) {
        if(Objects.equals(EnableStatusEnum.ENABLE.getStatus(), isEstablish)){
            return Stream.of(ProjectConfigEnum.values()).filter(x -> !Objects.equals(x, PROJECT_CREATE_VERIFY)).toArray(ProjectConfigEnum[] :: new);
        }else{
            return ProjectConfigEnum.values();
        }
    }

    public Integer getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getDescribe() {
        return describe;
    }


}

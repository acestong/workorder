package com.fea.project.enums.flow.base;

import com.fea.project.enums.base.EnableStatusEnum;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/10 10:13
 * 修改权限类型枚举
 **/
public enum ProjectChangePriorityTypeEnum {

    TYPE_CANT_CHANGE_VERIFY("提交申请时，员工不可修改审批人"),
    TYPE_CANT_CHANGE_COPYER("提交申请时，员工不可修改抄送人");

    private String text;

    ProjectChangePriorityTypeEnum(String text) {
        this.text = text;
    }

    public static Integer getDefaultValue() {
        return EnableStatusEnum.ENABLE.getStatus();
    }

    public String getText() {
        return text;
    }

}

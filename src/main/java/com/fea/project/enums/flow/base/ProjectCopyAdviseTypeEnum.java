package com.fea.project.enums.flow.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuqi
 * @since 2019/10/10 10:09
 * 抄送通知枚举
 **/
public enum ProjectCopyAdviseTypeEnum {

    TYPE_SUBMIT_ADVISE(1, "提交申请时抄送"),
    TYPE_VERIFY_ADVISE(2, "审批通过后抄送"),
    TYPE_SUBMIT_AND_VERIFY(3, "提交申请时和审批通过后都抄送");

    private Integer value;
    private String text;

    ProjectCopyAdviseTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public static List<Integer> getBeforeVerifyNeedAdviseStatus() {
        return new ArrayList<Integer>() {{
            add(TYPE_SUBMIT_ADVISE.value);
            add(TYPE_SUBMIT_AND_VERIFY.value);
        }};
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

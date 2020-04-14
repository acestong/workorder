package com.fea.project.enums.user;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/29 17:22
 **/
public enum UserStatusEnum {

    TYPE_DELETE(-1, "删除"),
    TYPE_LEAVE(0, "移出项目组"),
    TYPE_NORMAL(1, "正常");

    private Integer value;
    private String text;

    UserStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 获取项目用户处在项目中的状态
     *
     * @return
     */
    public static List<Integer> getProjectUserStatus() {
        List<Integer> list = new ArrayList<>();
        list.add(UserStatusEnum.TYPE_LEAVE.getValue());
        list.add(UserStatusEnum.TYPE_NORMAL.getValue());
        return list;
    }

    public Integer getValue() {
        return value;
    }


    public String getText() {
        return text;
    }

}

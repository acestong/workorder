package com.fea.project.enums.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/8 11:20
 * 启用状态
 **/
public enum EnableStatusEnum {

    DISABLE(0, "禁用"),
    ENABLE(1, "启用");

    private Integer status;
    private String msg;

    EnableStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static Map<Integer, String> getStatusMap() {
        Map<Integer, String> map = new HashMap<>();
        EnableStatusEnum[] enableStatusEnums = EnableStatusEnum.values();
        for (int i = 0; i < enableStatusEnums.length; i++) {
            map.put(enableStatusEnums[i].getStatus(), enableStatusEnums[i].getMsg());
        }
        return map;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

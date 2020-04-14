package com.fea.project.workorder.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除状态枚举
 *
 * @author wuqi
 * @version 1.0
 * @since 2019/5/8 11:16
 **/
public enum DeleteStatusEnum {

    NOT_DELETE(0, "未删除"),
    DELETE(1, "删除");

    private Integer status;
    private String msg;

    DeleteStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        DeleteStatusEnum[] enums = DeleteStatusEnum.values();
        for (DeleteStatusEnum tmp : enums) {
            map.put(tmp.getStatus(), tmp.getMsg());
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
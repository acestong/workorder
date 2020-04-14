package com.fea.project.enums.base;

import com.fea.project.model.base.BaseResultModel;
/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/8 15:57
 * 200: OK
 * 400: Bad Request
 * 500：Internal Server Error
 * 401：Unauthorized
 * 403：Forbidden
 * 404：Not Found
 **/
public enum RequestReturnCodeEnum {

    CODE_REQUEST_SUCCESS("200", "请求成功"),
    CODE_REQUEST_OVERTIME("401", "cookie超时"),
    CODE_REQUEST_EXCEPTION("500", "请求异常"),
    CODE_SYSTEM_ERROR("500", "系统错误");


    private String code;
    private String msg;

    RequestReturnCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> BaseResultModel createRightModel(T model) {
        return BaseResultModel.createSuccessModel(model, RequestReturnCodeEnum.CODE_REQUEST_SUCCESS.getCode());
    }
    public static <T> BaseResultModel createFailureModel(T model, RequestReturnCodeEnum targetEnum) {
        return BaseResultModel.createFailureModel(targetEnum.getMsg(), model, targetEnum.getCode());
    }
    public static <T> BaseResultModel createFailureModel(T model, RequestReturnCodeEnum targetEnum, String alarmMsg) {
        return BaseResultModel.createFailureModel(alarmMsg, model, targetEnum.getCode());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
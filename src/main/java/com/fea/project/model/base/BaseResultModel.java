package com.fea.project.model.base;

import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/5 14:50
 * 交互式通讯，返回的基本model
 **/
@Data
public class BaseResultModel {

    private String msg;
    private String code;
    private Object data;

    /**
     * 创建失败返回参数
     *
     * @param failureMsg 报错信息
     * @param params     报错参数
     * @param code       报错码 来源于RequestReturnCodeEnum
     * @return
     */
    public static BaseResultModel createFailureModel(String failureMsg, Object params, String code) {
        BaseResultModel model = new BaseResultModel();
        model.setMsg(failureMsg);
        model.setData(params);
        model.setCode(code);
        return model;
    }

    /**
     * 创建成功返回参数
     *
     * @param params 成功返回的参数
     * @return
     */
    public static BaseResultModel createSuccessModel(Object params, String code) {
        BaseResultModel model = new BaseResultModel();
        model.setData(params);
        model.setCode(code);
        return model;
    }

}

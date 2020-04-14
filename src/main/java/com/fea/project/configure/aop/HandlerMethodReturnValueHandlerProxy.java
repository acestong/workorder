package com.fea.project.configure.aop;

import com.fea.project.enums.base.RequestReturnCodeEnum;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/26 10:22
 **/
public class HandlerMethodReturnValueHandlerProxy implements HandlerMethodReturnValueHandler {
    private HandlerMethodReturnValueHandler proxyObject;

    public HandlerMethodReturnValueHandlerProxy(HandlerMethodReturnValueHandler proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return proxyObject.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        proxyObject.handleReturnValue(RequestReturnCodeEnum.createRightModel(returnValue), returnType, mavContainer, webRequest);
    }
}

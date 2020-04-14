package com.fea.project.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/8/22 10:18
 * httpServletRequest对象获取类
 **/
public class HttpServletRequestUtil {

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}

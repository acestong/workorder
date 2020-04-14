package com.fea.project.configure.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/9 11:17
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UserLoginInterceptor userLoginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(userLoginInterceptor).excludePathPatterns("/login", "/welcome", "/uploads/**");
    }

}
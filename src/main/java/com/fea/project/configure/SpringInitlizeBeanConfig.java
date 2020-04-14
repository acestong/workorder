package com.fea.project.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @since 2019/4/22 15:47
 * spring容器管理bean配置
 **/
@Configuration
@ComponentScan({"com.fea.project.configure.auth"})
public class SpringInitlizeBeanConfig {

    @Value("${spring.restTemplate.readTimeout}")
    private int readTimeout;

    @Value("${spring.restTemplate.connectTimeout}")
    private int connectTimeout;


    @Bean
    public ServletListenerRegistrationBean<EventListener> getDemoListener() {
        ServletListenerRegistrationBean<EventListener> registrationBean
                = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new RequestContextListener());
        return registrationBean;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(readTimeout);
        factory.setConnectTimeout(connectTimeout);
        return factory;
    }


}

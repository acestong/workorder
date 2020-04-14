package com.fea.project.util;

import com.alibaba.fastjson.JSON;
import com.fea.project.configure.SpringContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/18 17:09
 **/
@Slf4j
public class RestTemplateUtil<T> {

    private static RestTemplate restTemplate = SpringContextHelper.getBean(RestTemplate.class);


    public static <T> T exchangeForObject(String url, Class<T> targetClass, HttpMethod method){
        HttpHeaders headers  = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
        headers.set(HttpHeaders.COOKIE, HttpServletRequestUtil.getRequest().getHeader("Authorization"));
        HttpEntity requestEntity = new HttpEntity(null, headers);
        ResponseEntity<T> model = restTemplate.exchange(url, method, requestEntity, targetClass);
        log.debug("model: "+ JSON.toJSONString(model));
        return model.getBody();
    }

    public static <T> T exchangeForObject(String url, Class<T> targetClass, HttpMethod method, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
        headers.set(HttpHeaders.COOKIE, HttpServletRequestUtil.getRequest().getHeader("Authorization"));
        HttpEntity requestEntity = new HttpEntity(body, headers);
        ResponseEntity<T> model = restTemplate.exchange(url, method, requestEntity, targetClass);
        return model.getBody();
    }

    public static <T> T exchangeForObject(String url, Class<T> targetClass, HttpMethod method, String body, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf-8");
        headers.set(HttpHeaders.COOKIE, request.getHeader("Authorization"));
        HttpEntity requestEntity = new HttpEntity(body, headers);
        ResponseEntity<T> model = restTemplate.exchange(url, method, requestEntity, targetClass);
        return model.getBody();
    }


}

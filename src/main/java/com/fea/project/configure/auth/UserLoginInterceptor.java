package com.fea.project.configure.auth;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.login.SystemQueryReturnModel;
import com.fea.project.configure.exception.LoginStateIllegalException;
import com.fea.project.util.HttpServletRequestUtil;
import com.fea.project.util.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/9 11:19
 **/
@Slf4j
@Component
public class UserLoginInterceptor extends HandlerInterceptorAdapter {
//
//    @Value("${main.server.url}")
//    private String url;
//
//    @Value("${login.server.base}")
//    private String base;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    private static final String JSESSIONID = "JSESSIONID";
//
//    private static final String REG_ID_STR = "regId";
//    private static final String ID_STR = "id";
//    private static final long THIRTY_MINUTE = 30;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String authorization = HttpServletRequestUtil.getRequest().getHeader("Authorization");
//        log.debug("authorization: " + authorization);
//        String[] params = authorization.split(";");
//        Map<String, String> map = Stream.of(params).collect(Collectors
//                .toMap(x -> x.split("=")[0].trim(), x -> x.split("=")[1].trim()));
//        log.debug("map: " + JSON.toJSONString(map));
//        log.debug("JSESSIONID: " + map.get(JSESSIONID));
//        if (map.get(JSESSIONID) != null) {
//            Map<String, Long> userInfo = (Map<String, Long>) redisTemplate.opsForValue().get(map.get(JSESSIONID));
//            log.debug("userInfo: " + JSON.toJSONString(userInfo));
//            if (userInfo == null || userInfo.size() != 2 || userInfo.get(REG_ID_STR) == null || userInfo.get(ID_STR) == null) {
//                redisTemplate.delete(JSESSIONID);
//
//                log.debug("url: "+url);
//                SystemQueryReturnModel model = RestTemplateUtil.exchangeForObject(url, SystemQueryReturnModel.class, HttpMethod.GET);
//                if (!model.getStatus()) {
//                    throw new LoginStateIllegalException(base + model.getUrl());
//                }
//                if (userInfo == null) {
//                    userInfo = new HashMap<>(2);
//                }
//                userInfo.put(REG_ID_STR, model.getMap().get(REG_ID_STR));
//                userInfo.put(ID_STR, model.getMap().get(ID_STR));
//                redisTemplate.opsForValue().set(map.get(JSESSIONID), userInfo, THIRTY_MINUTE, TimeUnit.MINUTES);
//            }
//            request.setAttribute(REG_ID_STR, userInfo.get(REG_ID_STR));
//            request.setAttribute(ID_STR, userInfo.get(ID_STR));
//            return Boolean.TRUE;
//        } else {
//            throw new LoginStateIllegalException("JsessionId异常");
//        }
//    }
}
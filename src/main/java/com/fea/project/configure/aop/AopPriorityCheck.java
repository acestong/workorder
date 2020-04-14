package com.fea.project.configure.aop;

import com.fea.project.api.other.model.base.SysUriModel;
import com.fea.project.api.other.service.base.SysUriService;
import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.configure.exception.PriorityIllegalException;
import com.fea.project.enums.base.EnableStatusEnum;
import com.github.pagehelper.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/23 11:25
 **/
@Aspect
@Component
public class AopPriorityCheck {

    @Autowired
    private SysUriService sysUriService;

    @Value("${self.config.security}")
    private Integer securityStartFlag;

    public static final String PROJECT_MANAGE_PRIORITY_STR = "/projectManage/%";



    @Pointcut(value = "execution(public * com.fea.project.controller..*.*(..)) ")
    public void checkPriority() {
    }

    @Before("checkPriority()")
    public void doBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Annotation[] annotations = methodSignature.getMethod().getAnnotations();
        if(!Objects.equals(securityStartFlag, EnableStatusEnum.ENABLE.getStatus())){
            return;
        }
        Arrays.stream(annotations).forEach(x -> {
            if(x instanceof PermissionAnno){
                String permissionStr = ((PermissionAnno) x).value();
                if(StringUtil.isEmpty(permissionStr.trim())){
                    return;
                }
               List<String> priorityList = sysUriService.selectByCurrentUserProjectPriority(PROJECT_MANAGE_PRIORITY_STR)
                       .stream().map(SysUriModel::getURICODE).collect(Collectors.toList());
                if(priorityList.contains(permissionStr)){
                    return;
                }
                throw new PriorityIllegalException("当前用户不具备访问该接口权限");
            }
        });
    }
}

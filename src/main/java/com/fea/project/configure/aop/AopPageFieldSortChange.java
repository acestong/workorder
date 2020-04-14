package com.fea.project.configure.aop;

import com.fea.project.model.BasePageInfo;
import com.fea.project.service.util.AopFieldSortService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/23 11:25
 **/
@Aspect
@Component
public class AopPageFieldSortChange {

    @Pointcut(value = "execution(public * com.fea.project.controller..*.select*(..)) || execution(public * com.fea.project.controller..*.list*(..))")
    public void insertOrUpdateSingleTable() {
    }

    @Before("insertOrUpdateSingleTable()")
    public void doBefore(JoinPoint joinPoint) {
        if (joinPoint.getArgs() == null || joinPoint.getArgs().length == 0) {
            return;
        }
        Object param = joinPoint.getArgs()[0];
        if (param instanceof BasePageInfo) {
            BasePageInfo basePageInfo = (BasePageInfo) param;
            AopFieldSortService.sortFieldTranslateToTargetFieldName(basePageInfo);
        }
    }

}

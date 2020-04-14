package com.fea.project.configure.aop;

import com.fea.project.service.util.AopParamCheckService;
import com.fea.project.service.util.UniqueCheckService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/23 11:25
 **/
@Aspect
@Component
public class AopInsertOrUpdateSingleTableParamCheck {

    @Autowired
    private UniqueCheckService uniqueCheckService;


    @Pointcut(value = "execution(public * com.fea.project.service..*.insertModel(..)) " +
            "|| execution(public * com.fea.project.service..*.updateModel(..))")
    public void insertOrUpdateSingleTable() {
    }

    @Before("insertOrUpdateSingleTable()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        AopParamCheckService.insertOrUpdateParamCheck(joinPoint.getArgs()[0], uniqueCheckService);
    }


}

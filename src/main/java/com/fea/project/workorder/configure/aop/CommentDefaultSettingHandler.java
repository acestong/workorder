package com.fea.project.workorder.configure.aop;


import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.util.WeightSettingUtil;


/**
 * 工单日志操作切点类
 * 
 * @author st
 * @since 2020/3/13
 *
 */
@Aspect
@Component
public class CommentDefaultSettingHandler {

	@Resource
	private SysUserService sysUserService;
	
	private static final Logger log = LoggerFactory.getLogger(CommentDefaultSettingHandler.class);

	@Pointcut(value = "execution(public * com.fea.project.workorder.service.impl.*.*(..)) " )
	public void operationLog() {
	}

	/**
	 * 对评论进行默认设置，进入列表前进行默认值
	 * @param jp
	 */
	@Before("operationLog()")
	public void doBefore(JoinPoint jp) {
		WeightSettingUtil.setDefaultSettting();
	}
	
}

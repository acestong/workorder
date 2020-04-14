package com.fea.project.configure.annotations.base;

import java.lang.annotation.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 16:42
 * 权限特征码校验
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PermissionAnno {
    String value();
}

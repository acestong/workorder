package com.fea.project.configure.annotations.base;

import java.lang.annotation.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/9 15:13
 * 非空检查注解
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NotNullAnno {
    String value();

    String field();
}
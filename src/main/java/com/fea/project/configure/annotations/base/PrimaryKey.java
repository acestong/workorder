package com.fea.project.configure.annotations.base;

import java.lang.annotation.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/9 15:56
 * 主键标识注解
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PrimaryKey {
    String field();
}
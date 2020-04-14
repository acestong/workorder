package com.fea.project.configure.annotations.base;

import java.lang.annotation.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 16:04
 * 数据表名称注解
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TableNameAnno {
    String value();
}

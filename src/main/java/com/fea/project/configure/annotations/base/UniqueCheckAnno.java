package com.fea.project.configure.annotations.base;

import java.lang.annotation.*;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/5/9 15:14
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface UniqueCheckAnno {
    String value();

    String field();
}

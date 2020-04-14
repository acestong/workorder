package com.fea.project.workorder.configure.annotation;

import java.lang.annotation.*;
import java.util.Date;

/**
 * @author st
 * @since 2020/03/13
 * 
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WorkorderLogAnno {

    /*
     * 操作类型  com.fea.project.workorder.enums.OptionResultEnum
     */
     long resultType() default 0;



}

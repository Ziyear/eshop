package com.eshop.common.aoplog;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLogs {

    /**
     * 描述
     */
    String description() default "";
}

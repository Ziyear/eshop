package com.eshop.common.aoplog;

import java.lang.annotation.*;

/**
 * 自定义Controller的注解，做日志记录注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLogs {
    /**
     * 描述
     */
    String description() default "";
}

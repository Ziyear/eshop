package com.eshop.generator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 */
@RestControllerAdvice
public class RRExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BIZException.class)
    public ActionResult handleRRException(BIZException e) {
        ActionResult r = new ActionResult();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());

        return r;
    }

    @ExceptionHandler(Exception.class)
    public ActionResult handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return ActionResult.error();
    }
}

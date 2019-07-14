/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GlobalExceptionHandle
 * Author:   pc-20171125
 * Date:     2018/12/12 18:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.eshop.common.exception;

import com.eshop.common.enums.ResultStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 自定义异常拦截
 * @return
 * @author mhy
 * @date 2018-12-13 14:05:18
 */
@ControllerAdvice(annotations = {RestController.class})
@ResponseBody
public class GlobalExceptionHandler {


    /**
     * 系统异常处理，比如：404,500
     * @param request
     * @param e
     * @return
     * @author mhy
     * @date 2018-12-13 14:05:18
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return Result.error(ex.getResultStatus());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(ResultStatus.http_status_not_found);
        } else {
            return Result.error(ResultStatus.http_status_internal_server_error);
        }
    }



}
package com.eshop.common.exception;


import com.eshop.common.enums.ResultStatus;

/**
 * 全局异常
 * @return
 * @author mhy
 * @date 2018-12-13 14:05:18
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResultStatus resultStatus;

    public GlobalException(ResultStatus resultStatus) {
        super(resultStatus.toString());
        this.resultStatus = resultStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

}

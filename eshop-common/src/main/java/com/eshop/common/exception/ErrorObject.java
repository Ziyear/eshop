package com.eshop.common.exception;

/**
 * 通用错误信息记录类
 */
public class ErrorObject {
    private String errCode;
    private String errMsg;

    public ErrorObject() {
    }

    public ErrorObject(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}

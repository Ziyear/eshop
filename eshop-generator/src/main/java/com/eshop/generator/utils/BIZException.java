package com.eshop.generator.utils;

/**
 * 自定义业务异常
 *
 */
public class BIZException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BIZException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BIZException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BIZException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BIZException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}

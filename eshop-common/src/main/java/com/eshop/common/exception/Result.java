package com.eshop.common.exception;

import com.eshop.common.enums.ResultStatus;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private int code;
    private String msg;
    private Object data;
    private boolean ret;

    public Result(boolean ret) {
        this.ret = ret;
    }

    public static Result success(Object object, String msg) {
        Result result = new Result(true);
        result.data = object;
        result.msg = msg;
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result(true);
        result.data = object;
        return result;
    }

    public static Result success() {
        return new Result(true);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public static Result error(ResultStatus resultStatus) {
        return new Result(resultStatus);
    }

    public static Result fail(String msg) {
        Result result = new Result(false);
        result.msg = msg;
        return result;
    }

    private Result(Object data) {
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(ResultStatus resultStatus) {
        if (resultStatus != null) {
            this.code = resultStatus.getErrorCode();
            this.msg = resultStatus.getErrorMsg();
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }
}

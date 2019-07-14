package com.eshop.common.enums.rest;

public enum MemberTypeEnum {

    NORMAL("普通用户","1"),
    DEVELOP("开发者","2"),
    ADVANCED("后台超级用户","3");

    private String code;
    private String msg;


    MemberTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

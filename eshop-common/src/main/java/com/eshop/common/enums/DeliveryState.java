package com.eshop.common.enums;

public enum DeliveryState {
    WAITING_SELLER(0,"等待商家确认"),
    DELIVERY_CLOSE(1,"提货关闭"),
    SELLER_CONFIRM(2,"商家已经开单"),
    WAITING_BUYER(3,"等待买家确认"),
    DELIVERY_FINISH(4,"提货关闭");

    private int code;
    private String msg;
    DeliveryState(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}

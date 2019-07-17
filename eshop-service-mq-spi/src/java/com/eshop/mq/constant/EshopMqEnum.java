package com.eshop.mq.constant;

/**
 * MQ的常量类
 */
public enum EshopMqEnum {
    /**
     * 会员
     */
    MEMBER("CID_MEMBER_", "会员"),
    /**
     * 文件
     */
    FILE("CID_FILE_", "文件"),
    /**
     * 商品
     */
    COMMODITY("CID_COMMODITY_", "商品"),
    /**
     * 订单
     */
    ORDER("CID_ORDER_", "订单"),
    /**
     * 价格
     */
    PRICE("CID_PRICE_", "价格"),
    /**
     * 风控
     */
    RISK("CID_RISK_", "风控"),
    /**
     * 购物车
     */
    SHOPPING_CART("CID_SHOPPING_CART_", "购物车"),
    /**
     * 登录
     */
    SSO("CID_SSO_", "登录"),
    /**
     * 库存
     */
    STOCK("CID_STOCK_", "库存"),
    /**
     * 上帝视角
     */
    ADMIN("CID_ADMIN_", "上帝视角"),
    /**
     * 客户端
     */
    WEB("CID_WEB_", "客户端"),
    /**
     * 商家端
     */
    STORE("CID_STORE_", "商家端");
    String code;
    String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    EshopMqEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static EshopMqEnum getByQueue(String queue) {
        EshopMqEnum[] values = EshopMqEnum.values();
        for (EshopMqEnum value : values) {
            if (value.code.equals(queue)) {
                return value;
            }
        }
        return null;
    }

    public static String[] getAllCodes() {
        EshopMqEnum[] values = EshopMqEnum.values();
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].getCode();
        }
        return result;
    }
}

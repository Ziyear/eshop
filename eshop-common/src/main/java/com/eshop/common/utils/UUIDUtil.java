package com.eshop.common.utils;

import java.util.UUID;

/**
 * UUID相关操作的工具类
 */
public class UUIDUtil {
    /**
     * volatile变量保证可见性
     */
    private volatile static UUIDUtil instance = null;

    private UUIDUtil() {
        getInstance();
    }

    /**
     * 单例获取当前类实例
     */
    private static UUIDUtil getInstance() {
        if (instance == null) {
            synchronized (UUIDUtil.class) {
                if (instance == null) {
                    instance = new UUIDUtil();
                }
            }
        }
        return instance;
    }

    /**
     * <p>获取随机UUID并转换为字符串且字母为大写</p>
     */
    public static String getCodeUUID() {
        // 获取随机的UUID，去掉“-”符号 ，并且将字母转换为大写
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}

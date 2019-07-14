package com.eshop.common.page;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>Copyright © 2019 LOUIS. All rights reserved.</p>
 * @ClassName: <p>DateCommon</p>
 * @Description: <p>时间处理公用代码部分</p>
 * @author: <p>291576222</p>
 * @date: <p>2019年3月30日11:16:08</p>
 * @version: <p>V1.0</p>
 */
public class DateCommon {

    /**
     * volatile变量保证可见性
     */
    private volatile static DateCommon instance = null;
    private DateCommon() {
        getInstance();
    }
    /**
     * 单例获取当前类实例
     */
    private static DateCommon getInstance() {
        if (instance == null) {
            synchronized (DateCommon.class) {
                if (instance == null) {
                    instance = new DateCommon();
                }
            }
        }
        return instance;
    }

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 格式"yyyy-MM-dd HH:mm:ss"的长度。
     */
    private static final Integer TIME_LENGTH_19 = 19;
    /**
     * 格式"yyyy-MM-dd HH:mm"的长度。
     */
    private static final Integer TIME_LENGTH_16 = 16;
    /**
     * 格式"yyyy-MM-dd"的长度。
     */
    private static final Integer TIME_LENGTH_10 = 10;

    /**
     * 生成时间戳
     */
    public static String getTimestamp() {
        return Instant.now().toString().replace("-", "").replace(":", "").replace(".", "").toUpperCase();
    }

    /**
     * DateTimeFormatter转换为Date类型时间，时间格式"yyyy-MM-dd HH:mm:ss"。
     */
    public static Date parseDate(String time) {
        return Date.from(LocalDateTime.parse(timeFormat(time, TIME_LENGTH_19), dtf).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 提货时间的时间格式处理，只保留年月日，格式"yyyy-MM-dd"。
     */
    private static final DateTimeFormatter dtf10 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static Date parseDeliveryDate(String deliveryTime) {
        return Date.from(LocalDate.parse(timeFormat(deliveryTime, TIME_LENGTH_10), dtf10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 首页H5的报价时间长度处理，固定格式长度。
     */
    public static String timeFormat(String time, Integer timeLength) {
        if (timeLength < time.length()) {
            time = time.substring(0, timeLength);
        }
        return time;
    }
    /**
     * 首页H5的报价时间查询处理方法。
     * 如果时间不是今天或昨天，那么时间只保留到分，格式“yyyy-MM-dd HH:mm”（长度16）
     * @param releaseTime 发布时间
     * @return 返回处理完成的时间
     */
    public static String quotationDateHandle(String releaseTime) {
        releaseTime = timeFormat(releaseTime, TIME_LENGTH_19);
        int nowDate = LocalDate.now().getDayOfMonth();
        int date = LocalDate.parse(releaseTime, dtf).getDayOfMonth();
        LocalTime time = LocalTime.parse(releaseTime, dtf);
        int hour = time.getHour();
        int minute = time.getMinute();
        if (0 == (nowDate - date)) {
            releaseTime = "今天 " + hour + ":" + minute;
        } else if (1 == (nowDate - date)) {
            releaseTime = "昨天 " + hour + ":" + minute;
        } else {
            releaseTime = timeFormat(releaseTime, TIME_LENGTH_16);
        }
        return releaseTime;
    }

}

package com.eshop.mq.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 接受基类
 */
@Data
public class EshopTaskDTO implements Serializable {
    /**
     * 消息唯一标识
     */
    private Long id;
    /**
     * CID
     */
    private String cid;
    /**
     * 消息
     */
    private String message;
    /**
     * 回调服务名
     */
    private String callBackHandlerName;
    /**
     * 队列名
     */
    private String queueCode;
}

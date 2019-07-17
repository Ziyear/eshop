package com.eshop.mq.service;

import com.eshop.mq.dto.EshopTaskDTO;

/**
 * 创建并发送消息
 */
public interface RabbitSenderService {

    String creatAndSend(EshopTaskDTO eshopTaskDTO);
}

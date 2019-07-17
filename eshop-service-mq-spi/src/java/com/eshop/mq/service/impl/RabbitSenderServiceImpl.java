package com.eshop.mq.service.impl;

import com.alibaba.fastjson.JSON;
import com.eshop.mq.dto.EshopTaskDTO;
import com.eshop.mq.producer.MsgProducer;
import com.eshop.mq.service.RabbitSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送消息实现
 */
@Service
public class RabbitSenderServiceImpl implements RabbitSenderService {
    @Autowired
    private MsgProducer msgProducer;

    @Override
    public String creatAndSend(EshopTaskDTO eshopTaskDTO) {
        msgProducer.sendMsg(JSON.toJSONString(eshopTaskDTO));
        return null;
    }
}

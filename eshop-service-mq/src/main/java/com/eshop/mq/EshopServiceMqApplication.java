package com.eshop.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceMqApplication.class, args);
        log.info("============== MQService启动成功 ===================");
    }

}

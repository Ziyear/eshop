package com.eshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EshopEurekaServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EshopEurekaServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EshopEurekaServiceApplication.class, args);
        LOGGER.info("============== EurekaService启动成功 ===================");
    }
}

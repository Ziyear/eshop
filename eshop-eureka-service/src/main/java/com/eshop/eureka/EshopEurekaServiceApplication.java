package com.eshop.eureka;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class EshopEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopEurekaServiceApplication.class, args);
        log.info("============== EurekaService启动成功 ===================");
    }
}

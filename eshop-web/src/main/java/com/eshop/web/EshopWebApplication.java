package com.eshop.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopWebApplication.class, args);
        log.info("============== WebService启动成功 ===================");
    }

}

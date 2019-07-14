package com.eshop.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceBasicApplication.class, args);
        log.info("============== BasicService启动成功 ===================");
    }

}

package com.eshop.hystrix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopHystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopHystrixServiceApplication.class, args);
        log.info("============== HystrixService启动成功 ===================");
    }

}

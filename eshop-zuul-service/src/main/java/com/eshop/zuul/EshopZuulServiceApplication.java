package com.eshop.zuul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopZuulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopZuulServiceApplication.class, args);
        log.info("============== ZuulService启动成功 ===================");
    }

}

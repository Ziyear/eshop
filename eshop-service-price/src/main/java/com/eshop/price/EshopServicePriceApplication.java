package com.eshop.price;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServicePriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServicePriceApplication.class, args);
        log.info("============== PriceService启动成功 ===================");
    }

}

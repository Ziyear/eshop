package com.eshop.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceStockApplication.class, args);
        log.info("============== StockService启动成功 ===================");
    }

}

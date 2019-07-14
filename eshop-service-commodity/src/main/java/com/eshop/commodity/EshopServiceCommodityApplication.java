package com.eshop.commodity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceCommodityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceCommodityApplication.class, args);
        log.info("============== CommodityService启动成功 ===================");
    }

}

package com.eshop.statistic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceStatisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceStatisticApplication.class, args);
        log.info("============== StatisticService启动成功 ===================");
    }

}

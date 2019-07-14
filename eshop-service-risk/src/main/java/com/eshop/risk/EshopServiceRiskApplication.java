package com.eshop.risk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceRiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceRiskApplication.class, args);
        log.info("============== RiskService启动成功 ===================");
    }

}

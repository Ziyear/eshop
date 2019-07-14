package com.eshop.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopAdminApplication.class, args);
        log.info("============== AdminApplication启动成功 ===================");
    }

}

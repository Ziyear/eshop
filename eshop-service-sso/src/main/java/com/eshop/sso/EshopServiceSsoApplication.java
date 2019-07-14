package com.eshop.sso;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceSsoApplication.class, args);
        log.info("============== SSOService启动成功 ===================");
    }

}

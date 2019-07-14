package com.eshop.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceMemberApplication.class, args);
        log.info("============== FileService启动成功 ===================");
    }

}

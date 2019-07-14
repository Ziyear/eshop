package com.eshop.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceFileApplication.class, args);
        log.info("============== FileService启动成功 ===================");
    }

}

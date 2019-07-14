package com.eshop.store;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopStoreApplication.class, args);
        log.info("============== StoreService启动成功 ===================");
    }

}

package com.eshop.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopGeneratorApplication.class, args);
        log.info("============== GeneratorApplication启动成功 ===================");
    }

}

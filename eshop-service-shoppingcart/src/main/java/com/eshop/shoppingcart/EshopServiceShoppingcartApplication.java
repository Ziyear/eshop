package com.eshop.shoppingcart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EshopServiceShoppingcartApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopServiceShoppingcartApplication.class, args);
        log.info("============== ShoppingcartService启动成功 ===================");
    }

}

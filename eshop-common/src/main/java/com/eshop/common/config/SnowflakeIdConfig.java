package com.eshop.common.config;

import com.eshop.common.utils.SnowflakeIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeIdConfig {
    @Bean
    public SnowflakeIdGenerator idGenerator() {
        return new SnowflakeIdGenerator(0, 0);
    }
}

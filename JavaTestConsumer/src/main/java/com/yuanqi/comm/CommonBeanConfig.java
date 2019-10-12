package com.yuanqi.comm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置一些线程安全的工具类
 */
@Configuration
public class CommonBeanConfig {

    /**
     * 配置jwt token
     */
    @Bean
    public JwtTokenUtil configToken() {
        return new JwtTokenUtil();
    }
}
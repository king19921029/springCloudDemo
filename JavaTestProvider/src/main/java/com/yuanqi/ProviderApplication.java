package com.yuanqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by fengqiang on 2019/9/6.
 */


@MapperScan(basePackages="com.yuanqi.dao")  //扫描Mybatis文件
@SpringBootApplication                      //SpringBoot主要注解
@EnableDiscoveryClient                      //对服务进行注册
@EnableScheduling
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}

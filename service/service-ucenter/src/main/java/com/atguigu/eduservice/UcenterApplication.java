package com.atguigu.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/5/4 19:37
 */
@ComponentScan(basePackages = {"com.atguigu"})
@SpringBootApplication//取消数据源自动配置
@EnableDiscoveryClient
@MapperScan("com.atguigu.eduservice.mapper")
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class, args);
    }
}

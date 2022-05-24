package com.atguigu.oss;

import com.sun.org.apache.xerces.internal.dom.DeferredCDATASectionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 创建人: 刘百顺
 * 创建日期: 2022/4/18 21:27
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//在不加数据源不加数据库的情况下加上这个不会报错
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.atguigu"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}

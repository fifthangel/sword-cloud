package com.sword.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // nacos服务器端启动类,接受其它微服务注册进来
public class NacosServerApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosServerApp.class, args);
    }
}

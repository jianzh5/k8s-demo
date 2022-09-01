package com.jianzh5.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jam
 * 公众号：JAVA日知录
 * @date 2022/8/31 22:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args);
    }
}

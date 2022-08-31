package com.jianzh5.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * @author jam
 */
@SpringBootApplication
@RestController
@Slf4j
public class Demo1Application {
    @Value("${user.account}")
    private String userName;

    public static void main(String[] args) {
        int mb = 1024 * 1024;
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        long xmx = memoryBean.getHeapMemoryUsage().getMax() / mb;
        long xms = memoryBean.getHeapMemoryUsage().getInit() / mb;
        log.info( "Initial Memory (xms) : {} mb", xms);
        log.info("Max Memory (xmx) : {} mb", xmx);

        SpringApplication.run(Demo1Application.class, args);
    }

    @GetMapping("hello")
    public String sayHello(){
        return "hello:"+userName;
    }
}

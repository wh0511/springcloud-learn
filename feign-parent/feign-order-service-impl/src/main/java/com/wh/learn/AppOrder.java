package com.wh.learn;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//feign
@EnableFeignClients
//hystrix
@EnableHystrix
public class AppOrder {

    public static void main(String[] args) {

        SpringApplication.run(AppOrder.class,args);
    }
}

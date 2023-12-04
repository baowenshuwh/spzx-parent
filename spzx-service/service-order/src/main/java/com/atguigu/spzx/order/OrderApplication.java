package com.atguigu.spzx.order;

import com.atguigu.spzx.common.service.annotation.EnableUserTokenFeignInterceptor;
import com.atguigu.spzx.common.service.annotation.EnableUserWebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableUserTokenFeignInterceptor
@EnableFeignClients(basePackages = {"com.atguigu.spzx"})
@EnableUserWebMvcConfiguration
//@EnableUserLoginAuthInterceptor
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}

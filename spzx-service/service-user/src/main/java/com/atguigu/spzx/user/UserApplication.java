package com.atguigu.spzx.user;

import com.atguigu.spzx.common.service.annotation.EnableUserWebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableUserWebMvcConfiguration
//@ComponentScan(basePackages = {"com.atguigu.spzx"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}

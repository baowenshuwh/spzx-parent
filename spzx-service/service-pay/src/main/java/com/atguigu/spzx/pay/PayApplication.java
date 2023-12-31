package com.atguigu.spzx.pay;


import com.atguigu.spzx.common.service.annotation.EnableUserWebMvcConfiguration;
import com.atguigu.spzx.pay.utils.AlipayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableUserWebMvcConfiguration
@EnableFeignClients(basePackages = {"com.atguigu.spzx.feign.order","com.atguigu.spzx.feign.product"})
@EnableConfigurationProperties(value = { AlipayProperties.class })
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class , args) ;
    }
}

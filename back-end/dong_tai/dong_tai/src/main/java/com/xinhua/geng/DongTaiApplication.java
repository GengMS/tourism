package com.xinhua.geng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DongTaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongTaiApplication.class, args);
    }

}

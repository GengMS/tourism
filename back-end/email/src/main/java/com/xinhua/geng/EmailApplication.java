package com.xinhua.geng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class EmailApplication {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void timer() {
        redisTemplate.opsForValue().get("heartbeat");
    }
}

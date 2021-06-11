package com.xinhua.geng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Author: geng
 * @Date: 2021/5/31 8:18
 */
@Configuration
public class EmailConfig {

    @Bean
    public static JavaMailSenderImpl mail(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setUsername("3230630470@qq.com");
        sender.setPassword("ducaevsrwkkodbha");
        sender.setPort(465);
        sender.setDefaultEncoding("UTF-8");
        sender.setHost("smtp.qq.com");
        sender.setProtocol("smtps");
        return sender;
    }
}

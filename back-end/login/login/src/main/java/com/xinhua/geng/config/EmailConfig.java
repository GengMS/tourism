package com.xinhua.geng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:02
 */

public class EmailConfig {

    public static JavaMailSenderImpl senderBuilder(){
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

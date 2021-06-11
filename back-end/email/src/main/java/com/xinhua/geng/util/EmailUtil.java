package com.xinhua.geng.util;

import com.xinhua.geng.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/5/31 8:20
 */
public class EmailUtil {
    private static final String from = "3230630470@qq.com";

    @Autowired
    private static JavaMailSenderImpl mail = EmailConfig.mail();


    /**
     * 简单文本邮件
     * @param to 收件人
     *
     * @param content 内容
     */
    public static void sendSimpleMail(String[] to, String subject, String content) {

        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        System.out.println(mail);
        mail.send(message);

    }
}

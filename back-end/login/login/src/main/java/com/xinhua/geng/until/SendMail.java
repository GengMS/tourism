package com.xinhua.geng.until;

import com.xinhua.geng.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:19
 */

public class SendMail {
    private static final String from = "3230630470@qq.com";
    @Autowired
    private static JavaMailSenderImpl sender = EmailConfig.senderBuilder();


    /**
     * 简单文本邮件
     * @param to 收件人
     *
     * @param content 内容
     */
    public static void sendSimpleMail(String to,String subject,  String content) {


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
        sender.send(message);

    }
}

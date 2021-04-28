package com.xinhua.geng;

import com.xinhua.geng.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Author: geng
 * @Date: 2021/4/5 8:53
 */
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JavaMailSenderImpl JavaMailSenderImpl;
    @Test
    public void getUserByIdTest(){
        userDao.getUserById(1);
    }
}

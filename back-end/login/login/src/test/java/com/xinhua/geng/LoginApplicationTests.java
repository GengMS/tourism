package com.xinhua.geng;

import com.xinhua.geng.dao.UserDao;
import com.xinhua.geng.dao.UserInforDao;
import com.xinhua.geng.entity.User;
import com.xinhua.geng.entity.UserInfor;
import com.xinhua.geng.until.SendMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApplicationTests {

    @Autowired
    FirstDaoTest firstDaoTest;
    @Autowired
    UserDao userDao;
    @Autowired
    UserInforDao userInforDao;
    @Test
    void contextLoads() {
        System.out.println( userDao.getUserById(1));

    }
    @Test
    void mailtest(){
        SendMail.sendSimpleMail("3230630470@qq.com","geng","你好");
    }
    @Test
    void testCountUid(){
        System.out.println(userInforDao.updateInfor(new UserInfor(1,"b","a","a")));
    }
    @Test
    void testUpdateInfor(){
        userDao.updateUserInfor(1);
    }
    @Test
    void test(){
        System.out.println(userInforDao.getInfor(5));
    }
}

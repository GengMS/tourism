package com.xinhua.geng;

import com.xinhua.geng.dao.ForgetPasswdDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:33
 */
@SpringBootTest
public class ForgetPasswdDaoTest {
    @Autowired
    private ForgetPasswdDao forgetPasswdDao;
    @Test
    void saveMailCode(){
        UUID uuid = UUID.randomUUID();
        String mailCode = uuid.toString().substring(0,4);
        forgetPasswdDao.saveMailCode("323063040@qq.com",mailCode);
    }
}

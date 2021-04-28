package com.xinhua.geng.service;

import com.xinhua.geng.dao.UserDao;
import com.xinhua.geng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:39
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;


    @Override
    public User getUser(String email, String passwd) {
        return userDao.getUser(email,passwd);
    }
}

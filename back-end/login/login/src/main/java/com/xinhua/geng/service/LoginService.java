package com.xinhua.geng.service;

import com.xinhua.geng.entity.User;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:39
 */
public interface LoginService {
    User getUser(String email,String passwd);
}

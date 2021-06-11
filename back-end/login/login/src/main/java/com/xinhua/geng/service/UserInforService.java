package com.xinhua.geng.service;

import com.xinhua.geng.entity.User;
import com.xinhua.geng.entity.UserInfor;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/6 15:24
 */
public interface UserInforService {
    int countUId(int id);
    boolean saveInfor(UserInfor userInfor);
    boolean updateInfor(UserInfor userInfor);
    boolean updateUserInfor(UserInfor userInfor);
    UserInfor getInfor(int id);
    Integer hadInfor(int id);
    String getMail(int id);
    List<String> getAllMail();
}

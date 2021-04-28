package com.xinhua.geng.service;

import com.xinhua.geng.dao.ForgetPasswdDao;
import com.xinhua.geng.dao.UserDao;
import com.xinhua.geng.until.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:55
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserDao userDao;
    @Autowired
    ForgetPasswdDao forgetPasswdDao;
    @Override
    public boolean register(String email, String passwd, String mailCode) {
        try{
            if(forgetPasswdDao.countEmailByCode(email,mailCode) >= 1){
                return userDao.saveUser(email,passwd);
            }else{
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean saveMailCode(String email) {
        try{
            UUID uuid = UUID.randomUUID();
            String mailCode = uuid.toString().substring(0,4);
            SendMail.sendSimpleMail(email,"通了旅游","验证码"+mailCode);
            return forgetPasswdDao.saveMailCode(email,mailCode);
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }

    @Override
    public boolean updatePasswd(String email, String passwd, String mailCode) {
        try{
            if(forgetPasswdDao.countEmailByCode(email,mailCode) >= 1){
                return userDao.updateUserPasswd(email,passwd);
            }else{
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

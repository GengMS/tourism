package com.xinhua.geng.service;

import com.xinhua.geng.dao.UserDao;
import com.xinhua.geng.dao.UserInforDao;
import com.xinhua.geng.entity.UserInfor;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: geng
 * @Date: 2021/4/6 15:25
 */
@Service
public class UserInforServiceImpl implements UserInforService {

    @Autowired
    private UserInforDao userInforDao;
    @Autowired
    private UserDao userDao;

    @Override
    @GlobalTransactional
    public boolean updateUserInfor (UserInfor userInfor){
        try {
            if(userInforDao.countUId(userInfor.getuId()) >= 1) {
                System.out.println("1");
                userInforDao.updateInfor(userInfor);
                return userDao.updateUserInfor(userInfor.getuId());

            }else{
                System.out.println(2);
                userInforDao.saveInfor(userInfor);
                return userDao.updateUserInfor(userInfor.getuId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserInfor getInfor(int id) {
        return userInforDao.getInfor(id);
    }

    @Override
    public Integer hadInfor(int id) {
        return userDao.hadInfor(id);
    }

    @Override
    public String getMail(int id) {
        return userDao.getMail(id);
    }

    @Override
    public int countUId(int id) {
        return userInforDao.countUId(id);
    }

    @Override
    public boolean saveInfor(UserInfor userInfor) {
        return userInforDao.saveInfor(userInfor);
    }

    @Override
    public boolean updateInfor(UserInfor userInfor) {
        return userInforDao.updateInfor(userInfor);
    }
}

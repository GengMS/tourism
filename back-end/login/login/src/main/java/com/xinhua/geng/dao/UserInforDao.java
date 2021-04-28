package com.xinhua.geng.dao;

import com.xinhua.geng.entity.User;
import com.xinhua.geng.entity.UserInfor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: geng
 * @Date: 2021/4/6 11:39
 */
@Component
@Mapper
public interface UserInforDao {
    int countUId(int id);
    boolean saveInfor(UserInfor userInfor);
    boolean updateInfor(UserInfor userInfor);
    UserInfor getInfor(int id);

}

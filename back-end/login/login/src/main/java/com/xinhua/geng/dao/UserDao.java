package com.xinhua.geng.dao;

import com.xinhua.geng.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/5 8:44
 */
@Component
@Mapper
public interface UserDao {
    User getUserById(int id);
    User getUser(@Param("email") String email, @Param("passwd") String passwd);
    boolean saveUser(@Param("email") String email, @Param("passwd") String passwd);
    boolean updateUserPasswd(@Param("email") String email, @Param("passwd") String passwd);
    boolean updateUserInfor(int id);
    Integer hadInfor(int id);
    String getMail(int id);
    List<String> getAllMail();
}

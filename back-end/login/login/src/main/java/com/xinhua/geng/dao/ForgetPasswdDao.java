package com.xinhua.geng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:29
 */
@Component
@Mapper
public interface ForgetPasswdDao {

    boolean saveMailCode(@Param("email") String email,@Param("mailCode") String mailCode);
    int countEmailByCode(@Param("email") String email, @Param("mailCode") String mailCode);
}

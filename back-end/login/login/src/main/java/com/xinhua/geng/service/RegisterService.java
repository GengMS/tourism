package com.xinhua.geng.service;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: geng
 * @Date: 2021/4/5 9:54
 */
public interface RegisterService {
    boolean register(String email, String passwd, String mailCode);
    boolean saveMailCode( String email);
    boolean updatePasswd(String email, String passwd, String mailCode);
}

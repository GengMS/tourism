package com.xinhua.geng.service;

import com.xinhua.geng.entity.HomePage;
import com.xinhua.geng.entity.PhoneNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: geng
 * @Date: 2021/4/27 14:52
 */
public interface HomePageShowService {
    boolean saveShowInfor(HomePage homePage);
    ArrayList<Map<Object,Object>> listShowInfor();
    boolean delShowInfor(String id);
}

package com.xinhua.geng.service;

import com.xinhua.geng.entity.PhoneNum;
import com.xinhua.geng.entity.TeamInforFront;

import java.util.List;
import java.util.Map;

/**
 * @Author: geng
 * @Date: 2021/4/21 16:50
 */
public interface PhoneNumService {
    boolean savePhoenNum(Long phoneNum);
    List<PhoneNum> listPhoneNum();
}

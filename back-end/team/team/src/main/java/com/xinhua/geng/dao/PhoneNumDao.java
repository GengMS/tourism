package com.xinhua.geng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/21 16:47
 */
@Component
@Mapper
public interface PhoneNumDao {

    boolean savePhoenNum(Long phoneNum);
    List<Integer> listPhoneNum();
    Integer countPhoneNum(Long phoneNum);
}

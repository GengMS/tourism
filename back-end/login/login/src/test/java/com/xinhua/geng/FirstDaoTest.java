package com.xinhua.geng;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: geng
 * @Date: 2021/4/3 19:00
 */
@Component
@Mapper
public interface FirstDaoTest {

    Map<Integer,String> test();
}

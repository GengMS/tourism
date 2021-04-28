package com.xinhua.geng.dao;

import com.xinhua.geng.entity.Dong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/9 14:15
 */
@Component
@Mapper
public interface DongDao {
    boolean delDong(int dId);

    boolean saveDong(HashMap<String,Object> map);

    List<Dong> listDong(@Param("begIndex") int begIndex, @Param("endIndex") int endIndex);

    boolean increDot(int dId);

    boolean increComments(int dId);

    boolean decDot(int dId);

    List<String> getSight();

    Integer countDong();
    Integer countDongBySight(String sight);
    List<Dong> listDongBySight(@Param("sight") String sight, @Param("begIndex") int begIndex, @Param("endIndex") int endIndex);
    Dong getDong(int dId);
}

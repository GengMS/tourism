package com.xinhua.geng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: geng
 * @Date: 2021/4/12 14:34
 */
@Mapper
@Component
public interface DotDao {

    boolean saveDot(@Param("dId") int dId, @Param("uId") int uId);
    boolean delDot(@Param("dId") int dId, @Param("uId") int uId);
    int getDot(@Param("dId") int dId, @Param("uId") int uId);
    boolean delDotbyDid(int dId);
}

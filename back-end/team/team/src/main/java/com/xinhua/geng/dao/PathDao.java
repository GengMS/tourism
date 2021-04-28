package com.xinhua.geng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: geng
 * @Date: 2021/4/19 14:38
 */
@Mapper
@Component
public interface PathDao {
    boolean savePath(@Param("tId") int tId, @Param("content") String content);
    boolean delPath(int tId);
}

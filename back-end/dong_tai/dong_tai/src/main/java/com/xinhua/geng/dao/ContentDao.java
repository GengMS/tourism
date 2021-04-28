package com.xinhua.geng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: geng
 * @Date: 2021/4/9 14:25
 */
@Mapper
@Component
public interface ContentDao {
    boolean delDong(int dId);
    boolean saveDong(@Param("dId") int dId, @Param("type") String type, @Param("content") String content);

}

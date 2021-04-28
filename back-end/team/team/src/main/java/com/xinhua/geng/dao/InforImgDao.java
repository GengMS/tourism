package com.xinhua.geng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: geng
 * @Date: 2021/4/19 14:46
 */
@Mapper
@Component
public interface InforImgDao {
    boolean saveInforImg(@Param("tId") int tId, @Param("imgUrl") String imgUrl);
    boolean delInforImg(int tId);
}

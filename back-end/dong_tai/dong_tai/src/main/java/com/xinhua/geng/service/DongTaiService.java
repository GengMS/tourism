package com.xinhua.geng.service;

import com.xinhua.geng.entity.Comment;
import com.xinhua.geng.entity.Dong;
import com.xinhua.geng.entity.DongFront;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/9 17:15
 */
public interface DongTaiService {
    boolean delDong(int dId);
    boolean saveDong(DongFront dongFront);
    List<Dong> listDong(int senderUId, int pageIndex);
    boolean saveComment( int dId,  int uId,  String comment);
    boolean increDot(int dId , int uId);
    boolean decDot(int dId , int uId);
    List<Comment> listComments(int dId);
    List<String> getSight();
    Integer countDong();
    Integer countDongBySight(String sight);
    List<Dong> listDongBySight(int senderUId,  String sight, int pageIndex );
    Dong getDong(int dId);
}

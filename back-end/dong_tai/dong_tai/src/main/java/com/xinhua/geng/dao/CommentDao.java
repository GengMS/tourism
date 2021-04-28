package com.xinhua.geng.dao;

import com.xinhua.geng.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/11 7:10
 */
@Mapper
@Component
public interface CommentDao {

    boolean saveComment(@Param("dId") int dId, @Param("uId") int uId, @Param("comment") String comment);
    boolean delComment(int dId);
    List<Comment> listComments(int dId);
}

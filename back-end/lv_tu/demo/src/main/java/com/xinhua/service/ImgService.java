package com.xinhua.service;

import com.xinhua.domain.Img;

import java.util.HashMap;
import java.util.List;

public interface ImgService {
    //添加图片
    boolean saveImg(Img img);

    //根据i_id删除图片
    boolean deleteIid(Integer i_id);

    //根据用户id(u_id)查询图片
    List<Img> findByUid(Integer u_id);

    HashMap<String, List<Img>> listImgByDate(Integer u_id);
}

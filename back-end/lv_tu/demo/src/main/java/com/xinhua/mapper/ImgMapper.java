package com.xinhua.mapper;

import com.xinhua.domain.Img;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ImgMapper {
    //添加图片
    boolean saveImg(Img img);

    //根据i_id删除图片
    boolean deleteIid(Integer i_id);

    //根据用户id(u_id)查询图片
    List<Img> findByUid(Integer u_id);

}

package com.xinhua.service.impl;

import com.xinhua.domain.Img;
import com.xinhua.mapper.ImgMapper;
import com.xinhua.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgMapper imgMapper;

    //添加图片
    @Override
    public boolean saveImg(Img img) {
       return imgMapper.saveImg(img);
    }

    //根据i_id删除图片
    @Override
    public boolean deleteIid(Integer i_id) {
       return imgMapper.deleteIid(i_id);
    }

    //根据用户id(u_id)查询图片
    @Override
    public List<Img> findByUid(Integer u_id) {

        return imgMapper.findByUid(u_id);
    }

    @Override
    //返回带有日期格式的数据
    public HashMap<String, List<Img>> listImgByDate(Integer u_id){
        List<Img> imgs = imgMapper.findByUid(u_id);
        System.out.println(imgs);

        LinkedHashSet<String> dateSet = new  LinkedHashSet<>();
        LinkedHashMap<String,List<Img>> result = new LinkedHashMap<>();

        for(Img img : imgs){
            dateSet.add(img.getDateime());
        }
        for(String s : dateSet) {
            ArrayList<Img> imgs1 = new ArrayList<>();
            for(Img img : imgs) {
                if(img.getDateime().equals(s)) {
                    imgs1.add(img);
                }
            }
            result.put(s,imgs1);
            System.out.println(result);
        }

//        for (String string : dataSet1) {
//
//        }
        System.out.println(result);
       return result;
    }
}

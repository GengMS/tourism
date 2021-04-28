package com.xinhua.controller;

import com.xinhua.domain.Img;
import com.xinhua.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class ImgController {
    @Autowired
    private ImgService imgService;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //添加图片
    @RequestMapping("/saveImg/{imgUrl}/{id}")
    public boolean saveImg(@PathVariable String imgUrl, @PathVariable int id) {
        Img img = new Img();
        img.setDateime(simpleDateFormat.format(new Date()));
        img.setImg_url(imgUrl);
        img.setU_id(id);
        return imgService.saveImg(img);
    }

    //根据i_id删除图片
    @RequestMapping("/delImg/{i_id}")
    public boolean deleteIid(@PathVariable("i_id") Integer i_id) {
        return imgService.deleteIid(i_id);
    }

    //根据u_id(用户id)查询图片
    @RequestMapping("/listImg/{u_id}")
    public List<Img> findByUid(@PathVariable("u_id") Integer u_id) {
        return imgService.findByUid(u_id);
    }

    //根据日期查询图片信息
    @RequestMapping("/listImgByDate/{u_id}")
    public HashMap<String,List<Img>> findByDate(@PathVariable("u_id") Integer u_id) {


         return  imgService.listImgByDate(u_id);
    }


}

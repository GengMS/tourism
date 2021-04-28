package com.xinhua.geng.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xinhua.geng.entity.Comment;
import com.xinhua.geng.entity.Dong;
import com.xinhua.geng.entity.DongFront;
import com.xinhua.geng.service.DongTaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/10 9:00
 */
@RestController
@CrossOrigin
public class DongTaiController {

    @Autowired
    DongTaiService dongTaiService;

    /**
     * 上传动态
     * @param dongFront
     * @return
     */
    @PostMapping("/dong/upload")
    public boolean saveDong(@RequestBody String dongFront){
        try {
            JSONObject jsonObject = JSON.parseObject(dongFront);
            DongFront dongFront1 = JSON.toJavaObject(jsonObject,DongFront.class);
            return dongTaiService.saveDong(dongFront1);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除动态
     * @param dId
     * @return
     */
    @RequestMapping("/dong/del/{dId}")
    public boolean delDong(@PathVariable int dId){
        return dongTaiService.delDong(dId);
    }

    /**
     * 查看动态
     * @return
     */
    @RequestMapping("/dong/listDong/{uId}/{pageIndex}")
    public List<Dong> listDong(@PathVariable int uId, @PathVariable int pageIndex){

        return dongTaiService.listDong(uId,pageIndex);
    }

    @RequestMapping("/comment/list/{dId}")
    public List<Comment> listComments(@PathVariable int dId) {
        return dongTaiService.listComments(dId);
    }

    @PostMapping("/countDong")
    public Integer countDong(){
        return dongTaiService.countDong();
    }
    @PostMapping("/countDong/{sight}")
    public Integer countDongBySight(@PathVariable String sight) {
        return dongTaiService.countDongBySight(sight);
    }
    @RequestMapping("/listDongBySight/{senderUId}/{sight}/{pageIndex}")
    public List<Dong> listDongBySight(@PathVariable int senderUId, @PathVariable  String sight, @PathVariable int pageIndex ){
        return dongTaiService.listDongBySight(senderUId, sight, pageIndex);
    }

    @RequestMapping("/getDong/{dId}")
    public Dong getDong(@PathVariable int dId){
        try{
            return dongTaiService.getDong(dId);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}


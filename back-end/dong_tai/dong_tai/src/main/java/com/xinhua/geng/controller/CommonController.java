package com.xinhua.geng.controller;

import com.xinhua.geng.dao.DongDao;
import com.xinhua.geng.service.DongTaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/11 8:38
 */
@RestController
@CrossOrigin
public class CommonController {

    @Autowired
    private DongTaiService dongTaiService;

    @PostMapping("/increDot/{dId}/{uId}")
    public boolean increDot(@PathVariable int dId, @PathVariable int uId){
        return dongTaiService.increDot(dId,uId);
    }
    @PostMapping("/decDot/{dId}/{uId}")
    public boolean decDot(@PathVariable int dId , @PathVariable int uId) {

        return dongTaiService.decDot(dId, uId);
    }
    @PostMapping("/uploadComments/{dId}/{uId}/{comments}")
    public boolean uploadComments(@PathVariable int dId,@PathVariable int uId, @PathVariable String comments){
        try{
            return dongTaiService.saveComment(dId, uId, comments);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    @PostMapping("/sights")
    public List<String> getSight(){
        return dongTaiService.getSight();
    }
}
